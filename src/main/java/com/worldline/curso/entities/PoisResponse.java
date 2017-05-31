package com.worldline.curso.entities;

import java.util.List;

public class PoisResponse {
	
	private String status="Ok";
	private List<Poi> pois;
	private Poi poi;
	
	public PoisResponse() {
	}
	public PoisResponse(String status, List<Poi> pois) {
		super();
		this.status = status;
		this.pois = pois;
	}
	public PoisResponse(String status, Poi poi) {
		this.poi = poi;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Poi> getPois() {
		return pois;
	}
	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}
	public Poi getPoi() {
		return poi;
	}
	public void setPoi(Poi poi) {
		this.poi = poi;
	}
	
}
