package br.com.uol.platcorpv1.dto;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	public String continent_name;
	
	public String country_name;
	
	public String subdivision_1_name;
	
	public String city_name;
	
	public String latitude;
	
	public String longitude;

	public Data() {
	}

	public Data(String continent_name, String country_name, String subdivision_1_name, String city_name,
			String latitude, String longitude) {
		super();
		this.continent_name = continent_name;
		this.country_name = country_name;
		this.subdivision_1_name = subdivision_1_name;
		this.city_name = city_name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getContinent_name() {
		return continent_name;
	}

	public void setContinent_name(String continent_name) {
		this.continent_name = continent_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getSubdivision_1_name() {
		return subdivision_1_name;
	}

	public void setSubdivision_1_name(String subdivision_1_name) {
		this.subdivision_1_name = subdivision_1_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city_name == null) ? 0 : city_name.hashCode());
		result = prime * result + ((continent_name == null) ? 0 : continent_name.hashCode());
		result = prime * result + ((country_name == null) ? 0 : country_name.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((subdivision_1_name == null) ? 0 : subdivision_1_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (city_name == null) {
			if (other.city_name != null)
				return false;
		} else if (!city_name.equals(other.city_name))
			return false;
		if (continent_name == null) {
			if (other.continent_name != null)
				return false;
		} else if (!continent_name.equals(other.continent_name))
			return false;
		if (country_name == null) {
			if (other.country_name != null)
				return false;
		} else if (!country_name.equals(other.country_name))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (subdivision_1_name == null) {
			if (other.subdivision_1_name != null)
				return false;
		} else if (!subdivision_1_name.equals(other.subdivision_1_name))
			return false;
		return true;
	}
}