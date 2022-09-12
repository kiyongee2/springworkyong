package com.cloud.mapper;

import java.util.List;
import java.util.Map;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;

public interface BoardMapper {
	
	public void insert(BoardVO vo);   //�� ����
	
	public List<BoardVO> getBoardList(); //�� ���
	
	public List<BoardVO> getListWithPage(Criteria cri); //��� ������ ó��
	
	public int getTotalCount(Criteria cri);  //�Խñ� �� ����
	
	public BoardVO getBoard(int bno); //�� �󼼺���
	
	public void delete(BoardVO vo); //�� ����
	
	public void update(BoardVO vo); //�� ����
	
	public void updateCount(int bno); //��ȸ��
	
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);  //�˻�
}
