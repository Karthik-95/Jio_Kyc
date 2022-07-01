package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JiokycService {
	@Autowired
	JiokycDao dao;
	public String add(Jiokyc j) {
		return dao.add(j);
	}
	public String addlist(List<Jiokyc> j) {
		return dao.addlist(j);
	}

}
