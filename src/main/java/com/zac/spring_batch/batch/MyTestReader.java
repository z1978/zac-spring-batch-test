package com.zac.spring_batch.batch;


import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zac.spring_batch.entity.people;

@Component
public class MyTestReader extends MyBatisPagingItemReader<people>{
	private static final Logger log = LoggerFactory.getLogger(MyTestReader.class);
	private static final int PAGE_SIZE = 100;

	@Autowired
    public MyTestReader( SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        this.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        this.setQueryId("selectByPrimaryKey");
//        this.setParameterValues(getParameterValues());
        this.setPageSize(PAGE_SIZE);
    }
	
	private Map<String, Object> getParameterValues() throws ParseException {
		Map<String, Object> parameterValues = new HashMap<String, Object>();
		
		return parameterValues;		
	}
}
