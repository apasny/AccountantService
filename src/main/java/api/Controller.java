package api;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entity.TrackingReport;
import mapper.EntityMapper;
import service.TrackingService;

@RestController
public class Controller {

	@Autowired
	private TrackingService service;

	@Autowired
	private EntityMapper entityMapper;

	@GetMapping(value = "/trackings", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<TrackingReport>> getAllTrackings() {

		List<TrackingReport> trackingReports = service.findAll();

		return new ResponseEntity<List<TrackingReport>>(trackingReports, HttpStatus.OK);
	}

	@PostMapping("/trackings")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveTracking(@RequestBody String trackingReport) {

		TrackingReport trackingReportEntity = entityMapper.mapToEntity(trackingReport);

		service.save(trackingReportEntity);
	}

	@GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<TrackingReport>> getReport() throws ParseException {

		List<TrackingReport> trackingReportsWithinThreeDays = entityMapper
				.mapFromNativeQuery(service.findAllWithinThreeDays());

		return new ResponseEntity<List<TrackingReport>>(trackingReportsWithinThreeDays, HttpStatus.OK);
	}

	@DeleteMapping("/trackings/{id}")
	void deleteTrackingReport(@PathVariable Long id) {
		service.deleteReportById(id);
	}

}
