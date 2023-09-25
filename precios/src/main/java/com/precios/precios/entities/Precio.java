package com.precios.precios.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "precio")
public class Precio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "brandId")
	private Long brandId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "starDate")
	private LocalDateTime starDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "endDate")
	private LocalDateTime endDate;

	@Column(name = "idPriceList")
	private Long idPriceList;

	@Column(name = "idProducto")
	private Long idProducto;

	@Column(name = "priority")
	private Long priority;

	@Column(name = "priece")
	private Double priece;

	@Column(name = "curr")
	private String curr;

	public Precio() {
		super();
	}

	public Precio(Long id, Long brandId, LocalDateTime starDate, LocalDateTime endDate, Long idPriceList,
			Long idProducto, Long priority, Double priece, String curr) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.starDate = starDate;
		this.endDate = endDate;
		this.idPriceList = idPriceList;
		this.idProducto = idProducto;
		this.priority = priority;
		this.priece = priece;
		this.curr = curr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStarDate() {
		return starDate;
	}

	public void setStarDate(LocalDateTime starDate) {
		this.starDate = starDate;
	}

	public LocalDateTime getEndDate() {

		return endDate;
	}

	public void setEndDate(LocalDateTime date) {
		this.endDate = date;
	}

	public Long getIdPriceList() {
		return idPriceList;
	}

	public void setIdPriceList(Long idPriceList) {
		this.idPriceList = idPriceList;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Double getPriece() {
		return priece;
	}

	public void setPriece(Double priece) {
		this.priece = priece;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}
