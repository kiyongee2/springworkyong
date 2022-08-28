package test.di.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.DelegatingFilterProxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.di.service.HomeService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*@Autowired   //�ʵ� ����
	private HomeService homeService;*/
	
	private final HomeService homeService;  //������ ����
	
	/*@Autowired  //setter ����
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}*/

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		//�ð� ���� - home.jsp
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//sayHello() �޼��� ȣ��
		homeService.sayHello();
		
		return "home";
	}
}
