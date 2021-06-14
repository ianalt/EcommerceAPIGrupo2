//package com.ecommerce.services;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.ecommerce.exception.ArquivosException;
//
//@Service
//public class ArquivosService {
//
//	private Path fileStorageLocation;
//
//	@Value("${arquivos.imagem}")
//	private String dirArquivosImagem;
//
//	private void createDirectory() throws ArquivosException {
//		this.fileStorageLocation = Paths.get(dirArquivosImagem).toAbsolutePath().normalize();
//
//	private void createDirectory() {
//		this.fileStorageLocation = Paths.get(dirArquivosImagem).toAbsolutePath().normalize();
//
//		try {
//			Files.createDirectories(this.fileStorageLocation);
//		} catch (Exception ex) {
//			throw new ArquivosException("Não foi possível criar o diretório para armazenar o arquivo", ex);
//		}
//	}
//
//	public String storeFile(MultipartFile file) throws ArquivosException {
//		createDirectory();
//
//	public String storeFile(MultipartFile file) {
//		createDirectory();
//
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//		try {
//			if (fileName.contains("..")) {
//				throw new ArquivosException("Nome do arquivo inválido :: " + fileName);
//			}
//
//			Path targetLocation = this.fileStorageLocation.resolve(fileName);
//			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//			return fileName;
//		} catch (IOException ex) {
//			throw new ArquivosException("Ocorreu um erro e não foi possível armazenar o arquivo :: " + fileName, ex);
//		}
//	}
//
//	public boolean deleteFile(String file) throws ArquivosException {
//		String fileName = StringUtils.cleanPath(file);
//
//		try {
//			if (fileName.contains("..")) {
//				throw new ArquivosException(
//						"O nome do arquivo contém uma sequência de caminho inválida :: " + fileName);
//			}
//
//			Path targetLocation = this.fileStorageLocation.resolve(fileName);
//
//			return Files.deleteIfExists(targetLocation);
//
//		} catch (IOException ex) {
//			throw new ArquivosException("O arquivo " + fileName + " não foi encontrado no servidor", ex);
//		}
//	}}
//
//	try{if(fileName.contains("..")){throw new ArquivosException("O nome do arquivo contém uma sequência de caminho inválida :: "+fileName);}
//
//	Path targetLocation = this.fileStorageLocation.resolve(fileName);
//
//	return Files.deleteIfExists(targetLocation);}catch(
//	IOException ex){throw new ArquivosException("O arquivo"+fileName+" não foi encontrado no servidor :: ",ex);
//}}
//}
