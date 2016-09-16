/**
 * 
 */
package crudSpa.models;

import java.util.Date;

/**
 *Clase DetalleReserva
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class DetalleReserva {
	
      
        private int idDetalle;
        private int idReserva;
        private int idServicio;	       
        private double precio;
        private int cantidad;
        
        /**
         * constructor vacio
         */
    public DetalleReserva() {
    }

    /**
     * Constructor con todos los atributos de detalle de una reserva
     * @param idDetalle identificador de detalle de la reserva
     * @param idReserva identificador de la reserva
     * @param idServicio identificador del servicio
     * @param precio coste del servicio
     * @param cantidad numero de servicio comprados
     */
    public DetalleReserva(int idDetalle, int idReserva, int idServicio,  double precio, int cantidad) {
        this.idDetalle = idDetalle;
        this.idReserva = idReserva;
        this.idServicio = idServicio;        
        this.precio = precio;
        this.cantidad= cantidad;
        
    }   

     public DetalleReserva(int idReserva, int idServicio,  double precio, int cantidad) {
        this.idReserva = idReserva;
        this.idServicio = idServicio;        
        this.precio = precio;
        this.cantidad= cantidad;
        
    }   
     
    public DetalleReserva(int idReserva, int id_servicio,  double precio) {
        this.idReserva = idReserva;
        this.idServicio = id_servicio;
        this.precio = precio;
        
    }
        
    public DetalleReserva(int idReserva, int idServicio) {
        this.idReserva = idReserva;
        this.idServicio = idServicio;        
        
    }
    
    
    public DetalleReserva(int idDetalle, double precio) {
        this.idDetalle = idDetalle;
        this.precio = precio;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    @Override
    public String toString() {
        return "DetalleReserva{" + "idDetalle=" + idDetalle + ", idReserva=" + idReserva + ", idServicio=" + idServicio + ", precio=" + precio + '}';
    }

        
    
    
	
}
