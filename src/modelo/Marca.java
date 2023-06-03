/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mario
 */
public class Marca {
    private String codigoMarca;
    private String nombre;

    public Marca(String codigoMarca, String nombre) {
        this.codigoMarca = codigoMarca;
        this.nombre = nombre;
    }
    
    public Marca(){
        
    }

    public String getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" + "codigoMarca=" + codigoMarca + ", nombre=" + nombre + '}';
    }
    
    
}
