package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import entity.TrackingReport;

@Repository
public interface TrackingsRepository {
	
	boolean create(TrackingReport trackingReport);
	TrackingReport read(Long trackingReportId);
	boolean update(Long trackingReportId);
	boolean delete(Long trackingReportId);
	List<TrackingReport> getAll();
	
}
