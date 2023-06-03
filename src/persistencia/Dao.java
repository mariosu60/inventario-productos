/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mycompany.inventario.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Marca;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Seccion;
import modelo.Usuario;

/**
 *
 * @author mario
 */
public class Dao {
    Conexion enlace=new Conexion();
    Connection conect= Conexion.getConexion();
    DefaultTableModel defualt=new DefaultTableModel();
    
     public boolean registrar(Usuario usr) {
        PreparedStatement pst = null;
        Connection con = Conexion.getConexion();

        String sql = "INSERT INTO usuarios (dni,usuario,pass,nombre,correo,id_tipo) VALUES (?,?,?,?,?,?)";
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1, usr.getDni());
            
            pst.setString(2, usr.getUsuario());
            pst.setString(3, usr.getPassword());
            pst.setString(4, usr.getNombre());
            pst.setString(5, usr.getCorreo());
            pst.setInt(6, usr.getId_tipo());
            pst.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
        return false;
    }
     
     public boolean existeUsuario(String dni){
         Statement stmt=null ;
         Connection con = Conexion.getConexion();
             
          String sql="SELECT * FROM usuarios WHERE dni='"+dni+"'";
          
         try {
             stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
                                
			}
			rs.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
	return false;		
     }
     
     public boolean existeUsuarioRegistrado(String dni,String password){
         Statement stmt=null ;
         Connection con = Conexion.getConexion();
             
        String sql="SELECT * FROM usuarios WHERE dni='"+dni+"' AND pass='"+password+"'";  
          System.out.println(sql);
         try {
             stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
                                con.close();
				return true;
                                
			}
			rs.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
	return false;		
     }
     
     public void añadirProducto(Producto pro){
         try{
           
          PreparedStatement pst = null;
        Connection con = Conexion.getConexion();

        String sql = "INSERT INTO producto (codigoProducto,nombre,stock,codigoProveedor,codigoSeccion,codigoMarca,precio,talla) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1, pro.getCodigo());
            pst.setString(2, pro.getNombre());
            pst.setInt(3, pro.getStock());
            pst.setString(4, pro.getProveedor());
            pst.setString(5, pro.getSeccion());
            pst.setString(6, pro.getMarca());
            pst.setDouble(7, pro.getPrecio());
            pst.setString(8, pro.getTalla());
           int res= pst.executeUpdate();
           if(res >0){
               JOptionPane.showMessageDialog(null, "Producto añadido");
           }else{
               JOptionPane.showMessageDialog(null, "Error, producto  no añadido");
           }
           con.close();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    
       
      /*prod.setCodigo(txtCodigo.getText());
      prod.setNombre(txtNombre.getText());
      prod.setSeccion(txtSeccion.getText());
      prod.setProveedor(txtProveedor.getText());
      prod.setMarca(txtMarca.getText());
      prod.setPrecio(Double.parseDouble(txtPrecio.getText()));
      prod.setStock(Integer.parseInt(txtStock.getText()));
      prod.setTalla(Integer.parseInt(txtTalla.getText()));*/
      
      
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
     }
       
     public void añadirProveedor(Proveedor pro){
          try{
           
          PreparedStatement pst = null;
        Connection con = Conexion.getConexion();

        String sql = "INSERT INTO proveedor (codigoProveedor,nombre,email,DNI,direccion,telefono,poblacion,provincia) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1, pro.getCodigo());
            pst.setString(2, pro.getNombre());
            pst.setString(3, pro.getEmail());
            pst.setString(4, pro.getDni());
            pst.setString(5, pro.getDireccion());
            pst.setString(6, pro.getTelefono());
            pst.setString(7, pro.getPoblacion());
            pst.setString(8, pro.getProvincia());
           int res= pst.executeUpdate();
           if(res >0){
               JOptionPane.showMessageDialog(null, "Proveedor añadido");
           }else{
               JOptionPane.showMessageDialog(null, "Error, producto no añadido");
           }
           con.close();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    
       
      /*prod.setCodigo(txtCodigo.getText());
      prod.setNombre(txtNombre.getText());
      prod.setSeccion(txtSeccion.getText());
      prod.setProveedor(txtProveedor.getText());
      prod.setMarca(txtMarca.getText());
      prod.setPrecio(Double.parseDouble(txtPrecio.getText()));
      prod.setStock(Integer.parseInt(txtStock.getText()));
      prod.setTalla(Integer.parseInt(txtTalla.getText()));*/
      
      
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
     }
     
     public void añadirMarca(Marca marca){
         try{
           
          PreparedStatement pst = null;
        Connection con = Conexion.getConexion();

        String sql = "INSERT INTO marca (codigoMarca,nombre) VALUES (?,?)";
        
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1, marca.getCodigoMarca());
            pst.setString(2, marca.getNombre());
           int res= pst.executeUpdate();
           if(res >0){
               JOptionPane.showMessageDialog(null, "Marca añadida");
           }else{
               JOptionPane.showMessageDialog(null, "Marca  no añadida");
           }
           con.close();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
     }
     
     public void añadirSeccion(Seccion seccion){
         try{
           
          PreparedStatement pst = null;
        Connection con = Conexion.getConexion();

        String sql = "INSERT INTO seccion (codigoSeccion,nombre,color) VALUES (?,?,?)";
        
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1, seccion.getCodigoSeccion());
            pst.setString(2, seccion.getNombre());
            pst.setString(3, seccion.getColor());
           int res= pst.executeUpdate();
           if(res >0){
               JOptionPane.showMessageDialog(null, "Seccion añadida");
           }else{
               JOptionPane.showMessageDialog(null, "Error, seccion  no añadida");
           }
           con.close();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
     }
     
   
     public boolean updateDatosProveedor(Proveedor pro){
          try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "UPDATE proveedor set nombre=?,email=?,DNI=?,direccion=?,telefono=?,poblacion=?,provincia=? WHERE codigoProveedor=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, pro.getNombre());
           pst.setString(2, pro.getEmail());
           pst.setString(3, pro.getDni());
           pst.setString(4, pro.getDireccion());
           pst.setString(5, pro.getTelefono());
           pst.setString(6, pro.getPoblacion());
           pst.setString(7, pro.getProvincia());
           pst.setString(8, pro.getCodigo());
           JOptionPane.showMessageDialog(null, "Proveedor modificado");
           pst.executeUpdate();
           
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, proveedor no se pudo modificar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     public boolean updateDatosProducto(Producto prod){
          try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "UPDATE producto set nombre=?,stock=?,codigoProveedor=?,codigoSeccion=?,codigoMarca=?,precio=?,talla=? WHERE codigoProducto=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, prod.getNombre());
           pst.setInt(2, prod.getStock());
           pst.setString(3, prod.getProveedor());
           pst.setString(4, prod.getSeccion());
           pst.setString(5, prod.getMarca());
           pst.setDouble(6, prod.getPrecio());
           pst.setString(7, prod.getTalla());
           pst.setString(8, prod.getCodigo());
           JOptionPane.showMessageDialog(null, "Producto modificado");
           pst.executeUpdate();
           
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, producto no se pudo modificar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     
     public boolean updateDatosMarca(Marca marca){
          try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "UPDATE marca set nombre=? WHERE codigoMarca=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, marca.getNombre());
           pst.setString(2, marca.getCodigoMarca());
           JOptionPane.showMessageDialog(null, "Marca modificada");
           pst.executeUpdate();
           
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, marca no se pudo modificar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
    
     public boolean updateDatosSeccion(Seccion seccion){
          try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "UPDATE seccion set nombre=?, color=? WHERE codigoSeccion=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, seccion.getNombre());
           pst.setString(2, seccion.getColor());
           pst.setString(3, seccion.getCodigoSeccion());
           JOptionPane.showMessageDialog(null, "Sección modificada");
           pst.executeUpdate();
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, seccion no se pudo modificar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     
     public boolean eliminarProveedor(String codigo){
         try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "DELETE from proveedor WHERE codigoProveedor=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, codigo);
           JOptionPane.showMessageDialog(null, "Proveedor eliminado");
           pst.execute();
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, proveedor no se pudo eliminar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     public boolean eliminarProducto(String codigo){
         try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "DELETE from producto WHERE codigoProducto=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, codigo);
           JOptionPane.showMessageDialog(null, "Producto eliminado");
           pst.execute();
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, producto no se pudo eliminar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     
     public boolean eliminarMarca(String codigo){
         try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "DELETE from marca WHERE codigoMarca=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, codigo);
           JOptionPane.showMessageDialog(null, "Marca eliminada");
           pst.execute();
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, marca no se pudo eliminar  "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     
     public boolean eliminarSeccion(String codigo){
         try{
          Connection con = Conexion.getConexion();
          PreparedStatement pst = null;
       

        String sql = "DELETE from seccion WHERE codigoSeccion=?";
        
        try {
          
           pst=con.prepareStatement(sql);
           pst.setString(1, codigo);
           JOptionPane.showMessageDialog(null, "Sección eliminada");
           pst.execute();
           con.close();
           return true;
        } catch (SQLException ex) {
            System.out.println("Error, seccion no se pudo eliminar "+ex.getMessage());
           
        }
         try {
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
         }
      }catch(Exception e){
          System.out.println("Error: "+e.getMessage());
      }
       return false;
     }
     
     public DefaultTableModel buscarCodigoSeccion(String buscar){
        String []nombreColumna={"codigoSeccion","nombre","color"};
        String []registros=new String [3];
         DefaultTableModel modelo=new DefaultTableModel(null,nombreColumna);
         
        String sql="SELECT * from seccion where nombre like '%"+buscar+"%' or color like '%"+buscar+"' or codigoSeccion like'%"+buscar+"%'";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            con=Conexion.getConexion();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          while(rs.next()){
              registros[0]=rs.getString("codigoSeccion");
              registros[1]=rs.getString("nombre");
              registros[2]=rs.getString("color");
              modelo.addRow(registros);
              
            }
        }catch(Exception e){
            System.out.println("Error, no se puede buscar datos "+e);
        }
    return modelo;
}
     public DefaultTableModel buscarCodigoMarca(String buscar){
        String []nombreColumna={"codigoMarca","nombre"};
        String []registros=new String [2];
         DefaultTableModel modelo=new DefaultTableModel(null,nombreColumna);
         
        String sql="SELECT * from marca where nombre like '%"+buscar+"%' or codigoMarca like'%"+buscar+"%'";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            con=Conexion.getConexion();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          while(rs.next()){
              registros[0]=rs.getString("codigoMarca");
              registros[1]=rs.getString("nombre");
              modelo.addRow(registros);
              
            }
        }catch(Exception e){
            System.out.println("Error, no se puede buscar datos "+e);
        }
    return modelo;
}
      public DefaultTableModel buscarCodigoProveedor(String buscar){
        String []nombreColumna={"codigoProveedor","nombre","email","DNI","direccion","telefono","poblacion","provincia"};
        String []registros=new String [8];
         DefaultTableModel modelo=new DefaultTableModel(null,nombreColumna);
         
        String sql="SELECT * from proveedor where nombre like '%"+buscar+"%' or codigoProveedor like'%"+buscar+"%' or email like '%"+buscar+"%' or DNI like '%"+buscar+"%' or direccion like '%"+buscar+"%' or telefono like '%"+buscar+"%' or poblacion like '%"+buscar+"%' or provincia like '%"+buscar+"'";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            con=Conexion.getConexion();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          while(rs.next()){
              registros[0]=rs.getString("codigoProveedor");
              registros[1]=rs.getString("nombre");
              registros[2]=rs.getString("email");
              registros[3]=rs.getString("DNI");
              registros[4]=rs.getString("direccion");
              registros[5]=rs.getString("telefono");
              registros[6]=rs.getString("poblacion");
              registros[7]=rs.getString("provincia");
              modelo.addRow(registros);
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    return modelo;
}
       public DefaultTableModel buscarCodigoProducto(String buscar){
        String []nombreColumna={"codigoProducto","nombre","stock","codigoProveedor","codigoSeccion","codigoMarca","precio","talla"};
        String []registros=new String [8];
         DefaultTableModel modelo=new DefaultTableModel(null,nombreColumna);
         
        String sql="SELECT * from producto where nombre like '%"+buscar+"%' or codigoProducto like'%"+buscar+"%' or stock like '%"+buscar+"%' or codigoProveedor like '%"+buscar+"%' or codigoSeccion like '%"+buscar+"%' or codigoMarca like '%"+buscar+"%' or precio like '%"+buscar+"%' or talla like '%"+buscar+"&'";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            con=Conexion.getConexion();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          while(rs.next()){
              registros[0]=rs.getString("codigoProducto");
              registros[1]=rs.getString("nombre");
              registros[2]=rs.getString("stock");
              registros[3]=rs.getString("codigoProveedor");
              registros[4]=rs.getString("codigoSeccion");
              registros[5]=rs.getString("codigoMarca");
              registros[6]=rs.getString("precio");
              registros[7]=rs.getString("talla");
              modelo.addRow(registros);
            }
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    return modelo;
}
       
}
