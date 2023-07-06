package com.example.transaction.repository;
import java.util.Optional;
import java.util.List;
import com.example.transaction.domain.Transaction;

public interface TransactionRepository {
    Transaction save(Transaction trans);
    int remove(Transaction trans);

    Optional<Transaction> findById(int sno);
    List<Transaction> findByType(int type);

    List<Transaction> findAll();
}
