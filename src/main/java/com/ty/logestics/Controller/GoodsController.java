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

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@PostMapping("/savegoods")
	public ResponseEntity<ResponseStructure<Goods>> saveGooods(@RequestParam int oid, @RequestParam String uid,
			@RequestParam int bid, @RequestBody Goods goods) {
		return goodsService.saveGoods(oid, uid, bid, goods);
	}

	@PutMapping("/updategoods")
	public ResponseEntity<ResponseStructure<Goods>> updateGoods(@RequestParam int gid, @RequestBody Goods goods) {
		return goodsService.updateGoods(gid, goods);
	}

	@DeleteMapping("/deletegoods")
	public ResponseEntity<ResponseStructure<Goods>> delete(@RequestParam int gid){
		return goodsService.deleteGoodsById(gid);
	}
	@GetMapping("/getgoods")
	public ResponseEntity<ResponseStructure<Goods>> getGoods(@RequestParam int gid){
		return goodsService.getGoodsById(gid);
	}
}
