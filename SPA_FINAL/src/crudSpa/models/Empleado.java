/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudSpa.models;

import java.sql.Date;
/**
 *Clase Empleado que extiende de la clase Persona y hereda sus atributos
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class Empleado extends Persona{
    
    //ATRIBUTOS
    
    
    private String tipo_cuenta;
    private double salario;
    private String usuario;
    private String contrasenia;
    private boolean estado;
    
    //CONSTRUCTORES 
    /**
     * Contructor de empleado con todos los atributos
     * @param dni
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param email
     * @param tipo_cuenta
     * @param salario
     * @param usuario
     * @param contrasenia
     * @param estado 
     */
    public Empleado( String dni, String nombre, String apellidos, int telefono, String email,  String tipo_cuenta, double salario, String usuario, String contrasenia, boolean estado) {
        super(dni, nombre, apellidos, telefono, email);
        
        this.tipo_cuenta = tipo_cuenta;
        this.salario = salario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.estado= estado;
    }
    
        public Empleado( String dni, String nombre, String apellidos, int telefono, String email,  String tipo_cuenta, double salario, String usuario, String contrasenia) {
        super(dni, nombre, apellidos, telefono, email);
        
        this.tipo_cuenta = tipo_cuenta;
        this.salario = salario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
       
    }
    
        public Empleado(String tipo_cuenta, double salario, String nombre, String apellidos, String dni, int telefono, String email) {
        super(dni, nombre, apellidos, telefono, email);
        
        this.tipo_cuenta = tipo_cuenta;
        this.salario = salario;
    }
        
         public Empleado(String dni) {
         super(dni);
      
        }
     
    public Empleado(String tipo_cuenta, double salario) {
        
        this.tipo_cuenta = tipo_cuenta;
        this.salario = salario;
    }
    
    public Empleado (){
        
    }    
    
    //GETTERS AND SETTERS

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    //MÉTODOS
    
    public String toString(){
        return super.toString()+", tipo cuenta = "+tipo_cuenta
                +", Salario = "+salario;
    }

    



   
    
}
