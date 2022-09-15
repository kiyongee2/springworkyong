package com.cloud.domain;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;   //������ ��ȣ
	private int amount;    //�������� �Խñ� ��
	
	private String type;  //t, tc, tcw (�迭, ������ ����)
	private String keyword;  //�˻���
	
	public Criteria() {    //�� �ٸ� ������ ȣ��
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//Ÿ���� ������ �޼��� ����(type�� null�� �ƴϸ� ���ڿ��� �и��Ͽ� �迭�� ��ȯ)
	public String[] getTypeArr() {
		System.out.println("getTypeArr....");
		return type == null ? new String[] {} : type.split("");
	}
}



