package br.com.uol.platcorpv1.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class MetaWeatherDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long distance;
	
	private String title;
	
	private String location_type;
	
	private Long woeid;
	
	private String latt_long;
	
	private Long id;
	
	private String weather_state_name;
	
	private Timestamp created;
	
	private Date applicable_date;
	
	private BigDecimal min_temp;
	
	private BigDecimal max_temp;
	
	private Long humidity;
	
	public MetaWeatherDTO() {		
	}

	public MetaWeatherDTO(Long distance, String title, String location_type, Long woeid, String latt_long, Long id,
			String weather_state_name, Timestamp created, Date applicable_date, BigDecimal min_temp,
			BigDecimal max_temp, Long humidity) {
		super();
		this.distance = distance;
		this.title = title;
		this.location_type = location_type;
		this.woeid = woeid;
		this.latt_long = latt_long;
		this.id = id;
		this.weather_state_name = weather_state_name;
		this.created = created;
		this.applicable_date = applicable_date;
		this.min_temp = min_temp;
		this.max_temp = max_temp;
		this.humidity = humidity;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public Long getWoeid() {
		return woeid;
	}

	public void setWoeid(Long woeid) {
		this.woeid = woeid;
	}

	public String getLatt_long() {
		return latt_long;
	}

	public void setLatt_long(String latt_long) {
		this.latt_long = latt_long;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWeather_state_name() {
		return weather_state_name;
	}

	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Date getApplicable_date() {
		return applicable_date;
	}

	public void setApplicable_date(Date applicable_date) {
		this.applicable_date = applicable_date;
	}

	public BigDecimal getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(BigDecimal min_temp) {
		this.min_temp = min_temp;
	}

	public BigDecimal getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(BigDecimal max_temp) {
		this.max_temp = max_temp;
	}

	public Long getHumidity() {
		return humidity;
	}

	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}
}
