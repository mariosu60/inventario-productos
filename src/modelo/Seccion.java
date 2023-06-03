/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mario
 */
public class Seccion {
    private String codigoSeccion;
    private String nombre;
    private String color;

    public Seccion(String codigoSeccion, String nombre, String color) {
        this.codigoSeccion = codigoSeccion;
        this.nombre = nombre;
        this.color = color;
    }
    
    public Seccion(){
        
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Seccion{" + "codigoSeccion=" + codigoSeccion + ", nombre=" + nombre + ", color=" + color + '}';
    }
    
    
}
