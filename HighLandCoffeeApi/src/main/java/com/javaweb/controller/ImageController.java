package com.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.service.IImageService;

@RestController
public class ImageController {
	@Autowired
	    IImageService imageService;


	    @PostMapping("file")
	    public ResponseEntity create(@RequestParam(name = "file") MultipartFile[] files) {

	            for (MultipartFile file : files) {

	                try {

	                	
	                    String fileName = imageService.save(file);

	                    String imageUrl = imageService.getImageUrl(fileName);

	                    // do whatever you want with that
	                    System.err.println(fileName);
	                    System.err.println(file);

	                } catch (Exception e) {
	                System.err.println(e);
	                }
	            }

	        return ResponseEntity.ok().build();
	    }
}
