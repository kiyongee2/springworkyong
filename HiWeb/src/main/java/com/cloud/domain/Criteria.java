package com.cloud.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	private int pageNum;
	private int amount;

	private String type;       //t, tc, tcw, cw - �迭, ����Ʈ �ʿ�
	private String keyword;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() { //Ÿ�� ����
		return type == null ? new String[] {} : type.split(""); //�����͸� �ɰ�
	}
}
