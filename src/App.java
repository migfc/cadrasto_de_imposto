import java.util.Scanner;

import impostos.tipos.ImpostoIpi;
import impostos.tipos.ImpostoPis;
import pagamentos.Pagamentos;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        var pagamentos = new Pagamentos(nomeEmpresa);

        System.out.println("\n=== Cadastro de Impostos ===");
        System.out.println("Digite 'pare' para encerrar o cadastro de impostos.\n");

        String continuar = "";
        while (!continuar.equals("pare")) {
            System.out.println("Menu de Impostos");
            System.out.println("1. Adicionar Imposto IPI");
            System.out.println("2. Adicionar Imposto PIS");
            System.out.print("Escolha uma opcao (ou digite 'pare' para encerrar): ");
            String entrada = scanner.nextLine();

            if (entrada.equals("pare")) {
                continuar = "pare";
                System.out.println("\nEmpresa: " + pagamentos.getNomeEmpresa());
                System.out.println("\n=== Impostos Calculados ===");
                if (!pagamentos.getImpostos().isEmpty()) {
                    double totalGeral = 0;
                    for (var imposto : pagamentos.getImpostos()) {
                        double valor = imposto.calcular();
                        System.out.println("-------------------------------");
                        System.out.println("Descricao: " + imposto.getDescricao());
                        System.out.println("Valor do imposto: R$ " + valor);
                        totalGeral += valor;
                    }
                    System.out.println("-------------------------------");
                    System.out.println("Total de impostos: R$ " + totalGeral);
                } else {
                    System.out.println("Nenhum imposto foi cadastrado.");
            }
                break;
            }

            int opcao = Integer.parseInt(entrada);
            String descricao;

            switch (opcao) {
                case 1:
                    System.out.println("\nAdicionar Imposto IPI");
                    System.out.print("Digite a descricao do imposto: ");
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
                    scanner.nextLine(); // Consumir quebra de linha
                    pagamentos.adicionarImposto(new ImpostoIpi(descricao, produto, frete, seguro, outrasDespesas, aliquota));
                    System.out.println("Imposto IPI adicionado com sucesso!\n");
                    break;
                case 2:
                    System.out.println("\nAdicionar Imposto PIS");
                    System.out.print("Digite a descricao do imposto: ");
                    descricao = scanner.nextLine();
                    System.out.print("Digite o valor do debito: ");
                    double debito = scanner.nextDouble();
                    System.out.print("Digite o valor do credito: ");
                    double credito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir quebra de linha
                    pagamentos.adicionarImposto(new ImpostoPis(descricao, debito, credito));
                    System.out.println("Imposto PIS adicionado com sucesso!\n");
                    break;
                default:
                    System.out.println("Opcao invalida!\n");
                    break;
            }
        }
        System.out.println("Encerrando a aplicacao");
        scanner.close();
    }
}
