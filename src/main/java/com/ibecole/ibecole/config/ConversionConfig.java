package com.ibecole.ibecole.config;

import com.ibecole.ibecole.convertor.PersonneRequestToEleveConverter;
import com.ibecole.ibecole.convertor.PersonneRequestToParentConverter;
import com.ibecole.ibecole.convertor.PersonneRequestToProfesseurConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(new PersonneRequestToEleveConverter());
        converters.add(new PersonneRequestToParentConverter());
        converters.add(new PersonneRequestToProfesseurConverter());

        return converters;
    }

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }
}
