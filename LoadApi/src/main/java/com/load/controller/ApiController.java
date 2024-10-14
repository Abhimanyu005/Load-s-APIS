package com.load.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.load.entity.LoadApi;
import com.load.exception.ResourceNotFoundException;
import com.load.services.ServiceImplementation;

@RestController
@RequestMapping("/load")
public class ApiController {

	@Autowired
	private ServiceImplementation implementation;

	@PostMapping
	public ResponseEntity<String> addLoad(@RequestBody LoadApi load) {
		implementation.addLoad(load);
		return ResponseEntity.status(HttpStatus.CREATED).body("Load details added successfully");
	}

	@GetMapping
	public ResponseEntity<List<LoadApi>> getLoadsByShipperId(@RequestParam UUID shipperId) {
		List<LoadApi> loads = implementation.getLoadsByShipperId(shipperId);
		return ResponseEntity.ok(loads);
	}

	@GetMapping("/{loadId}")
	public ResponseEntity<LoadApi> getLoadById(@PathVariable UUID loadId) throws ResourceNotFoundException {
		LoadApi load = implementation.getLoadById(loadId);
		return ResponseEntity.ok(load);
	}

	@PutMapping("/{loadId}")
	public ResponseEntity<LoadApi> updateLoad(@PathVariable UUID loadId, @RequestBody LoadApi updatedLoad)
			throws ResourceNotFoundException {
		LoadApi load = implementation.updateLoad(loadId, updatedLoad);
		return ResponseEntity.ok(load);
	}

	@DeleteMapping("/{loadId}")
	public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId) throws ResourceNotFoundException {
		implementation.deleteLoad(loadId);
		return ResponseEntity.ok("Load deleted successfully");
	}

}
