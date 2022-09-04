package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardList")
	public String getBoardList(Model model, HttpSession session) {  //게시글 목록 요청
		List<BoardVO> boardList = service.getBoardList();
		String id = (String)session.getAttribute("sessionId");
		
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("id", id);
		return "/board/boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) { //상세 보기 요청
		service.updateCount(bno);  //조회수 증가
		BoardVO board = service.getBoard(bno);  //상세 보기 처리
		model.addAttribute("board", board); //model-"board"
		return "/board/boardView";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoard() {  //글쓰기 폼 페이지 요청
		return "/board/insertBoard";
	}
	
	/*@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(HttpServletRequest request) throws UnsupportedEncodingException {
		//사용자 입력 정보 추출
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("title");
		String content = request.getParameter("content");
		
		//db 연동
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		boardService.insert(vo);
		return "redirect:boardList";
	}*/
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IOException{  //글쓰기 처리
		//command 객체 - BoardVO -> HttpServletRequest request 대체함
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/upload/" + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {  //글 삭제 요청
		service.delete(vo);
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {  //글 수정 요청
		service.update(vo);
		return "redirect:/board/boardList";
	}
}
