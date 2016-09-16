/**
 * 
 */
package crudSpa.models;

import java.sql.Date;

/**
 *Clase Reserva
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class Reserva {
	
	
	private int idReserva;
	private Date fecha_reserva;	
        private String dni;
        

    public Reserva(int idReserva, Date fecha_reserva) {
        this.idReserva = idReserva;
        this.fecha_reserva = fecha_reserva;
    }
    
    /**
     * Constructor vacio
     */
    public Reserva() {
    }

    /**
     * constructor con todos los atributos de una reserva
     * @param idReserva identificador de la reserva
     * @param fecha_reserva fecha en la que resivira el servicio el cliente
     * @param dni identificador del cliente
     */
    public Reserva(int idReserva, Date fecha_reserva, String dni) {
        this.idReserva = idReserva;
        this.fecha_reserva = fecha_reserva;        
        this.dni = dni;
        
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fecha_reserva=" + fecha_reserva + ", dni=" + dni + '}';
    }
	
	
	
	
	
	
	
	
	

}
