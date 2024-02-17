package com.example.tmaxrookiestudy.employee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkStatus {

  WORK("현직"),
  REST("휴직"),
  RETIRE("퇴직");

  private final String status;
}
