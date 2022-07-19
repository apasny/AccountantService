package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.TrackingReport;

@Component
public class TrackingRepositoryImpl implements TrackingsRepository {

	@Autowired
	DatabaseConnector databaseConnector;

	@Override
	public boolean create(TrackingReport trackingReport) {

		Session session = databaseConnector.startTransaction();

		session.beginTransaction();
		session.save(trackingReport);
		session.getTransaction().commit();
		session.close();

		return true;
	}

	@Override
	public TrackingReport read(Long trackingReportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Long trackingReportId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long trackingReportId) {
		Session session = databaseConnector.startTransaction();
		
		int rows = session.createQuery("DELETE FROM TrackingReport T WHERE T.id = :id").setParameter("id", trackingReportId).executeUpdate();
		
		return rows > 0;
	}

	@Override
	public List<TrackingReport> getAll() {

		Session session = databaseConnector.startTransaction();

		return session.createQuery("from TrackingReport", TrackingReport.class).getResultList();
	}

	public List<Object[]> getAllWithinThreeDays() {
		String sqlQueryString = "SELECT * FROM tracking_reports WHERE CAST(tracking_date AS DATE) <= CAST(CURRENT_TIMESTAMP AS DATE) AND CAST(tracking_date AS DATE) > (CAST(CURRENT_TIMESTAMP AS DATE)-integer '3')";

		Session session = databaseConnector.startTransaction();

		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createNativeQuery(sqlQueryString);

		List<Object[]> trackingReports = query.list();

		return trackingReports;
	}

}
