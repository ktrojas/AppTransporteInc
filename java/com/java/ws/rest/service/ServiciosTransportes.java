package com.java.ws.rest.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.ws.rest.back.Estadisticas;
import com.java.ws.rest.back.Main;
import com.java.ws.rest.back.Transporte;
import com.java.ws.rest.vo.InfoContenedores;
import com.java.ws.rest.vo.ListaContenedores;

@Path("/transportesInc")
public class ServiciosTransportes {

    @POST
    @Path("/containers")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Transporte validaContenedores(ListaContenedores lista) {
    	Main cont = new Main();
    	ArrayList<InfoContenedores> contenedores = lista.getInfoContenedores();
    	Transporte solucionOptima = cont.llenarContenedores(contenedores, lista.getPresupuesto());
        return solucionOptima;
    }
    
    @GET
    @Path("/stats")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Estadisticas stats() {
    	Main cont = new Main();
    	return cont.stats();
    }
}
