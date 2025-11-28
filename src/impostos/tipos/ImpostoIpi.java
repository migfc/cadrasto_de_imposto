package impostos.tipos;

import impostos.interfase.Imposto;

public class ImpostoIpi implements Imposto {
    private String descricao;
    private double produto;
    private double frete;
    private double seguro;
    private double outrasDespesas;
    private double aliquota;
    public ImpostoIpi(String descricao, double produto, double frete, double seguro, double outrasDespesas, double aliquota) {
        this.descricao = descricao;
        this.produto = produto;
        this.frete = frete;
        this.seguro = seguro;
        this.outrasDespesas = outrasDespesas;
        this.aliquota = aliquota;
    }
    @Override
    public double calcular() {
        double baseCalculo = produto + frete + seguro + outrasDespesas;
        return baseCalculo * (aliquota / 100);
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

}
