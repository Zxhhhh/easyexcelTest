package com.zxh.easyexcelTest.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class WriteModel extends BaseRowModel {
	
	@ExcelProperty(value="姓名",index=0)
	private String name;
	
	@ExcelProperty(value="密码",index=1)
	private String password;
	
	@ExcelProperty(value="年龄",index=2)
	private Integer age;

	public WriteModel(String name, String password, Integer age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
