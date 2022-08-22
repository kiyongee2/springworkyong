package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세보기");
		
		//게시글 번호 추출
		String seq = request.getParameter("seq");

		//DB 연동 처리
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(Integer.parseInt(seq));
		
		//검색 결과를 세션에 저장하고 목록 화면으로 이동
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		//response.sendRedirect("getBoard.jsp");
		return "getBoard";
	}
	
}
