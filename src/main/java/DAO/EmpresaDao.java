package DAO;

import JDBC.ConnectionSingleton;
import Model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaDao {
    private Connection con;

    public EmpresaDao() {
        this.con = ConnectionSingleton.getInstance().getConnection();
    }

    public boolean create(Empresa e) {
        String sql = "INSERT INTO empresa(nome, cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getCnpj());
            stmt.setString(3, e.getEndereco());
            stmt.setString(4, e.getCidade());
            stmt.setString(5, e.getEstado());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Empresa empresa) {
        String sql = "UPDATE empresa SET nome = ?, cnpj = ? WHERE id = ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setLong(3, empresa.getId());
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean delete(Empresa empresa) {
        String sql = "DELETE FROM empresa WHERE id = ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, empresa.getId());
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public List<Empresa> getList() {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet st = stmt.executeQuery();

            while (st.next()) {
                Empresa p = new Empresa();
                p.setId(st.getLong("id"));
                p.setNome(st.getString("nome"));
                p.setCnpj(st.getString("cnpj"));
                p.setEndereco(st.getString("endereco"));
                p.setCidade(st.getString("cidade"));
                p.setEstado(st.getString("estado"));
                empresas.add(p);
            }

            stmt.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(EmpresaDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

        return empresas;
    }
}