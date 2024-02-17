package com.example.tmaxrookiestudy.global.config;

import com.example.tmaxrookiestudy.employee.domain.typeHandler.DepartmentHandler;
import com.example.tmaxrookiestudy.employee.domain.typeHandler.WorkStatusHandler;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.example.tmaxrookiestudy", sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

  @Value("${spring.datasource.mybatis.mapper-locations}")
  String mapperPath;

  @Bean(name = "dataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource
      , ApplicationContext applicationContext) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    // xml 파일에 쿼리문을 매핑할 때 사용한다.
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperPath));

    // Enum Class Type Handler
    sqlSessionFactoryBean.addTypeHandlers(new TypeHandler[] { new DepartmentHandler(), new WorkStatusHandler()});
    return sqlSessionFactoryBean.getObject();
  }

  @Bean(name = "sqlSessionTemplate")
  public SqlSessionTemplate sqlSessionTemplate(
      @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
