package com.Liveasy.LoadTracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Liveasy.LoadTracker.Entities.Load;

public interface LoadDoa extends JpaRepository<Load, Long>{

	List<Load> findByshipperId(long shipperId);

	Load findByloadId(long loadId);

}
