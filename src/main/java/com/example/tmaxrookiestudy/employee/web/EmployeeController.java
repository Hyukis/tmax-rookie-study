package com.example.tmaxrookiestudy.employee.web;

import com.example.tmaxrookiestudy.employee.dto.request.SaveRequestDto;
import com.example.tmaxrookiestudy.employee.service.EmployeeServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tmax/api/v1/employee")
public class EmployeeController {

  private final EmployeeServiceFacade employeeServiceFacade;
  @PostMapping("/save")
  public ResponseEntity<?> saveNewEmployee(@RequestBody SaveRequestDto dto) {

    employeeServiceFacade.save(dto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
