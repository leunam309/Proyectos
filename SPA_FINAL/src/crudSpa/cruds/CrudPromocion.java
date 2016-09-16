/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.cruds;

import crudSpa.models.Promocion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import crudConnect.db.ConnectDB;
/**
 *Clase CrudPromocion
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CrudPromocion {
    
     /**
      * Este metodo sirve para crear una nueva promocion
      * @param pr promocion 
      * @return 
      */
    public static boolean create(Promocion pr) {
				
		String sql = "INSERT INTO PROMOCION VALUES (SEQ_ID_PRO.NEXTVAL,?,?)";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			
                        pstm.setString(1, pr.getNombre());
			pstm.setDouble(2, pr.getDescuento());
                       
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
         * Metodo para poder modificar una promocion
         * @param pr promocion
         * @return 
         */
	public static boolean update(Promocion pr) {
		
		String sql = "UPDATE PROMOCION SET NOMBRE = ?, "
				+ "DESCUENTO = ? WHERE ID_PROMOCION = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
                       	
			
                        pstm.setString(1, pr.getNombre());
       			pstm.setDouble(2, pr.getDescuento());
                        pstm.setInt(3, pr.getIdPromocion());
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
	
	public static boolean delete(Promocion pr) {
            
		
            return delete(pr.getIdPromocion());
	}
	
        /**
         * Este metodo elimina una promocion
         * @param pk identificador de la promocion
         * @return 
         */
	public static boolean delete(int pk) {
		String sql = "DELETE FROM PROMOCION WHERE ID_PROMOCION = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			pstm.setInt(1, pk);
			
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
	
	public List<Promocion> findAll() {
		
		List<Promocion> lista = new ArrayList<Promocion>();
		
		
		String sql = "SELECT * FROM PROMOCION";
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lista.add(new Promocion(rs.getInt("ID_PROMOCION"),
                                                rs.getString("NOMBRE"),
						rs.getDouble("DESCUENTO")
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
	
	public static Promocion findByPk(Promocion pr) {
            
		return findByPk(pr .getIdPromocion());
	}
	
	
	public static Promocion findByPk(int pk) {
		String sql = "SELECT * FROM PROMOCION WHERE ID_PROMOCION = ?";
		Promocion pr = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setInt(1, pk);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				pr = new Promocion(rs.getInt("ID_PROMOCION"),
                                                rs.getString("NOMBRE"),
						rs.getDouble("DESCUENTO"));
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
		
		return pr;
	}
    
        
        // PRUEBA BUSQUEDA POR NOMBRE
        
        
	public static Promocion findByNombre(Promocion pr) {
		return findByNombre(pr.getNombre());
	}
	
	
	public static Promocion findByNombre(String nombre) {
		String sql = "SELECT * FROM SERVICIO WHERE NOMBRE = ?";
		Promocion pr = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setString(1, nombre);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				pr = new Promocion(rs.getInt("ID_PROMOCION"),
                                                rs.getString("NOMBRE"),
						rs.getDouble("DESCUENTO"));
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
		
		return pr;
	}
	
        
        
        
}

