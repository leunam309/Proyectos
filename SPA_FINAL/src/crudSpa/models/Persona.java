/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crudSpa.models;

/**
 *Clase  Persona
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class Persona {
    
    //ATRIBUTOS
     private String dni;
    private String nombre;
    private String apellidos;   
    private int telefono;
    private String email;
    
    
    //CONSTRUCTORES
    /**
     * Constructor con todos los atributos de una persona
     * @param dni
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param email 
     */
    public Persona(String dni, String nombre, String apellidos, 
             int telefono, String email){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;        
        this.telefono = telefono;
        this.email = email;
    }
    //constructor vacio
    public Persona(){
        
    }
    
    public Persona(String dni){
        this.dni = dni;
    }
    
    
    //GETTERS AND SETTERS
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getDni(){
        return dni;
    }
    
    public void setDni(String dni){
        this.dni = dni;
    }
    
     public int getTelefono(){
        return telefono;
    }
    
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
     public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
        //MÉTODOS
        
      public String toString() {
		return "Personas [Nombre=" + nombre + ", Apellidos=" + apellidos
				+ ", dni=" + dni + ", Telefono="+telefono
                        +", Email= "+email+"]";
	}
    
}
