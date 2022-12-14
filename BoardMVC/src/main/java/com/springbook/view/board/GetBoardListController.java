package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList();
		
		//검색 결과를 세션에 저장하고 목록 화면으로 이동
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
//		response.sendRedirect("getBoardList.jsp");
		return "getBoardList";
	}
	
}
