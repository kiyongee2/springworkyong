package com.cloud.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		//마지막 페이지                    //3/10.0.. 0.3 -> 1(올림) -> 10page
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10; 
		//시작 페이지
		this.startPage = this.endPage - 9;
		//실제 마지막 페이지                  //74.0/10 -> 7.4 -> 8 
		int realEndPage = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		//마지막 페이지와 실제 페이지 조건
		this.endPage = realEndPage < endPage ? realEndPage : endPage;
		
		this.prev = this.startPage > 1;    //다음
		this.next = this.endPage < realEndPage;  //이전
	}
}
