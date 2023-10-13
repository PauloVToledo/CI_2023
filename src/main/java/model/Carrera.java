package model;

import model.data.DBConnector;
import model.data.dao.carreraDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Carrera {
    private String nombreCarrera;
    private String codigoCarrera;
    private int cantidadSemestres;
    public Carrera(String nombreCarrera,String codigoCarrera,int cantidadSemestres){
        this.nombreCarrera=nombreCarrera;
        this.codigoCarrera=codigoCarrera;
        this.cantidadSemestres=cantidadSemestres;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public int getCantidadSemestres() {
        return cantidadSemestres;
    }
    public boolean registrarCarrera(){
        Connection connection=DBConnector.connection("intranet","root","");
        DSLContext create= DSL.using(connection);
        return new carreraDAO().registrarCarrera(create, this);
    }
    public Carrera encontrarCarrera(){
        carreraDAO carreraDAO=new carreraDAO();
        Connection connection=DBConnector.connection("intranet","root","");
        DSLContext query= DSL.using(connection);
        return carreraDAO.encontrarCarrera(query,getNombreCarrera());
    }

    public ArrayList<String> obtenerCarreras() {
        Connection connection=DBConnector.connection("intranet","root","");
        DSLContext query= DSL.using(connection);
        return new carreraDAO().obtenerCarreras(query);
    }
}
