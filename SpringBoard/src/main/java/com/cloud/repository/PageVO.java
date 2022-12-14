package com.cloud.repository;

import lombok.Data;

@Data
public class PageVO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	//현재 페이지 번호, 한 페이지에 표시할 데이터 개수
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//시작페이지, 마지막 페이지 계산
		this.endPage = (int) Math.ceil(cri.getPageNum()/10.0) * 10;
		this.startPage = this.endPage - 9;
		
		//실제 마지막 페이지
		int realEndPage = (int)Math.ceil(total * 1.0) / cri.getAmount();
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}
	
	
}
