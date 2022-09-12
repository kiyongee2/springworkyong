package com.cloud.domain;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;   //������ ��ȣ
	private int amount;    //�������� �Խñ� ��
	
	public Criteria() {    //�� �ٸ� ������ ȣ��
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
