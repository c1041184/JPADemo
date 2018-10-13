/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UseraccountFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author c1041184
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UseraccountFacade useraccountFacade;

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }
    
}
