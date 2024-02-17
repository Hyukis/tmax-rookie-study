package com.example.tmaxrookiestudy.employee.repository.mapper;

import com.example.tmaxrookiestudy.employee.domain.Department;
import com.example.tmaxrookiestudy.employee.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

  void save(EmployeeVO employeeVO);

  @Select("SELECT COUNT(*) FROM employee WHERE department = #{department} AND YEAR(entry_date) = #{curYear}")
  int countByDepartmentAndEntryYear(Department department, int curYear);
}
