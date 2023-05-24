
package com.emergentes.modelo;

public class Aviso {
    private int id;
    private String titulo;
    private String contenido;
    
    public Aviso()
    {
        id = 0;
        titulo = "";
        contenido = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
//LOS CUALES SON VALOR QUE TIENE EL OBJETO EN DETERMINADO TIEMPO
    
    @Override
    public String toString() {
        return "Aviso{" + "id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + '}';
    }
}
