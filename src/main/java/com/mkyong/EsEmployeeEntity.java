package com.mkyong;

import com.mkyong.error.validator.ChName;

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

//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsEmployeeEntity {

    @Id
    @GeneratedValue
    private Long empId;

    @NotEmpty(message = "Please provide a employee name")
    private String empName;

    @ChName
    @NotEmpty(message = "Employee Chinese Name is MANDATORY field")
    private String empChineseName;

    @NotNull(message = "Please provide a employee wallet balance")
    @DecimalMin("1.00")
    private BigDecimal empWalletBalance;

    @Override
    public String toString() {
        return String.format("Employee{" +
                "employeeId=" + empId +
                ", employeeName='" + empName + '\'' +
                ", employeeChineseName='" + empChineseName + '\'' +
                ", empWalletBalance=" + empWalletBalance +
                '}');
    }
    
}
