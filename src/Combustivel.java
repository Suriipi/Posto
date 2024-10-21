public class Combustivel {
    private String nome;
    private double precoCompra;
    private double precoVenda;
    private double estoque;
    private int totalVendas;

    public Combustivel(String nome, double precoCompra, double precoVenda, double estoque) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.totalVendas = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public double getEstoque() {
        return estoque;
    }

    public void comprar(double quantidade, double valor) {
        if (valor >= precoCompra * quantidade) {
            estoque += quantidade;
        }
    }

    public boolean vender(double quantidade) {
        if (estoque >= quantidade) {
            estoque -= quantidade;
            totalVendas += quantidade;
            return true;
        }
        return false;
    }

    public int getTotalVendas() {
        return totalVendas;
    }
}
