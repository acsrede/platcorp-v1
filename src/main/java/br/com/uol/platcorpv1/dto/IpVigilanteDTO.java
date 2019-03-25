package br.com.uol.platcorpv1.dto;

import java.io.Serializable;

public class IpVigilanteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	
	private Data data;

	public IpVigilanteDTO() {		
	}

	public IpVigilanteDTO(String status, Data data) {
		super();
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
