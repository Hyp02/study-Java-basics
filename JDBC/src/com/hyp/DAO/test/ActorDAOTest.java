package com.hyp.DAO.test;

import com.hyp.DAO.dao.ActorDAO;
import com.hyp.DAO.domain.Actor;

import java.util.List;

public class ActorDAOTest {
    public static void main(String[] args) {
        ActorDAO actorDAO = new ActorDAO();
        String sql ="select *from " +
                "actor where id =?";
        List<Actor> results = actorDAO.Results(sql, Actor.class);
        System.out.println(results);
    }
}
