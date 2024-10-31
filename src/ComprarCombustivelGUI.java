import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComprarCombustivelGUI extends JPanel {

    public ComprarCombustivelGUI(){

  
  
        // Criação do JFrame
        JFrame telaCompra = new JFrame("Compra de Combustível");
        telaCompra.setSize(400, 600);
        telaCompra.setLayout(null);
        telaCompra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaCompra.setLocationRelativeTo(null);

          // Label para mostrar o saldo total
        JLabel lblSaldoTotal = new JLabel("Saldo Total: R$" + PostoGUI.posto.getSaldoCaixa() , JLabel.CENTER);
        lblSaldoTotal.setBounds(50, 000, 300, 20);
        telaCompra.add(lblSaldoTotal);

        // ComboBox para selecionar o tipo de combustível
        JLabel lblCombustivel = new JLabel("Selecione o combustível:");
        lblCombustivel.setBounds(50, 50, 150, 20);
        JComboBox<String> cmbCombustivel = new JComboBox<>(new String[]{"Gasolina", "Álcool", "Diesel"});
        cmbCombustivel.setBounds(200, 50, 120, 20);

        // Campo para inserir a quantidade
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(50, 100, 150, 20);
        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(200, 100, 120, 20);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(150, 250, 100, 30);

        telaCompra.add(btnConfirmar);

        // Adiciona os componentes ao JFrame
        telaCompra.add(lblCombustivel);
        telaCompra.add(cmbCombustivel);
        telaCompra.add(lblQuantidade);
        telaCompra.add(txtQuantidade);


        // Torna a janela visível
        telaCompra.setVisible(true);


        btnConfirmar.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoCombustivel = (String) cmbCombustivel.getSelectedItem();
                try {
                    double quantidade = Double.parseDouble(txtQuantidade.getText());

                    boolean vendaRealizada = PostoGUI.posto.comprarCombustivel(tipoCombustivel, quantidade);

                    if (vendaRealizada) {
                        JOptionPane.showMessageDialog(telaCompra, "Compra de " + quantidade + " litros de " + tipoCombustivel + " realizada com sucesso!");
                        telaCompra.dispose();
                    } else {
                        JOptionPane.showMessageDialog(telaCompra, "Você não possui saldo suficiente para fazer essa compra!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(telaCompra, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
