import pagamentos.Pagamentos;

public class App {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.print("Digite o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);
        scanner.close();
    }
}