package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import entity.TrackingReport;


public interface TrackingService {

	List<TrackingReport> findAll();
	Optional<TrackingReport> findById(Long id);
	void save(TrackingReport tracking);
	List<TrackingReport> findAllWithinThreeDays();
	void deleteReportById(Long id);
	
}
