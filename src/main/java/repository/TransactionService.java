package repository;

import entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public Transaction addTrunsaction(Transaction t) {
        return repo.save(t);
    }

    public Long updateTransactionData(Long tId, Map<Long, Double> data) {
        return repo.updateTransactionData(tId, data);
    }
}
