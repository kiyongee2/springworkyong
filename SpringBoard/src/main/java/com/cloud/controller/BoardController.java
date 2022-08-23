package com.cloud.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public String getBoardList(Model model) {  //�Խñ� ��� ���� ��û
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) {
		BoardVO board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "boardView";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}
	
	/*@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(HttpServletRequest request) throws UnsupportedEncodingException {
		//����� �Է� ���� ����
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("title");
		String content = request.getParameter("content");
		
		//db ����
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		boardService.insert(vo);
		return "redirect:boardList";
	}*/
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo){

		boardService.insert(vo);
		return "redirect:boardList";
	}
}
