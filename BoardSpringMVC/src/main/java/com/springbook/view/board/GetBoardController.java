package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �󼼺���");
		
		//�Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		//DB ���� ó��
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(Integer.parseInt(seq));
		
		//�˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵�
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		//response.sendRedirect("getBoard.jsp");
//		return "getBoard";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		return mav;
	}
	
}
