package com.example.transaction;
import javax.sql.DataSource;
import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.transaction.repository.TransactionRepository;
import com.example.transaction.repository.JpaTransactionRepository;
//import accountbook.demo.repository.MemoryTransactionRepository;
import com.example.transaction.service.TransactionService;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }
    
    @Bean
    public TransactionService transactionService(){
        return new TransactionService(transactionRepository());
    }

    @Bean
    public TransactionRepository transactionRepository(){
        //return new MemoryTransactionRepository();
        //return new JdbcTransactionRepository(dataSource);
        return new JpaTransactionRepository(em);
    }
}
