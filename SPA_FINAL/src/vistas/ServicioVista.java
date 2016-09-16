/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import crudSpa.cruds.CrudPromocion;
import crudSpa.cruds.CrudServicio;
import crudSpa.models.Promocion;
import crudSpa.models.Servicio;
import javax.swing.ImageIcon;
import tableModels.ServicioTableModel;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import tableModels.PromocionTableModel;
/**
 *En esta clase servicioVista tenemos un formulario en el que recogemos los dados de
 * las reservas, dos tabla donde nos muestra los servicio, las promociones que 
 * existentes, tambien cuenta con un campo de busqueda con su correspondiente boton y 
 * los botones añadir, modificar, eliminar y volver al menu
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class ServicioVista extends javax.swing.JFrame {

    
    String valueToFilter;
    TableRowSorter sorter;
    ServicioTableModel stm;
    Servicio p;
    Promocion pr;
    
    /**
     * Creates new form Servici
     */
    public ServicioVista() {
        initComponents();

        //Este codigo es para poner el icono a la ventana del programa
       setIconImage(new ImageIcon(getClass().getResource("../icon/icono1.jpg")).getImage());
        this.setLocationRelativeTo(null);
        //ocultamos el campo id del formulario       
        this.id.setVisible(false);

        
        //Si solo queremos que las filas se puedan ordenar por los valores
        //de las columnas, de forma automática (números, cadenas, ...)
        //jTable1.setAutoCreateRowSorter(true);
        
        
        //Si queremos ordenación y filtrado por algún valor, necesitamos
        //todo el código siguiente:
        
        //Instanciamos nuestro table model
        stm = new ServicioTableModel();
        
        //Instanciamos nuestro TableRowSorter. Debe estar
        //parametrizado sobre EmployeeTableModel, y usaremos
        //la variable anterior en el constructor para poder instanciarlo.
        sorter = new TableRowSorter<ServicioTableModel>(stm);
        
        //Asignamos el table model a la tabla ya creada
        tabla_servicios.setModel((TableModel) stm);
        
        //Le asignamos ahora el RowSorter
        tabla_servicios.setRowSorter(sorter);
        
        //Inicializamos el valor de filtrado
        valueToFilter = "";
        
        
        /*
            Mediante este código, vamos a ocultar la columna con ID 
            (puesto que es un valor que solo sirve a nivel interno de la
            base de datos), pero que se debe utilizar en los eventos
            para recuperar datos usando este valor para buscar por PK.
        */
        tabla_servicios.removeColumn(tabla_servicios.getColumnModel().getColumn(0));
        tabla_promociones_servicio.removeColumn(tabla_promociones_servicio.getColumnModel().getColumn(0));
    }
    
   /**
     * metodo para limpiar los campos del formulario
     */
    public void limpiarCampos(){
        
     this.nombre_servicio.setText("");
     this.precio_servicio.setText("");
     this.nombre_promocion.setText("");
     this.id.setText("");
    }
    
    /**
     *metodo para actualiza la tabla de clientes
     */
    public void refresh() {
        sorter = new TableRowSorter<ServicioTableModel>(stm);
        
        //Instanciamos nuestro table model
        stm = new ServicioTableModel();
                
        //Asignamos el table model a la tabla ya creada
        tabla_servicios.setModel((TableModel) stm);
        
        //Le asignamos ahora el RowSorter
        tabla_servicios.setRowSorter(sorter);
        
        //Inicializamos el valor de filtrado
        valueToFilter = "";
    }
    
    
    /*
     * En este método vamos a crear un nuevo filtro, basado
     * en el valor recogido mediante un JOptionPane. Dicho valor
     * será usado para filtrar los resultados de la tabla
     */
    private void newFilter() {
        //Creamos la referencia del RowFilter a construir
        RowFilter<ServicioTableModel, Object> rf = null;
        //Si la siguiente excepción no puede ser parseada,
        //no hacemos nada
        try {
            //Obtenemos el RowFilter a través de la factoría
            //En este caso, creamos un filtro que usa expresiones regulares
            rf = RowFilter.regexFilter(valueToFilter);
        } catch (java.util.regex.PatternSyntaxException ex) {
            return;
        }
        //Asignamos el filtro al sorter.
        sorter.setRowFilter(rf);
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
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_servicios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        precio_servicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombre_servicio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre_promocion = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        modificar_servicio = new javax.swing.JButton();
        nuevo_servicio = new javax.swing.JButton();
        eliminar_servicio = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        busca_serv = new javax.swing.JTextField();
        volver_menu = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_promociones_servicio = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Servicios", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel6.setOpaque(false);

        tabla_servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Servicio", "Precio", "Promocion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_servicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_serviciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_servicios);
        if (tabla_servicios.getColumnModel().getColumnCount() > 0) {
            tabla_servicios.getColumnModel().getColumn(1).setHeaderValue("Precio");
            tabla_servicios.getColumnModel().getColumn(2).setHeaderValue("Promocion");
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Servicio", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        precio_servicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precio_servicioKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*Servicio");

        nombre_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_servicioActionPerformed(evt);
            }
        });
        nombre_servicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_servicioKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*Precio");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Promoción");

        nombre_promocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_promocionActionPerformed(evt);
            }
        });
        nombre_promocion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_promocionKeyTyped(evt);
            }
        });

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(precio_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombre_promocion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(precio_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(nombre_promocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        modificar_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102247_Pencil3.png"))); // NOI18N
        modificar_servicio.setBorderPainted(false);
        modificar_servicio.setContentAreaFilled(false);
        modificar_servicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_servicioActionPerformed(evt);
            }
        });

        nuevo_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102285_Plus__Orange.png"))); // NOI18N
        nuevo_servicio.setBorderPainted(false);
        nuevo_servicio.setContentAreaFilled(false);
        nuevo_servicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_servicioActionPerformed(evt);
            }
        });

        eliminar_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102216_DeleteRed.png"))); // NOI18N
        eliminar_servicio.setBorderPainted(false);
        eliminar_servicio.setContentAreaFilled(false);
        eliminar_servicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_servicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(nuevo_servicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(modificar_servicio)
                .addGap(41, 41, 41)
                .addComponent(eliminar_servicio))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar_servicio)
                    .addComponent(nuevo_servicio)
                    .addComponent(eliminar_servicio))
                .addGap(1, 1, 1))
        );

        jPanel5.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar:");

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102262_Magnifier2.png"))); // NOI18N
        Buscar.setBorderPainted(false);
        Buscar.setContentAreaFilled(false);
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        busca_serv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busca_servActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addGap(37, 37, 37)
                .addComponent(busca_serv, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Buscar)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Buscar))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busca_serv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        volver_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429031124_Log Out.png"))); // NOI18N
        volver_menu.setBorderPainted(false);
        volver_menu.setContentAreaFilled(false);
        volver_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volver_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver_menuActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Promociones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel7.setOpaque(false);

        tabla_promociones_servicio.setModel(new tableModels.PromocionServicioTableModel());
        tabla_promociones_servicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_promociones_servicioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_promociones_servicio);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(206, 206, 206)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volver_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(volver_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombre_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_servicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_servicioActionPerformed

    private void busca_servActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busca_servActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busca_servActionPerformed
    
               
    //Este es boton no hace volver al menu
    private void volver_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_menuActionPerformed

        MenuVista m = new MenuVista();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_volver_menuActionPerformed

    private void nombre_promocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_promocionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_promocionActionPerformed

    /**
     * metodo para cargar los campos del formulario seleccionando una fila de la tabla
     */
    private void tabla_serviciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_serviciosMouseClicked
      
       
        int fila = tabla_servicios.convertRowIndexToModel(tabla_servicios.getSelectedRow());
        BigDecimal idServicio = (BigDecimal) tabla_servicios.getModel().getValueAt(fila, 0);        
          
        p = CrudServicio.findByPk(idServicio.intValue());        
        
        nombre_servicio.setText(p.getTipoServicio());
         precio_servicio.setText(String.valueOf(p.getPrecioUnitario()));
        pr = CrudPromocion.findByPk(p.getIdPromo()); 
        nombre_promocion.setText(pr.getNombre());
        id.setText(String.valueOf(p.getIdPromo()));
    }//GEN-LAST:event_tabla_serviciosMouseClicked

    
    //con este boton conseguimos eliminar el servicio que seleccionamos de la tabla
    //servicios, se actualiza la tabla y limpie los campos
    private void eliminar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_servicioActionPerformed
        // TODO add your handling code here:
        
        if(nombre_servicio.getText().equals("") || precio_servicio.getText().equals("") || id.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un servicio de la 'Lista'", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        int fila = tabla_servicios.convertRowIndexToModel(tabla_servicios.getSelectedRow());
        int respuesta;
        BigDecimal idServicio = (BigDecimal) tabla_servicios.getModel().getValueAt(fila, 0);        
        
           respuesta = JOptionPane.showConfirmDialog(rootPane,"¿Desea eliminar el servicio seleccionada?"+JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                CrudServicio.delete(idServicio.intValue());
                
                refresh();
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_eliminar_servicioActionPerformed
    
    //Este boton crea un nuevo servicio con los datos recogidos de los campos
    //del formulario, de los cuales necesitaremos todos los datos
    //una vez creado se actualizara la tabla de servicios y se limpiaran los campos
    private void nuevo_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_servicioActionPerformed
        
        if(nombre_servicio.getText().equals("") || precio_servicio.getText().equals("") || id.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        p= new Servicio();
        pr= new Promocion();
        p.setTipoServicio(nombre_servicio.getText());
        p.setPrecioUnitario(Double.valueOf(precio_servicio.getText()));
        p.setIdPromo(Integer.valueOf(id.getText()));
        
        CrudServicio.create(p);
        refresh();
        tabla_servicios.removeColumn(tabla_servicios.getColumnModel().getColumn(0));
        limpiarCampos();
        refresh();
        tabla_servicios.removeColumn(tabla_servicios.getColumnModel().getColumn(0));
        }
        
    }//GEN-LAST:event_nuevo_servicioActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    /**
     * metodo para cargar los campos del formulario seleccionando una fila de la tabla
     */    
    private void tabla_promociones_servicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_promociones_servicioMouseClicked
        
        int fila = tabla_promociones_servicio.getSelectedRow();
        BigDecimal idPromocion = (BigDecimal) tabla_promociones_servicio.getModel().getValueAt(fila, 0);        
          
        pr = CrudPromocion.findByPk(idPromocion.intValue()); 
        nombre_promocion.setText(pr.getNombre());
        id.setText(String.valueOf(pr.getIdPromocion()));
    }//GEN-LAST:event_tabla_promociones_servicioMouseClicked

    
    //con este boton conseguimos modificar el servicio que seleccionamos de la tabla
    //servicios, se actualiza la tabla y limpie los campos
    private void modificar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_servicioActionPerformed
        
        if(nombre_servicio.getText().equals("") || precio_servicio.getText().equals("") || id.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        p.setTipoServicio(nombre_servicio.getText());
        p.setPrecioUnitario(Double.valueOf(precio_servicio.getText()));
        p.setIdPromo(Integer.valueOf(id.getText()));
        
        
        CrudServicio.update(p);
        refresh();
        tabla_servicios.removeColumn(tabla_servicios.getColumnModel().getColumn(0));
        limpiarCampos();
        refresh();
        tabla_servicios.removeColumn(tabla_servicios.getColumnModel().getColumn(0));
        }
    }//GEN-LAST:event_modificar_servicioActionPerformed
        // boton para buscar texto que le indicamos en el campo buscar_serv
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        
        //String busca = busca_serv.getText();
        valueToFilter = busca_serv.getText();        
        newFilter();
        //this.tabla_servicios.setModel(new ServicioTableModel(Consulta.BuscarServicios(busca)));
        
    }//GEN-LAST:event_BuscarActionPerformed
    /*
    * eliminamos la opción de meter números en el textfield
    */
    private void nombre_servicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_servicioKeyTyped
        
        char c = evt.getKeyChar();
	if(Character.isDigit(c)){
	evt.consume();
	JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
	}
        
    }//GEN-LAST:event_nombre_servicioKeyTyped
    /*
    * eliminamos la opción de meter letras en el textfield
    */ 
    private void precio_servicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precio_servicioKeyTyped
        char c = evt.getKeyChar();
				if(Character.isLetter(c)){
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Introduzca sólo números","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
    }//GEN-LAST:event_precio_servicioKeyTyped
/*
    * eliminamos la opción de meter números en el textfield
    */
    private void nombre_promocionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_promocionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
	if(Character.isDigit(c)){
	evt.consume();
	JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
	}
        
    }//GEN-LAST:event_nombre_promocionKeyTyped
    
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
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField busca_serv;
    private javax.swing.JButton eliminar_servicio;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modificar_servicio;
    private javax.swing.JTextField nombre_promocion;
    private javax.swing.JTextField nombre_servicio;
    private javax.swing.JButton nuevo_servicio;
    private javax.swing.JTextField precio_servicio;
    private javax.swing.JTable tabla_promociones_servicio;
    private javax.swing.JTable tabla_servicios;
    private javax.swing.JButton volver_menu;
    // End of variables declaration//GEN-END:variables
}
