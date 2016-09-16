/**
 * 
 */
package crudSpa.models;

import java.sql.Date;

/**
 *Clase Promocion
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class Promocion {
	
	
	private int idPromocion;
        private String nombre;
	private double descuento;
	
	
	
	public Promocion(int idPromocion) {
		super();
		this.idPromocion = idPromocion;
	}
        
	
	public Promocion(int idPromocion, String nombre) {
		super();
		this.idPromocion = idPromocion;
                this.nombre = nombre;
	}

	public Promocion(int idPromocion, double descuento) {
		super();
		this.idPromocion = idPromocion;
                this.descuento = descuento;
	}
        
        /**
         * constructor con todos los atributos de una promocion
         * @param idPromocion identificador de la promocion
         * @param nombre nombre que tendra la promocion
         * @param descuento precio que se le descontara al servicio en promocion
         */
        	public Promocion(int idPromocion, String nombre, double descuento) {
		super();
		this.idPromocion = idPromocion;
                this.nombre = nombre;
                this.descuento = descuento;
	}
        
    /**
     * Constructor vacio
     */
    public Promocion() {
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Promocion{" + "idPromocion=" + idPromocion + ", descuento=" + descuento + '}';
    }
    
    

        
	
	
	
	
	

}
