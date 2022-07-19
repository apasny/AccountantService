package mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.TrackingReport;

@Component
public class EntityMapper {

	public String mapToJson(TrackingReport trackingReport) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(trackingReport);
					
		return json;
	}

	public TrackingReport mapToEntity(String trackingReportJson) {

		Gson gson = new Gson();
		TrackingReport trackingReportEntity = gson.fromJson(trackingReportJson, TrackingReport.class);

		return trackingReportEntity;
	}

	public List<TrackingReport> mapFromNativeQuery(List<Object[]> list) throws ParseException {
		
		List<TrackingReport> trackingReports = new ArrayList<>();
		
		for (Object[] row : list) {
			TrackingReport trackingReport = new TrackingReport();
			trackingReport.setTrackingReportId(Long.parseLong(row[0].toString()));
			trackingReport.setReportDescription(row[1].toString());
			trackingReport.setDuration(Integer.parseInt(row[2].toString()));
			trackingReport.setTrackingDate(new SimpleDateFormat("yyyy-MM-dd").parse(row[3].toString()));
			trackingReport.setUserId(Integer.parseInt(row[4].toString()));
			trackingReports.add(trackingReport);
		}
		
		return trackingReports;
	}
}
