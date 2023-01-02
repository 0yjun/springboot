package com.camss.helloJpa;

import com.camss.helloJpa.domain.Member;
import com.camss.helloJpa.domain.Order;
import com.camss.helloJpa.domain.Team;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Log
public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setId(1);
            member.setPsw("1234");
            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }
}
