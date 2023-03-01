package com.ty.logestics.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.logestics.dto.Branch;
import com.ty.logestics.service.BranchService;
import com.ty.logestics.util.ResponseStructure;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService service;
	
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody  Branch branch, @RequestParam int cid){
		return service.saveBranch(branch, cid);
	}
	
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id){
		return service.deleteBranch(id);
	}
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getById(@RequestParam int id){
		return service.getBranchById(id);
	}
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int id,@RequestBody Branch branch){
		return service.updateBranch(id, branch);
	}
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches(){
		return service.getAllBranches();
	}
	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getByManager(@RequestParam String managerName){
		return service.getBranchByManager(managerName);
	}

}
