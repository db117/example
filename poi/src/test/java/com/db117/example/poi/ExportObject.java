package com.db117.example.poi;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author db117
 * @date 2019/12/24/024 16:30
 */
@Data
@Builder
public class ExportObject {
    private String string;
    private Integer integer;
    private Double aDouble;
    private BigDecimal decimal;
    private Boolean aBoolean;
    private LocalDate localDate;
    private LocalDateTime localDateTime;
    private Date date;
}
