package com.java.ws.rest.back;

public class Estadisticas {
	
    private int costoMaximo;
    private int kpiDespachado;
    private int kpiNoDespachado;

    
    
    public Estadisticas(int costoMaximo, int kpiDespachado, int kpiNoDespachado) {
        this.costoMaximo = costoMaximo;
        this.kpiDespachado = kpiDespachado;
        this.kpiNoDespachado = kpiNoDespachado;
    }

    public Estadisticas() {
	}

	public int getCostoMaximo() {
		return costoMaximo;
	}

	public void setCostoMaximo(int costoMaximo) {
		this.costoMaximo = costoMaximo;
	}

	public int getKpiDespachado() {
		return kpiDespachado;
	}

	public void setKpiDespachado(int kpiDespachado) {
		this.kpiDespachado = kpiDespachado;
	}

	public int getKpiNoDespachado() {
		return kpiNoDespachado;
	}

	public void setKpiNoDespachado(int kpiNoDespachado) {
		this.kpiNoDespachado = kpiNoDespachado;
	}
    
    
}
