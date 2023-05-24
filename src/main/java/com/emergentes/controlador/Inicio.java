package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // --System.out.println("INICIANDO PROYECTO..." + request.getParameter("action"));
        try {
            int id;
            Aviso avi = new Aviso();
            AvisoDAO dao = new AvisoDAOimpl();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

//-- System.out.println("Opcion enviada: " +action);
            switch (action) {
                case "add":
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect (request.getContextPath()+"/inicio");
                    break;
                case "view":
                    List<Aviso> lista = dao.getAll();
                    request.setAttribute("avisos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Aviso avi = new Aviso();
        
        avi.setId(id);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        
        try {
            AvisoDAO dao = new AvisoDAOimpl();
            if (id == 0) {
                // Insertar registro
                dao.insert(avi);
            } else {
                //Actualizar registro
                dao.update(avi);
            }
        } catch (Exception ex) {
            System.out.println("ERROR al guardar datos...");
        }
        response.sendRedirect("inicio");
        
    }
    
}
