package database.model;


public class ProdutoEntity {
    private Long id;
    private String nome;
    private Double preco;
    private Integer estoqueAtual;

    public ProdutoEntity(Long id, String nome, Double preco, Integer estoqueAtual) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(Integer estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public static final class ProdutoEntityBuilder {
        private Long id;
        private String nome;
        private Double preco;
        private Integer estoqueAtual;

        private ProdutoEntityBuilder() {
        }

        public static ProdutoEntityBuilder aProdutoEntity() {
            return new ProdutoEntityBuilder();
        }

        public ProdutoEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProdutoEntityBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ProdutoEntityBuilder preco(Double preco) {
            this.preco = preco;
            return this;
        }

        public ProdutoEntityBuilder estoqueAtual(Integer estoqueAtual) {
            this.estoqueAtual = estoqueAtual;
            return this;
        }

        public ProdutoEntity build() {
            return new ProdutoEntity(id, nome, preco, estoqueAtual);
        }
    }
}