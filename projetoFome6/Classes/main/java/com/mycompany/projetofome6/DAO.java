package com.mycompany.projetofome6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
      
public class DAO {

    // ✅ Verifica se o usuário existe no banco
    public boolean existe(Usuario usuario) {
        String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Erro na verificação do usuário: " + e.getMessage());
            return false;
        }
    }

    // 🔑 Retorna o ID do usuário a partir do login e senha
    public Integer getUsuarioId(Usuario usuario) {
        String sql = "SELECT id FROM tb_usuario WHERE usuario = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao obter o ID do usuário: " + e.getMessage());
            return null;
        }
    }

    // ✔️ Método para inserir produto
    public void inserir(Produto produto) throws Exception {
        String sql = "INSERT INTO tb_produto (nome, quantidade, preco) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPreco());
            

            ps.executeUpdate();
            System.out.println("✅ Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir produto: " + e.getMessage());
            throw e;
        }
    }

    // ✔️ Método para atualizar produto
    public void atualizar(Produto produto) throws Exception {
    String sql = "UPDATE tb_produto SET nome = ?, quantidade = ?, preco = ? WHERE id = ?";
    try (Connection conn = ConexaoBD.obtemConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, produto.getNome());
        ps.setDouble(2, produto.getQuantidade());
        ps.setDouble(3, produto.getPreco());
        ps.setInt(4, produto.getId());

        ps.executeUpdate();
        System.out.println("Produto atualizado com sucesso!");
    }
}


    // ✔️ Método para excluir produto
    public void excluir(Produto produto) throws Exception {
        String sql = "DELETE FROM tb_produto WHERE id = ?";
        try (Connection conn = ConexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, produto.getId());
            ps.executeUpdate();
            System.out.println("Produto excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
            throw e;
        }
    }
}