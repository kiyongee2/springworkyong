package com.cloud.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/boardList")
	public String getBoardList(Model model, HttpSession session) {//게시글 목록 요청
		List<BoardVO> boardList = service.getBoardList();
		String id = (String)session.getAttribute("sessionId");
		
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("id", id);
		return "boardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {  //글쓰기 폼 페이지 요청
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(BoardVO vo){  //글쓰기 처리
		service.insert(vo);
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) { //상세 보기 요청
		service.updateCount(bno);  //조회수 증가
		BoardVO board = service.getBoard(bno);  //상세 보기 처리
		model.addAttribute("board", board); //model-"board"
		return "boardView";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {  //글 삭제 요청
		service.delete(vo);
		return "redirect:boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {  //글 수정 요청
		service.update(vo);
		return "redirect:boardList";
	}
}
