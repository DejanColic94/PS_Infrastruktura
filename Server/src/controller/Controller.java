/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DBBroker;

/**
 *
 * @author DCX
 */
public class Controller {

    private static Controller instance;
    private DBBroker db;

    private Controller() {
        db = new DBBroker();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

}
