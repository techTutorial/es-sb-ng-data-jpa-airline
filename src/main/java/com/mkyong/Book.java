package com.mkyong;

import com.mkyong.error.validator.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long employeeId;

    @NotEmpty(message = "Please provide a employee name")
    private String employeeName;

    @Author
    @NotEmpty(message = "Please provide a employee chinese name")
    private String employeeChineseName;

    @NotNull(message = "Please provide a employee wallet balance")
    @DecimalMin("1.00")
    private BigDecimal empWalletBalance;

    @Override
    public String toString() {
        return String.format("Book{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeChineseName='" + employeeChineseName + '\'' +
                ", empWalletBalance=" + empWalletBalance +
                '}');
    }
    
}
