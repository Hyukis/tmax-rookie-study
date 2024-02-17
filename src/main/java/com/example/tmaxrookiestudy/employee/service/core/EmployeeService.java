package com.example.tmaxrookiestudy.employee.service.core;

import com.example.tmaxrookiestudy.employee.domain.Department;
import com.example.tmaxrookiestudy.employee.dto.request.SaveRequestDto;
import com.example.tmaxrookiestudy.employee.repository.mapper.EmployeeMapper;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeMapper employeeMapper;

  public void save(SaveRequestDto dto) {

    String employeeNumber = makeEmployeeNumber(dto.getDepartment());
    employeeMapper.save(dto.toVO(employeeNumber));
    System.out.println(employeeNumber);
  }

  public String makeEmployeeNumber(Department dept) {
    int curYear = LocalDate.now().getYear();
    // 올해 신규 입사자 수
    int cntCurYearHires = employeeMapper.countByDepartmentAndEntryYear(dept, curYear);
    return String.format("%d%d%02d", curYear, dept.getDepNo(), cntCurYearHires);
  }
}
