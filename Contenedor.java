package com.java.ws.rest.back;

public class Contenedor {
	 
    private int costo = 0;
    private int kpi = 0 ;
    private String nombreContenedor = "";

    public Contenedor(String nombreContenedor, int peso, int kpi) {
        this.nombreContenedor = nombreContenedor;
    	this.costo = peso;
        this.kpi = kpi;
    }
    
	public String getNombreContenedor() {
		return nombreContenedor;
	}

	public void setNombreContenedor(String nombreContenedor) {
		this.nombreContenedor = nombreContenedor;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getKpi() {
		return kpi;
	}

	public void setKpi(int kpi) {
		this.kpi = kpi;
	}


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Contenedor c = (Contenedor) obj;
        
        if (this.nombreContenedor != c.nombreContenedor) {
            return false;
        }
        if (this.costo != c.costo) {
            return false;
        }
        if (this.kpi != c.kpi) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        //return  "Nombre Contenedor:" + nombreContenedor + ", " + "Costo:" + costo + "," + " Kpi:" + kpi;
    	return  nombreContenedor;
    }

    
    
}
