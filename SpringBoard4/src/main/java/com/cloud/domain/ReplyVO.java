package com.cloud.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int rno;  //��� ��ȣ
	private int bno;  //�� ��ȣ
	
	private String reply;    //��� ����
	private String replyer;  //��� �ۼ���
	private Date replyDate;  //��� �ۼ���
	private Date updateDate; //��� ������
}
