/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author guilherme
 */
public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> cliente = new ArrayList<Cliente>();

    @Override
    public int getRowCount() {
        return cliente.size();
    }

    @Override
    public int getColumnCount() {
        return 4;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "cpf";
            }
            case 1 -> {
                return "nome";
            }
            case 2->{
                return "data";
            }
            case 3 ->{
                return "telefone";
            }
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return cliente.get(rowIndex).getCpf();
            }
            case 1 -> {
                return cliente.get(rowIndex).getNome();
            }
            case 2 ->{
                return cliente.get(rowIndex).getDataNascimento();
            }
            case 3->{
                return cliente.get(rowIndex).getTelefone();
            }
        }
        return 0;
    }

    public void addCliente(Cliente c) {
        cliente.add(c);
        fireTableRowsInserted(cliente.size() - 1, cliente.size() - 1);
    }

    public void excluir(int indice) {
        cliente.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public void limpar() {
        cliente.clear();
    }

    public Cliente pegarCliente(int indice) {
        return cliente.get(indice);
    }

}
    

