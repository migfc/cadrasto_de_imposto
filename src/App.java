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
            String descricao;
            System.out.println("Menu de Impostos");
            System.out.println("1. Adicionar Imposto IPI");
            System.out.println("2. adicionar Imposto PIS");
            System.out.println("3. listar Impostos");
            System.out.println("0. sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\nAdicionar Imposto IPI");
                    System.out.print("Digite a descricao do imposto: ");
                    scanner.nextLine();
                    descricao = scanner.nextLine();
                    System.out.print("Digite o valor do produto: ");
                    double produto = scanner.nextDouble();
                    System.out.print("Digite o valor do frete: ");
                    double frete = scanner.nextDouble();
                    System.out.print("Digite o valor do seguro: ");
                    double seguro = scanner.nextDouble();
                    System.out.print("Digite o valor de outras despesas: ");
                    double outrasDespesas = scanner.nextDouble();
                    System.out.print("Digite a aliquota do imposto (%): ");
                    double aliquota = scanner.nextDouble();
                    pagamentos.adicionarImposto(new ImpostoIpi(descricao, produto, frete, seguro, outrasDespesas, aliquota));
                    System.out.print("Imposto IPI adicionado com sucesso!\n");
                    break;
                case 2:
                    System.out.println("\nAdicionar Imposto PIS");
                    scanner.nextLine();
                    System.out.print("digite a descricao do imposto: ");
                    descricao = scanner.nextLine();
                    System.out.print("digite o valor do debito: ");
                    double debito = scanner.nextDouble();
                    System.out.print("digite o valor do credito: ");
                    double credito = scanner.nextDouble();
                    pagamentos.adicionarImposto(new impostos.tipos.ImpostoPis(descricao, debito, credito));
                    break;
                case 3:
                    System.out.print("\nLista de Impostos\n");
                    for (var imposto : pagamentos.getImpostos()) {
                        System.out.println("Descricao: " + imposto.getDescricao());
                        System.out.println("Valor do imposto: " + imposto.calcular() + "\n");
                    }
                    break;
                default:
                    System.out.println("resposta invalida");
                    break;
                case 0:
                    condition = false;
                    break;
            }
        } while (condition);
        System.out.println("Encerando a aplicação");
        scanner.close();
    }
}
