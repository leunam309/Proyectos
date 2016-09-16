/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.cruds;

import crudSpa.models.DetalleReserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import crudConnect.db.ConnectDB;
/**
 *Clase CrudDetalleReserva
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CrudDetalleReserva {
    
     /**
      * en este metodo se realiza el proceso para crear los detalle de una reserva
      * @param dr detalle de la reserva
      * @return 
      */
    public static boolean create(DetalleReserva dr) {
				// SEQ_ID_RES.NEXTVAL PUESTO PARA PROBAR PERO ESTA MAL
		String sql = "INSERT INTO DETALLE_RESERVA VALUES (SEQ_ID_DET.NEXTVAL, ?, SYSDATE, ?, ?, ?)";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
                	pstm.setInt(1, dr.getIdReserva());                        
                        pstm.setInt(2, dr.getIdServicio());                       
                        pstm.setDouble(3, dr.getPrecio());
                        pstm.setInt(4, dr.getCantidad());
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
         * modifica los detalle de la reserva
         * @param dr detalle de la reserva
         * @return 
         */
	public static boolean update(DetalleReserva dr) {
		
		String sql = "UPDATE DETELLE_RESERVA SET  PRECIO = ?, ID_SERVICIO = ?, CANTIDAD = ? "
				+ "WHERE ID_DETALLE = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
		
                        pstm.setDouble(1, dr.getPrecio());
			pstm.setInt(2, dr.getIdServicio());                       
                        pstm.setInt(3, dr.getIdDetalle());
                        pstm.setInt(4, dr.getCantidad());
                        
                        
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
	
	public static boolean delete(DetalleReserva dr) {
            
		
            return delete(dr.getIdReserva());
	}
	
        /**
         * este metodo elimina los detalle de la reserva por su identificador
         * @param pk identificador id_detalle
         * @return 
         */
	public static boolean delete(int pk) {
		String sql = "DELETE FROM DETALLE_RESERVA WHERE ID_DETALLE = ?";
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
	
	public static List<DetalleReserva> findAll() {
		
		List<DetalleReserva> lista = new ArrayList<DetalleReserva>();
		
		
		String sql = "SELECT * FROM DETALLE_RESERVA";
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lista.add(new DetalleReserva(rs.getInt("ID_DETALLE"),                          
                                                rs.getInt("ID_RESERVA"),
                                                rs.getInt("ID_SERVICIO"),
                                                rs.getDouble("PRECIO"),
                                                rs.getInt("CANTIDAD")
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
	
	public static DetalleReserva findByPk(DetalleReserva dr) {
            
		return findByPk(dr.getIdDetalle());
	}
	
	
	public static DetalleReserva findByPk(int pk) {
		String sql = "SELECT * FROM DETALLE_RESERVA WHERE ID_DETALLE = ?";
		DetalleReserva dr = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setInt(1, pk);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				dr = new DetalleReserva(rs.getInt("ID_DETALLE"),                          
                                                rs.getInt("ID_RESERVA"),
                                                rs.getInt("ID_SERVICIO"),
                                                rs.getDouble("PRECIO"),
                                                rs.getInt("CANTIDAD"));
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
		
		return dr;
	}
    
}

