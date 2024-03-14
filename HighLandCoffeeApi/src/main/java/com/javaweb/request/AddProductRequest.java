package com.javaweb.request;

import org.springframework.web.multipart.MultipartFile;

public class AddProductRequest {

	private MultipartFile[] file;
	private CreateProductRequest data;
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	public CreateProductRequest getData() {
		return data;
	}
	public void setData(CreateProductRequest data) {
		this.data = data;
	}
	public AddProductRequest(MultipartFile[] file, CreateProductRequest data) {
		super();
		this.file = file;
		this.data = data;
	}
	public AddProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
