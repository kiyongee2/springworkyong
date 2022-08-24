package com.cloud.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	private String id;
	private String passwd;
	private String name;
	private String role;
}
