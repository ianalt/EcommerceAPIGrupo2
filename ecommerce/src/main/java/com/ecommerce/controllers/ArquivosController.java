//package com.ecommerce.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.ecommerce.exception.ArquivosException;
//import com.ecommerce.services.ArquivosService;
//import com.ecommerce.vo.ArquivosVO;
//
//@RestController
//@RequestMapping("/arquivos")
//public class ArquivosController {
//	
//	@Autowired
//	ArquivosService arquivosService;
//	
//	@PostMapping("/uploadFile")
//	public ArquivosVO uploadFile(@RequestParam("file") MultipartFile file) throws ArquivosException {
//		String fileName = arquivosService.storeFile(file);
//		
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/img")
//				.path(fileName)
//				.toUriString();
//		
//		return new ArquivosVO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
//	}
//	
//	@DeleteMapping("/deleteFile")
//	public boolean deleteFile(@RequestParam("file") String file) throws ArquivosException {
//		return arquivosService.deleteFile(file);
//	}
//}
