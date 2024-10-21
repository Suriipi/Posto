import java.util.HashMap;
import java.util.Map;

public class PostoCombustivel {
    private double saldoCaixa;
    private Map<String, Combustivel> combustiveis;

    public PostoCombustivel(double saldoInicial) {
        this.saldoCaixa = saldoInicial;
        combustiveis = new HashMap<>();
    }

    public void adicionarCombustivel(String nome, double precoCompra, double precoVenda, double estoque) {
        combustiveis.put(nome, new Combustivel(nome, precoCompra, precoVenda, estoque));
    }

    public Combustivel getCombustivel(String nome) {
        return combustiveis.get(nome);  // Novo método que retorna o combustível pelo nome
    }

    public void comprarCombustivel(String nome, double quantidade) {
        Combustivel combustivel = combustiveis.get(nome);
        double custoTotal = combustivel.getPrecoCompra() * quantidade;
        if (saldoCaixa >= custoTotal) {
            saldoCaixa -= custoTotal;
            combustivel.comprar(quantidade, custoTotal);
            System.out.println("Compra de " + nome + " realizada.");
        } else {
            System.out.println("Saldo insuficiente para comprar " + nome);
        }
    }

    public boolean venderCombustivel(String nome, double quantidade) {
        Combustivel combustivel = combustiveis.get(nome);
        if (combustivel.vender(quantidade)) {
            saldoCaixa += combustivel.getPrecoVenda() * quantidade;
            System.out.println("Venda de " + nome + " realizada.");
            return true;
        } else {
            System.out.println("Estoque insuficiente de " + nome);
            return false;
        }
    }

    public double getSaldoCaixa() {
        return saldoCaixa;
    }

    public void mostrarEstoque() {
        for (Combustivel combustivel : combustiveis.values()) {
            System.out.println(combustivel.getNome() + ": " + combustivel.getEstoque() + " litros");
        }
    }

    public String getCombustivelMaisVendido() {
        Combustivel maisVendido = null;
        for (Combustivel combustivel : combustiveis.values()) {
            if (maisVendido == null || combustivel.getTotalVendas() > maisVendido.getTotalVendas()) {
                maisVendido = combustivel;
            }
        }
        return maisVendido != null ? maisVendido.getNome() : "Nenhum combustível vendido";
    }
}
