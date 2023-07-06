package com.example.transaction.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.example.transaction.service.TransactionService;
import java.util.List;
import java.util.Optional;

import com.example.transaction.domain.Transaction;

@Controller
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("month-plan")
    public String get_month_plan(Model model){
        //List<Transaction> trans = transactionService.findAll();
        for(int i = 0; i<5;i++){
            List<Transaction> trans = transactionService.findByType(i);
            model.addAttribute("trans"+i, trans);
        }
        return "month_plan";
    }

    @GetMapping("month-plan-item/{sno}")
    @ResponseBody
    public Optional<Transaction> get_month_plan_item(@PathVariable Integer sno){
        Optional<Transaction> trans = transactionService.findById(sno);
        return trans;
    }

    @PostMapping("month-plan-item")
    @ResponseBody
    public void add_month_plan_item(@ModelAttribute Transaction trans) {
        transactionService.add_transaction(trans);
    }


    @PutMapping("month-plan-item/{sno}")
    @ResponseBody
    public void update_month_plan_item(@ModelAttribute Transaction trans, @PathVariable Integer sno) {
        transactionService.update_transaction(trans);
    }

    @DeleteMapping("month-plan-item/{sno}")
    @ResponseBody
    public void delete_month_plan_item(@PathVariable Integer sno) {
        Optional<Transaction> trans_op = transactionService.findById(sno);
        if(trans_op.isPresent()) {
	        Transaction trans = trans_op.get();
            transactionService.remove_transaction(trans);
        }
    }
}
