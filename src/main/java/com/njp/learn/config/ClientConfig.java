package com.njp.learn.config;

import com.njp.learn.config.JmsConfig;
import com.njp.learn.service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;

/**
 * Created by niejinping on 2016/7/30.
 */
@Configuration
@Import(JmsConfig.class)
public class ClientConfig {
    @Autowired
    private JmsConfig jmsConfig;

    @Bean
    public CheckingAccountService checkingAccountService(){
        JmsInvokerProxyFactoryBean jmsInvokerProxyFactoryBean = new JmsInvokerProxyFactoryBean();
        jmsInvokerProxyFactoryBean.setServiceInterface(CheckingAccountService.class);
        jmsInvokerProxyFactoryBean.setConnectionFactory(jmsConfig.connectionFactory());
        jmsInvokerProxyFactoryBean.setQueue(jmsConfig.queue());
        jmsInvokerProxyFactoryBean.afterPropertiesSet();


        return (CheckingAccountService) jmsInvokerProxyFactoryBean.getObject();
    }
}
