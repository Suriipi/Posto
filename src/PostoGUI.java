import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostoGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    static PostoCombustivel posto;

    public PostoGUI() {
        posto = new PostoCombustivel(10000);
        posto.adicionarCombustivel("Gasolina", 5.00, 6.50, 1000);
        posto.adicionarCombustivel("Álcool", 3.00, 4.50, 500);
        posto.adicionarCombustivel("Diesel", 4.00, 5.00, 800);

        setTitle("Posto de Combustível");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Botão para Comprar Combustível (implementação futura)
        JButton btnComprar = new JButton("Comprar Combustível");
        btnComprar.setBounds(50, 50, 170, 30);
        add(btnComprar);
        
        btnComprar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ComprarCombustivelGUI(); 
            }
        });
        
        //Botão Relatórios
        JButton btnRelatorios = new JButton("Relatórios");
        btnRelatorios.setBounds(400, 50, 170, 30);
        add(btnRelatorios);
        
        btnRelatorios.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RelatoriosGUI(); 
            }
        });

        // Botão para Vender Combustível
        JButton btnVender = new JButton("Vender Combustível");
        btnVender.setBounds(240, 50, 150, 30);
        add(btnVender);

        // Ação do botão "Vender Combustível"
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre uma nova janela para vender combustível
                abrirTelaVenda();
            }
        });};



    private void abrirTelaVenda() {
        // Cria a nova tela
        JFrame telaVenda = new JFrame("Venda de Combustível");
        telaVenda.setSize(400, 300);
        telaVenda.setLayout(null);

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

        // Área de texto para mostrar o estoque
        JTextArea txtEstoque = new JTextArea();
        txtEstoque.setBounds(50, 150, 300, 80);
        txtEstoque.setEditable(false);
        atualizarEstoque(txtEstoque); // Atualiza o estoque inicial

        // Botão para confirmar a venda
        JButton btnConfirmarVenda = new JButton("Confirmar Venda");
        btnConfirmarVenda.setBounds(120, 250, 150, 30);

        // Ação para o botão confirmar venda
        btnConfirmarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoCombustivel = (String) cmbCombustivel.getSelectedItem();
                try {
                    double quantidade = Double.parseDouble(txtQuantidade.getText());
                    boolean vendaRealizada = posto.venderCombustivel(tipoCombustivel, quantidade);

                    if (vendaRealizada) {
                        JOptionPane.showMessageDialog(telaVenda, "Venda de " + quantidade + " litros de " + tipoCombustivel + " realizada com sucesso!");
                        atualizarEstoque(txtEstoque); // Atualiza o estoque após a venda
                    } else {
                        JOptionPane.showMessageDialog(telaVenda, "Estoque insuficiente para " + quantidade + " litros de " + tipoCombustivel, "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(telaVenda, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adiciona os componentes à nova tela
        telaVenda.add(lblCombustivel);
        telaVenda.add(cmbCombustivel);
        telaVenda.add(lblQuantidade);
        telaVenda.add(txtQuantidade);
        telaVenda.add(txtEstoque);
        telaVenda.add(btnConfirmarVenda);

        telaVenda.setVisible(true);
    }

    // Método para atualizar a exibição do estoque
    private void atualizarEstoque(JTextArea txtEstoque) {
        txtEstoque.setText("");
        for (String nome : new String[]{"Gasolina", "Álcool", "Diesel"}) {
            txtEstoque.append(nome + ": " + posto.getCombustivel(nome).getEstoque() + " litros\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PostoGUI().setVisible(true);
        });
    }
}