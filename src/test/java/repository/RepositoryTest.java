package repository;


public class RepositoryTest {

//	@Test
//	public void testConnection() {
//
//		DatabaseConnector databaseConnector = new DatabaseConnector();
//
//		Session session = databaseConnector.startTransaction();
//
//		assertNotNull(session);
//	}
//	
//	@Test
//	public void getAll() {
//
//		DatabaseConnector databaseConnector = new DatabaseConnector();
//
//		Session session = databaseConnector.startTransaction();
//
//		List<TrackingReport> result = session.createQuery("from TrackingReport", TrackingReport.class).getResultList();
//
//		assertEquals(result.size(), 0);
//	}

//	@Test
//	public void getAllWithinThreeDays() {
//
//		DatabaseConnector databaseConnector = new DatabaseConnector();
//
//		Session session = databaseConnector.startTransaction();
//
//		List<TrackingReport> result = session.createNativeQuery(
//				"SELECT * FROM tracking_reports WHERE CAST(tracking_date AS DATE) <= CAST(CURRENT_TIMESTAMP AS DATE) AND CAST(tracking_date AS DATE) > (CAST(CURRENT_TIMESTAMP AS DATE)-integer '3')",
//				TrackingReport.class).getResultList();
//
//		session.close();
//
//		assertEquals(result.size(), 3);
//	}

//	@Test
//	public void delete() {
//
//		DatabaseConnector databaseConnector = new DatabaseConnector();
//
//		Session session = databaseConnector.startTransaction();
//
//		session.beginTransaction();
//		
//		int rows = session.createQuery("DELETE FROM TrackingReport t WHERE t.id = :id")
//				.setParameter("id", 8L).executeUpdate();
//
//		session.getTransaction().commit();
//		session.close();
//
//		assertTrue(rows > 0);
//	}
}
