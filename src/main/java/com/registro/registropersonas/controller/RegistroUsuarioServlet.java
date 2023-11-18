package com.registro.registropersonas.controller;

import com.registro.registropersonas.model.Usuario;
import com.registro.registropersonas.model.data.DBGenerator;
import com.registro.registropersonas.model.data.dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Usuarios");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("edad").length() != 0 && request.getParameter("nombre").length() != 0 && request.getParameter("rut").length() != 0) {
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String rut = request.getParameter("rut");
            Usuario usuario = new Usuario(nombre, edad, rut);
            DSLContext query = null;
            try {
                query = DBGenerator.conectarBD("Usuarios");
                if (agregarUsuario(query, usuario)) {
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("/registroValido.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", "No se puede agregar el usuario. Ya está registrado.");
                    request.getRequestDispatcher("/registroInvalido.jsp").forward(request, response);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            }
        }


    private boolean agregarUsuario(DSLContext query, Usuario usuario) {
        try {

            if (UsuarioDAO.existeUsuario(query, usuario.getRut())) {
                return false;
            }

            UsuarioDAO.agregarUsuario(query, usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
