package service;

import database.model.ProdutoEntity;
import exception.EstoqueInsuficiente;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ProdutoService {
    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.ProdutoEntityBuilder.aProdutoEntity().id(1L).nome("Camiseta").preco(150.0).estoqueAtual(3).build());
        PRODUTOS.add(ProdutoEntity.ProdutoEntityBuilder.aProdutoEntity().id(2L).nome("Tênis").preco(555.0).estoqueAtual(7).build());
        PRODUTOS.add(ProdutoEntity.ProdutoEntityBuilder.aProdutoEntity().id(3L).nome("Calça").preco(190.0).estoqueAtual(8).build());
    }

    public void listarProdutos() {
        for (ProdutoEntity produtoEntity : PRODUTOS) {
            System.out.println("-------------------------");
            System.out.println("ID: " + produtoEntity.getId());
            System.out.println("Nome: " + produtoEntity.getNome());
            System.out.println("Preco: " + produtoEntity.getPreco());
            System.out.println("Estoque: " + produtoEntity.getEstoqueAtual());
            if (produtoEntity.getEstoqueAtual() < 5) {
                System.out.println("ESTOQUE BAIXO!!!!");
            }
            System.out.println("-------------------------");
        }
    }
    public void entradaDeEstoque(long id,int entrada) {
        for (ProdutoEntity Produto : PRODUTOS) {
            if (Produto.getId().equals(id)) {
                Produto.setEstoqueAtual(Produto.getEstoqueAtual() + entrada);
                System.out.println("Estoque atualizado com sucesso!");
            }
        }
    }
    public void saidaDeEstoque(long id,int saida) {
        for (ProdutoEntity Produto : PRODUTOS) {
            if (Produto.getId().equals(id)) {
                if (Produto.getEstoqueAtual() >= saida) {
                    Produto.setEstoqueAtual(Produto.getEstoqueAtual() - saida);
                    System.out.println("Estoque atualizado sucesso!");
                }else{
                    throw new EstoqueInsuficiente("Estoque não pode ficar negativo, tente novamente.");
                }
            }
        }
    }

    public List<ProdutoEntity> adicionarProduto(String nome,double preco,double estoque) {
        int max = PRODUTOS.stream().mapToInt(produtoEntity -> produtoEntity.getId().intValue()).max().orElse(0);
        ProdutoEntity novoProduto = ProdutoEntity.ProdutoEntityBuilder.aProdutoEntity()
                .id(max + 1L).nome(nome).preco(preco).estoqueAtual((int) estoque).build();
        PRODUTOS.add(novoProduto);
        return new ArrayList<>(PRODUTOS);
    }
}
