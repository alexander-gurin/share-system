package process;

import common.Status;
import entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Processor {
    public boolean checkTransaction(Transaction t) {
        Double sum = t.getData().values().stream().mapToDouble(Double::doubleValue).sum();

        return sum == 0;
    }

    public Transaction createTransaction (Long id, Map<Long, Double> data){
        Transaction t = new Transaction();
        t.setId(id);
        t.setData(data);
        t.setStatus(Status.open);

        return t;
    }

    public boolean changeTransactionStatus(Transaction t, Status status){
        t.setStatus(status);
        return true;
    }
}
