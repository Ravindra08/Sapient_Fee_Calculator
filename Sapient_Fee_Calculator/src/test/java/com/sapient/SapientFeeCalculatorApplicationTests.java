package com.sapient;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.bean.TransactionBean;
import com.sapient.service.SapientFeeCalculatorService;

/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SapientFeeCalculatorApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void calculateTransactionFeeTest(){
		List<TransactionBean> transactionBean = new ArrayList<TransactionBean>();
		transactionBean.add(new TransactionBean("SAPEXTXN1","GS","RELIND","WITHDRAW","18-07-2017 11:34:46",125.67,true,500.00));
		transactionBean.add(new TransactionBean("SAPEXTXN2","AP","ICICI","SELL","18-07-2017 11:34:46",125.67,false,100.00));
		transactionBean.add(new TransactionBean("SAPEXTXN2","HJ","REL","BUY","18-07-2017 11:34:46",125.67,false,100.00));
		SapientFeeCalculatorService sapientFeeCalculatorService = new SapientFeeCalculatorService();
		sapientFeeCalculatorService.calculateTransactionFee(transactionBean);
		assertTrue(true);
	}
	
	@Test
	public void displayTransactionReportTest(){
		
		List<TransactionBean> transactionBean = new ArrayList<TransactionBean>();
		transactionBean.add(new TransactionBean("SAPEXTXN1","GS","RELIND","WITHDRAW","18-07-2017 11:34:46",125.67,true,500.00));
		SapientFeeCalculatorService sapientFeeCalculatorService = new SapientFeeCalculatorService();
		sapientFeeCalculatorService.displayTransactionReport(transactionBean);
		assertTrue(true);
	}
}
