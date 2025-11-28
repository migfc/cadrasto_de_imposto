import impostos.tipos.ImpostoIpi;
import pagamentos.Pagamentos;

public class App {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.print("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        var pagamentos = new Pagamentos(nomeEmpresa);
        boolean condition = true;
        do {
            System.out.println("Menu de Impostos");
            System.out.println("1. Adicionar Imposto IPI");
            System.out.println("2. adicionar Imposto PIS");
            System.out.println("3. listar Impostos");
            System.out.println("0. sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    condition = false;
                    break;
            }
        } while (condition);
        System.out.println("Encerando a aplicação");
        scanner.close();
    }
}
