package com.cloud.domain;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;   //페이지 번호
	private int amount;    //페이지당 게시글 수
	
	public Criteria() {    //또 다른 생성자 호출
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
