package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService service = (BoardService) container.getBean("boardService");
		
		//글 등록
//		BoardVO vo = new BoardVO();
//		vo.setSeq(100);  명시적으로 입력
//		vo.setTitle("4월의 토요일");
//		vo.setWriter("안산");
//		vo.setContent("양궁 국가대표");
//		service.insert(vo);
		
		//글 목록
		List<BoardVO> list = service.selectAll();
		for(BoardVO board : list) {
			System.out.println(board.toString());
//			System.out.println("글 번호 : " + board.getSeq());
//			System.out.println("글 제목 : " + board.getTitle());
//			System.out.println("글쓴이 : " + board.getWriter());
//			System.out.println("글 내용 : " + board.getContent());
//			System.out.println("작성일 : " + board.getRegdate());
//			System.out.println("조회수 : " + board.getCnt());
		}
		
		container.close();
	}

}
