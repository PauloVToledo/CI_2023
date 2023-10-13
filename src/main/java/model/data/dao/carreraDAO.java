package model.data.dao;

import model.Carrera;
import model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class carreraDAO {
    public boolean registrarCarrera(DSLContext query, Carrera carrera){
        String codigo= carrera.getCodigoCarrera();
        String nombreCarrera=carrera.getNombreCarrera();
        Table carrerasTabla=table(name("carreras"));
        if(!existeCarreraOCodigo(query,carrerasTabla,carrera)){
            int cantidadSemestres=carrera.getCantidadSemestres();
            Field[] columnas= carrerasTabla.fields(
                    "id",
                    "nombre_carrera",
                    "semestres");
            int results=query.insertInto(
                    carrerasTabla,
                    columnas[0],columnas[1],columnas[2]
            ).values(
                    codigo,nombreCarrera,cantidadSemestres
            ).execute();
            //query.close();
            DBConnector.closeConnection();
            return results == 1;
        }else{
            return false;
        }
    }
    public boolean existeCarreraOCodigo(DSLContext query,Table table,Carrera carrera){
        String codigo= carrera.getCodigoCarrera();
        String nombreCarrera=carrera.getNombreCarrera();
            int resultCodigo=query.select().from(table)
                    .where(DSL.field("id").eq(codigo)).execute();
            int resultNombre=query.select().from(table)
                    .where(DSL.field("nombre_carrera").eq(nombreCarrera)).execute();
            return resultCodigo>0 || resultNombre>0;
    }
    public Carrera encontrarCarrera(DSLContext query, String nombreCarrera){
        Table carrerasTabla=table(name("carreras"));

        Result result=query.select(
                DSL.field("id"),
                DSL.field("nombre_carrera"),
                DSL.field("semestres")
        ).from(carrerasTabla).where(
                DSL.field("nombre_carrera").eq(nombreCarrera)).fetch();
        return new Carrera(
                result.getValue(0,"nombre_carrera").toString(),
                result.getValue(0,"id").toString(),
                Integer.parseInt(result.getValue(0,"semestres").toString()));

    }

    public ArrayList<String> obtenerCarreras(DSLContext query) {
        Table carrerasTabla=table(name("carreras"));
        Result result=query.select(DSL.field("nombre_carrera")).
                from(carrerasTabla).fetch();
        ArrayList<String> nombreCarreras=new ArrayList<>();
        for (int i = 0; i <result.size() ; i++) {
            nombreCarreras.add((result.getValue(i, "nombre_carrera")).toString());
        }
        DBConnector.closeConnection();
        return nombreCarreras;
    }
}
