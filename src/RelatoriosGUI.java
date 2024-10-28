import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RelatoriosGUI extends JPanel {

    private void atualizarEstoque(JTextArea txtEstoque) {
        txtEstoque.setText("");
        for (String nome : new String[]{"Gasolina", "Álcool", "Diesel"}) {
            txtEstoque.append(nome + ": " + PostoGUI.posto.getCombustivel(nome).getEstoque() + " litros\n");
        }
    }

    public RelatoriosGUI(){

        // Criação do JFrame
        JFrame telaRelatorios = new JFrame("Relatórios");
        telaRelatorios.setSize(400, 600);
        telaRelatorios.setLayout(null);
        telaRelatorios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaRelatorios.setLocationRelativeTo(null);
        
        // Label para mostrar o saldo total
        JLabel lblSaldoTotal = new JLabel("Saldo Total: R$" + PostoGUI.posto.getSaldoCaixa() , JLabel.CENTER);
        lblSaldoTotal.setBounds(50, 000, 300, 20);
        telaRelatorios.add(lblSaldoTotal);

        // Área de texto para mostrar o estoque
        JTextArea txtEstoque = new JTextArea();
        txtEstoque.setBounds(50, 150, 300, 80);
        txtEstoque.setEditable(false);
        atualizarEstoque(txtEstoque); // Atualiza o estoque inicial
        telaRelatorios.add(txtEstoque);

        JLabel lblCombMaisVendido = new JLabel("Combustível Mais Vendido: " + PostoGUI.posto.getCombustivelMaisVendido());
        lblCombMaisVendido.setBounds(50, 300, 300, 20);
        telaRelatorios.add(lblCombMaisVendido);
        telaRelatorios.setVisible(true);
    }
}

