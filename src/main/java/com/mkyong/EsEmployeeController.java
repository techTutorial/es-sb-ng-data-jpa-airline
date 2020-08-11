package com.mkyong;

import com.mkyong.error.ResourceNotFoundException;
import com.mkyong.error.ResourceUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class EsEmployeeController {

    @Autowired
    private EsEmployeeRepository repository;

    
    @GetMapping("/employees")
    List<EsEmployeeEntity> findAll() {
        return repository.findAll();
    }

    
    @PostMapping("/employee")
    EsEmployeeEntity newEmployee(@Valid @RequestBody EsEmployeeEntity newEmployee) {
        return repository.save(newEmployee);
    }

    
    @GetMapping("/employee/{id}") // eId
    EsEmployeeEntity findOne(@PathVariable @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    
    @PutMapping("/employee/{id}")
    EsEmployeeEntity saveOrUpdate(@RequestBody EsEmployeeEntity newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setEmpName(newEmployee.getEmpName());
                    x.setEmpChineseName(newEmployee.getEmpChineseName());
                    x.setEmpWalletBalance(newEmployee.getEmpWalletBalance());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newEmployee.setEmpId(id);
                    return repository.save(newEmployee);
                });
    }

    // update only employee Chinese name
    @PatchMapping("/employee/{id}")
    EsEmployeeEntity patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String chName = update.get("employeeChineseName");
                    if (!StringUtils.isEmpty(chName)) {
                        x.setEmpChineseName(chName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new ResourceUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new ResourceNotFoundException(id);
                });

    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
