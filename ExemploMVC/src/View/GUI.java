package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controle;

public class GUI extends JFrame {
    JFrame frame;
    JButton listar;
    JButton filtrar;
    JButton cadastrar;
    JButton apagar;
    JButton limpar;
    JTextField nome;
    JTextField email;
    JLabel digiteNome;
    JLabel digiteemail;
    Object v[] = new Object[3];
    Controle controller;

    public void iniciar() {
        frame = new JFrame();
        cadastrar = new JButton("Cadastrar");
        listar = new JButton("Listar");
        apagar = new JButton("Apagar");
        limpar = new JButton("limpar");
        filtrar = new JButton("Filtrar");

        nome = new JTextField();
        email = new JTextField();

        digiteNome = new JLabel("Nome");
        digiteemail = new JLabel("Email");

        frame.setTitle("Cadastro de Contatos");
        frame.setLayout(null);
        frame.setBounds(300, 300, 400, 250);
        cadastrar.setBounds(70, 120, 120, 25);
        cadastrar.setBackground(Color.YELLOW);

        filtrar.setBounds(70, 200, 120, 25);
        filtrar.setBackground(Color.YELLOW);

        listar.setBounds(200, 120, 120, 25);
        listar.setBackground(Color.CYAN);

        apagar.setBounds(70, 160, 120, 25);
        apagar.setBackground(Color.PINK);

        limpar.setBounds(200, 160, 120, 25);
        limpar.setBackground(Color.ORANGE);

        digiteNome.setBounds(70, 10, 120, 25);
        nome.setBounds(70, 30, 250, 25);

        digiteemail.setBounds(70, 60, 120, 25);
        email.setBounds(70, 80, 250, 25);

        frame.add(cadastrar);
        frame.add(listar);
        frame.add(apagar);
        frame.add(limpar);
        frame.add(filtrar);
        frame.add(digiteNome);
        frame.add(digiteemail);
        frame.add(nome);
        frame.add(email);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        apagar();
        cadastrar();
        listar();
        limparButton();
        filtrar();

        controller = new Controle();
    }

    private void listar() {
        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v[2] = "Listar";
                controller.requisitar(v);
            }
        });
    }

    private void cadastrar() {
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v[0] = nome.getText();
                v[1] = email.getText();
                v[2] = "Cadastrar";
                controller.requisitar(v);
                JOptionPane.showMessageDialog(frame, "Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limpar();
            }
        });
    }

    private void apagar() {
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v[2] = "Apagar";
                v[0] = nome.getText();
                controller.requisitar(v);
                limpar();
            }
        });
    }

    private void filtrar() {
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v[2] = "Filtrar";
                v[0] = nome.getText();
                controller.requisitar(v);
                limpar();
            }
        });
    }

    private void limparButton() {
        limpar.addActionListener(() -> {     
            limpar();
        });
    }

    private void limpar() {
        nome.setText("");
        email.setText("");
        nome.grabFocus();
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.iniciar();
    }
}
