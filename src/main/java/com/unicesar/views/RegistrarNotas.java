/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicesar.views;

import com.unicesar.components.TableWithFilterSplit;
import com.unicesar.entity.Listas;
import com.unicesar.utils.SeveralProcesses;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author orenaro
 */
public class RegistrarNotas extends VerticalSplitPanel implements View {

    private Label lblTitulo;
    private Label lblNombreDocente;
    private Label lblCorte;
    private Button btnPublicar;
    private GridLayout layoutCabecera;
    private TableWithFilterSplit tblAsignaturas;
    private TableWithFilterSplit tblEstudiantes;
    private Panel panelTblAsignaturas;
    private Panel panelTblEstudiantes;
    private HorizontalSplitPanel layoutTablas;
    
    private String cadenaSql;
    private final int codigoCorte = 1;
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Listas.cargarListaAsignaturas();
        Listas.cargarListaEstudiantes();
        lblTitulo = new Label("Registro de Notas");
        lblTitulo.setWidthUndefined();
        lblTitulo.setStyleName("titulo");
        lblTitulo.addStyleName("textoEnormeRojo");
        lblNombreDocente = new Label("Docente: <strong>" + SeveralProcesses.getNombreUsuarioEnSesion() + "</strong>", ContentMode.HTML);
        lblNombreDocente.setWidthUndefined();
        setValorLblCorte();
        btnPublicar = new Button("PUBLICAR", FontAwesome.EYE);
        btnPublicar.setStyleName("verde");
        
        layoutCabecera = new GridLayout(3, 2);
        layoutCabecera.addComponent(lblTitulo, 0, 0, 2, 0);
        layoutCabecera.addComponent(lblNombreDocente, 0, 1);
        layoutCabecera.addComponent(lblCorte, 1, 1);
        layoutCabecera.addComponent(btnPublicar, 2, 1);
        layoutCabecera.setWidth("100%");
        layoutCabecera.setMargin(new MarginInfo(false, true, false, true));
        layoutCabecera.setSpacing(true);
        layoutCabecera.setComponentAlignment(lblTitulo, Alignment.MIDDLE_CENTER);
        layoutCabecera.setComponentAlignment(lblNombreDocente, Alignment.MIDDLE_LEFT);
        layoutCabecera.setComponentAlignment(lblCorte, Alignment.MIDDLE_CENTER);
        layoutCabecera.setComponentAlignment(btnPublicar, Alignment.MIDDLE_RIGHT);
        
        tblAsignaturas = new TableWithFilterSplit("asignatura", null, true);
        tblAsignaturas.addContainerProperty("codigo", Object.class, null, "Codigo", null, Table.Align.CENTER);
        tblAsignaturas.addContainerProperty("asignatura", Object.class, null, "Asignatura", null, Table.Align.CENTER);
        tblAsignaturas.setSizeFull();
        tblAsignaturas.setStyleName("tablaasignaturas");
        panelTblAsignaturas = new Panel("Listado de Asignaturas", tblAsignaturas);
        panelTblAsignaturas.setSizeFull();
        panelTblAsignaturas.setStyleName("panelverde");
        panelTblAsignaturas.addStyleName("bordeverde");
        
        tblEstudiantes = new TableWithFilterSplit("estudiante", null, true);
        tblEstudiantes.addContainerProperty("codigo", Object.class, null, "Codigo", null, Table.Align.CENTER);
        tblEstudiantes.addContainerProperty("estudiante", Object.class, null, "Estudiante", null, Table.Align.CENTER);
        tblEstudiantes.addContainerProperty("id", Object.class, null, "Identificación", null, Table.Align.CENTER);
        tblEstudiantes.addContainerProperty("nota", TextField.class, null, "Nota", null, Table.Align.CENTER);
        tblEstudiantes.setSizeFull();
        tblEstudiantes.setStyleName("tablafilasdelgadascomponente");
        panelTblEstudiantes = new Panel("Listado de Estudiantes", tblEstudiantes);
        panelTblEstudiantes.setSizeFull();
        panelTblEstudiantes.setStyleName("panelverde");
        panelTblEstudiantes.addStyleName("bordeverde");
        
        layoutTablas = new HorizontalSplitPanel(panelTblAsignaturas, panelTblEstudiantes);
        layoutTablas.setSizeFull();
        layoutTablas.setSplitPosition(500, Sizeable.Unit.PIXELS);
        
        addComponents(layoutCabecera, layoutTablas);
        setSizeFull();
        setSplitPosition(85, Sizeable.Unit.PIXELS);
        setStyleName("fondoaplicacion");
        
        cargarTblAsignaturasDesdeLista();
        tblAsignaturas.addItemClickListener(e -> {
            cargarTblEstudiantes(e.getItem().getItemProperty("codigo").getValue());
        });
    }
    
    private void setValorLblCorte() {
        lblCorte = new Label();
        lblCorte.setWidthUndefined();
        lblCorte.setContentMode(ContentMode.HTML);
        lblCorte.setValue("<strong>Primer Corte</strong> - Fecha Limite: " + "<strong>2021-10-06</strong>" );
        
    }
    
    private void cargarTblAsignaturasDesdeLista() {
        Listas.asignaturas.forEach(asignatura -> {
                tblAsignaturas.addItem(
                        new Object[]{
                            asignatura.getCodigoAsignatura(),
                            asignatura.getNombreAsignatura()
                        }, 
                        asignatura.getCodigoAsignatura()
                );
        });
    }
    
    private void cargarTblEstudiantes(Object codigoAsignatura) {
        tblEstudiantes.removeAllItems();
        
        Listas.estudiantes.forEach(estudiante -> {
            if ( estudiante.getCodigoAsignatura() == Integer.valueOf(codigoAsignatura.toString()) ) {
//                NumberFieldCustom txtNota = new NumberFieldCustom(null, true, false, 0.00, 5.00, estudiante.getNota(), "100%", false, true, null);
                TextField txtNota = new TextField();
                txtNota.setStyleName(ValoTheme.TEXTAREA_BORDERLESS);
                txtNota.addValueChangeListener(new Property.ValueChangeListener() {
                    private final int codigoEstudianteAsignatura = estudiante.getCodigoEstudiante();
                    @Override
                    public void valueChange(Property.ValueChangeEvent event) {
                        Listas.estudiantes.forEach(estudiante -> {
                            if ( estudiante.getCodigoEstudiante() == codigoEstudianteAsignatura )
                                estudiante.setNota(event.getProperty().getValue().toString());
                        });
                    }
                });
                if ( tblEstudiantes.size() == 0 )
                    txtNota.focus();
                tblEstudiantes.addItem(
                        new Object[]{
                            estudiante.getCodigoUniversitario(), 
                            estudiante.getNombreEstudiante(), 
                            estudiante.getTipoId() + " - " + estudiante.getId(), 
                            txtNota
                        }, 
                        estudiante.getCodigoEstudiante()
                );
            }
        });
        
    }
    
}
