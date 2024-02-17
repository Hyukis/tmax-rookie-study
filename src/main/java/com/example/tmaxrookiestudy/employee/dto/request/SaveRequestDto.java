package com.example.tmaxrookiestudy.employee.dto.request;

import com.example.tmaxrookiestudy.employee.domain.Department;
import com.example.tmaxrookiestudy.employee.domain.WorkStatus;
import com.example.tmaxrookiestudy.employee.vo.EmployeeVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveRequestDto {

  @NotNull
  private String name;

  @NotNull
  private Department department;

  @NotNull
  private WorkStatus workStatus;

  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
  private LocalDate entryDate;

  public EmployeeVO toVO(String employeeNumber) {
    return EmployeeVO.builder()
        .name(this.name)
        .employeeNumber(employeeNumber)
        .welfarePoint(1000)
        .department(this.department)
        .workStatus(this.workStatus)
        .entryDate(this.entryDate)
        .build();
  }
}
