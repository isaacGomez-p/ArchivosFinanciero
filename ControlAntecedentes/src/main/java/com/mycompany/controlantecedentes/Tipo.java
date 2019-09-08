/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlantecedentes;

import java.io.Serializable;

/**
 *
 * @author ISAACELEAZAR
 */
public class Tipo implements Serializable{
    
    private String descripcion;
    
    private String nombreCaracteristico;

    public Tipo(String descripcion, String nombreCaracteristico) {
        this.descripcion = descripcion;
        this.nombreCaracteristico = nombreCaracteristico;
    }   
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCaracteristico() {
        return nombreCaracteristico;
    }

    public void setNombreCaracteristico(String nombreCaracteristico) {
        this.nombreCaracteristico = nombreCaracteristico;
    }

    @Override
    public String toString() {
        return "Tipo{" + "descripcion=" + descripcion + ", nombreCaracteristico=" + nombreCaracteristico + '}';
    }   
}
