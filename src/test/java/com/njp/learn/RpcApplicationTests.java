package com.njp.learn;

import com.njp.learn.model.Account;
import com.njp.learn.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = RpcApplication.class)
public class RpcApplicationTests {
    @Autowired
    private AccountService accountService;

	@Test
	public void contextLoads() {
        Account account = new Account();
        account.setName("hello rmi");
        accountService.insertAccount(account);

        System.out.println(accountService.getAccounts().size());

        if(accountService.getAccounts().size() > 0){
            System.out.println(accountService.getAccounts().get(0).getName());
        }

    }

}
