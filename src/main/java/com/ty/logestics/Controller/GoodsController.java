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

import com.ty.logestics.dto.Goods;
import com.ty.logestics.service.GoodsService;
import com.ty.logestics.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	
	
	@ApiOperation(value = "save the goods ", notes = "Api is used save the goods based on the order id,user id,branch id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 404, message = "not found") })
	@PostMapping("/savegoods")
	public ResponseEntity<ResponseStructure<Goods>> saveGooods(@RequestParam int oid, @RequestParam String uid,
			@RequestParam int bid, @RequestBody Goods goods) {
		return goodsService.saveGoods(oid, uid, bid, goods);
	}

	@ApiOperation(value = "update the goods ", notes = "Api is used update the goods based on the goods id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "not found") })
	@PutMapping("/updategoods")
	public ResponseEntity<ResponseStructure<Goods>> updateGoods(@RequestParam int gid, @RequestBody Goods goods) {
		return goodsService.updateGoods(gid, goods);
	}
	@ApiOperation(value = "delete the goods ", notes = "Api is used delete the goods based on the  id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/deletegoods")
	public ResponseEntity<ResponseStructure<Goods>> delete(@RequestParam int gid){
		return goodsService.deleteGoodsById(gid);
	}
	@ApiOperation(value = "get the goods ", notes = "Api is used get the goods based on the id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })
	@GetMapping("/getgoods")
	public ResponseEntity<ResponseStructure<Goods>> getGoods(@RequestParam int gid){
		return goodsService.getGoodsById(gid);
	}
}
