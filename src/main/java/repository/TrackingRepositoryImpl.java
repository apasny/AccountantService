package repository;

import entity.TrackingReport;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrackingRepositoryImpl implements TrackingsRepository {

    private final DatabaseConnector databaseConnector;

    @Autowired
    public TrackingRepositoryImpl(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public boolean create(TrackingReport trackingReport) {

        Session session = databaseConnector.startTransaction();

        session.beginTransaction();
        session.persist(trackingReport);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    public TrackingReport read(Long trackingReportId) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Long trackingReportId) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(Long trackingReportId) {
//        Session session = databaseConnector.startTransaction();
//
//        int rows = session.createQuery("DELETE FROM TrackingReport T WHERE T.id = :id").setParameter("id", trackingReportId).executeUpdate();
//
        return true ;//rows > 0;
    }

    public List<TrackingReport> getAll() {

        Session session = databaseConnector.startTransaction();

        return session.createQuery("from TrackingReport", TrackingReport.class).getResultList();
    }

    public List<TrackingReport> getAllWithinThreeDays() {
        String sqlQueryString = "SELECT * FROM tracking_reports WHERE CAST(tracking_date AS DATE) <= CAST(CURRENT_TIMESTAMP AS DATE) AND CAST(tracking_date AS DATE) > (CAST(CURRENT_TIMESTAMP AS DATE)-integer '3')";

        Session session = databaseConnector.startTransaction();

        return session.createNativeQuery(sqlQueryString, TrackingReport.class).list();
    }

}
