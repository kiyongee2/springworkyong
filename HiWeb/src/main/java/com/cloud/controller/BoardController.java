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
import com.cloud.domain.ReplyVO;
import com.cloud.service.BoardService;
import com.cloud.service.ReplyService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyService;
	
	//�Խñ� ��� ��û
	@GetMapping("/boardList")
	public String getBoardList(ReplyVO vo, Criteria cri, Model model) {
		List<BoardVO> boardList = service.getListWithPage(cri);
		PageDTO pageMaker = new PageDTO(cri, service.getTotalCount(cri)); //�� �Խñ� ��
		
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("pageMaker", pageMaker);
		return "/board/boardList";
	}
	
	//�۾��� �� ������ ��û
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/insertBoard")
	public String insertBoard() {  
		return "/board/insertBoard";
	}
	
	//�۾��� ó��
	@PostMapping("/insertBoard")
	//@PreAuthorize("isAuthenticated()")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException{ 
		//���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "C:/upload/";
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}

	//�Խñ� �� ����, ��� ���
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/boardView")
	public String getBoard(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		service.updateCount(bno);  //��ȸ�� ����
		BoardVO board = service.getBoard(bno);  //�� ���� ó��
		List<ReplyVO> replyList = replyService.getReplyList(bno);
		
		model.addAttribute("board", board); //model-"board"
		model.addAttribute("replyList", replyList);
		return "/board/boardView";
	}
	
	//�� ���� ó��
	@GetMapping("/board/deleteBoard")
	public String deleteBoard(BoardVO vo, Criteria cri, 
			RedirectAttributes rttr) {  
		service.delete(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
	//�� ���� ó��
	@PostMapping("/board/updateBoard")
	public String updateBoard(BoardVO vo, Criteria cri, 
			RedirectAttributes rttr) {  
		service.update(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
	//��� ���
	@PostMapping("/reply")
	public String reply(ReplyVO vo, RedirectAttributes rttr) {
		log.info("��� �ۼ�");
		replyService.register(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		
		return "redirect:/board/boardView";
	}
	
	//��� ���� ������ ��û, ������ ��� ��� ��������
	@GetMapping("/replyDelete")
	public String replyDeleteView(ReplyVO vo, Model model,
			RedirectAttributes rttr) {
		ReplyVO selectReply = replyService.getReply(vo.getRno());
		
		model.addAttribute("selectReply", selectReply);
		
		return "/board/replyDelete";
	}
	
	//��� ����
	@PostMapping("/replyDelete")
	public String replyDelete(ReplyVO vo, 
			RedirectAttributes rttr) {
		replyService.delete(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		
		return "redirect:/board/boardView";
	}
	
	//��� ���� ������ ��û, ������ ��� ��� ��������
	@GetMapping("/replyUpdate")
	public String replyUpdateView(ReplyVO vo, Model model,
			RedirectAttributes rttr) {
		ReplyVO selectReply = replyService.getReply(vo.getRno());
		
		model.addAttribute("selectReply", selectReply);
		
		return "/board/replyUpdate";
	}
	
	//��� ���� ó��
	@PostMapping("/replyUpdate")
	public String replyUpdate(ReplyVO vo, RedirectAttributes rttr) {
		replyService.update(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		
		return "redirect:/board/boardView";
	}
}
