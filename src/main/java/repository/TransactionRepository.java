package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import entity.Transaction;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Transaction t SET t.data = :data WHERE c.id = :id")
    Long updateTransactionData(@Param("id") Long id, @Param("data") Map<Long, Double> data);
}
