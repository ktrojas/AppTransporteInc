package com.java.ws.rest.back;

import java.util.ArrayList;

import com.java.ws.rest.vo.InfoContenedores;

public class Main {

	static int gkpiNoDespachado = 0;
	static int gkpiTotal = 0;
	static int gpresupuesto = 0;
	    
    public Transporte llenarContenedores(ArrayList<InfoContenedores> contenedores, int presupuesto) {
    	
    	Contenedor[] contenedor = new Contenedor[contenedores.size()];
        
    	int kpiTotal =0;
    	
    	for(int i = 0; i<contenedores.size(); i++) {
    		contenedor[i] = new Contenedor(contenedores.get(i).getNombreContenedor(), contenedores.get(i).getCosto(), contenedores.get(i).getKpi());
    		kpiTotal += contenedores.get(i).getKpi();
    	}

        Transporte t_base = new Transporte(presupuesto, contenedores.size(),kpiTotal);
        Transporte t_mejorKpi = new Transporte(presupuesto, contenedores.size(),kpiTotal);

        seleccionContenedores(t_base, contenedor, false, t_mejorKpi);
        t_mejorKpi.setKpiNoDespachado(t_mejorKpi.getKpiTotal() -  t_mejorKpi.getKpi());

        gkpiNoDespachado = t_mejorKpi.getKpiNoDespachado();
        gkpiTotal = t_mejorKpi.getKpi();
        gpresupuesto = presupuesto;
         
        return t_mejorKpi;
    }
    
    public Estadisticas stats() {
    	
    	Estadisticas e_mejorKpi = new Estadisticas(gpresupuesto, gkpiTotal, gkpiNoDespachado);
    	return e_mejorKpi;
    }
    
    
    
	/*************************************************************************************
    * Selecciona los contenedores a transportar
    * @param t_base , contenedores , maxPresupuesto, t_mejorKpi
    ************************************************************************************/

    public static void seleccionContenedores(Transporte t_base, Contenedor[] contenedores, boolean maxPresupuesto, Transporte t_mejorKpi) {

        //se cumple con el presupuesto?
        if (maxPresupuesto) {
            //compruebo si tiene mas KPI que otra
            if (t_base.getKpi() > t_mejorKpi.getKpi()) {

                Contenedor[] contenedoresBase = t_base.getContenedor();
                t_mejorKpi.clear();

                for (Contenedor c : contenedoresBase) {
                    if (c != null) {
                        t_mejorKpi.agregarContenedor(c);
                    }
                }
            }

        } else {
            //Recorre los contenedores
            for (int i = 0; i < contenedores.length; i++) {
                //si existe el contenedor
                if (!t_base.existeContenedor(contenedores[i])) {
                    //Si el costo del Transporte se supera, indicamos que esta cumple el costo
                    if (t_base.getCostoMaximo() >= t_base.getCosto() + contenedores[i].getCosto()) {
                        t_base.agregarContenedor(contenedores[i]); //agregamos un contenedor
                        seleccionContenedores(t_base, contenedores, false, t_mejorKpi);
                        t_base.eliminarContenedor(contenedores[i]); // eliminamos contenedor
                    } else {
                        seleccionContenedores(t_base, contenedores, true, t_mejorKpi);
                    }

                }

            }

        }

    }

}

