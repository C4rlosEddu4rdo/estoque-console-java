package menutomain;

import service.ProdutoService;

import java.util.Scanner;

public class MenuToMain {
    private static final ProdutoService  produtoService = new ProdutoService();
    private static final Scanner in = new Scanner(System.in);
    public static void menu(){
        System.out.println("*__Loja De Roupas__*");
        System.out.println("1_Mostrar Produtos");
        System.out.println("2_Entrada de estoque");
        System.out.println("3_Saida de Produto");
        System.out.println("4_Adicionar Produto");
        System.out.println("0_Sair");
    }
    public static void entradaDeEstoque(){
        System.out.println("Digite o ID do Produto que deseja adicionar estoque: ");
        long id =  in.nextLong();
        System.out.println("Digite a quantidade de entrada de estoque: ");
        int entrada = in.nextInt();
        produtoService.entradaDeEstoque(id,entrada);
    }
    public static void saidaDeEstoque(){
        System.out.println("Digite o ID do Produto que deseja remover estoque: ");
        long id =  in.nextLong();
        System.out.println("Digite a quantidade de saida de estoque: ");
        int saida = in.nextInt();
        produtoService.saidaDeEstoque(id,saida);
    }
    public static void adicionarProduto(){
        System.out.println("Digite o nome do seu novo produto: ");
        String nome = in.nextLine();
        System.out.println("Digite o preço do seu produto: ");
        double preco =  in.nextDouble();
        System.out.println("Digite a quantidade de estoque: ");
        int estoque = in.nextInt();
        produtoService.adicionarProduto(nome,preco,estoque);
    }
}
