/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.models;

import java.sql.Date;
/**
 *Clase Cliente que extiende de la clase Persona y hereda sus atributos
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class Cliente extends Persona{
    
    //ATRIBUTOS
    

    
    //CONSTRUCTORES 
    /**
     * Este metodo tiene los atributos de clientes
     * @param dni
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param email 
     */
    public Cliente(String dni, String nombre, String apellidos, int telefono, String email) {
        super(dni, nombre, apellidos, telefono, email);


    }

  
    public Cliente (){
        
    }    
    
    //GETTERS AND SETTERS


    //MÉTODOS
    /**
     * este metodos muestra los datos 
     * @return devuelve el toString de la herencia clase persona (dni, nombre, apellidos, telefono, email) 
     */
    public String toString(){
        return super.toString();
    }

    



   
    
}
