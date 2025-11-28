package pagamentos;

import java.util.ArrayList;
import java.util.List;

import impostos.interfase.Imposto;

public class Pagamentos {
    String nomeEmpresa;
    ArrayList<Imposto> impostos = new ArrayList<>();

    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

}
