package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó��");
		
		//1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		//3. ȭ�� �׺���̼�
		//redirect: - .do ��û�� ��� viewResolver�� �����Ǿ� �ִ��� �����ϰ� redirect�Ѵ�.
		ModelAndView mav = new ModelAndView();
		if(user != null){
			mav.setViewName("redirect:getBoardList.do");
		}else{
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}
	
}