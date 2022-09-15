package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.service.BoardService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	/*@GetMapping("/boardList")
	public String getBoardList(Model model, HttpSession session) {//게시글 목록 요청
		List<BoardVO> boardList = service.getBoardList();
		String id = (String)session.getAttribute("sessionId");
		
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("id", id);
		return "/board/boardList";
	}*/
	
	//게시글 목록(페이지 요청)
	@GetMapping("/boardList")
	public String getBoardList(Criteria cri, Model model) {
		List<BoardVO> boardList = service.getListWithPage(cri);
		PageDTO pageMaker = new PageDTO(cri, service.getTotalCount(cri));
		
		log.info(cri);
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("pageMaker", pageMaker); //model-"pageMaker"
		return "/board/boardList";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard")
	public String insertBoard() {  //글쓰기 폼 페이지 요청
		return "/board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	//@PreAuthorize("isAuthenticated()")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException{  //글쓰기 처리
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "C:/upload/";
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}

	@RequestMapping("/boardView")
	public String getBoard(int bno, Criteria cri, Model model) { //상세 보기 요청
		service.updateCount(bno);  //조회수 증가
		BoardVO board = service.getBoard(bno);  //상세 보기 처리
		
		model.addAttribute("board", board); //model-"board"
		model.addAttribute("cri", cri);  //model-"cri"
		return "/board/boardView";
	}
	
	@GetMapping("/board/deleteBoard")
	public String deleteBoard(BoardVO vo, Criteria cri, 
			RedirectAttributes rttr) {  //글 삭제 요청
		service.delete(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/board/updateBoard")
	public String updateBoard(BoardVO vo, Criteria cri, 
			RedirectAttributes rttr) {  //글 수정 요청
		service.update(vo);
		//URL 뒤에 원래의 페이지로 이동하기 위해 pageNum과 amount 값을 보내줌
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
}
