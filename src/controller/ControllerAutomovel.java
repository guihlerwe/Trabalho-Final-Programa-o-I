/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Automovel;
import model.DAOAutomovel;
import view.FCadAutomovel;

/**
 *
 * @author guilherme
 */
public class ControllerAutomovel {
    private Automovel automovel;
    private FCadAutomovel fCadAutomovel;
    private DAOAutomovel DAOA;
    
    public ControllerAutomovel(){
        fCadAutomovel = new FCadAutomovel(null, true);
        automovel = new Automovel();
        DAOA= new DAOAutomovel();
        
    }
    
    public void inicializarComponenetes(){}
    
    public void cadastroautmovel(){
        fCadAutomovel.setVisible(true);
    }
    
}
