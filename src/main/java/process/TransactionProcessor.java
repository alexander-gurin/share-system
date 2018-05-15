package process;

import common.Status;
import entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransactionProcessor {

    public double getTransactionSum(Transaction t) {
        return t.getData().values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public boolean changeTransactionStatus(Transaction t, Status status){

        switch(status)
        {
            case OPEN:
                       t.setStatus(status);

                       return true;
            case CLOSE:
                       if(getTransactionSum(t) == 0){
                            t.setStatus(status);
                            return true;
                       }

                       return false;
            case BAD:
                       t.setStatus(status);

                       return true;
        }

        return false;
    }

    public Transaction createTransaction (Long id, Map<Long, Double> data){
        Transaction t = new Transaction();
        t.setId(id);
        t.setData(data);
        changeTransactionStatus(t, Status.OPEN);

        return t;
    }

    public Transaction modifyTransactionData(Transaction t, Map<Long, Double> data){
        Map<Long, Double> res = Stream.of(t.getData(), data).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::max));
        t.setData(res);

        return t;
    }

}
