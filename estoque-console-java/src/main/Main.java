package main;


import menutomain.MenuToMain;
import service.ProdutoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();
        Scanner in = new Scanner(System.in);
        int op;
        while (true) {
            MenuToMain.menu();
            op = in.nextInt();
            switch (op) {
                case 1 -> produtoService.listarProdutos();
                case 2 -> MenuToMain.entradaDeEstoque();
                case 3 -> MenuToMain.saidaDeEstoque();
                case 4 -> MenuToMain.adicionarProduto();
                default -> {
                    return;
                }
            }
        }
    }

}
