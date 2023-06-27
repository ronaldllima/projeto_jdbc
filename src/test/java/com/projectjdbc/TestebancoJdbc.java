package com.projectjdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.projectjdbc.dao.UserPosDao;
import com.projectjdbc.model.BeanUserFone;
import com.projectjdbc.model.Telefone;
import com.projectjdbc.model.UserPosJava;

public class TestebancoJdbc {

    @Test
    public void initInserir() {
        UserPosDao userPosDao = new UserPosDao();
        UserPosJava userPosJava = new UserPosJava();

        userPosJava.setNome("mara");
        userPosJava.setEmail("mara@gmail.com");

        userPosDao.salvar(userPosJava);
    }

    @Test
    public void initListar() {
        UserPosDao dao = new UserPosDao();
        try {
            List<UserPosJava> list = dao.listar();
            for (UserPosJava userPosJava : list) {
                System.out.println(userPosJava);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initBuscar() {
        UserPosDao dao = new UserPosDao();

        try {
            UserPosJava posJava = dao.buscar(5L);
            System.out.println(posJava);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void initAtualizar() {
        try {
            UserPosDao dao = new UserPosDao();
            UserPosJava objeto = dao.buscar(5L);

            objeto.setNome("nome mudado com metodo");

            dao.atualizar(objeto);

        } catch (Exception e) { 
            e.printStackTrace();
        }

    }

    @Test
    public void initDeletar() {
        try {
            UserPosDao dao = new UserPosDao();

            dao.deletar(5L);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testeInsertTelefone() {

        UserPosDao dao = new UserPosDao();
        Telefone telefone = new Telefone();
        telefone.setNumero("75 93658-3658");
        telefone.setTipo("CELULAR");
        telefone.setUsuario(7L);

        dao.salvarTelefone(telefone);
    }

    @Test
    public void testeCarregaFoneUser(){
        UserPosDao dao = new UserPosDao();

        List<BeanUserFone> beanUserFones = new ArrayList<>();

        beanUserFones = dao.listaUserFone();

        beanUserFones.forEach(x -> System.out.println(x));
    }

    @Test
    public void testeDeletePorId() {
        UserPosDao dao = new UserPosDao();

        dao.deleteFoneByUser(2L);
    }
}
