package entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tracking_reports")
@Component
public class TrackingReport {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trackingReportId")
	@SequenceGenerator(name = "trackingReportId", sequenceName = "tracking_reports_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Long trackingReportId;

	@Column(name = "report_description")
	private String reportDescription;

	@Column(name = "duration")
	private int duration;

	@Column(name = "tracking_date")
	private Date trackingDate;

	@Column(name = "user_id")
	private int userId;

	public TrackingReport() {

	}

	public TrackingReport(String reportDescription, int duration, Date trackingDate, int userId) {
		this.reportDescription = reportDescription;
		this.duration = duration;
		this.trackingDate = trackingDate;
		this.userId = userId;
	}

	public TrackingReport(Long trackingReportId, String reportDescription, int duration, Date trackingDate,
			int userId) {
		this.trackingReportId = trackingReportId;
		this.reportDescription = reportDescription;
		this.duration = duration;
		this.trackingDate = trackingDate;
		this.userId = userId;
	}

	public Long getTrackingReportId() {
		return trackingReportId;
	}

	public void setTrackingReportId(Long trackingReportId) {
		this.trackingReportId = trackingReportId;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getTrackingDate() {
		return trackingDate;
	}

	public void setTrackingDate(Date trackingDate) {
		this.trackingDate = trackingDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, reportDescription, trackingDate, trackingReportId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackingReport other = (TrackingReport) obj;
		return duration == other.duration && Objects.equals(reportDescription, other.reportDescription)
				&& Objects.equals(trackingDate, other.trackingDate)
				&& Objects.equals(trackingReportId, other.trackingReportId) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "TrackingReport [trackingReportId=" + trackingReportId + ", reportDescription=" + reportDescription
				+ ", duration=" + duration + ", trackingDate=" + trackingDate + ", userId=" + userId + "]";
	}

}
