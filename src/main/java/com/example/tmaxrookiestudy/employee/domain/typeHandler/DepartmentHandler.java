package com.example.tmaxrookiestudy.employee.domain.typeHandler;

import com.example.tmaxrookiestudy.employee.domain.Department;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(Department.class)
public class DepartmentHandler implements TypeHandler<Department> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Department parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setInt(i, parameter.getDepNo());
  }

  @Override
  public Department getResult(ResultSet rs, String columnName) throws SQLException {
    return null;
  }

  @Override
  public Department getResult(ResultSet rs, int columnIndex) throws SQLException {
    return null;
  }

  @Override
  public Department getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}
