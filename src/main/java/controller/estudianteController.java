package controller;

import model.Carrera;
import model.Estudiante;
import views.tablaEstudiantesCarreraView;

public class estudianteController {
    public boolean registrarEstudiante(String rut,String nombre,int nMatricula, String nombreCarrera){

        Carrera carreraEncontrada=new Carrera(nombreCarrera,"",0).encontrarCarrera();
        Estudiante estudiante=new Estudiante(rut,nombre,nMatricula,carreraEncontrada);
        return estudiante.registrarEstudiante();
    }
    public boolean estudiantesEncontrados(String nombreEstudiante,String nombreCarrera){
        Carrera carreraBuscar=new Carrera(nombreCarrera,"",0);
        carreraBuscar=carreraBuscar.encontrarCarrera();
        Estudiante estudiante=new Estudiante("",nombreEstudiante,0,carreraBuscar);
        new tablaEstudiantesCarreraView(estudiante.estudiantesEcontrados());
        return true;
    }
}
