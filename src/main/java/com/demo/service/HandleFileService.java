package com.demo.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HandleFileService {

	public Map<String, String> handleSaveFileUpload(MultipartFile file, String desFolder) {

		Map<String, String> map = new HashMap<>();
		byte[] bytes;
		try {
			bytes = file.getBytes();

			String rootPath = System.getProperty("jboss.home.dir");

			File dir = new File(rootPath + File.separator + desFolder);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;

	}

	public void deleteFile(String fileName, String filePath) {
		String rootPath = System.getProperty("jboss.home.dir");
		// Specify the file path
		File file = new File(rootPath + filePath + fileName);
		// Attempt to delete the file
		if (file.delete()) {
			System.out.println("File deleted successfully!");
		} else {
			System.out.println("Failed to delete the file. It may not exist.");
		}
	}

}
