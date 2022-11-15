package com.example.demo.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Attachment;
import com.example.demo.model.ResponseData;
import com.example.demo.service.AttachmentService;

@RestController
public class AttachmentController {
	
	private AttachmentService attachmentService;

	public AttachmentController(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	
	@PostMapping("/upload")
	public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception
	{
		//We have to convert file into byte array
		Attachment attachment = null;
		
		String downloadUrl ="";
		
		attachment = attachmentService.saveAttachment(file);
		//current context path of application
		downloadUrl=ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/download/").path(attachment.getId()).toUriString();
		
	
		return new ResponseData(attachment.getFileName(),downloadUrl,file.getContentType(),
				file.getSize());
		
	}
	
	@GetMapping("/download/{fileId}")
	 public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") String fileId) throws Exception{
		
		 Attachment attachment=attachmentService.getAttachment(fileId);
		 
		 
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName = \" "+attachment.getFileName() + "\"")
				.body(new ByteArrayResource(attachment.getData()));
		
		 
	 }

}
