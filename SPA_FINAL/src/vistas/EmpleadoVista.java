/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;


import crudSpa.cruds.CrudEmpleado;
import crudSpa.models.Cliente;
import crudSpa.models.Empleado;
import javax.swing.ImageIcon;
import tableModels.EmpleadoTableModel;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import tableModels.*;
/**
 *En esta clase empleado tenemos un formulario en el que recogemos los dados de
 * los empleados, una tabla donde nos muestra los empleados que existentes, tambien
 * cuenta con un campo de busqueda con su correspondiente boton y 
 * los botones añadir, modificar, eliminar y volver
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class EmpleadoVista extends javax.swing.JFrame {

    
    String valueToFilter;
    TableRowSorter sorter;
    EmpleadoTableModel etm;
    Empleado em;
    
    /**
     * Creates new form Emplead
     */
    public EmpleadoVista() {
        initComponents();
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        //Este codigo es para poner el icono a la ventana del programa
      setIconImage(new ImageIcon(getClass().getResource("../icon/icono1.jpg")).getImage());
        this.setLocationRelativeTo(null);
       
        activar_empleado.setVisible(false);
        //Si solo queremos que las filas se puedan ordenar por los valores
        //de las columnas, de forma automática (números, cadenas, ...)
        //jTable1.setAutoCreateRowSorter(true);
        
        
        //Si queremos ordenación y filtrado por algún valor, necesitamos
        //todo el código siguiente:
        
        //Instanciamos nuestro table model
        etm = new EmpleadoTableModel();
        
        //Instanciamos nuestro TableRowSorter. Debe estar
        //parametrizado sobre EmployeeTableModel, y usaremos
        //la variable anterior en el constructor para poder instanciarlo.
        sorter = new TableRowSorter<EmpleadoTableModel>(etm);
        
        //Asignamos el table model a la tabla ya creada
        tabla_empleado.setModel((TableModel) etm);
        
        //Le asignamos ahora el RowSorter
        tabla_empleado.setRowSorter(sorter);
        
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
    
    //Este metodo recoge los datos de los campos de textos con lo que crearemos
    // o modificaremos un empleado
    public Empleado recogerEmpleado(){
        Empleado em= new Empleado();
        
        em.setNombre(nombre_empleado.getText());
        em.setApellidos(apellidos_empleado.getText());
        em.setEmail(correo_empleado.getText());
        em.setDni(dni_empleado.getText());
        em.setTelefono(Integer.parseInt(telefono_empleado.getText()));
        em.setTipo_cuenta((String) cuenta.getSelectedItem());
        em.setSalario(Double.valueOf(salario_empleado.getText()));
        em.setUsuario(usuario.getText());
        em.setContrasenia(contraseña.getText());
        return em;
    }
    
    // Este metodo lo se usa para limpiar los campos una vez q se a añadido, modificado
    // o eliminado un empleado
    public void limpiarCampos(){
        
        this.nombre_empleado.setText("");
        this.apellidos_empleado.setText("");
        this.correo_empleado.setText("");
        this.dni_empleado.setText("");
        this.telefono_empleado.setText("");
        this.contraseña.setText("");
        this.usuario.setText("");
        this.salario_empleado.setText("");
    }
    
    /**
     * Con este metodo refresca la tabla de empleados
     */
    public void refresh() {
       
        
        //Instanciamos nuestro table model
        etm = new EmpleadoTableModel();
        
         sorter = new TableRowSorter<EmpleadoTableModel>(etm);
                
        //Asignamos el table model a la tabla ya creada
        tabla_empleado.setModel((TableModel) etm);
        
        //Le asignamos ahora el RowSorter
        tabla_empleado.setRowSorter(sorter);
        
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
        RowFilter<EmpleadoTableModel, Object> rf = null;
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
        nombre_empleado = new javax.swing.JTextField();
        apellidos_empleado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        telefono_empleado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        correo_empleado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dni_empleado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        salario_empleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contraseña = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cuenta = new javax.swing.JComboBox();
        usuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        eliminar_empleado = new javax.swing.JButton();
        modificar_empleado = new javax.swing.JButton();
        nuevo_empleado = new javax.swing.JButton();
        activar_empleado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empleado = new javax.swing.JTable();
        Volver_menu = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        buscarEmpleadoForm = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_empleado_desactivado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empleado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*Nombre");

        nombre_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_empleadoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Telefono");

        telefono_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefono_empleadoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Correo");

        correo_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correo_empleadoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("*DNI");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*Salario");

        salario_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salario_empleadoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Cuenta ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("*Usuario");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*Contraseña");

        cuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "USUARIO" }));
        cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaActionPerformed(evt);
            }
        });

        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rellene los campos marcados con asteriscos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dni_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(apellidos_empleado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(telefono_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salario_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salario_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dni_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel3.setOpaque(false);

        eliminar_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102216_DeleteRed.png"))); // NOI18N
        eliminar_empleado.setBorderPainted(false);
        eliminar_empleado.setContentAreaFilled(false);
        eliminar_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_empleadoActionPerformed(evt);
            }
        });

        modificar_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102247_Pencil3.png"))); // NOI18N
        modificar_empleado.setBorderPainted(false);
        modificar_empleado.setContentAreaFilled(false);
        modificar_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_empleadoActionPerformed(evt);
            }
        });

        nuevo_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102285_Plus__Orange.png"))); // NOI18N
        nuevo_empleado.setBorderPainted(false);
        nuevo_empleado.setContentAreaFilled(false);
        nuevo_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_empleadoActionPerformed(evt);
            }
        });

        activar_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/activar.png"))); // NOI18N
        activar_empleado.setBorderPainted(false);
        activar_empleado.setContentAreaFilled(false);
        activar_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        activar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activar_empleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(nuevo_empleado)
                .addGap(51, 51, 51)
                .addComponent(modificar_empleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(activar_empleado)
                .addGap(68, 68, 68)
                .addComponent(eliminar_empleado))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activar_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(eliminar_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(modificar_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nuevo_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Empleados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        tabla_empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_empleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_empleado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Volver_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429031124_Log Out.png"))); // NOI18N
        Volver_menu.setBorderPainted(false);
        Volver_menu.setContentAreaFilled(false);
        Volver_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Volver_menuActionPerformed(evt);
            }
        });

        jPanel5.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar:");

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1429102262_Magnifier2.png"))); // NOI18N
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        buscarEmpleadoForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpleadoFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel10)
                .addGap(47, 47, 47)
                .addComponent(buscarEmpleadoForm, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buscar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(buscarEmpleadoForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buscar))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historico Empleados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel6.setOpaque(false);

        tabla_empleado_desactivado.setModel(new tableModels.EmpleadoDesactivadoTableModel());
        tabla_empleado_desactivado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_empleado_desactivadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_empleado_desactivado);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Volver_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Volver_menu)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void correo_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correo_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correo_empleadoActionPerformed

    private void salario_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salario_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salario_empleadoActionPerformed

        //Este es boton no hace volver al menu
    private void Volver_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver_menuActionPerformed
        // TODO add your handling code here:
        MenuVista m = new MenuVista();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_Volver_menuActionPerformed

    private void buscarEmpleadoFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpleadoFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarEmpleadoFormActionPerformed

    private void cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuentaActionPerformed
    
    //mediante este codigo nos rellena los campos del formulario al seleccionar
    //una fila de la tabla
    private void tabla_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_empleadoMouseClicked
                   
            int fila = tabla_empleado.convertRowIndexToModel(tabla_empleado.getSelectedRow());
            
            String dni = String.valueOf(tabla_empleado.getModel().getValueAt(fila, 0));
            
           
            em = CrudEmpleado.findByDni(dni);
            
            System.out.println(em.getNombre());
            
            dni_empleado.setText(em.getDni());
            nombre_empleado.setText(em.getNombre());
            apellidos_empleado.setText(em.getApellidos());            
            telefono_empleado.setText(String.valueOf(em.getTelefono()));
            salario_empleado.setText(String.valueOf(em.getSalario()));
            correo_empleado.setText(em.getEmail());
            usuario.setText(em.getUsuario());
            cuenta.setSelectedItem(em.getTipo_cuenta());
            contraseña.setText(em.getContrasenia());
        
    }//GEN-LAST:event_tabla_empleadoMouseClicked

    //Este boton crea un nuevo empleado con los datos recogidos de los campos
    //del formulario, de los cuales necesitaremos un minimo (nombre, telefono, dni y salario)
    //una vez creado se actualizara la tabla de empleados y se limpiaran los campos
    private void nuevo_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_empleadoActionPerformed
        if(nombre_empleado.getText().equals("") || telefono_empleado.getText().equals("") || dni_empleado.getText().equals("") || salario_empleado.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
        
        CrudEmpleado.create(recogerEmpleado());
        refresh();
        this.tabla_empleado.setModel(new EmpleadoTableModel());
        JOptionPane.showMessageDialog(rootPane, "Empleado creado");
        this.tabla_empleado.setModel(new EmpleadoTableModel());
        refresh();
        limpiarCampos();
        }
    }//GEN-LAST:event_nuevo_empleadoActionPerformed

    //con este boton conseguimos eliminar el empleado que seleccionamos de la tabla
    //empleado, se actualiza la tabla y limpie los campos
    private void eliminar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_empleadoActionPerformed
        
        int fila = tabla_empleado.convertRowIndexToModel(tabla_empleado.getSelectedRow());
        int respuesta;
        String dni = String.valueOf(tabla_empleado.getModel().getValueAt(fila, 0));
        
        respuesta = JOptionPane.showConfirmDialog(rootPane,"¿Desea desactivar el empleado seleccionada?"+JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
            CrudEmpleado.desactivarEmpleado(em);
            //this.tabla_empleado_desactivado.setModel(new EmpleadoTableModel());
            refresh();
            limpiarCampos();
            this.tabla_empleado_desactivado.setModel(new EmpleadoDesactivadoTableModel());
            
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        }        
    }//GEN-LAST:event_eliminar_empleadoActionPerformed
    
    //con este boton conseguimos modificar el empleado que seleccionamos de la tabla
    //empleado, se actualiza la tabla y limpie los campos
    private void modificar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_empleadoActionPerformed
        // TODO add your handling code here:
        if(nombre_empleado.getText().equals("") || telefono_empleado.getText().equals("") || dni_empleado.getText().equals("") || salario_empleado.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Debe rellenar los campos marcados con asteriscos", "Campos insuficientes", JOptionPane.WARNING_MESSAGE);
				}else{
             
        
        em.setNombre(nombre_empleado.getText());
             em.setApellidos(apellidos_empleado.getText());          
            em.setTelefono(Integer.parseInt(telefono_empleado.getText()));
            em.setSalario(Double.valueOf(salario_empleado.getText()));
            em.setEmail(correo_empleado.getText());
            em.setUsuario(usuario.getText());
            em.setTipo_cuenta((String)cuenta.getSelectedItem());
            em.setContrasenia(contraseña.getText());
            
            CrudEmpleado.update(em);
            
          refresh();
        this.tabla_empleado.setModel(new EmpleadoTableModel());
        JOptionPane.showMessageDialog(rootPane, "cliente modificado");
        this.tabla_empleado.setModel(new EmpleadoTableModel());
        refresh();
        limpiarCampos();
        }
    }//GEN-LAST:event_modificar_empleadoActionPerformed

    // boton para buscar segun la opcion seleccionada
    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //String tipo =buscarEmpleadoOP.getSelectedItem().toString();
       // String busca = buscarEmpleadoForm.getText();
        valueToFilter = buscarEmpleadoForm.getText();
          newFilter();
       // this.tabla_empleado.setModel(new ClienteTableModel(Consulta.BuscarEmpleados(tipo, busca)));
        //this.buscarEmpleadoForm.setText("");
    }//GEN-LAST:event_buscarActionPerformed

    /**
     * este metodo hace que solo podamos introducir letras en el campo del formulario
     * @param evt 
     */
    private void nombre_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_empleadoKeyTyped
        char c = evt.getKeyChar();
				if(Character.isDigit(c)){
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
        
    }//GEN-LAST:event_nombre_empleadoKeyTyped

     /**
     * este metodo hace que solo podamos introducir numeros en el campo del formulario
     * @param evt 
     */
    private void telefono_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono_empleadoKeyTyped
        // TODO add your handling code here:
                char c = evt.getKeyChar();
				if(Character.isLetter(c)){
					evt.consume();
					JOptionPane.showMessageDialog(rootPane, "Introduzca sólo números","Error de introducción",JOptionPane.ERROR_MESSAGE);
				}
    }//GEN-LAST:event_telefono_empleadoKeyTyped
    /**
     * este metodo hace que solo podamos introducir letras en el campo del formulario
     * @param evt 
     */
    private void usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
	if(Character.isDigit(c)){
	evt.consume();
	JOptionPane.showMessageDialog(rootPane, "Introduzca sólo letras","Error de introducción",JOptionPane.ERROR_MESSAGE);
	}
    }//GEN-LAST:event_usuarioKeyTyped

    private void tabla_empleado_desactivadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_empleado_desactivadoMouseClicked
              activar_empleado.setVisible(true);       
            int fila = tabla_empleado_desactivado.convertRowIndexToModel(tabla_empleado_desactivado.getSelectedRow());
            
            String dni = String.valueOf(tabla_empleado_desactivado.getModel().getValueAt(fila, 7));
            
           
            em = CrudEmpleado.findByDni(dni);
            
            System.out.println(em.getNombre());
            
            dni_empleado.setText(em.getDni());
            nombre_empleado.setText(em.getNombre());
            apellidos_empleado.setText(em.getApellidos());            
            telefono_empleado.setText(String.valueOf(em.getTelefono()));
            salario_empleado.setText(String.valueOf(em.getSalario()));
            correo_empleado.setText(em.getEmail());
            usuario.setText(em.getUsuario());
            cuenta.setSelectedItem(em.getTipo_cuenta());
            contraseña.setText(em.getContrasenia());
            
           
        
    }//GEN-LAST:event_tabla_empleado_desactivadoMouseClicked

    private void activar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activar_empleadoActionPerformed
        
        CrudEmpleado.activarEmpleado(recogerEmpleado());
        refresh();
        //this.tabla_empleado_desactivado.setModel(new EmpleadoTableModel());
        this.tabla_empleado.setModel(new EmpleadoTableModel());
        JOptionPane.showMessageDialog(rootPane, "Empleado creado");
        this.tabla_empleado.setModel(new EmpleadoTableModel());
        this.tabla_empleado_desactivado.setModel(new EmpleadoDesactivadoTableModel());
        refresh();
        limpiarCampos();
        activar_empleado.setVisible(false);
        
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));
        tabla_empleado_desactivado.removeColumn(tabla_empleado_desactivado.getColumnModel().getColumn(0));

    }//GEN-LAST:event_activar_empleadoActionPerformed

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
            java.util.logging.Logger.getLogger(EmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new EmpleadoVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver_menu;
    private javax.swing.JButton activar_empleado;
    private javax.swing.JTextField apellidos_empleado;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField buscarEmpleadoForm;
    private javax.swing.JTextField contraseña;
    private javax.swing.JTextField correo_empleado;
    private javax.swing.JComboBox cuenta;
    private javax.swing.JTextField dni_empleado;
    private javax.swing.JButton eliminar_empleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar_empleado;
    private javax.swing.JTextField nombre_empleado;
    private javax.swing.JButton nuevo_empleado;
    private javax.swing.JTextField salario_empleado;
    private javax.swing.JTable tabla_empleado;
    private javax.swing.JTable tabla_empleado_desactivado;
    private javax.swing.JTextField telefono_empleado;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
