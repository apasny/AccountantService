package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import entity.TrackingReport;

@Component
public class DatabaseConnector {

	private SessionFactory sessionFactory;
	
	public DatabaseConnector() {
		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(TrackingReport.class);

		// Create Session Factory
		this.sessionFactory = configuration.buildSessionFactory();
	}

	public Session startTransaction() {
		Session session = sessionFactory.openSession();
		return session;
	}

}