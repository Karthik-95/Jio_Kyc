package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JiokycDao {
	@Autowired
	JiokycRepository repo;
	public String add(Jiokyc j) {
		repo.save(j);
		return "// Jio Customer Details Are Saved //";
	}
	public String addlist(List<Jiokyc> j) {
		repo.saveAll(j);
		return "** KYC LIST SAVED **";
	}

}
