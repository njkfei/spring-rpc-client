package com.njp.learn.config;

import com.njp.learn.model.Account;
import com.njp.learn.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * Created by niejinping on 2016/7/30.
 */
@Configuration
public class RmiBean {
    /**
     *   <bean id="accountService" class="org.springframework.remoting.rmi.RmiProxyFactoryBean">
     <property name="serviceUrl" value="rmi://HOST:1199/AccountService"/>
     <property name="serviceInterface" value="example.AccountService"/>
     </bean>
     * @return
     */
    @Bean
    public AccountService accountService(){
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();

        proxy.setServiceUrl("rmi://localhost:1199/AccountService");
        proxy.setServiceInterface(AccountService.class);
        proxy.afterPropertiesSet();  // 这句话不能少

        if(proxy.getObject() instanceof AccountService){
            System.out.println("yes");
        }else{
            System.out.println("No");
        }

        return (AccountService) proxy.getObject();
    }

    /**
     <bean id="accountService" class="org.springframework.remoting.rmi.RmiProxyFactoryBean">
     <property name="serviceUrl" value="rmi://HOST:1199/AccountService"/>
     <property name="serviceInterface" value="example.AccountService"/>
     </bean>
     * @return
     */

}
