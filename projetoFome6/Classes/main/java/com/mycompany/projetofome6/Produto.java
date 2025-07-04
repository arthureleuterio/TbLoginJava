package com.mycompany.projetofome6;

public class Produto {
    private int id;
    private String nome;
    private double quantidade;
    private double preco;

    // 🔥 Construtor completo
    public Produto(int id, String nome, double quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // 🟢 Construtor sem ID (para inserir)
    public Produto(String nome, double quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // ✅ Construtor só com ID (para excluir ou buscar por ID)
    public Produto(int id) {
        this.id = id;
    }

    // 🔧 Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}