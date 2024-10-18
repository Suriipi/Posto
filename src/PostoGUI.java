import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostoGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PostoCombustivel posto;
    private JTextField txtQuantidade;
    private JTextArea txtAreaEstoque;

    public PostoGUI() {
        posto = new PostoCombustivel(10000);
        posto.adicionarCombustivel("Gasolina", 5.00, 6.50, 1000);
        posto.adicionarCombustivel("Álcool", 3.00, 4.50, 500);
        posto.adicionarCombustivel("Diesel", 4.00, 5.00, 800);

        setTitle("Posto de Combustível");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnComprar = new JButton("Comprar Combustível");
        btnComprar.setBounds(50, 50, 150, 30);

        JButton btnVender = new JButton("Vender Combustível");
        btnVender.setBounds(220, 50, 150, 30);

        JButton btnMostrarEstoque = new JButton("Relatório");
        btnMostrarEstoque.setBounds(390, 50, 150, 30);

        add(btnComprar);
        add(btnVender);
        add(btnMostrarEstoque);


        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
        //         String nomeCombustivel = JOptionPane.showInputDialog("Digite o nome do combustível:");
        //         double quantidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade:"));
        //         posto.comprarCombustivel(nomeCombustivel, quantidade);
            }
        });

        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        //         String nomeCombustivel = JOptionPane.showInputDialog("Digite o nome do combustível:");
        //         double quantidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade:"));
        //         posto.venderCombustivel(nomeCombustivel, quantidade);
            }
        });

        btnMostrarEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        //         txtAreaEstoque.setText("");
        //         for (String nome : new String[]{"Gasolina", "Álcool", "Diesel"}) {
        //             txtAreaEstoque.append(nome + ": " + posto.combustiveis.get(nome).getEstoque() + " litros\n");
        //         }
            }
        });
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PostoGUI().setVisible(true);
        });
    }
}
