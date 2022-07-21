package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.TrackingReport;
import mapper.EntityMapper;
import repository.TrackingRepositoryImpl;

@Component
public class TrackingServiceImpl implements TrackingService {
	
	@Autowired
	TrackingRepositoryImpl repository;
	
	@Autowired
	EntityMapper entityMapper;

	@Override
	public List<TrackingReport> findAll() {
		return repository.getAll();
	}

	@Override
	public Optional<TrackingReport> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void save(TrackingReport tracking) {
		repository.create(tracking);
	}

	@Override
	public List<TrackingReport> findAllWithinThreeDays() {
		return repository.getAllWithinThreeDays();
	}

	@Override
	public void deleteReportById(Long id) {
		repository.delete(id);
	}

	

}
