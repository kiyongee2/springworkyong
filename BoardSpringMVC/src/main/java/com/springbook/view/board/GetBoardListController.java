package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//DB ���� ó��
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList();
		
		//�˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵�
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
	
		//�˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ����
		/*session - Ŭ���̾�Ʈ ������ �ϳ��� �ϳ��� ���� �޸𸮿� �����Ǿ� Ŭ���̾�Ʈ�� ���� ������
		   �����ϱ� ���� ���Ǿ� ������ �δ��� �� �� �ִ�.*/
		//InternalResourceViewResolver�� �����Ǿ� ������ Ȯ���� .jsp�� ������.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}
	
}
