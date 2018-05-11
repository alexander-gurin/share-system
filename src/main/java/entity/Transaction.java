package entity;

import common.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public class Transaction {

    Long id;

    Long prevId;

    Status status;

    Map<Long, Double> data;

}
