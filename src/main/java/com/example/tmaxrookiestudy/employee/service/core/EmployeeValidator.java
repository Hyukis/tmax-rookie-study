package com.example.tmaxrookiestudy.employee.service.core;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

  public boolean validateEntryDate(LocalDate entryDate){
    return !LocalDate.now().isBefore(entryDate);
  }
}
