package com.javaweb.request;

import org.springframework.web.multipart.MultipartFile;

public class AddProductRequest {

	private MultipartFile[] file;
	private TestRequest data;
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	public TestRequest getData() {
		return data;
	}
	public void setData(TestRequest data) {
		this.data = data;
	}

	
	
	
}
