package model.data.dao;
import model.Carrera;
import model.Estudiante;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;

import static org.jooq.impl.DSL.*;

public class estudianteDAO {
    public boolean registrarEstudiante(DSLContext query, Estudiante estudiante){
        Table estudiantes=table(name("estudiantes"));
        Field[] columnas= estudiantes.fields(
                "rut",
                "nombre",
                "nMatricula",
                "id.carrera");
        if(!EstaRegistrado(query,estudiante,estudiantes)){
            String rut= estudiante.getRut();
            String nombre=estudiante.getNombre();
            int nMatricula=estudiante.getnMatricula();
            String codigoCarrera=estudiante.getCarrera().getCodigoCarrera();
            System.out.println("codigo_:"+ codigoCarrera);
            query.insertInto(estudiantes,
                            columnas[0],
                            columnas[1],
                            columnas[2],
                            columnas[3]).
                    values(
                            rut,
                            nombre,
                            nMatricula,
                            codigoCarrera
                    ).execute();
            System.out.println("a");
            return true;
        }
        return false;
    }
    public boolean EstaRegistrado(DSLContext query, Estudiante estudiante,Table estudiantes){
        String rut=estudiante.getRut();
        int result=query.select().from(estudiantes).where(DSL.field("rut").eq(rut)).execute();
        return result==1;
    }
    public ArrayList<Estudiante> estudiantesEncontrados(DSLContext query,Estudiante estudiante){
        ArrayList<Estudiante> estudiantes=new ArrayList<>();
        String nombre=estudiante.getNombre();
        String codigoCarrera=estudiante.getCarrera().getCodigoCarrera();
        Table estudianteTabla=DSL.table("estudiantes");
        System.out.println(codigoCarrera);
        System.out.println(nombre);
        Result<Record> results =
                query.select().from(estudianteTabla)
                        .where(field("nombre").eq(nombre))
                                .or(field("carrera").eq(codigoCarrera))
                        .fetch();

        for (int i = 0; i <results.size() ; i++) {
            estudiantes.add(new Estudiante(
                    results.getValue(i,"rut").toString(),
                    results.getValue(i,"nombre").toString(),
                    Integer.parseInt(results.getValue(i,"nMatricula").toString()),
                    new Carrera(
                            "",
                            results.getValue(i,"carrera").toString(),
                            0
                    )
            ));

        }
        return estudiantes;
        }
    }

