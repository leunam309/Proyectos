/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.cruds;

import crudSpa.models.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import crudConnect.db.ConnectDB;
/**
 *Clase CrudEmpleado
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CrudEmpleado {
    
     /**
      * Este metodo hace el proceso para crear un nuevo empleado
      * @param em empleado
      * @return 
      */
    public static boolean create(Empleado em) {
		
		String sql = "INSERT INTO EMPLEADO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			pstm.setString(1, em.getDni());
                        pstm.setString(2, em.getNombre());
                        pstm.setString(3, em.getApellidos());
                        pstm.setInt(4, em.getTelefono());
                        pstm.setString(5, em.getEmail());
			pstm.setString(6, em.getTipo_cuenta());
                        pstm.setDouble(7, em.getSalario());
                        pstm.setString(8, em.getUsuario());
                        pstm.setString(9, em.getContrasenia());
                                   
                   
			
			nFilas = pstm.executeUpdate();
			
			
			pstm.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return (nFilas > 0) ? true : false;
		
		/*
		 	if (nFilas > 0)
		 		return true;
		 	else
		 		return false;		 
		 */
		
		
	}
	
        /**
         * Este metodo logueo sirve para verificar si el usuario esta en la base de datos 
         * @param usuario nombre de acceso para el programa
         * @param contrasenia contraseña de acceso al programa
         * @return 
         */
	 public static boolean logueo (String usuario, String contrasenia) {
            
            String sql = "SELECT * FROM EMPLEADO WHERE USUARIO = ? AND CONTRASENIA = ? AND ESTADO = 1";
            Empleado ad = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setString(1, usuario);
                        pstm.setString(2,contrasenia);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
			      ad = new Empleado(
                                                rs.getString("DNI"),
                                                rs.getString("NOMBRE"),
                                                rs.getString("APELLIDOS"),                                                
                                                rs.getInt("TELEFONO"),
                                                rs.getString("EMAIL"),
						rs.getString("TIPO_CUENTA"),
                                                rs.getDouble("SALARIO_ACTUAL"),
                                                rs.getString("USUARIO"),
                                                rs.getString("CONTRASENIA")
                                                );
			}
			
			rs.close();
			pstm.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ad==null){
                    return false;
                }else{
                    return true;
                }
        }
	 
         /**
          * Este metodo es igual al anterio pero con la condicion que tendra una prohibicion para el usuario
          * @param usuario el usuario debe tener un tipo de cuenta "usuario"
          * @param contrasenia
          * @return 
          */
	 public static boolean logueoUsuario (String usuario, String contrasenia) {
            
            String sql = "SELECT * FROM EMPLEADO WHERE USUARIO = ? AND CONTRASENIA = ? AND TIPO_CUENTA = 'USUARIO'";
            Empleado ad = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setString(1, usuario);
                        pstm.setString(2,contrasenia);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
			      ad = new Empleado(
                                                rs.getString("DNI"),
                                                rs.getString("NOMBRE"),
                                                rs.getString("APELLIDOS"),                                                
                                                rs.getInt("TELEFONO"),
                                                rs.getString("EMAIL"),
						rs.getString("TIPO_CUENTA"),
                                                rs.getDouble("SALARIO_ACTUAL"),
                                                rs.getString("USUARIO"),
                                                rs.getString("CONTRASENIA"));
			}
			
			rs.close();
			pstm.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ad==null){
                    return false;
                }else{
                    return true;
                }
        }
	 
         
         /**
          * metodo para poder modifica un empleado 
          * @param em empleado
          * @return 
          */
	public static boolean update(Empleado em) {
		
		String sql = "UPDATE EMPLEADO SET  NOMBRE = ?, APELLIDOS = ?, TELEFONO = ?, EMAIL = ?, TIPO_CUENTA = ?, SALARIO_ACTUAL = ?, USUARIO = ?, CONTRASENIA = ? "
				+ "WHERE DNI = ? ";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
  
                      
			
                        pstm.setString(1, em.getNombre());
                        pstm.setString(2, em.getApellidos());
                        pstm.setInt(3, em.getTelefono());
                        pstm.setString(4, em.getEmail());
			pstm.setString(5, em.getTipo_cuenta());
                        pstm.setDouble(6, em.getSalario());
                        pstm.setString(7, em.getUsuario());
                        pstm.setString(8, em.getContrasenia());
                        pstm.setString(9, em.getDni());
                       
                        
			
			nFilas = pstm.executeUpdate();
			
			
			pstm.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return (nFilas > 0) ? true : false;		
	}
	
        /**
         * Metodo para activar empleado
         * @param em empleado
         * @return 
         */
        public static boolean activarEmpleado(Empleado em) {
		
		String sql = "UPDATE EMPLEADO SET  ESTADO = 1 WHERE DNI = ? ";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
  
                      
			
                        pstm.setString(1, em.getDni());
                       
                        
			
			nFilas = pstm.executeUpdate();
			
			
			pstm.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return (nFilas > 0) ? true : false;		
	}
	
        /**
         * Metodo para desactivar empleado
         * @param em empleado
         * @return 
         */        
        public static boolean desactivarEmpleado(Empleado em) {
		
		String sql = "UPDATE EMPLEADO SET  ESTADO = 0 WHERE DNI = ? ";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
                        
			
                        pstm.setString(1, em.getDni());
                       
                        
			
			nFilas = pstm.executeUpdate();
			
			
			pstm.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return (nFilas > 0) ? true : false;		
	}
        
        
	public static boolean delete(Empleado em) {
		return delete(em.getDni());
	}
	
         
        
        /**
         * metodo para eliminar empleado
         * @param dni identificador mediante el cual se buscara el empleado para ser eliminado
         * @return 
         */
	public static boolean delete(String dni) {
		String sql = "DELETE FROM EMPLEADO WHERE DNI = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			pstm.setString(1, dni);
			
			nFilas = pstm.executeUpdate();
			
			
			pstm.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return (nFilas > 0) ? true : false;		
	}
	
	public List<Empleado> findAll() {
		
		List<Empleado> lista = new ArrayList<Empleado>();
		
		
		String sql = "SELECT * FROM EMPLEADO";
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lista.add(new Empleado(
                                                rs.getString("DNI"),
                                                rs.getString("NOMBRE"),
                                                rs.getString("APELLIDOS"),                                                
                                                rs.getInt("TELEFONO"),
                                                rs.getString("EMAIL"),
						rs.getString("TIPO_CUENTA"),
                                                rs.getDouble("SALARIO_ACTUAL"),
                                                rs.getString("USUARIO"),
                                                rs.getString("CONTRASENIA")  
                                                ));
			}
			
			rs.close();
			pstm.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
		
	}
	
	public static Empleado findByDni(Empleado em) {
		return findByDni(em.getDni());
	}
	
	
	public static Empleado findByDni(String dni) {
		String sql = "SELECT EMPLEADO.* FROM EMPLEADO WHERE DNI = ?";
		Empleado em = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setString(1, dni);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				em = new Empleado(
                                                rs.getString("DNI"),
                                                rs.getString("NOMBRE"),
                                                rs.getString("APELLIDOS"),                                                
                                                rs.getInt("TELEFONO"),
                                                rs.getString("EMAIL"),
						rs.getString("TIPO_CUENTA"),
                                                rs.getDouble("SALARIO_ACTUAL"),
                                                rs.getString("USUARIO"),
                                                rs.getString("CONTRASENIA"));
			}
			
			rs.close();
			pstm.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectDB.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return em;
        }
    }
    

