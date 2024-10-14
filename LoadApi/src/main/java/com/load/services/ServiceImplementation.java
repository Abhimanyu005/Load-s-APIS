package com.load.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.load.entity.LoadApi;
import com.load.exception.ResourceNotFoundException;
import com.load.repositry.LoadApiRepo;

@Service
public class ServiceImplementation implements LoadApiService {
	
	@Autowired
	private LoadApiRepo apiRepo;

	@Override
	public LoadApi addLoad(LoadApi load) {
		return apiRepo.save(load);
	}

	@Override
	public List<LoadApi> getLoadsByShipperId(UUID shipperId) {
		 return apiRepo.findByShipperId(shipperId);
	}


	@Override
	public LoadApi updateLoad(UUID loadId, LoadApi updatedLoad) throws ResourceNotFoundException {
		 LoadApi existingLoad = apiRepo.findById(loadId)
			        .orElseThrow(() -> new ResourceNotFoundException("Load not found with id: " + loadId));
			    existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
			    existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
			    existingLoad.setProductType(updatedLoad.getProductType());
			    existingLoad.setTruckType(updatedLoad.getTruckType());
			    existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
			    existingLoad.setWeight(updatedLoad.getWeight());
			    existingLoad.setComment(updatedLoad.getComment());
			    existingLoad.setShipperId(updatedLoad.getShipperId());
			    existingLoad.setDate(updatedLoad.getDate());
			    
			    return apiRepo.save(existingLoad);
	}

	@Override
	public void deleteLoad(UUID loadId) throws ResourceNotFoundException {
		 LoadApi load = apiRepo.findById(loadId)
			        .orElseThrow(() -> new ResourceNotFoundException("Load not found with id: " + loadId));
			    apiRepo.delete(load);
		
	}

	@Override
	public LoadApi getLoadById(UUID loadId) throws ResourceNotFoundException {
		 return apiRepo.findById(loadId)
		            .orElseThrow(() -> new ResourceNotFoundException("Load not found with id: " + loadId));
	}

}
