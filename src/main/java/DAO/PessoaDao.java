package DAO;

import JDBC.ConnectionSingleton;
import Model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDao {
    private Connection con;
    public PessoaDao(){
        this.con = ConnectionSingleton.getInstance().getConnection();
    }

    public boolean create(Pessoa p){
        String sql = "INSERT INTO pessoa(nome,email,senha) VALUES(?,?,?);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getEmail());
            stmt.setString(3, p.getSenha());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE,null,e);
            return false;
        }

    }

    public boolean update(Pessoa p){
        String sql = "UPDATE pessoa SET nome = ?, email = ?, senha = ?  WHERE id=?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1,p.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE,null,e);
            return false;
        }

    }

    public boolean delete(Pessoa p){
        String sql = "DELETE  FROM pessoa WHERE id=?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1,p.getId());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE,null,e);
            return false;
        }

    }



    public List<Pessoa> getList(){
        // Cria lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();
        // sql para buscar os dados no banco de dados
        String sql = "SELECT * FROM pessoa";
        try {
            // prepara e já executa.
            PreparedStatement stmt = con.prepareStatement(sql); // estabelece conexão com banco de dados.
            ResultSet st = stmt.executeQuery(); // usado para trazer dados

            while(st.next()){
                Pessoa p = new Pessoa();

                // Nomes das colunas
                p.setId(st.getLong("id"));// String nome da coluna no banco.
                p.setNome(st.getString("nome"));// string nome da coluna no banco
                p.setEmail(st.getString("email"));
                p.setSenha(st.getString("senha"));
                pessoas.add(p); // adiciona na lista pessoas   List<Pessoa> pessoas = new ArrayList<>();
            }

            stmt.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao retornar lista no banco de dados.");
            return null;
        }

        return  pessoas;
    }




}
