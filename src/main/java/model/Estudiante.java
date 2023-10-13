package model;

import model.data.DBConnector;
import model.data.dao.estudianteDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Estudiante {
    private String rut;
    private String nombre;
    private int nMatricula;
    private Carrera carrera;

    public Estudiante(String rut, String nombre, int nMatricula, Carrera carrera) {
        this.rut = rut;
        this.nombre = nombre;
        this.nMatricula = nMatricula;
        this.carrera = carrera;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public int getnMatricula() {
        return nMatricula;
    }

    public Carrera getCarrera() {
        return carrera;
    }
    public boolean registrarEstudiante(){
        Connection connection= DBConnector.connection("intranet","root","");
        DSLContext query= DSL.using(connection);
        return new estudianteDAO().registrarEstudiante(query,this);
    }
    public ArrayList<Estudiante> estudiantesEcontrados(){
        Connection connection= DBConnector.connection("intranet","root","");
        DSLContext query= DSL.using(connection);
        return new estudianteDAO().estudiantesEncontrados(query,this);
    }
}
