/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import crudSpa.cruds.CrudCliente;
import crudSpa.cruds.CrudDetalleReserva;
import crudSpa.cruds.CrudPromocion;
import crudSpa.cruds.CrudReserva;
import crudSpa.cruds.CrudServicio;
import crudSpa.models.Cliente;
import crudSpa.models.DetalleReserva;
import crudSpa.models.Reserva;
import crudSpa.models.Servicio;
import javax.swing.ImageIcon;
import tableModels.ReservaTableModel;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.util.Locale;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import tableModels.PromocionServicioReservaTableModel;
/**
 *En esta clase reservaVista tenemos un formulario en el que recogemos los dados de
 * las reservas, tres tabla donde nos muestra los servicio, los clientes 
 * y las reservas que existentes, tambien
 * cuenta con un campo de busqueda con su correspondiente boton y 
 * los botones añadir, modificar, eliminar y volver al menu
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class ReservaVista extends javax.swing.JFrame {

    
    
    String valueToFilter;
    TableRowSorter sorter;
    ReservaTableModel rtm;
    Servicio p;
    Reserva re;
    DetalleReserva dr;
    Cliente cl;
    /**
     * Creates new form Reserv
     */
    public ReservaVista() {
        initComponents();
                
        //Este codigo es para poner el icono a la ventana del programa
      setIconImage(new ImageIcon(getClass().getResource("../icon/icono1.jpg")).getImage());
        this.setLocationRelativeTo(null);
        
        //ocultacion del campos de textos precio y id
        this.precio.setVisible(false);
        this.id.setVisible(false);
        
        //Si solo queremos que las filas se puedan ordenar por los valores
        //de las columnas, de forma automática (números, cadenas, ...)
        //jTable1.setAutoCreateRowSorter(true);
        
        
        //Si queremos ordenación y filtrado por algún valor, necesitamos
        //todo el código siguiente:
        
        //Instanciamos nuestro table model
        rtm = new ReservaTableModel();
        
        //Instanciamos nuestro TableRowSorter. Debe estar
        //parametrizado sobre EmployeeTableModel, y usaremos
        //la variable anterior en el constructor para poder instanciarlo.
        sorter = new TableRowSorter<ReservaTableModel>(rtm);
        
        //Asignamos el table model a la tabla ya creada
        tabla_reservas.setModel((TableModel) rtm);
        
        //Le asignamos ahora el RowSorter
        tabla_reservas.setRowSorter(sorter);
        
        //Inicializamos el valor de filtrado
        valueToFilter = "";
        
        
        /*
            Mediante este código, vamos a ocultar la columna con ID 
            (puesto que es un valor que solo sirve a nivel interno de la
            base de datos), pero que se debe utilizar en los eventos
            para recuperar datos usando este valor para buscar por PK.
        */
       
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_servicios_reserva.removeColumn(tabla_servicios_reserva.getColumnModel().getColumn(0));
        tabla_servicios_reserva.removeColumn(tabla_servicios_reserva.getColumnModel().getColumn(0));

    }
    
          

    /**
     * metodo para limpiar los campos del formulario
     */    
    public void limpiarCampos(){
    
        this.nombre_cliente.setText("");
        this.dni_cliente.setText("");
        this.telefono_cliente.setText("");
        this.nombre_servicio.setText("");
        this.id.setText("");
        this.fecha_reserva.setDate(null);
        this.precio.setText("");
        this.cantidad.setText("");
    }
    
    /**
     *metodo para actualiza la tabla de clientes
     */
    public void refresh() {
        //cambiar ancho de columna
        sorter = new TableRowSorter<ReservaTableModel>(rtm);
        
        //Instanciamos nuestro table model
        rtm = new ReservaTableModel();
                
        //Asignamos el table model a la tabla ya creada
        tabla_reservas.setModel((TableModel) rtm);
        
        //Le asignamos ahora el RowSorter
        tabla_reservas.setRowSorter(sorter);
        
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
        RowFilter<ReservaTableModel, Object> rf = null;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre_cliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefono_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nombre_servicio = new javax.swing.JTextField();
        dni_cliente = new javax.swing.JTextField();
        fecha_reserva = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        modificar_reserva = new javax.swing.JButton();
        nueva_reserva = new javax.swing.JButton();
        eliminar_reserva = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reservas = new javax.swing.JTable();
        volver_menu = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_servicios_reserva = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_clientes_reserva = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        buscar_reserva = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Reserva", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefono");

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
        jLabel6.setText("*Fecha");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*DNI");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rellene los campos marcados con asteriscos usando las \"Listas\"");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("*Cantidad");

        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(telefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dni_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(telefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(dni_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(fecha_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        modificar_reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102247_Pencil3.png"))); // NOI18N
        modificar_reserva.setBorderPainted(false);
        modificar_reserva.setContentAreaFilled(false);
        modificar_reserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_reservaActionPerformed(evt);
            }
        });

        nueva_reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102285_Plus__Orange.png"))); // NOI18N
        nueva_reserva.setBorderPainted(false);
        nueva_reserva.setContentAreaFilled(false);
        nueva_reserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nueva_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_reservaActionPerformed(evt);
            }
        });

        eliminar_reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102216_DeleteRed.png"))); // NOI18N
        eliminar_reserva.setBorderPainted(false);
        eliminar_reserva.setContentAreaFilled(false);
        eliminar_reserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_reservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nueva_reserva)
                .addGap(18, 18, 18)
                .addComponent(modificar_reserva)
                .addGap(21, 21, 21)
                .addComponent(eliminar_reserva)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar_reserva)
                    .addComponent(nueva_reserva)
                    .addComponent(eliminar_reserva))
                .addGap(1, 1, 1))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Reservas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        tabla_reservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Telefono", "Servicio", "Fecha"
            }
        ));
        tabla_reservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_reservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reservas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Servicios", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel6.setOpaque(false);

        tabla_servicios_reserva.setModel(new tableModels.PromocionServicioReservaTableModel());
        tabla_servicios_reserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_servicios_reservaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_servicios_reserva);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Clientes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel7.setOpaque(false);

        tabla_clientes_reserva.setModel(new tableModels.ClienteReservaTableModel());
        tabla_clientes_reserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientes_reservaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_clientes_reserva);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar");

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102262_Magnifier2.png"))); // NOI18N
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        buscar_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_reservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(buscar_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(buscar))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buscar))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(volver_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volver_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void buscar_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_reservaActionPerformed
        //Este es boton no hace volver al menu
    private void volver_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_menuActionPerformed

        MenuVista m = new MenuVista();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_volver_menuActionPerformed
    /**
     * metodo para cargar los campos del formulario seleccionando una fila de la tabla
     */
    private void tabla_clientes_reservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientes_reservaMouseClicked
        
        int fila = tabla_clientes_reserva.getSelectedRow();
        String dni = (String) tabla_clientes_reserva.getModel().getValueAt(fila, 0);        
          
        cl = CrudCliente.findByDni(dni);
        nombre_cliente.setText(cl.getNombre());
        dni_cliente.setText(cl.getDni());
        telefono_cliente.setText(String.valueOf(cl.getTelefono()));
    }//GEN-LAST:event_tabla_clientes_reservaMouseClicked
    /**
     * metodo para cargar los campos del formulario seleccionando una fila de la tabla
     */
    private void tabla_reservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reservasMouseClicked
       
        
        int fila = tabla_reservas.convertRowIndexToModel(tabla_reservas.getSelectedRow());
        
        BigDecimal idDetalle = (BigDecimal) tabla_reservas.getModel().getValueAt(fila, 0);        
          
        DetalleReserva dr = CrudDetalleReserva.findByPk(idDetalle.intValue());        
       
        re = CrudReserva.findByPk(dr.getIdReserva()); 
        dni_cliente.setText(re.getDni());
        fecha_reserva.setDate(re.getFecha_reserva());
        
        cl = CrudCliente.findByDni(re.getDni());
        telefono_cliente.setText(String.valueOf(cl.getTelefono()));
        nombre_cliente.setText(cl.getNombre());
        p = CrudServicio.findByPk(dr.getIdServicio());
        nombre_servicio.setText(p.getTipoServicio());
        id.setText(String.valueOf(p.getIdServicio()));
        
    }//GEN-LAST:event_tabla_reservasMouseClicked

    /**
     * metodo para cargar los campos del formulario seleccionando una fila de la tabla
     */    
    private void tabla_servicios_reservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_servicios_reservaMouseClicked
       
        int fila = tabla_servicios_reserva.getSelectedRow();
        BigDecimal idServicio = (BigDecimal) tabla_servicios_reserva.getModel().getValueAt(fila, 0);        
          
        p = CrudServicio.findByPk(idServicio.intValue()); 
        nombre_servicio.setText(p.getTipoServicio());
        id.setText(String.valueOf(p.getIdServicio()));
        precio.setText(String.valueOf(p.getPrecioUnitario()));

        
    }//GEN-LAST:event_tabla_servicios_reservaMouseClicked
    
    //Este boton crea una nueva reserva con los datos recogidos de los campos
    //del formulario, de los cuales necesitaremos (dni, fecha de reserva y el servicio)
    //una vez creado se actualizara la tabla de reservas y se limpiaran los campos
    private void nueva_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_reservaActionPerformed
        if(dni_cliente.getText().equals("") || nombre_servicio.getText().equals("") || fecha_reserva.getDate().equals(null) || cantidad.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
                    dr = new DetalleReserva();

        
        dr = new DetalleReserva();
        re= new Reserva();
        dr.setCantidad(Integer.valueOf(cantidad.getText()));
        dr.setIdServicio(Integer.valueOf(id.getText()));
        re.setDni(dni_cliente.getText());
        re.setFecha_reserva(utiles.CambiarFecha.cambiarUtilASQL(fecha_reserva.getDate()));
        
        int id_reserva = CrudReserva.create(re);
        dr.setIdServicio(Integer.valueOf(id.getText()));
        dr.setPrecio(Double.valueOf(precio.getText()));
                
        CrudDetalleReserva.create(
                new DetalleReserva(id_reserva,dr.getIdServicio(),dr.getPrecio(),dr.getCantidad())
        );
         
        refresh();
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        this.tabla_reservas.setModel(new ReservaTableModel());
        refresh();
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        limpiarCampos();        
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));

        }
    }//GEN-LAST:event_nueva_reservaActionPerformed
    
    //con este boton conseguimos modificar la reserva que seleccionamos de la tabla
    //reservas, se actualiza la tabla y limpie los campos
    private void modificar_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_reservaActionPerformed
        if(dni_cliente.getText().equals("") || nombre_servicio.getText().equals("") || fecha_reserva.getDate().equals(null)){
					JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una reserva para rellenar los campos marcados con asteriscos usando la 'Lista Reservas'", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        re.setDni(dni_cliente.getText());
        re.setFecha_reserva(utiles.CambiarFecha.cambiarUtilASQL(fecha_reserva.getDate()));
        CrudReserva.update(re);
        dr.setCantidad(Integer.valueOf(cantidad.getText()));
        refresh();
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        limpiarCampos();
        }
    }//GEN-LAST:event_modificar_reservaActionPerformed
    
    //con este boton conseguimos eliminar la reserva que seleccionamos de la tabla
    //reservas, se actualiza la tabla y limpie los campos
    private void eliminar_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_reservaActionPerformed
                if(dni_cliente.getText().equals("") || nombre_servicio.getText().equals("") || fecha_reserva.getDate().equals(null)){
					JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una reserva para rellenar los campos marcados con asteriscos usando la 'Lista Reservas'", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        int fila = tabla_reservas.convertRowIndexToModel(tabla_reservas.getSelectedRow());
        int respuesta;
        BigDecimal idReserva = (BigDecimal) tabla_reservas.getModel().getValueAt(fila, 0);        
        BigDecimal idDetalle = (BigDecimal) tabla_reservas.getModel().getValueAt(fila, 0);        

        
           respuesta = JOptionPane.showConfirmDialog(rootPane,"¿Desea eliminar el servicio seleccionada?"+JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                
                CrudDetalleReserva.delete(idDetalle.intValue());
                CrudReserva.delete(idReserva.intValue());
               
                refresh();                
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
        tabla_reservas.removeColumn(tabla_reservas.getColumnModel().getColumn(0));
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_eliminar_reservaActionPerformed
    // boton para buscar texto que le indicamos en el campo buscar_reserva
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        
        //String busca = buscar_reserva.getText();
        valueToFilter = buscar_reserva.getText();
        newFilter();
        
        //this.tabla_reservas.setModel(new ReservaTableModel(Consulta.BuscarReservas(busca)));
       // this.buscar_reserva.setText("");
    }//GEN-LAST:event_buscarActionPerformed
                                          
    /*
    * eliminamos la opción de meter números en el textfield
    */
    private void nombre_servicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_servicioKeyTyped
        char c = evt.getKeyChar();
	if(Character.isDigit(c)){
	evt.consume();
	JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
	}    }//GEN-LAST:event_nombre_servicioKeyTyped

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
                        char c = evt.getKeyChar();			
                        if(Character.isLetter(c)){
			
                            evt.consume();
			JOptionPane.showMessageDialog(rootPane, "Introduzca sólo números","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
    }//GEN-LAST:event_cantidadKeyTyped

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
            java.util.logging.Logger.getLogger(ReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ReservaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField buscar_reserva;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField dni_cliente;
    private javax.swing.JButton eliminar_reserva;
    private com.toedter.calendar.JDateChooser fecha_reserva;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modificar_reserva;
    private javax.swing.JTextField nombre_cliente;
    private javax.swing.JTextField nombre_servicio;
    private javax.swing.JButton nueva_reserva;
    private javax.swing.JTextField precio;
    private javax.swing.JTable tabla_clientes_reserva;
    private javax.swing.JTable tabla_reservas;
    private javax.swing.JTable tabla_servicios_reserva;
    private javax.swing.JTextField telefono_cliente;
    private javax.swing.JButton volver_menu;
    // End of variables declaration//GEN-END:variables
}
