package com.cloud.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/boardList")
	public String getBoardList(Model model, HttpSession session) {//�Խñ� ��� ��û
		List<BoardVO> boardList = service.getBoardList();
		String id = (String)session.getAttribute("sessionId");
		
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("id", id);
		return "/board/boardList";
	}
	
	@GetMapping("/insertBoard")
	@PreAuthorize("isAuthenticated()")
	public String insertBoard() {  //�۾��� �� ������ ��û
		return "/board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	@PreAuthorize("isAuthenticated()")
	public String insertBoard(BoardVO vo){  //�۾��� ó��
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) { //�� ���� ��û
		service.updateCount(bno);  //��ȸ�� ����
		BoardVO board = service.getBoard(bno);  //�� ���� ó��
		model.addAttribute("board", board); //model-"board"
		return "/board/boardView";
	}
	
	@GetMapping("/board/deleteBoard")
	public String deleteBoard(BoardVO vo) {  //�� ���� ��û
		service.delete(vo);
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/board/updateBoard")
	public String updateBoard(BoardVO vo) {  //�� ���� ��û
		service.update(vo);
		return "redirect:/board/boardList";
	}
}
