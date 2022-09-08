package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/boardList")
	public String getBoardList(BoardVO vo, Model model, HttpSession session) {  //�Խñ� ��� ��û
		//null üũ
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		List<BoardVO> boardList = service.getBoardList(vo);
		String id = (String)session.getAttribute("sessionId");
		
		model.addAttribute("boardList", boardList); //model-"boardList"
		model.addAttribute("id", id);
		return "/board/boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) { //�� ���� ��û
		service.updateCount(bno);  //��ȸ�� ����
		BoardVO board = service.getBoard(bno);  //�� ���� ó��
		model.addAttribute("board", board); //model-"board"
		return "/board/boardView";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoard(HttpSession session, Model model) {  //�۾��� �� ������ ��û
		String id = (String)session.getAttribute("sessionId");
		String name = service.getNameByLogin(id);
		model.addAttribute("name", name);
		return "/board/insertBoard";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IOException{  //�۾��� ó��
		//command ��ü - BoardVO -> HttpServletRequest request ��ü��
		//���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/upload/" + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {  //�� ���� ��û
		service.delete(vo);
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {  //�� ���� ��û
		service.update(vo);
		return "redirect:/board/boardList";
	}
}
