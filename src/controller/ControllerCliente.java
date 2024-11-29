/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.DAOCliente;
import view.ClienteTableModel;
import view.FCadCliente;
import view.FConsCliente;

/**
 *
 * @author guilherme
 */
public class ControllerCliente {

    private Cliente cliente;
    private DAOCliente DAOC;
    private FCadCliente fCadCliente;
    private FConsCliente fConsCliente;
    private ClienteTableModel model;

    public ControllerCliente() throws ParseException {
        cliente = new Cliente();
        DAOC = new DAOCliente();
        fCadCliente = new FCadCliente(null, true);
        fConsCliente = new FConsCliente(null, true);
        model = new ClienteTableModel();
        inicializarComponentes();
    }

    public void inicializarComponentes() throws ParseException {
        fConsCliente.boxCliente.setModel(model);
        fCadCliente.edData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        fCadCliente.btFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharTela();
            }
        });
        fConsCliente.btFerchar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharTela();
            }
        });
        fCadCliente.btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inserir();
                } catch (ParseException ex) {
                    Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        fConsCliente.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecionarEditar();
            }
        });
        fConsCliente.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
    }

    public void cadastroCliente() {
        limpar();
        fCadCliente.setVisible(true);
    }

    public void consultarCliente() {
        carregarClientes();
        fConsCliente.setVisible(true);
    }

    public void carregarClientes() {
        model.limpar();
        for (Cliente c : DAOC.listar()) {
            model.addCliente(c);
        }
    }

    public void fecharTela() {
        limpar();
        fCadCliente.setVisible(false);
        fConsCliente.setVisible(false);
    }

    public void limpar() {
        cliente = null;
        fCadCliente.edData.setText("");
        fCadCliente.edNome.setText("");
        fCadCliente.edTelefone.setText("");
        fCadCliente.edCpf.setText("");
    }

    public void inserir() throws ParseException {
        if (cliente == null) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String cpf = fCadCliente.edCpf.getText();
            String nome = fCadCliente.edNome.getText();
            String telefone = fCadCliente.edTelefone.getText();
            Date data = formatador.parse(fCadCliente.edData.getText());

            Cliente cliente = new Cliente(cpf, nome, data, telefone);

            if (DAOC.Inserir(cliente)) {
                JOptionPane.showMessageDialog(null, "Gravado");
                limpar();
                fCadCliente.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro");

            }
        } else {
            cliente.setNome(fCadCliente.edNome.getText());
            if (DAOC.editar(cliente)) {
                JOptionPane.showMessageDialog(null, "Editado");
                limpar();
                fCadCliente.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
    }

    public void selecionarEditar() {
        int linhaSelecionada = fConsCliente.boxCliente.getSelectedRow();

        if (linhaSelecionada >= 0) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

            carregarClientes();
            cliente = model.pegarCliente(linhaSelecionada);
            fCadCliente.edNome.setText(cliente.getNome());
            fCadCliente.edTelefone.setText(cliente.getTelefone());
            fCadCliente.edCpf.setText(cliente.getCpf());
            fCadCliente.edData.setText(formatador.format(cliente.getDataNascimento()));
            
            fConsCliente.setVisible(false);
            fCadCliente.setVisible(true);
            fConsCliente.setVisible(true);

        }
    }

    /*public int pegarIndiceCliente(Cliente c) {
        int i = 0;
        for (Cliente cliente : DAOC.listar()) {
            if (c.getNome().equals(cliente.getNome())) {
                return i;
            }
            i++;
        }
        return 0;
    }*/
    
    public void excluir() {
        int linhaSelecionada = fConsCliente.boxCliente.getSelectedRow();
        if (linhaSelecionada >= 0) {
            Cliente c = model.pegarCliente(linhaSelecionada);
            if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro?", "Confirmação", 0) == 0) {
                if (DAOC.excluir(c)) {
                    model.excluir(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Excluido");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro");
        }
    }

}
