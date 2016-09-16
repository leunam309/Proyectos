/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.cruds;

import crudSpa.models.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import crudConnect.db.ConnectDB;
import java.sql.CallableStatement;
/**
 *Clase CrudCliente
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class CrudReserva {
    
     /**
      * Este metodo sirve para crear una reserva
      * @param p reserva
      * @return 
      */
    public static int create(Reserva p) {
		
		//Definimos la variable cuyo valor vamos a retornar. Lo inicializamos a -1,
                //que podría ser un buen valor para detectar si no hemos realizado la inserción
                //correctamente
		int id = -1;
		try {
                    
                        /*
                            Esta sentencia que vamos a lanzar es especial, pues se trata de un bloque
                            de código PL/SQL. En definitiva, estamos pidiéndole a la BD que inserte
                            un nuevo pedidos, y que tras hacerlo, nos devuelva el valor de la columna
                            COD_PED.
                        */
                        String sql = "BEGIN INSERT INTO RESERVA VALUES (SEQ_ID_RES.NEXTVAL,?,?) RETURNING ID_RESERVA INTO ?; END;";
                        /*
                            Para poder ejecutar un bloque de código PL/SQL, NECESITAMOS usar CallableStatement. Este nos va a permitir
                            las mismas funcionalidades de PreparedStatement, pero añade la posibilidad de registrar parámetros de salida (OUT)
                            mediante los cuales podemos recoger valores desde la base de datos, aunque hayamos ejecutado una inserción.
                        */
                        CallableStatement cstm = ConnectDB.conectar().prepareCall(sql);
                        
                        //Le pasamos el parámetro del 1º interrogante
                        cstm.setString(1, p.getDni());  
                        cstm.setDate(2, utiles.CambiarFecha.cambiarUtilASQL(p.getFecha_reserva()));
                        
                        //Registramos el parámetro de salida, que será el COD_PED del nuevo pedido creado
                        cstm.registerOutParameter(3, java.sql.Types.NUMERIC);
                        
                        //Ejecutamos el bloque de código.
                        cstm.execute();
                    
                        //Recogemos el COD_PED del nuevo pedido creado
                        id = cstm.getInt(3);
                    
                        System.out.println("executeUpdate: " + sql + ", id: " + id);
                    
                        //Cerramos el CallableStatement
			cstm.close();
			
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
		
                //Devolvemos el valor
		return id;
	}
	
	
	/**
         * Metodo para modificar una reserva
         * @param re
         * @return 
         */
	public static boolean update(Reserva re) {
		
		String sql = "UPDATE RESERVA SET DNI = ?, "
				+ "FECHA_RESERVA = ? WHERE ID_RESERVA = ?";
		int nFilas = 0;
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
                                               
                        pstm.setString(1, re.getDni());
                        pstm.setDate(2, re.getFecha_reserva());
			pstm.setInt(3, re.getIdReserva()); 
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
	
	public static boolean delete(Reserva re) {
            
		
            return delete(re.getIdReserva());
	}
	
        /**
         * Metodo que sirve para eliminar una reserva
         * @param pk identificador de la reserva
         * @return 
         */
	public static boolean delete(int pk) {
		String sql = "DELETE FROM RESERVA WHERE ID_RESERVA = ?";
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
	
	public List<Reserva> findAll() {
		
		List<Reserva> lista = new ArrayList<Reserva>();
		
		
		String sql = "SELECT * FROM RESERVA";
		
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lista.add(new Reserva(rs.getInt("ID_RESERVA"),
                                                rs.getDate("FECHA_RESERVA"),                                                
						rs.getString("DNI")                                                
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
	
	public static Reserva findByPk(Reserva re) {
            
		return findByPk(re .getIdReserva());
	}
	
	
	public static Reserva findByPk(int pk) {
		String sql = "SELECT * FROM RESERVA WHERE ID_RESERVA = ?";
		Reserva re = null;
		try {
			PreparedStatement pstm = ConnectDB.conectar().prepareStatement(sql);
			
			pstm.setInt(1, pk);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				re = new Reserva(rs.getInt("ID_RESERVA"),
                                                rs.getDate("FECHA_RESERVA"),                                                
						rs.getString("DNI"));
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
		
		return re;
	}
    
}

