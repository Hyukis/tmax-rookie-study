package com.example.tmaxrookiestudy.employee.domain.typeHandler;

import com.example.tmaxrookiestudy.employee.domain.WorkStatus;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(WorkStatus.class)
public class WorkStatusHandler implements TypeHandler<WorkStatus> {

  @Override
  public void setParameter(PreparedStatement ps, int i, WorkStatus parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setString(i, parameter.getStatus());
  }

  @Override
  public WorkStatus getResult(ResultSet rs, String columnName) throws SQLException {
    return null;
  }

  @Override
  public WorkStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
    return null;
  }

  @Override
  public WorkStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}
