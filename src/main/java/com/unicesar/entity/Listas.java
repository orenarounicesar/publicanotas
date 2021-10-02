/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicesar.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orenaro
 */
public class Listas {
    public static List<Asignatura> asignaturas = new ArrayList<>();
    public static List<Estudiante> estudiantes = new ArrayList<>();
    
    public static void cargarAsignaturas() {
        asignaturas.add( new Asignatura(1, "PROGRAMACION ORIENTADA A OBJETOS") );
        asignaturas.add( new Asignatura(2, "ESTRUCTURAS DE DATOS") );
        asignaturas.add( new Asignatura(3, "CALCULO DIFERENCIAL") );
    }
    
    public static void cargarEstudiantes() {
        estudiantes.add(
            new Estudiante(1, "20190102", "SUSANA MARIA OROZCO PEREZ", "CC", "1065622133", null, 1)
        );
        estudiantes.add(
            new Estudiante(1, "20190103", "JOSE AVENDAÑO DUARTE", "CC", "1065332098", "3,5", 1)
        );
        estudiantes.add(
            new Estudiante(1, "20190104", "VICTOR HUGO SUAREZ BONILLA", "CC", "1067901099", null, 2)
        );
    }
}
