package com.example.transaction.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.transaction.domain.Transaction;
import com.example.transaction.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
    private TransactionRepository transRepo;

    public TransactionService(TransactionRepository transRepo){
        this.transRepo = transRepo;
    }

    public int add_transaction(Transaction trans){
        transRepo.save(trans);
        return trans.getSno();
    }

    public int update_transaction(Transaction trans){
        transRepo.save(trans);
        return trans.getSno();
    }

    public int remove_transaction(Transaction trans){
        return transRepo.remove(trans);
    }

    public List<Transaction> findAll(){
        return transRepo.findAll();
    }

    public Optional<Transaction> findById(int sno){
        return transRepo.findById(sno);
    }

    public List<Transaction> findByType(int type){
        return transRepo.findByType(type);
    }
}
