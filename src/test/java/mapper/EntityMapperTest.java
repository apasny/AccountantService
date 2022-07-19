package mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;

import entity.TrackingReport;
import repository.DatabaseConnector;

public class EntityMapperTest {

	@Test
	public void mapToJson() throws ParseException {
		
		List<String> trackingReportsJson = new ArrayList<>();
		DatabaseConnector databaseConnector = new DatabaseConnector();
		Session session = databaseConnector.startTransaction();
		EntityMapper entityMapper = new EntityMapper();
		
		String sqlQueryString = "SELECT * FROM tracking_reports WHERE CAST(tracking_date AS DATE) <= CAST(CURRENT_TIMESTAMP AS DATE) AND CAST(tracking_date AS DATE) > (CAST(CURRENT_TIMESTAMP AS DATE)-integer '3')";

		@SuppressWarnings("unchecked")
		NativeQuery<Object[]> query = session.createNativeQuery(sqlQueryString);

		List<Object[]> rows = query.list();

		List<TrackingReport> trackingReports = entityMapper.mapFromNativeQuery(rows);
		
		for (TrackingReport trackingReport : trackingReports) {
			trackingReportsJson.add(entityMapper.mapToJson(trackingReport));
		}

		System.out.println(trackingReportsJson.get(0));
		
		assertEquals(trackingReportsJson.size(), 3);
	}

}
