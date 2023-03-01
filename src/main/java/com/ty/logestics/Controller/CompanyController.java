package com.ty.logestics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.logestics.dto.Company;
import com.ty.logestics.service.CompanyService;
import com.ty.logestics.util.ResponseStructure;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@PostMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> saveCompany(@RequestBody Company company){
		return service.saveCompany(company);
	}
	
	@PutMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> updateCompany( @RequestParam String id ,@RequestBody Company company){
		return service.updateCompany(id, company);
	}
	
	@GetMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> getEntity(@RequestParam String id){
		return service.getCompanyId(id);
	}
	
	@DeleteMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> deleteCompany(@RequestParam String id){
		return service.deleteCompanyId(id);
	}
	

}
