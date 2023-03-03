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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	
	@ApiOperation(value = "save the company ", notes = "Api is used save the company ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 404, message = "not found") })
	@PostMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> saveCompany(@RequestBody Company company){
		return service.saveCompany(company);
	}
	
	@ApiOperation(value = "update the order ", notes = "Api is used update the company based on the company id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "not found") })
	@PutMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> updateCompany( @RequestParam String id ,@RequestBody Company company){
		return service.updateCompany(id, company);
	}
	@ApiOperation(value = "get the goods ", notes = "Api is used get the company based on the company id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })
	
	@GetMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> getEntity(@RequestParam String id){
		return service.getCompanyId(id);
	}
	@ApiOperation(value = "delete the company ", notes = "Api is used delete the company based on the company id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/company")
	public ResponseEntity<ResponseStructure<Company>> deleteCompany(@RequestParam String id){
		return service.deleteCompanyId(id);
	}
	
	@ApiOperation(value = "get the company ", notes = "Api is used get the company based on the email id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })
	@GetMapping("/companybyemail")
	public ResponseEntity<ResponseStructure<Company>> getEntityByEmail(@RequestParam String email){
		return service.getCompanyEmail(email);
	}
	
	@ApiOperation(value = "get the company ", notes = "Api is used get the company based on the ceo name ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })
	@GetMapping("/companybyceo")
	public ResponseEntity<ResponseStructure<Company>> getEntityByCeo(@RequestParam String ceo){
		return service.getCompanyCeo(ceo);
	}
	
	@ApiOperation(value = "get the company ", notes = "Api is used get the company based on the company name ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })
	@GetMapping("/companybyname")
	public ResponseEntity<ResponseStructure<Company>> getEntityByName(@RequestParam String name){
		return service.getCompanyName(name);
	}
}
