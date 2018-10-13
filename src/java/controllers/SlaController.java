/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.SlaFacade;
import entity.Sla;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


import java.util.List;


import javax.ejb.EJB;

/**
 *
 * @author c1041184
 */
@Named(value = "slaController")
@SessionScoped
public class SlaController implements Serializable {

    @EJB
    private SlaFacade slaFacade;
    
    private Sla sla = new Sla();

    public SlaFacade getSlaFacade() {
        return slaFacade;
    }

    public void setSlaFacade(SlaFacade slaFacade) {
        this.slaFacade = slaFacade;
    }

    public Sla getSla() {
        return sla;
    }

    public void setSla(Sla sla) {
        this.sla = sla;
    }

    /**
     * Creates a new instance of SlaController
     */
    public SlaController() {
    }
    
    public List<Sla> FindAll(){

        return this.slaFacade.findAll();    
    }
    
    public String add(){
        this.slaFacade.create(sla);
        this.sla = new Sla();
        return "index";
    }


}
