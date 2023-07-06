package com.example.transaction.repository;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import com.example.transaction.domain.Transaction;

public class JpaTransactionRepository implements TransactionRepository {
    private final EntityManager em;

    public JpaTransactionRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Transaction save(Transaction transaction){
        if(transaction.getSno()==0){
            em.persist(transaction);
        }else{
            em.merge(transaction);
        }        
        return null;
    }

    @Override
    public int remove(Transaction transaction){
        em.remove(transaction);
        return 1;
    }

    @Override
    public Optional<Transaction> findById(int sno){
        Transaction transaction = em.find(Transaction.class, sno);
        return Optional.ofNullable(transaction);
    }

    @Override
    public List<Transaction> findByType(int type){
        return em.createQuery("select t from transaction t where t.trans_type = '"+type+"'", Transaction.class).getResultList();
    }

    @Override
    public List<Transaction> findAll(){
        return em.createQuery("select t from transaction t", Transaction.class).getResultList();
    }
}
