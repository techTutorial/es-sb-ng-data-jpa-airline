package com.mkyong;

import com.mkyong.error.BookNotFoundException;
import com.mkyong.error.BookUnSupportedFieldPatchException;
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
public class BookController {

    @Autowired
    private BookRepository repository;

    
    @GetMapping("/books")
    List<Book> findAll() {
        return repository.findAll();
    }

    
    @PostMapping("/books")
    Book newBook(@Valid @RequestBody Book newBook) {
        return repository.save(newBook);
    }

    
    @GetMapping("/books/{id}") // eId
    Book findOne(@PathVariable @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    
    @PutMapping("/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setEmployeeName(newBook.getEmployeeName());
                    x.setEmployeeChineseName(newBook.getEmployeeChineseName());
                    x.setEmpWalletBalance(newBook.getEmpWalletBalance());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setEmployeeId(id);
                    return repository.save(newBook);
                });
    }

    // update only employee Chinese name
    @PatchMapping("/books/{id}")
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String chName = update.get("employeeChineseName");
                    if (!StringUtils.isEmpty(chName)) {
                        x.setEmployeeChineseName(chName);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });

    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
