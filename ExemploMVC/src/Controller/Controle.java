package Controller;

import Model.Cliente;
import Model.ClienteDAO;

public class Controle {
    private String nome, email, flag;
    ClienteDAO dao;

    public Controle() {
        dao = new ClienteDAO();
    }

    public void requisitar(Object[] v) {
        flag = (String) v[2];

        if(flag.equals("Cadastrar")){
            nome = (String) v[0];
            email = (String) v[1];
            dao.inserir(new Cliente(nome, email));
        }else if(flag.equals("Listar")){
            dao.listar();
        }else if(flag.equals("Apagar")){
            dao.apagar((String) v[0]);
        }else if(flag.equals("Filtrar")){
            dao.filtrar((String) v[0]);
        }else{
            System.out.println("Esse comando não existe");
        }
    }
    
}
