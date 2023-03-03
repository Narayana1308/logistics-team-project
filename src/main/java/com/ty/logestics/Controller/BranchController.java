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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService service;

	@ApiOperation(value = "save the branch ", notes = "Api is used save the branch based on the company id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 404, message = "not found") })
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @RequestParam String cid) {
		return service.saveBranch(branch, cid);
	}

	@ApiOperation(value = "delete the branch ", notes = "Api is used delete the branch based on the branch id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return service.deleteBranch(id);
	}

	@ApiOperation(value = "get the branch ", notes = "Api is used get the branch based on the branch id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })

	@GetMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> getById(@RequestParam int id) {
		return service.getBranchById(id);
	}

	@ApiOperation(value = "update the branch ", notes = "Api is used update the branch based on the branch id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "not found") })
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int id, @RequestBody Branch branch) {
		return service.updateBranch(id, branch);
	}

	@ApiOperation(value = "get all the branches ", notes = "Api is used  to get all branches")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })

	@GetMapping("/allbranches")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches() {
		return service.getAllBranches();
	}

	@ApiOperation(value = "get the branch by manager name ", notes = "Api is used get the branch based on the manager name ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })

	@GetMapping("/branchbymanager")
	public ResponseEntity<ResponseStructure<Branch>> getByManager(@RequestParam String managerName) {
		return service.getBranchByManager(managerName);
	}

}
