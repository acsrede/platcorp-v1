package br.com.uol.platcorpv1.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="cliente_eventos")
public class ClienteEventos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevt;

	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	private BigDecimal max_temp;
	
	private BigDecimal min_temp;

	private String ipexterno;
	
	private String ipinterno;
	
	public ClienteEventos() {
	}

	public ClienteEventos(Long idevt, Cliente cliente, BigDecimal max_temp, BigDecimal min_temp, String ipexterno, String ipinterno) {
		super();
		this.idevt = idevt;
		this.cliente = cliente;
		this.max_temp = max_temp;
		this.min_temp = min_temp;
		this.ipexterno = ipexterno;
		this.ipinterno = ipinterno;
	}

	public Long getIdevt() {
		return idevt;
	}

	public void setIdevt(Long idevt) {
		this.idevt = idevt;
	}

	public BigDecimal getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(BigDecimal max_temp) {
		this.max_temp = max_temp;
	}

	public BigDecimal getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(BigDecimal min_temp) {
		this.min_temp = min_temp;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getIpexterno() {
		return ipexterno;
	}

	public void setIpexterno(String ipexterno) {
		this.ipexterno = ipexterno;
	}

	public String getIpinterno() {
		return ipinterno;
	}

	public void setIpinterno(String ipinterno) {
		this.ipinterno = ipinterno;
	}
}
