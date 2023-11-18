package com.registro.registropersonas.model.data.dao;

import com.registro.registropersonas.model.Usuario;
import org.jooq.DSLContext;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;


public class UsuarioDAO {
    public static void agregarUsuario(DSLContext query, Usuario usuario){
        Table tablaUsuario = table(name("Usuario"));
        Field[] columnas = tablaUsuario.fields("nombre", "edad", "rut");
        query.insertInto(tablaUsuario, columnas[0], columnas[1], columnas[2])
                .values(usuario.getNombre(), usuario.getEdad(), usuario.getRut())
                .execute();
    }
    public static boolean existeUsuario(DSLContext query, String rut) {
        Table tablaUsuario = table(name("Usuario"));
        Result<Record> resultado = query.select().from(tablaUsuario).where(field("rut").eq(rut)).fetch();
        return resultado.isNotEmpty();
    }
}
