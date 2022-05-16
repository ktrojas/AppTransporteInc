package com.java.ws.rest.vo;

import java.util.ArrayList;

public class ListaContenedores {
	
    private int presupuesto;
    private String contMejorkpi;
    private ArrayList<InfoContenedores> infoContenedores;
    private ArrayList<String> contenedoresMejorKpi;
    
    
	public int getPresupuesto() {
		return presupuesto;
	}
	public ArrayList<InfoContenedores> getInfoContenedores() {
		return infoContenedores;
	}
	public void setInfoContenedores(ArrayList<InfoContenedores> infoContenedores) {
		this.infoContenedores = infoContenedores;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getContMejorkpi() {
		return contMejorkpi;
	}
	public void setContMejorkpi(String contMejorkpi) {
		this.contMejorkpi = contMejorkpi;
	}
	public ArrayList<String> getContenedoresMejorKpi() {
		return contenedoresMejorKpi;
	}
	public void setContenedoresMejorKpi(ArrayList<String> contenedoresMejorKpi) {
		this.contenedoresMejorKpi = contenedoresMejorKpi;
	}
	
  
}
