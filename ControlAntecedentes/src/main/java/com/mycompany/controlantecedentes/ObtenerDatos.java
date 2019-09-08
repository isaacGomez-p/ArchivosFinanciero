/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlantecedentes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISAACELEAZAR
 */
public final class ObtenerDatos {
    
    public ObtenerDatos(){
        ArrayList<Persona> personas = new ArrayList <>();        
        ArrayList<Persona> leerPersonas;
        List<Antecedentes> lAnt = new ArrayList<> ();
        Antecedentes ante;
        Tipo tip;
        Persona per;
        Scanner in = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        Scanner fe = new Scanner(System.in);
        Date fecha;
        String nombre, cedula, genero, strFecha, descripcion, tDescripcion, nombreCar;        
        byte leer, edad;
        System.out.println("ANTECEDENTES FINANCIEROS");
        do{            
            System.out.println("Digite la acción que desea realizar: \n 1. Agregar \n 2. Ver(Desde aqui puede Editar)");
            leer = in.nextByte();
            switch(leer){
                case 1:
                    do{                        
                        System.out.println("Digite el nombre:");
                        nombre = st.next();
                        System.out.println("Digite la cedula:");
                        cedula = st.next();
                        System.out.println("Digite la edad");
                        edad = in.nextByte();
                        System.out.println("Digite el genero (m/f/o)");
                        genero = st.next();
                        do{
                            System.out.println("Insertar un antecedente");
                            System.out.println("Digite la fecha:");
                            strFecha = fe.next();
                            fecha = ParseFecha(strFecha);
                            System.out.println("Escriba la descripcion del antecedente:");
                            descripcion = fe.next();
                            System.out.println("Digite el nombre caracteristico del tipo:");
                            nombreCar = fe.next();
                            System.out.println("Digite la descripcion del tipo:");
                            tDescripcion= fe.next();
                            tip = new Tipo(tDescripcion, nombreCar);
                            ante = new Antecedentes(fecha, tip, descripcion);
                            lAnt.add(ante);                        
                            System.out.println("Para insertar otro antecedente digite 1. Para salir digite otro numero.");
                            leer = in.nextByte();
                        }while(leer == 1);
                        per = new Persona(nombre, cedula, edad, genero.charAt(0), lAnt);
                        personas.add(per);                        
                        System.out.println("Para insertar otra persona digite 1. Para salir digite otro numero.");
                        leer = in.nextByte();
                    }while(leer == 1);                    
                    this.guardaDatos(cedula, personas);
                    break;
                case 2:
                    leerPersonas = this.verDatos();
                    for(int i = 0; i < leerPersonas.size(); i++) {
                        System.out.println( "Persona" + i + " = " + leerPersonas.get(i));
                    }
                    break;
            }
        }while(leer == 1 || leer == 2 );        
    }
    
    void guardaDatos(String cedula, ArrayList<Persona> arrayList1){
        ObjectOutputStream escribiendoFichero;
        try {
            escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream("Personas.dat"));
            escribiendoFichero.writeObject(arrayList1);
            escribiendoFichero.close();
        } catch (IOException ex) {
            Logger.getLogger(ObtenerDatos.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ArrayList<Persona> verDatos() {
        ArrayList<Persona> leerPersonas;
        try{    
            ObjectInputStream leyendoFichero = new ObjectInputStream(
            new FileInputStream("Personas.dat"));
            leerPersonas = ( ArrayList <Persona> )leyendoFichero.readObject();                 
            return leerPersonas;
        }catch (IOException | ClassNotFoundException e) {
            System.out.println( e.getMessage() );
        }
        return null;        
    }
    
    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }    
}
