package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService service = (BoardService) container.getBean("boardService");
		
		//�� ���
//		BoardVO vo = new BoardVO();
//		vo.setSeq(100);  ��������� �Է�
//		vo.setTitle("4���� �����");
//		vo.setWriter("�Ȼ�");
//		vo.setContent("��� ������ǥ");
//		service.insert(vo);
		
		//�� ���
		List<BoardVO> list = service.selectAll();
		for(BoardVO board : list) {
			System.out.println(board.toString());
//			System.out.println("�� ��ȣ : " + board.getSeq());
//			System.out.println("�� ���� : " + board.getTitle());
//			System.out.println("�۾��� : " + board.getWriter());
//			System.out.println("�� ���� : " + board.getContent());
//			System.out.println("�ۼ��� : " + board.getRegdate());
//			System.out.println("��ȸ�� : " + board.getCnt());
		}
		
		container.close();
	}

}
