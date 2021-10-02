/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicesar.entity;

/**
 *
 * @author orenaro
 */
public class Estudiante {
    private int codigoEstudiante;
    private String codigoUniversitario;
    private String nombreEstudiante;
    private String tipoId;
    private String id;
    private String nota;
    private int codigoAsignatura;

    public Estudiante() {
    }

    public Estudiante(int codigoEstudiante, String codigoUniversitario, String nombreEstudiante, String tipoId, String id, String nota, int codigoAsignatura) {
        this.codigoEstudiante = codigoEstudiante;
        this.codigoUniversitario = codigoUniversitario;
        this.nombreEstudiante = nombreEstudiante;
        this.tipoId = tipoId;
        this.id = id;
        this.nota = nota;
        this.codigoAsignatura = codigoAsignatura;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoUniversitario() {
        return codigoUniversitario;
    }

    public void setCodigoUniversitario(String codigoUniversitario) {
        this.codigoUniversitario = codigoUniversitario;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(int codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }
    
}
