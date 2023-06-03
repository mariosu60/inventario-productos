/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package contenidoInventario;

import RegistroYLogueo.Home;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.inventario.Conexion;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Item;
import modelo.Proveedor;
import persistencia.Dao;

/**
 *
 * @author mario
 */
public class ProductoFrm extends javax.swing.JFrame {

    /**
     * Creates new form Producto
     */
    Dao dao=new Dao();
    Conexion enlace=new Conexion();
    Connection conect= Conexion.getConexion();
    DefaultTableModel defualt=new DefaultTableModel();
    
    public ProductoFrm(){
        
        initComponents();
        rellenarMarca();
        rellenarSeccion();
        rellenarProveedor();
        rellenarTabla();
    }

    public void rellenarMarca(){
        
        Statement stmt=null ;
         Connection con = Conexion.getConexion();
             
        String sql="SELECT * FROM marca";  
          System.out.println(sql);
         try {
             stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
                            Item item=new Item(rs.getString("codigoMarca"),rs.getString("nombre"));
                           txtMarca.addItem(item);
                               
				
                                
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
			
    }
    
    public void rellenarSeccion(){
        Statement stmt=null ;
         Connection con = Conexion.getConexion();
             
        String sql="SELECT * FROM seccion";  
          System.out.println(sql);
         try {
             stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
                            
                            Item item=new Item(rs.getString("codigoSeccion"),rs.getString("nombre"));
                           txtSeccion.addItem(item);
                               
				
                                
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
    }
    
    public void rellenarProveedor(){
        
        Statement stmt=null ;
         Connection con = Conexion.getConexion();
             
        String sql="SELECT * FROM proveedor";  
          System.out.println(sql);
         try {
             stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
                            
                            Item item=new Item(rs.getString("codigoProveedor"),rs.getString("nombre"));
                           txtProveedor.addItem(item);
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
			
    }
    public void rellenarTabla2(){
        DefaultTableModel defualt=new DefaultTableModel();
             defualt.addColumn("Codigo");
             defualt.addColumn("Nombre");
             defualt.addColumn("Stock");
             defualt.addColumn("Proveedor");
             defualt.addColumn("Seccion");
             defualt.addColumn("Marca");
             defualt.addColumn("Precio");
             defualt.addColumn("Talla");
            miTabla.setModel(defualt);
            
            String []datos=new String[8];
            try{
                Statement leer=conect.createStatement();
                ResultSet resultado=leer.executeQuery("SELECT * FROM producto");
                
                while(resultado.next()){
                    datos[0]=resultado.getString(1);
                    datos[1]=resultado.getString(2);
                    datos[2]=resultado.getString(3);
                    datos[3]=resultado.getString(4);
                    datos[4]=resultado.getString(5);
                    datos[5]=resultado.getString(6);
                    datos[6]=resultado.getString(7);
                    datos[7]=resultado.getString(8);
                    defualt.addRow(datos);
                }
                miTabla.setModel(defualt);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lblProveedor = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        miTabla = new javax.swing.JTable();
        lblTalla = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtTalla = new javax.swing.JTextField();
        txtMarca = new javax.swing.JComboBox<>();
        txtSeccion = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JComboBox<>();
        btnImprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PRODUCTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 129, 37));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 88, 54, 26));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 90, 160, -1));

        lblCodigo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCodigo1.setText("CODIGO");
        jPanel1.add(lblCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, 54, 26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 90, 150, -1));

        lblStock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStock.setText("STOCK");
        jPanel1.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 257, 54, 26));

        lblSeccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSeccion.setText("SECCION");
        jPanel1.add(lblSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 141, 54, 26));
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 259, 160, -1));

        lblProveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProveedor.setText("PROVEEDOR");
        jPanel1.add(lblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, 26));

        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMarca.setText("MARCA");
        jPanel1.add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 197, 54, 26));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar (1).png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 120, 31));

        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 120, 31));

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar (1).png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 120, 30));

        miTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Stock", "Proveedor", "Seccion", "Marca", "Precio", "Talla"
            }
        ));
        miTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(miTabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 631, 180));

        lblTalla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTalla.setText("TALLA");
        jPanel1.add(lblTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 257, 54, 26));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 199, 150, -1));

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrecio.setText("PRECIO");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 197, 54, 26));
        jPanel1.add(txtTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 259, 150, -1));

        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 197, 160, 26));

        jPanel1.add(txtSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 141, 160, 26));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, 110, 31));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 110, 30));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 160, 30));

        jPanel1.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 150, -1));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_1.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
       String codigo=txtCodigo.getText();
       String nombre=txtNombre.getText();
       Item itemSeccion=(Item) txtSeccion.getSelectedItem();
       String codSeccion=itemSeccion.getCodigo();
       Item itemProveedor= (Item) txtProveedor.getSelectedItem();
       String codProveedor=itemProveedor.getCodigo();
       Item itemMarca=(Item) txtMarca.getSelectedItem();
       String codMarca=itemMarca.getCodigo();
       String precio=txtPrecio.getText();
       String stock=txtStock.getText();
      
       String talla=txtTalla.getText();
       
       if(codigo.isEmpty() || nombre.isEmpty() || codSeccion.isEmpty() || codProveedor.isEmpty() || codMarca.isEmpty() ||precio.isEmpty()|| stock.isEmpty()|| talla.isEmpty()){
            
           JOptionPane.showMessageDialog(null, "Por favor rellene los campos", "Error", JOptionPane.WARNING_MESSAGE);
       }else{
           double precioFinal=Double.parseDouble(precio);
            int stockFinal=Integer.parseInt(stock);
            Producto pro=new Producto(codigo, nombre, stockFinal, codProveedor, codSeccion, codMarca, precioFinal, talla);
           dao.añadirProducto(pro);
       limpiar();
       vaciarTabla();
       rellenarTabla();
       limpiar();
       txtCodigo.setEnabled(true);
       
           
       
       }
       
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       // JOptionPane.showMessageDialog(null, "Saliendo de la ventana producto");
       int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres salir de la ventana producto?","Producto",JOptionPane.OK_CANCEL_OPTION);
        switch(opcion){
            case 0:System.out.println("Presionaste el boton aceptar");
          this.setVisible(false);
        Home home=new Home();
        home.setVisible(true);
        break;
            case 1: System.out.println("Presionaste el boton cancelar");
            break;
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila=miTabla.getSelectedRow();
        /*Producto prod=new Producto();
        prod.setCodigo(txtCodigo.getText());
        prod.setNombre(txtNombre.getText());
        prod.setStock(Integer.parseInt(txtStock.getText()));
        Item itemProveedor= (Item) txtProveedor.getSelectedItem();
       String codProveedor=itemProveedor.getCodigo();
       Item itemSeccion=(Item) txtSeccion.getSelectedItem();
       String codSeccion=itemSeccion.getCodigo();
        Item itemMarca=(Item) txtMarca.getSelectedItem();
       String codMarca=itemMarca.getCodigo();
        prod.setPrecio(Double.parseDouble(txtPrecio.getText()));
        prod.setTalla(txtTalla.getText());
       if(dao.updateDatosProducto(prod)){
           limpiar();
           vaciarTabla();
           rellenarTabla();
          
       }*/
        String codigo=txtCodigo.getText();
       String nombre=txtNombre.getText();
       Item itemSeccion=(Item) txtSeccion.getSelectedItem();
       String codSeccion=itemSeccion.getCodigo();
       Item itemProveedor= (Item) txtProveedor.getSelectedItem();
       String codProveedor=itemProveedor.getCodigo();
       Item itemMarca=(Item) txtMarca.getSelectedItem();
       String codMarca=itemMarca.getCodigo();
        String precio=txtPrecio.getText();
       String stock=txtStock.getText();
       String talla=txtTalla.getText();
       
       if(codigo.isEmpty() || nombre.isEmpty() || codSeccion.isEmpty() || codProveedor.isEmpty() || codMarca.isEmpty() ||precio.isEmpty()|| stock.isEmpty()|| talla.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Losiento, no puede modificar, seleccione la seccion", "Error", JOptionPane.WARNING_MESSAGE);
       }else{
           double precioFinal=Double.parseDouble(precio);
            int stockFinal=Integer.parseInt(stock);
            Producto pro=new Producto(codigo, nombre, stockFinal, codProveedor, codSeccion, codMarca, precioFinal, talla);
       dao.updateDatosProducto(pro);
       limpiar();
       vaciarTabla();
       rellenarTabla();
       limpiar();
       txtCodigo.setEnabled(true);
       }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void miTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miTablaMouseClicked
        miTabla.getSelectedRow();
         
         String codigo=defualt.getValueAt(miTabla.getSelectedRow(), 0).toString();
         txtCodigo.setText(codigo);
         txtCodigo.setEnabled(false);
        txtCodigo.setEditable(false);
        String nombre=defualt.getValueAt(miTabla.getSelectedRow(), 1).toString();
         txtNombre.setText(nombre);
         String stock=defualt.getValueAt(miTabla.getSelectedRow(), 2).toString();
         txtStock.setText(stock);
         String proveedor=defualt.getValueAt(miTabla.getSelectedRow(), 3).toString();
         Item itemProveedor= (Item) txtProveedor.getSelectedItem();
        String codProveedor=itemProveedor.getCodigo();
         //txtProveedor.setSelectedItem(proveedor);
         String seccion=defualt.getValueAt(miTabla.getSelectedRow(), 4).toString();
         Item itemSeccion=(Item) txtSeccion.getSelectedItem();
         String codSeccion=itemSeccion.getCodigo();
         //txtSeccion.setSelectedItem(seccion);
         String marca=defualt.getValueAt(miTabla.getSelectedRow(), 5).toString();
         Item itemMarca=(Item) txtMarca.getSelectedItem();
       String codMarca=itemMarca.getCodigo();
         //txtMarca.setSelectedItem(marca);
         String precio=defualt.getValueAt(miTabla.getSelectedRow(), 6).toString();
         txtPrecio.setText(precio);
         String talla=defualt.getValueAt(miTabla.getSelectedRow(), 7).toString();
         txtTalla.setText(talla);
          
          
    }//GEN-LAST:event_miTablaMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila=miTabla.getSelectedRow();
       Producto prod=new Producto();
       if(fila<0){
             JOptionPane.showMessageDialog(null, "Seleccione fila");
       }else{
           System.out.println(miTabla.getValueAt(miTabla.getSelectedRow(), 0).toString());
          if(dao.eliminarProducto(miTabla.getValueAt(miTabla.getSelectedRow(), 0).toString())){
              limpiar();
              vaciarTabla();
              rellenarTabla();
              limpiar();
       txtCodigo.setEnabled(true);
             
          }
       }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       buscar(txtBuscar.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
      
        generarPDF(txtNombre.getText());
        abrirPDF(txtNombre.getText());
     
     
             
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
       
    }//GEN-LAST:event_txtBuscarActionPerformed

    
    public void buscar(String buscar){
        DefaultTableModel modelo=dao.buscarCodigoProducto(buscar);
        miTabla.setModel(modelo);
        txtBuscar.setText("");
        
       
        
    }
    
     public void rellenarTablaProducto(){
 
           
             defualt.addColumn("Codigo");
             defualt.addColumn("Nombre");
             defualt.addColumn("Stock");
             defualt.addColumn("Proveedor");
             defualt.addColumn("Seccion");
             defualt.addColumn("Marca");
             defualt.addColumn("Precio");
             defualt.addColumn("Talla");
            miTabla.setModel(defualt);
            
            String []datos=new String[8];
            try{
                Statement leer=conect.createStatement();
                ResultSet resultado=leer.executeQuery("SELECT * FROM producto");
                
                while(resultado.next()){
                    datos[0]=resultado.getString(1);
                    datos[1]=resultado.getString(2);
                    datos[2]=resultado.getString(3);
                    datos[3]=resultado.getString(4);
                    datos[4]=resultado.getString(5);
                    datos[5]=resultado.getString(6);
                    datos[6]=resultado.getString(7);
                    datos[7]=resultado.getString(8);
                    defualt.addRow(datos);
                }
                miTabla.setModel(defualt);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
     
    }
  
     public void generarPDF(String nombre){
     
         try {
          //  FileOutputStream archivo=new FileOutputStream(nombre+ " .pdf");
          String rutaDescargas = System.getProperty("user.home") + File.separator + "Downloads"+ File.separator+nombre+".pdf";
          File file=new File(rutaDescargas);
           FileOutputStream archivo=new FileOutputStream(file);
           Document documento=new Document();
           PdfWriter.getInstance(documento, archivo); 
            documento.open();
            Paragraph parrafo=new Paragraph("INVENTARIO DE PRODUCTOS",FontFactory.getFont("arial",25,Font.ITALIC,BaseColor.BLACK));
            parrafo.setSpacingAfter(20);
            parrafo.setAlignment(Element.ALIGN_CENTER);
           
            
            documento.add(parrafo);
            
            /*try{
                Image foto=Image.getInstance("src/imagenes/logo.jpg");
                foto.scaleToFit(100,100);
                foto.setAlignment(Image.ALIGN_CENTER);
                documento.add(foto);
                
            }catch(Exception e ){
                System.out.println("Error: "+e);
            }*/
           
           PdfPTable tabla=new PdfPTable(2);
           
           tabla.addCell("Codigo");
           tabla.addCell(txtCodigo.getText());
           tabla.addCell("Nombre");
           tabla.addCell(txtNombre.getText());
           //FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
           tabla.addCell("Stock");
           tabla.addCell(txtStock.getText());
            //FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
           tabla.addCell("Proveedor");
           tabla.addCell(txtProveedor.getSelectedItem().toString());
           // FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
           tabla.addCell("Seccion");
           tabla.addCell(txtSeccion.getSelectedItem().toString());
            //FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
           tabla.addCell("Marca");
           tabla.addCell(txtMarca.getSelectedItem().toString());
           // FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
           tabla.addCell("Precio");
           tabla.addCell(txtPrecio.getText());
           // FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
           tabla.addCell("Talla");
           tabla.addCell(txtTalla.getText());
          // FontFactory.getFont("arial",18,Font.BOLD,BaseColor.CYAN);
         
           PdfPCell celdaFinal=new PdfPCell(new Paragraph("Recibo del inventario"));
           celdaFinal.setColspan(2);
           documento.add(tabla);
            
           /* documento.add(new Paragraph("Codigo: "+txtCodigo.getText(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Nombre: "+txtNombre.getText(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Stock: "+txtStock.getText(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Proveedor: "+txtProveedor.getSelectedItem(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Seccion: "+txtSeccion.getSelectedItem(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Marca: "+txtMarca.getSelectedItem(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Precio: "+txtPrecio.getText(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));
            documento.add(new Paragraph("Talla: "+txtTalla.getText(),FontFactory.getFont("New Times Roman",13,Font.BOLD,BaseColor.BLACK)));*/
            
           
            documento.close();
            JOptionPane.showMessageDialog(null, "Archivo PDF creado con éxito","Información",1);
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ProductoFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void abrirPDF(String nombre){
         try{
             //File path=new File(nombre+ ".pdf");
             String rutaDescargas = System.getProperty("user.home") + File.separator + "Downloads"+ File.separator+nombre+".pdf";
          File file=new File(rutaDescargas);
             Desktop.getDesktop().open(file);
             
         } catch (IOException ex) {
            Logger.getLogger(ProductoFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void rellenarTabla(){
           
             defualt.addColumn("Codigo");
             defualt.addColumn("Nombre");
             defualt.addColumn("Stock");
             defualt.addColumn("Proveedor");
             defualt.addColumn("Seccion");
             defualt.addColumn("Marca");
             defualt.addColumn("Precio");
             defualt.addColumn("Talla");
            miTabla.setModel(defualt);
            
            String []datos=new String[8];
            try{
                Statement leer=conect.createStatement();
                ResultSet resultado=leer.executeQuery("select producto.codigoProducto as codigoProducto, producto.nombre as nombre, producto.stock as stock,proveedor.nombre as nombreProveedor,seccion.nombre as nombreSeccion,marca.nombre as nombreMarca,producto.precio as precio,producto.talla as talla from producto,proveedor,marca,seccion \n" +
"where producto.codigoProveedor = proveedor.codigoProveedor and producto.codigoSeccion= seccion.codigoSeccion \n" +
"and producto.codigoMarca = marca.codigoMarca;");
                
                while(resultado.next()){
                    datos[0]=resultado.getString(1);
                    datos[1]=resultado.getString(2);
                    datos[2]=resultado.getString(3);
                    datos[3]=resultado.getString(4);
                    datos[4]=resultado.getString(5);
                    datos[5]=resultado.getString(6);
                    datos[6]=resultado.getString(7);
                    datos[7]=resultado.getString(8);
                    defualt.addRow(datos);
                }
                miTabla.setModel(defualt);
            //   ordenarDatosTabla();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
       }
   public void vaciarTabla(){
         while (defualt.getRowCount() > 0) {
            defualt.removeRow(0);
       }
        while(defualt.getColumnCount()>0){
     defualt.setColumnCount(defualt.getColumnCount() - 1);
        }
     }
    
   public void limpiar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtStock.setText("");
        txtProveedor.setSelectedItem(0);
        txtSeccion.setSelectedItem(0);
        txtMarca.setSelectedItem(0);
        txtPrecio.setText("");
        txtTalla.setText("");
    }

   
   
   
  /* public void ordenarDatosTabla(){
       DefaultTableModel model=new DefaultTableModel();
       JTable table=new JTable(model);
       TableRowSorter<TableModel>ordena=new TableRowSorter<TableModel>(model);
       table.setRowSorter(ordena);
   }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JTable miTabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JComboBox<Item> txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JComboBox<Item> txtProveedor;
    private javax.swing.JComboBox<Item> txtSeccion;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTalla;
    // End of variables declaration//GEN-END:variables

   
}
