package com.mycompany.projetofome6;

public class Usuario {
    private int id;         // ➕ Adicionado o ID do usuário
    private String login;
    private String senha;

    // 🔥 Construtor completo
    public Usuario(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    // ✅ Construtor para login (sem ID, usado antes de saber se existe)
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    // 🔧 Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}