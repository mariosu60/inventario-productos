/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mario
 */
public class Producto {
    private String codigo;
    private String nombre;
     private int stock;
     private String proveedor;
    private String seccion;
    private String marca;
    private double precio;
    private String talla;

    public Producto(String codigo, String nombre, int stock, String proveedor, String seccion, String marca, double precio, String talla) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.proveedor = proveedor;
        this.seccion = seccion;
        this.marca = marca;
        this.precio = precio;
        this.talla = talla;
    }

  

   

   public Producto(){
       
   }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", proveedor=" + proveedor + ", seccion=" + seccion + ", marca=" + marca + ", precio=" + precio + ", talla=" + talla + '}';
    }

    

   
    
}
