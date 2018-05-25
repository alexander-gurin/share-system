package entity;

import common.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@RequiredArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    Long prevId;

    Status status;

    Date dateOpen;

    Date statusDate;

    Map<Long, Double> data;
}
