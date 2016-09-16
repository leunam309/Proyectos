/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.cruds;

import crudSpa.models.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import crudConnect.db.ConnectDB;
/**
 *Clase CrudCliente
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CrudCliente {
    
     /**
      * en este metodo se realiza el proceso para crear un nuevo cliente
      * @param cl cliente
      * @return 
      */
    public static boolean create(Cliente cl) {
		
		String sql = "INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?)";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			pstm.setString(1, cl.getDni());
                        pstm.setString(2, cl.getNombre());
                        pstm.setString(3, cl.getApellidos());                        
                        pstm.setInt(4, cl.getTelefono());
                        pstm.setString(5, cl.getEmail());
			
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
         * metodo en el que se modifica un cliente
         * @param cl cliente
         * @return 
         */
	public static boolean update(Cliente cl) {
		
		String sql = "UPDATE CLIENTE SET NOMBRE = ?, APELLIDOS = ?, TELEFONO = ?, EMAIL = ? "
				+ "WHERE DNI = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
  
                       
			
                        pstm.setString(1, cl.getNombre());
                        pstm.setString(2, cl.getApellidos());                        
                        pstm.setInt(3, cl.getTelefono());
                        pstm.setString(4, cl.getEmail());
			pstm.setString(5, cl.getDni());
                        
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
	
	public static boolean delete(Cliente cl) {
		return delete(cl.getDni());
	}
	
        /**
         * metodo para eliminar un cliente
         * @param dni identificador del cliente
         * @return 
         */
	public static boolean delete(String dni) {
		String sql = "DELETE FROM CLIENTE WHERE DNI = ?";
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
	
	public List<Cliente> findAll() {
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		
		String sql = "SELECT * FROM CLIENTE";
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lista.add(new Cliente(rs.getString("DNI"),
                                                    rs.getString("NOMBRE"),
                                                    rs.getString("APELLIDOS"),                                                
                                                rs.getInt("TELEFONO"),
                                                rs.getString("EMAIL")));
                                
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
	
	public static Cliente findByDni(Cliente cl) {
		return findByDni(cl.getDni());
	}
	
	
	public static Cliente findByDni(String dni) {
		String sql = "SELECT CLIENTE.* FROM CLIENTE WHERE DNI = ? ";
		Cliente cl = null;
                
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			pstm.setString(1, dni);
		
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				cl=new Cliente(rs.getString("DNI"),
                                                rs.getString("NOMBRE"),
                                               rs.getString("APELLIDOS"),                                                
                                                rs.getInt("TELEFONO"),
                                                rs.getString("EMAIL")
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
		
		return cl;
        }
    }
    

