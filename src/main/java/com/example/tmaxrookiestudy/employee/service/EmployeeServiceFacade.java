package com.example.tmaxrookiestudy.employee.service;

import com.example.tmaxrookiestudy.employee.dto.request.SaveRequestDto;
import com.example.tmaxrookiestudy.employee.service.core.EmployeeService;
import com.example.tmaxrookiestudy.employee.service.core.EmployeeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeServiceFacade {

  private final EmployeeService employeeService;
  private final EmployeeValidator employeeValidator;
  public void save(SaveRequestDto dto) {

    if(employeeValidator.validateEntryDate(dto.getEntryDate())) {
      throw new IllegalArgumentException();
    }
    employeeService.save(dto);
  }
}
