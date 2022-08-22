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
		System.out.println("�� �󼼺���");
		
		//�Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		//DB ���� ó��
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(Integer.parseInt(seq));
		
		//�˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵�
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		//response.sendRedirect("getBoard.jsp");
		return "getBoard";
	}
	
}
