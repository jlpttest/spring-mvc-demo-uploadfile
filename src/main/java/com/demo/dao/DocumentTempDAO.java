package com.demo.dao;

import java.util.List;

import com.demo.entities.DocumentManageTemp;


public interface DocumentTempDAO {

	public void saveOrUpdate(DocumentManageTemp docuTemp);

	public void delete(int docuTempId);

	public DocumentManageTemp get(int docuTempId);

	public List<DocumentManageTemp> list();

}
