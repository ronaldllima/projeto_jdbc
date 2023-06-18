package com.projectjdbc;

import java.util.List;

import org.junit.Test;

import com.projectjdbc.dao.UserPosDao;
import com.projectjdbc.model.UserPosJava;

public class TestebancoJdbc {
    
    @Test
    public void initbanco(){
        UserPosDao userPosDao = new UserPosDao();
        UserPosJava userPosJava = new UserPosJava();

        userPosJava.setId(5L);
        userPosJava.setNome("maria");
        userPosJava.setEmail("maria@gmail.com");

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
}
