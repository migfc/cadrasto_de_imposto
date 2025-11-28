package impostos.tipos;

import impostos.interfase.Imposto;

public class ImpostoPis implements Imposto {
    private String descricao;
    private double debito;
    private double credito;
    
    @Override
    public double calcular() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcular'");
    }

    @Override
    public String getDescricao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescricao'");
    }

}
