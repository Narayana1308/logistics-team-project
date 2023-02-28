package com.ty.logestics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.logestics.dto.Shipment;
import com.ty.logestics.service.ShipmentService;
import com.ty.logestics.util.ResponseStructure;

public class ShipmentController {

	@Autowired
	private ShipmentService service;

	@PostMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> saveShipment(@RequestParam int id,
			@RequestBody Shipment shipment) {

		return service.saveShipment(id, shipment);
	}

	@DeleteMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> deleteShipment(@RequestParam int id) {

		return service.deleteShipment(id);
	}

	@GetMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> getShipment(@RequestParam int id) {

		return service.getShipment(id);

	}

	@PutMapping("/shipment")
	public ResponseEntity<ResponseStructure<Shipment>> updateShipment(@RequestParam int id,
			@RequestBody Shipment shipment) {

		return service.updateShipment(id, shipment);

	}

}
