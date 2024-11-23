/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DAORevisao;
import model.Revisao;
import view.FCadRevisao;

/**
 *
 * @author guilherme
 */
public class ControllerRevisao {

    private Revisao revisao;
    private FCadRevisao fCadRevisao;
    private DAORevisao DAOR;

    public ControllerRevisao() {
        revisao = new Revisao();
        fCadRevisao = new FCadRevisao(null, true);
        DAOR = new DAORevisao();
        inicializarComponentes();
    }

    public void inicializarComponentes() {
    }

    public void cadastroRevisao() {
        fCadRevisao.setVisible(true);
    }

    public void consultaRevisao() {
        fCadRevisao.setVisible(true);

    }

}
