package com.java.ws.rest.back;


public class Transporte {

    
    private Contenedor[] contenedores;

    private int costoMaximo;
    private int costo;
    private int kpi;
    private int kpiTotal;
    private int kpiNoDespachado;

    public int getKpiNoDespachado() {
		return kpiNoDespachado;
	}

	public void setKpiNoDespachado(int kpiNoDespachado) {
		this.kpiNoDespachado = kpiNoDespachado;
	}

	public Transporte(int costoMaximo, int numContenedores, int kpiTotal) {
        this.costoMaximo = costoMaximo;
        this.kpiTotal = kpiTotal;
        this.contenedores = new Contenedor[numContenedores];
        this.kpi = 0;
        this.costo = 0;
    }

	public Transporte() {
	}

	public int getKpiTotal() {
		return kpiTotal;
	}
	public void setKpiTotal(int kpiTotal) {
		this.kpiTotal = kpiTotal;
	}
    
    public int getCostoMaximo() {
		return costoMaximo;
	}

	public void setCostoMaximo(int costoMaximo) {
		this.costoMaximo = costoMaximo;
	}

	public Contenedor[] getContenedor() {
		return contenedores;
	}

	public void setContenedor(Contenedor[] Contenedor) {
		this.contenedores = Contenedor;
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

	/*************************************************************************************
     * Agrega un contenedor a la lista a transportar
     * @param c 
     ************************************************************************************/
	
    public void agregarContenedor(Contenedor c) {

        for (int i = 0; i < this.contenedores.length; i++) {
            if (this.contenedores[i] == null) {
                this.contenedores[i] = c; //lo agrega
                this.kpi += c.getKpi(); // aumenta el KPI
                this.costo += c.getCosto(); // Aumenta el costo
                break;
            }
        }

    }

    /*************************************************************************************
     * Vaciamos la lista de los contenedores a transportar
     ************************************************************************************/
    
    public void clear() {
        this.costo = 0;
        this.kpi = 0;
        for (int i = 0; i < this.contenedores.length; i++) {
            this.contenedores[i] = null;
        }
    }

    /*************************************************************************************
     * Elimina contenedor ingresado
     * @param c 
     ************************************************************************************/
    
    public void eliminarContenedor(Contenedor c) {
        for (int i = 0; i < this.contenedores.length; i++) {
            if (this.contenedores[i].equals(c)) {
                this.contenedores[i] = null; //saca el contenedor de la lista a transportar
                this.costo-=c.getCosto(); //Reduce el costo
                this.kpi-=c.getKpi(); // reduce el KPI
                break;
            }
        }
    }
    
    /*************************************************************************************
     * Indica si el contenedor ya existe 
     * @param c
     * @return 
     ************************************************************************************/
    
    public boolean existeContenedor(Contenedor c) {
        for (int i = 0; i < this.contenedores.length; i++) {
            if (this.contenedores[i] != null && this.contenedores[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    /*************************************************************************************
     * Muestra los contenedores a transportar con mejor KPI
     * @return 
     ************************************************************************************/
    
    public String toString() {
       
    	String cadena = "";
    	int kpiNoDespachado = 0;
        
    	this.setKpiNoDespachado(getKpiTotal() -  getKpi());
    	
        for (int i = 0; i < this.contenedores.length; i++) {
            if (this.contenedores[i] != null) {
                cadena+=contenedores[i]+",";
            }
        }
        cadena += "\nCosto: " + getCosto() + "\n";
        cadena += "Kpi: " + getKpi() + "\n";
        cadena += "Kpi no despachado: " + kpiNoDespachado + "\n";
        return cadena;
    }

}
