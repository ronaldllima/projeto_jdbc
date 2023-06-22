package com.projectjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectjdbc.conexaojdbc.SingleConnection;
import com.projectjdbc.model.Telefone;
import com.projectjdbc.model.UserPosJava;

public class UserPosDao {

    private Connection connection;

    public UserPosDao() {
        connection = SingleConnection.getConnection();
    }

    public void salvar(UserPosJava userPosJava) {

        try {
            String sql = "insert into userposjava(nome, email) values (?, ?)";

            PreparedStatement insert = connection.prepareStatement(sql);

            insert.setString(1, userPosJava.getNome());
            insert.setString(2, userPosJava.getEmail());
            insert.execute();
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void salvarTelefone(Telefone telefone) {

        try {
            String sql = "insert into telefoneuser(numero, tipo, id_userposjava) values (?, ?, ?)";

            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, telefone.getNumero());
            insert.setString(2, telefone.getTipo());
            insert.setLong(3, telefone.getUsuario());

            insert.execute();
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }
    }

    public List<UserPosJava> listar() {
        List<UserPosJava> list = new ArrayList<UserPosJava>();
        String sql = "select * from userposjava;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            var resultado = statement.executeQuery();
            while (resultado.next()) {
                UserPosJava userPosJava = new UserPosJava();
                userPosJava.setId(resultado.getLong("id"));
                userPosJava.setNome(resultado.getString("nome"));
                userPosJava.setEmail(resultado.getString("email"));

                list.add(userPosJava);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public UserPosJava buscar(long id) {
        UserPosJava retorno = new UserPosJava();
        String sql = "select * from userposjava where id = " + id;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {

                retorno.setId(resultado.getLong("id"));
                retorno.setNome(resultado.getString("nome"));
                retorno.setEmail(resultado.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void atualizar(UserPosJava userPosJava) {

        try {
            String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();
            PreparedStatement atualizar = connection.prepareStatement(sql);
            atualizar.setString(1, userPosJava.getNome());

            atualizar.execute();
            connection.commit();

        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public void deletar(Long id) {
        try {
            String sql = "delete from userposjava where id = " + id;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
