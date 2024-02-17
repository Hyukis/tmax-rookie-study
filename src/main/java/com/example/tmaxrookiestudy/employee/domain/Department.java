package com.example.tmaxrookiestudy.employee.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum Department {

  PS(1),
  QA(2),
  RD(3),
  CS(4);

  private final int depNo;

  public static Department find(int deptNo) {
    return Arrays.stream(values())
        .filter(i->deptNo == i.getDepNo())
        .findAny()
        .orElseThrow(NoSuchElementException::new);
  }
}
