package com.example.Parser.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    @CsvBindByPosition(position = 0)
    private Integer orderId;

    @CsvBindByPosition(position = 1)
    private Float amount;

    @CsvBindByPosition(position = 2)
    private String currency;

    @CsvBindByPosition(position = 3)
    private String comment;

    private String filename;
    private Integer line;
    private String result;
}
