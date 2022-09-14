package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor   //�Ű����� ���� �⺻ ������
@AllArgsConstructor  //�Ű����� �ִ� ������
@Data
public class SampleVO {
	
	private Integer mno;
	private String firstName;
	private String lastName;
}
