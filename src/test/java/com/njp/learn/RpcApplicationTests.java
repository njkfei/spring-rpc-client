package com.njp.learn;

import com.njp.learn.model.Account;
import com.njp.learn.service.AccountService;
import com.njp.learn.service.CheckingAccountService;
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

    @Autowired
    private CheckingAccountService checkingAccountService;

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

    @Test
    public void testJmsRpc(){
        long start = System.currentTimeMillis();
        final int MAX_SIZE = 100000;
        for(int i = 0;i < MAX_SIZE;i++) {
            //System.out.println(checkingAccountService.cancelAccount(1234));
            checkingAccountService.cancelAccount(1234);
        }

        long elaps = System.currentTimeMillis() - start;

        System.out.println(String.format("JMS RPC elaps time : %d repead %d avg %d ",elaps,MAX_SIZE,elaps/MAX_SIZE));


    }

    @Test
    public void testRmiRpc(){
        long start = System.currentTimeMillis();
        final int MAX_SIZE = 100000;
        for(int i = 0;i < MAX_SIZE;i++) {
            //System.out.println(checkingAccountService.cancelAccount(1234));
            accountService.cancelAccount(1234);
        }

        long elaps = System.currentTimeMillis() - start;

        System.out.println(String.format("RMI RPC elaps time : %d repead %d avg %d ",elaps,MAX_SIZE,elaps/MAX_SIZE));

    }

    @Test
    public void testRpc(){
        testJmsRpc();
        testRmiRpc();
    }
}
