package interfaz;

import javax.swing.*;

import Parcial.Parcial;


import java.awt.event.*;

public class Interfaz {
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Calculadora de Potencia");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        ventana.add(panel);
        
        panel.setLayout(null);
        
        JLabel etiquetaBase = new JLabel("Base:");
        etiquetaBase.setBounds(50, 30, 80, 25);
        panel.add(etiquetaBase);
        
        JTextField campoBase = new JTextField();
        campoBase.setBounds(200, 30, 150, 25);
        panel.add(campoBase);
        
        JLabel etiquetaExponente = new JLabel("Exponente:");
        etiquetaExponente.setBounds(50, 80, 80, 25);
        panel.add(etiquetaExponente);

        JTextField campoExponente = new JTextField();
        campoExponente.setBounds(200, 80, 150, 25);
        panel.add(campoExponente);
        
        JButton botonCalcular = new JButton("Calcular");
        botonCalcular.setBounds(200, 180, 100, 25);
        panel.add(botonCalcular);
        
        JLabel etiquetaResultado = new JLabel("Resultado:");
        etiquetaResultado.setBounds(50, 130, 80, 25);
        panel.add(etiquetaResultado);
        
        JLabel valorResultado = new JLabel("---");
        valorResultado.setBounds(130, 130, 80, 25);
        panel.add(valorResultado);
        
        botonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int base = Integer.parseInt(campoBase.getText());
                    int exponente = Integer.parseInt(campoExponente.getText());
                    
                    Parcial p = new Parcial();
                    int resultado = p.potencia(base, exponente);
                    
                    valorResultado.setText(String.valueOf(resultado));
                } catch (NumberFormatException ex) {
                    valorResultado.setText("Error: Ingrese números");
                } catch (IllegalArgumentException ex) {
                    valorResultado.setText("Error: " + ex.getMessage());
                }
            }
        });
        
        ventana.setVisible(true);
    }
}