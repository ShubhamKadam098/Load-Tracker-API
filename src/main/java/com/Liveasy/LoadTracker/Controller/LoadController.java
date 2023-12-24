package com.Liveasy.LoadTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Liveasy.LoadTracker.Entities.Load;
import com.Liveasy.LoadTracker.Services.LoadServicesImplementation;

@RestController
public class LoadController {

	@Autowired
	private LoadServicesImplementation loadServicesImplementation;

	@GetMapping("/health")
	public String health() {
		return "Server is running";
	}

	// Add new Load
	@PostMapping("/load")
	public String addLoad(@RequestBody Load load) {
		return this.loadServicesImplementation.addLoad(load);
	}

	// Fetch all loads
	@GetMapping("/loads")
	public List<Load> getLoads() {
		return this.loadServicesImplementation.getLoads();
	}

	// Fetch all load for a shipperId
	@GetMapping("/load")
	public List<Load> getLoads(@RequestParam String shipperId) {
		return this.loadServicesImplementation.getLoads(Long.parseLong(shipperId));
	}

	// Fetch details of load
	@GetMapping("/load/{loadId}")
	public Load getDetailsOfload(@PathVariable String loadId) {
		return this.loadServicesImplementation.getDetailsOfLoad(Long.parseLong(loadId));
	}

	// Update Load with ID
	@PutMapping("/load/{loadId}")
	public String addLoad(@PathVariable String loadId, @RequestBody Load load) {
		return this.loadServicesImplementation.updateLoad(Long.parseLong(loadId), load);
	}

	// Delete new Load
	@DeleteMapping("/load/{loadId}")
	public String deleteLoad(@PathVariable String loadId) {
		return this.loadServicesImplementation.deleteLoad(Long.parseLong(loadId));
	}
}
