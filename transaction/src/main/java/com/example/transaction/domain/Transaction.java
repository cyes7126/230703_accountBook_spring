package com.example.transaction.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;


    private String trans_type;
    private int trans_date;
    private int amt;
    private String title;
    private String memo;
    private String reg_date;
}
