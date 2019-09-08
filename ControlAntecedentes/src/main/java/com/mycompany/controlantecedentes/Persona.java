/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlantecedentes;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ISAACELEAZAR
 */
public class Persona implements Serializable{
    
    private String nombre;
    
    private String cedula;      
    
    private byte edad;
    
    private char genero;
    
    private List<Antecedentes> conjuntoAntecedentes;

    public Persona(String nombre, String cedula, byte edad, char genero, List<Antecedentes> conjuntoAntecedentes) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.genero = genero;
        this.conjuntoAntecedentes = conjuntoAntecedentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public List<Antecedentes> getConjuntoAntecedentes() {
        return conjuntoAntecedentes;
    }

    public void setConjuntoAntecedentes(List<Antecedentes> conjuntoAntecedentes) {
        this.conjuntoAntecedentes = conjuntoAntecedentes;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + nombre + ", Cedula=" + cedula + ", Edad=" + edad + ", Genero=" + genero + ", Conjunto Antecedentes=" + conjuntoAntecedentes + '}';
    }
    
    
    
}
