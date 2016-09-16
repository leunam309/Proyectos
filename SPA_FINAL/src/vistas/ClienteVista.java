/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import crudSpa.cruds.CrudCliente;
import crudSpa.models.Cliente;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import tableModels.ClienteTableModel;

/**
 *En esta clase clienteVista tenemos un formulario en el que recogemos los dados de
 * los clientes, una tabla donde nos muestra los clientes que existentes, tambien
 * cuenta con un campo de busqueda con su correspondiente boton y 
 * los botones añadir, modificar, eliminar y volver al menu
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class ClienteVista extends javax.swing.JFrame {

        String valueToFilter;
    TableRowSorter sorter;
    ClienteTableModel ctm;
    Cliente cl;
    
    /**
     * Creates new form ClienteVist
     */
    public ClienteVista() {
          initComponents();
          
        //Este codigo es para poner el icono a la ventana del programa
      setIconImage(new ImageIcon(getClass().getResource("../icon/icono1.jpg")).getImage());
        this.setLocationRelativeTo(null);
    
        
        
        
        
        
        //Si solo queremos que las filas se puedan ordenar por los valores
        //de las columnas, de forma automática (números, cadenas, ...)
        //jTable1.setAutoCreateRowSorter(true);
        
        
        //Si queremos ordenación y filtrado por algún valor, necesitamos
        //todo el código siguiente:
        
        //Instanciamos nuestro table model
        ctm = new ClienteTableModel();
        
        //Instanciamos nuestro TableRowSorter. Debe estar
        //parametrizado sobre EmployeeTableModel, y usaremos
        //la variable anterior en el constructor para poder instanciarlo.
        sorter = new TableRowSorter<ClienteTableModel>(ctm);
        
        //Asignamos el table model a la tabla ya creada
        tabla_clientes.setModel((TableModel) ctm);
        
        //Le asignamos ahora el RowSorter
        tabla_clientes.setRowSorter(sorter);
        
        //Inicializamos el valor de filtrado
        valueToFilter = "";
        
        
        /*
            Mediante este código, vamos a ocultar la columna con ID 
            (puesto que es un valor que solo sirve a nivel interno de la
            base de datos), pero que se debe utilizar en los eventos
            para recuperar datos usando este valor para buscar por PK.
        */
        //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
        
    }
    /**
     * metodo que recoge los campos del formulario
     * @return cliente
     */
    public Cliente recogerCliente(){
        Cliente cl= new Cliente();
        
        cl.setNombre(nombre_cliente.getText());
        cl.setApellidos(apellidos_cliente.getText());
        cl.setEmail(correo_cliente.getText());
        cl.setDni(dni_cliente.getText());
        cl.setTelefono(Integer.parseInt(telefono_cliente.getText()));
        return cl;
    }
    
    /**
     * metodo para limpiar los campos del formulario
     */
    public void limpiarCampos(){
        
        this.nombre_cliente.setText("");
        this.apellidos_cliente.setText("");
        this.correo_cliente.setText("");
        this.dni_cliente.setText("");
        this.telefono_cliente.setText("");
        
    }
    /**
     *metodo para actualiza la tabla de clientes
     */
    public void refresh() {
        sorter = new TableRowSorter<ClienteTableModel>(ctm);
        
        //Instanciamos nuestro table model
        ctm = new ClienteTableModel();
                
        //Asignamos el table model a la tabla ya creada
        tabla_clientes.setModel((TableModel) ctm);
        
        //Le asignamos ahora el RowSorter
        tabla_clientes.setRowSorter(sorter);
        
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
        RowFilter<ClienteTableModel, Object> rf = null;
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
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre_cliente = new javax.swing.JTextField();
        apellidos_cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        telefono_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        correo_cliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dni_cliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        buscarCLienteForm = new javax.swing.JTextField();
        buscar_cliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        eliminar_cliente = new javax.swing.JButton();
        modificar_cliente = new javax.swing.JButton();
        nuevo_cliente = new javax.swing.JButton();
        volver_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setOpaque(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel6.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*Nombre");

        nombre_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_clienteKeyTyped(evt);
            }
        });

        apellidos_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidos_clienteKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Telefono");

        telefono_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefono_clienteKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Correo");

        correo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correo_clienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("*DNI");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rellene los campos marcados con asteriscos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telefono_cliente)
                            .addComponent(dni_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(apellidos_cliente)
                        .addComponent(correo_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(correo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dni_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Clientes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_clientes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar ");

        buscarCLienteForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCLienteFormActionPerformed(evt);
            }
        });

        buscar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102262_Magnifier2.png"))); // NOI18N
        buscar_cliente.setBorderPainted(false);
        buscar_cliente.setContentAreaFilled(false);
        buscar_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addComponent(buscarCLienteForm, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(buscar_cliente)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscar_cliente)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarCLienteForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        eliminar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102216_DeleteRed.png"))); // NOI18N
        eliminar_cliente.setBorderPainted(false);
        eliminar_cliente.setContentAreaFilled(false);
        eliminar_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminar_clienteMouseClicked(evt);
            }
        });
        eliminar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_clienteActionPerformed(evt);
            }
        });

        modificar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102247_Pencil3.png"))); // NOI18N
        modificar_cliente.setBorderPainted(false);
        modificar_cliente.setContentAreaFilled(false);
        modificar_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_clienteActionPerformed(evt);
            }
        });

        nuevo_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102285_Plus__Orange.png"))); // NOI18N
        nuevo_cliente.setBorderPainted(false);
        nuevo_cliente.setContentAreaFilled(false);
        nuevo_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevo_clienteMouseClicked(evt);
            }
        });
        nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(nuevo_cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(modificar_cliente)
                .addGap(144, 144, 144)
                .addComponent(eliminar_cliente))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eliminar_cliente)
            .addComponent(modificar_cliente)
            .addComponent(nuevo_cliente)
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volver_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(147, 147, 147)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(volver_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(338, 338, 338))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * metodo para cargar los campos del formulario seleccionando una fila de la tabla
     */
    private void tabla_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMouseClicked
           
            int fila = tabla_clientes.convertRowIndexToModel(tabla_clientes.getSelectedRow());
            
            String dni = String.valueOf(tabla_clientes.getModel().getValueAt(fila, 0));
            
            cl = CrudCliente.findByDni(dni);
            
            System.out.println(cl.getNombre());
            
            nombre_cliente.setText(cl.getNombre());
            apellidos_cliente.setText(cl.getApellidos());
            dni_cliente.setText(cl.getDni());
            telefono_cliente.setText(String.valueOf(cl.getTelefono()));
            correo_cliente.setText(cl.getEmail());
    }//GEN-LAST:event_tabla_clientesMouseClicked
    
    
    private void buscarCLienteFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCLienteFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarCLienteFormActionPerformed

            //Este es boton no hace volver al menu
    private void volver_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_menuActionPerformed
        MenuVista m = new MenuVista();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_volver_menuActionPerformed

    
    //Este boton crea un nuevo cliente con los datos recogidos de los campos
    //del formulario, de los cuales necesitaremos un minimo (nombre, telefono y dni)
    //una vez creado se actualizara la tabla de clientes y se limpiaran los campos
    private void nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_clienteActionPerformed
        
        if(nombre_cliente.getText().equals("") || telefono_cliente.getText().equals("") || dni_cliente.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
              
            
		// comprobación de la longitud de caracteres (debe de contener 9)
		                                 
                                CrudCliente.create(recogerCliente());
                                refresh();
                                this.tabla_clientes.setModel(new ClienteTableModel());
                                JOptionPane.showMessageDialog(rootPane, "cliente creado");
                                this.tabla_clientes.setModel(new ClienteTableModel());
                                refresh();
                                limpiarCampos();
                                        
				
			
                        
                }
                  
    }//GEN-LAST:event_nuevo_clienteActionPerformed

    private void correo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correo_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correo_clienteActionPerformed

    private void eliminar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminar_clienteMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_eliminar_clienteMouseClicked

    private void nuevo_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevo_clienteMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_nuevo_clienteMouseClicked

    //con este boton conseguimos modificar el cliente que seleccionamos de la tabla
    //cliente, se actualiza la tabla y limpie los campos
    private void modificar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_clienteActionPerformed
        // TODO add your handling code here:
         
        if(nombre_cliente.getText().equals("") || telefono_cliente.getText().equals("") || dni_cliente.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        cl.setNombre(nombre_cliente.getText());
        cl.setApellidos(apellidos_cliente.getText());
        cl.setEmail(correo_cliente.getText());        
        cl.setTelefono(Integer.parseInt(telefono_cliente.getText()));
              CrudCliente.update(cl);
        refresh();
        this.tabla_clientes.setModel(new ClienteTableModel());
        JOptionPane.showMessageDialog(rootPane, "cliente modificado");
        this.tabla_clientes.setModel(new ClienteTableModel());
        refresh();
        limpiarCampos();
        }
    }//GEN-LAST:event_modificar_clienteActionPerformed

    
    //con este boton conseguimos eliminar el cliente que seleccionamos de la tabla
    //clientes, se actualiza la tabla y limpie los campos
    private void eliminar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_clienteActionPerformed
        // TODO add your handling code here:
         
        if(nombre_cliente.getText().equals("") || telefono_cliente.getText().equals("") || dni_cliente.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un cliente de la 'Lista'", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
           int fila = tabla_clientes.convertRowIndexToModel(tabla_clientes.getSelectedRow());
        int respuesta;
        String dni = String.valueOf(tabla_clientes.getModel().getValueAt(fila, 0));
        
           respuesta = JOptionPane.showConfirmDialog(rootPane,"¿Desea eliminar el cliente seleccionada?"+JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                CrudCliente.delete(dni);
                
                refresh();
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_eliminar_clienteActionPerformed
    // boton para buscar segun la opcion seleccionada
    private void buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_clienteActionPerformed
        
        /*String tipo =buscarClienteOP.getSelectedItem().toString();
        String busca = buscarCLienteForm.getText();
        valueToFilter = buscarCLienteForm.getText();
        
        
        this.tabla_clientes.setModel(new );
        this.buscarCLienteForm.setText("");*/
        
        valueToFilter=buscarCLienteForm.getText();
        newFilter();
        
    }//GEN-LAST:event_buscar_clienteActionPerformed

    /*
    * eliminamos la opción de meter números en el textfield
    */
    
    private void nombre_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_clienteKeyTyped
        char c = evt.getKeyChar();
				if(Character.isDigit(c)){
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
    }//GEN-LAST:event_nombre_clienteKeyTyped

    /*
    * eliminamos la opción de meter números en el textfield
     */
    
    private void apellidos_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidos_clienteKeyTyped
        // TODO add your handling code here:
     
        char c = evt.getKeyChar();
				if(Character.isDigit(c)){
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
    }//GEN-LAST:event_apellidos_clienteKeyTyped

    
    /*
    * introducción de evento de teclado que cancela la colocación de letras en el textfield
    */
    
    private void telefono_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono_clienteKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
				if(Character.isLetter(c)){
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Introduzca sólo números","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
        
    }//GEN-LAST:event_telefono_clienteKeyTyped

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
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos_cliente;
    private javax.swing.JTextField buscarCLienteForm;
    private javax.swing.JButton buscar_cliente;
    private javax.swing.JTextField correo_cliente;
    private javax.swing.JTextField dni_cliente;
    private javax.swing.JButton eliminar_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar_cliente;
    private javax.swing.JTextField nombre_cliente;
    private javax.swing.JButton nuevo_cliente;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField telefono_cliente;
    private javax.swing.JButton volver_menu;
    // End of variables declaration//GEN-END:variables
}
