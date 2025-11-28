package impostos.tipos;

import impostos.interfase.Imposto;

public class ImpostoPis implements Imposto {
    private String descricao;
    private double debito;
    private double credito;

    public ImpostoPis(String descricao, double debito, double credito) {
        this.descricao = descricao;
        this.debito = debito;
        this.credito = credito;
    }
    
    @Override
    public double calcular() {
        return (debito - credito) * 1.65 / 100;
    }

    @Override
    public String getDescricao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescricao'");
    }

}
