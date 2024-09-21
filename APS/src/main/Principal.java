package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List<NotasFiscaisEmitidas> notasFiscais = new ArrayList<>();

        int opcao;

        do {
            System.out.println("┌──────────────────────────────────────────┐");
            System.out.println("│-----------Cadastro Notas---------------- │");
            System.out.println("├──────────────────────────────────────────┤");
            System.out.println("│                                          │");
            System.out.println("│1- Cadastrar nota                         │");
            System.out.println("│2- Calcular imposto                       │");
            System.out.println("│0- Sair do sistema                        │");
            System.out.println("│                                          │");
            System.out.println("└──────────────────────────────────────────┘");
            System.out.print("Escolha uma das opções: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1: {
                    System.out.print("Razao Social: ");
                    String razaoSocial = sc.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();
                    System.out.print("Regime Tributario (Simples Nacional / Lucro Presumido): ");
                    String regimeTributario = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();
                    System.out.print("Numero da Nota fiscal: ");
                    String numeroNota = sc.nextLine();
                    System.out.print("Data de emissao (dd/MM/yyyy): ");
                    String dataEmissaoStr = sc.nextLine();
                    System.out.print("Serviço: ");
                    String servico = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine(); 

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataEmissao = format.parse(dataEmissaoStr);

                    NotasFiscaisEmitidas novaEmissao = new NotasFiscaisEmitidas(
                            razaoSocial, cnpj, regimeTributario, email, numeroNota, dataEmissao, servico, valor);
                    notasFiscais.add(novaEmissao);
                    System.out.println("Nota fiscal cadastrada com sucesso!");
                }
                break;

                case 2: {
                    System.out.println("Notas fiscais cadastradas:");
                    if (notasFiscais.isEmpty()) {
                        System.out.println("Nenhuma nota fiscal cadastrada.");
                    } else {
                        for (NotasFiscaisEmitidas nota : notasFiscais) {
                            System.out.println(nota);
                          System.out.println(nota.calcularImposto(nota));
                        }
                    }
                }
                break;

                case 0:
                    System.out.println("Saindo !");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
