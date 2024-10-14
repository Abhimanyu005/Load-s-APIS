package com.load.repositry;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.load.entity.LoadApi;

@Repository
public interface LoadApiRepo extends JpaRepository<LoadApi, UUID>{
	 List<LoadApi> findByShipperId(UUID shipperId);

}
