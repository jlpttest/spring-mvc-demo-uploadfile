package com.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.DocumentTempDAO;
import com.demo.entities.DocumentManageTemp;
import com.demo.service.HandleFileService;


@Controller
public class DocumentController {

	@Autowired
	private DocumentTempDAO documentDao;
	
	@Autowired
	private HttpSession session;
	
	@Autowired 
	private HandleFileService handleFileService;

	@PostMapping(value="/")
	public ModelAndView listContact(ModelAndView model, @RequestParam("key1") String value1, @RequestParam("key2") String value2) throws IOException{
		System.out.println(">>> " + value1 +value2);
		session.setAttribute("key1", value1);
		System.out.println("in listContact " + session.getId());
		List<DocumentManageTemp> listDocument = documentDao.list();
		DocumentManageTemp modalDocutemp = new DocumentManageTemp();
		model.addObject("listDocs", listDocument);
		model.addObject("newDoc", modalDocutemp);
		model.setViewName("home");

		return model;
	}
	
	@PostMapping(value="/create")
	public String createDocumentTmp(@ModelAttribute DocumentManageTemp newDocumentManageTemp,@RequestParam("file") MultipartFile file) {
		System.out.println(newDocumentManageTemp.toString());
		handleFileService.handleSaveFileUpload(file, session.getId() + File.separator + "KAISO1");
		return "redirect:/";
	}
	
	@PostMapping(value="/test")
	public String test(@RequestParam("key1") String value1, @RequestParam("key2") String value2) {
		String username = (String) session.getAttribute("key1");
		System.out.println("in test: "+username + "id" + session.getId());
		handleFileService.deleteFile("laptop2.jpg", session.getId() + File.separator + "KAISO1");
		return "redirect:/";
	}
	
	@GetMapping("/")
	public ModelAndView lisDocument(ModelAndView model) {
		String username = (String) session.getAttribute("key1");
		System.out.println("in lisDocument" + username + " " + session.getId());
		List<DocumentManageTemp> listDocument = documentDao.list();
		DocumentManageTemp modalDocutemp = new DocumentManageTemp();
		model.addObject("listDocs", listDocument);
		model.addObject("newDoc", modalDocutemp);
		model.setViewName("home");
		
		return model;
		
	}



}
