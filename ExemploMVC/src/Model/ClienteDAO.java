package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO {

    private List<Cliente> lista;

    public ClienteDAO() {
        lista = new ArrayList<>();
    }

    public void inserir(Cliente cliente) {
        lista.add(cliente);
    }

    public void listar() {
        String contatos = "";
        for (Cliente cliente : lista) {
            contatos = contatos + cliente + "\n";
        }
        JOptionPane.showMessageDialog(null, contatos);
    }

    public void apagar(String nome) {
        Cliente contato = new Cliente();
        for (Cliente cliente : lista) {
            if(cliente.getNome().equals(nome)){
                contato = cliente;
            }
        }
        lista.remove(contato);
    }

    public void filtrar(String nome) {
        Cliente contato = new Cliente();
        for (Cliente cliente : lista) {
            if(cliente.getNome().equals(nome)){
                contato = cliente;
            }
        }
        JOptionPane.showMessageDialog(null, contato);
    }

}
