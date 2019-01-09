package com.haeyoum.member.service;

import org.springframework.stereotype.Service;

import com.haeyoum.member.model.FileVo;


@Service
public class FileUploadService {

	public boolean saveFile(String path, FileVo file) {
		boolean flag = file.saveFile(path);
		return flag;
	}
	
}
