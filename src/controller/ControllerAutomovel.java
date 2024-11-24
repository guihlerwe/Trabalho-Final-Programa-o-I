/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Automovel;
import model.Cliente;
import model.DAOAutomovel;
import model.DAOCliente;
import view.FCadAutomovel;

/**
 *
 * @author guilherme
 */
public class ControllerAutomovel {

    private Automovel automovel;
    private FCadAutomovel fCadAutomovel;
    private DAOAutomovel DAOA;
    private Cliente cliente;
    private DAOCliente DAOC;

    public ControllerAutomovel() {
        fCadAutomovel = new FCadAutomovel(null, true);
        automovel = new Automovel();
        DAOA = new DAOAutomovel();
        cliente= new Cliente();
        DAOC = new DAOCliente();

    }

    public void inicializarComponenetes() {
        fCadAutomovel.btFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharTela();
            }
        });
        fCadAutomovel.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserir();
            }
        });
    }

    public void cadastroautmovel() {
        fCadAutomovel.setVisible(true);
    }

    public void fecharTela() {
        limpar();
        fCadAutomovel.setVisible(false);
    }

    public void limpar() {
        automovel = null;
        fCadAutomovel.edAno.setText("");
        fCadAutomovel.edMarca.setText("");
        fCadAutomovel.checkMercosul.setSelected(false);
        fCadAutomovel.edPlaca.setText("");
        fCadAutomovel.edModelo.setText("");
    }

    public void inserir() {
        if (automovel == null) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(fCadAutomovel.edAno.getText());
            String marca = fCadAutomovel.edMarca.getText();
            String modelo = fCadAutomovel.edModelo.getText();
            
            String placa = "";
            if (fCadAutomovel.checkMercosul.isSelected()) {
                placa = fCadAutomovel.edPlaca.getText();

            } else {
                placa = fCadAutomovel.edPlaca.getText();
            }

            Automovel automovel = new Automovel(placa, marca, modelo, 0, cliente);

            automovel.setAno(sdf.parse(fcadAutomovel.edAno.getText()));

            // Usar a DAO para salvar o automóvel no banco de dados
            DAOAautomovel.inserir(automovel);

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Automóvel cadastrado com sucesso!");

        }

    }

}
