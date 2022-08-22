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
		//DB 연동 처리
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList();
		
		//검색 결과를 세션에 저장하고 목록 화면으로 이동
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
	
		//검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴
		/*session - 클라이언트 브라우저 하나당 하나씩 서버 메모리에 생성되어 클라이언트의 상태 정보를
		   유지하기 위해 사용되어 서버에 부담을 줄 수 있다.*/
		//InternalResourceViewResolver가 설정되어 있으면 확장자 .jsp를 제거함.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}
	
}
