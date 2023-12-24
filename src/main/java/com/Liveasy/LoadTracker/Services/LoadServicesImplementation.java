package com.Liveasy.LoadTracker.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Liveasy.LoadTracker.Entities.Load;
import com.Liveasy.LoadTracker.Repository.LoadDoa;

@Service
public class LoadServicesImplementation implements LoadServices {

	private final LoadDoa loadDoa;

	@Autowired
	public LoadServicesImplementation(LoadDoa loadDoa) {
		this.loadDoa = loadDoa;
	}

	@Override
	public List<Load> getLoads(long shipperId) {
		return loadDoa.findByshipperId(shipperId);
	}

	@Override
	public List<Load> getLoads() {
		return loadDoa.findAll();
	}

	@Override
	public Load getDetailsOfLoad(long loadId) {
		return loadDoa.findByloadId(loadId);
	}

	@Override
	public String updateLoad(long loadId, Load newLoad) {
		boolean exists = loadDoa.existsById(loadId);
		if (exists) {
			try {
				newLoad.setLoadId(loadId);
				loadDoa.save(newLoad);
				return "Load Details updated successfully";
			} catch (Exception e) {
				return e.toString();
			}
		} else {
			return "Load Id does not exists";
		}
	}

	@Override
	public String addLoad(Load load) {
		try {
			loadDoa.save(load);
			return "Load Details added successfully";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String deleteLoad(long loadId) {
		boolean exists = loadDoa.existsById(loadId);
		if (!exists) {
			return "Load Id does not exists";
		} else {
			try {
				loadDoa.deleteById(loadId);
				return "Load is deleted successfully";
			} catch (Exception e) {
				return e.toString();
			}
		}
	}

}


