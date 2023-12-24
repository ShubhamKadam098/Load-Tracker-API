package com.Liveasy.LoadTracker.Services;

import java.util.List;

import com.Liveasy.LoadTracker.Entities.Load;

public interface LoadServices{

	public List<Load> getLoads(long shipperId);
	
	public List<Load> getLoads();
	
	public Load getDetailsOfLoad(long loadId);
	
	public String updateLoad(long loadId, Load load);
	
	public String addLoad(Load load);
	
	public String deleteLoad(long loadId);
}
