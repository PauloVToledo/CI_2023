package controller;

import model.Carrera;

import java.util.ArrayList;

public class carreraController {
    public boolean registrarCarrera(String nombreCarrera,String codigoCarrera,int cantidadaSemestres){
        Carrera carrera=new Carrera(nombreCarrera,codigoCarrera,cantidadaSemestres);
        return carrera.registrarCarrera();
    }
    public ArrayList<String> obtenerNombresCarreras(){
        return new Carrera("","",0).obtenerCarreras();
    }
}
