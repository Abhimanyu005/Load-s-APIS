package com.load.services;

import java.util.List;
import java.util.UUID;

import com.load.entity.LoadApi;
import com.load.exception.ResourceNotFoundException;

public interface LoadApiService {
	
	  public LoadApi addLoad(LoadApi load);
	  public List<LoadApi> getLoadsByShipperId(UUID shipperId);
	  public LoadApi getLoadById(UUID loadId) throws ResourceNotFoundException;
	  public LoadApi updateLoad(UUID loadId, LoadApi updatedLoad) throws ResourceNotFoundException;
	  public void deleteLoad(UUID loadId) throws ResourceNotFoundException;

}
