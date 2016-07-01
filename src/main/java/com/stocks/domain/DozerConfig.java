package com.stocks.domain;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {
	@Bean
	public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:mappings/*mappings.xml") org.springframework.core.io.Resource[] resources) throws Exception {
		final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
		dozerBeanMapperFactoryBean.setMappingFiles(resources);
		return dozerBeanMapperFactoryBean;
	}
}
