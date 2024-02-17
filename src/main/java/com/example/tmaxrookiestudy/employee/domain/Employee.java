package com.example.tmaxrookiestudy.employee.domain;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  private Long id;
  private String name;
  private String employeeNumber;
  private Department department;
  private int welfarePoint;
  private WorkStatus workStatus;
  private LocalDate entryDate;
}
