/**
 * 
 */
package crudSpa.cruds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crudConnect.db.ConnectDB;
import crudSpa.models.Servicio;

/**
 *Clase CrudServicio
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CrudServicio {
	
	
	/**
         * Este metodo crea un nuevo servicio
         * @param p servicio
         * @return 
         */
	public static boolean create(Servicio p) {
		
		String sql = "INSERT INTO SERVICIO VALUES (SEQ_ID_SER.NEXTVAL,?,?,?)";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			
			pstm.setString(1, p.getTipoServicio());
			pstm.setDouble(2, p.getPrecioUnitario());
			pstm.setInt(3, p.getIdPromo());
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
         * Metodo para modificar un servicio
         * @param p
         * @return 
         */
	public static boolean update(Servicio p) {
		
		String sql = "UPDATE SERVICIO SET SERVICIO = ?, PRECIO = ?, ID_PROMOCION = ?  "
				+ " WHERE ID_SERVICIO = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			pstm.setString(1, p.getTipoServicio());
			pstm.setDouble(2, p.getPrecioUnitario());
			pstm.setInt(3, p.getIdPromo());
                        pstm.setInt(4, p.getIdServicio());
			
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
	
	public static boolean delete(Servicio p) {
		return delete(p.getIdServicio());
	}
	
        /**
         * Metodo para eliminar un servicio
         * @param pk identificador del servicio
         * @return 
         */
	public static boolean delete(int pk) {
		String sql = "DELETE FROM SERVICIO WHERE ID_SERVICIO = ?";
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
	
	public List<Servicio> findAll() {
		
		List<Servicio> lista = new ArrayList<Servicio>();
		
		
		String sql = "SELECT * FROM SERVICIO";
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lista.add(new Servicio(rs.getInt("ID_SERVICIO"),
						rs.getString("SERVICIO"),
						rs.getFloat("PRECIO"),
                                                rs.getInt("ID_PROMOCION")
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
	
	public static Servicio findByPk(Servicio p) {
		return findByPk(p.getIdServicio());
	}
	
	
	public static Servicio findByPk(int pk) {
		String sql = "SELECT * FROM SERVICIO WHERE ID_SERVICIO = ?";
		Servicio p = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setInt(1, pk);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				p = new Servicio(rs.getInt("ID_SERVICIO"),
						rs.getString("SERVICIO"),
						rs.getFloat("PRECIO"),
                                                rs.getInt("ID_PROMOCION")
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
		
		return p;
	}
	
	
	
	
	
	
	

}
