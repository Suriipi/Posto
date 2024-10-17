import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			PostoCombustivel posto = new PostoCombustivel(10000); // Inicializando com saldo em caixa

			// Adicionando combustíveis
			posto.adicionarCombustivel("Gasolina", 5.00, 6.50, 1000);
			posto.adicionarCombustivel("Álcool", 3.00, 4.50, 500);
			posto.adicionarCombustivel("Diesel", 4.00, 5.00, 800);

			while (true) {
			    System.out.println("1. Comprar combustível");
			    System.out.println("2. Vender combustível");
			    System.out.println("3. Ver saldo em caixa");
			    System.out.println("4. Ver estoque");
			    System.out.println("5. Combustível mais vendido");
			    System.out.println("6. Sair");
			    int opcao = scanner.nextInt();

			    switch (opcao) {
			        case 1:
			            System.out.print("Digite o combustível para comprar: ");
			            String combustivelCompra = scanner.next();
			            System.out.print("Digite a quantidade em litros: ");
			            double quantidadeCompra = scanner.nextDouble();
			            posto.comprarCombustivel(combustivelCompra, quantidadeCompra);
			            break;
			        case 2:
			            System.out.print("Digite o combustível para vender: ");
			            String combustivelVenda = scanner.next();
			            System.out.print("Digite a quantidade em litros: ");
			            double quantidadeVenda = scanner.nextDouble();
			            posto.venderCombustivel(combustivelVenda, quantidadeVenda);
			            break;
			        case 3:
			            System.out.println("Saldo em caixa: R$" + posto.getSaldoCaixa());
			            break;
			        case 4:
			            posto.mostrarEstoque();
			            break;
			        case 5:
			            System.out.println("Combustível mais vendido: " + posto.getCombustivelMaisVendido());
			            break;
			        case 6:
			            System.exit(0);
			        default:
			            System.out.println("Opção inválida!");
			    }
			}
		}
    }
}
