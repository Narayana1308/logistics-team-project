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

import com.ty.logestics.dto.Shipment;
import com.ty.logestics.service.ShipmentService;
import com.ty.logestics.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ShipmentController {

	@Autowired
	private ShipmentService service;

	@ApiOperation(value = "save the shipment ", notes = "Api is used save the shipment  based on goods id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 404, message = "not found") })

	@PostMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> saveShipment(@RequestParam int id,
			@RequestBody Shipment shipment) {

		return service.saveShipment(id, shipment);
	}

	@ApiOperation(value = "delete the shipment ", notes = "Api is used delete the shipment  based on shipment id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "not found") })

	@DeleteMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> deleteShipment(@RequestParam int id) {

		return service.deleteShipment(id);
	}

	@ApiOperation(value = "get the shipment ", notes = "Api is used get the shipment  based on shipment id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })

	@GetMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> getShipment(@RequestParam int id) {

		return service.getShipment(id);

	}

	@ApiOperation(value = "update the shipment ", notes = "Api is used update the shipment  based on goods id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "not found") })

	@PutMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> updateShipment(@RequestParam int id,
			@RequestBody Shipment shipment,@RequestParam int bid) {

		return service.updateShipment(id, shipment,bid);

	}

}
