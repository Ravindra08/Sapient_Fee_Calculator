/**
 * 
 */
package com.sapient.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sapient.bean.TransactionBean;
import com.sapient.constant.Constant.TRANSACTIONFEES;
import com.sapient.constant.Constant.TRANSACTIONTYPE;

/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
@Component
public class SapientFeeCalculatorService {

	public List<TransactionBean> transactionBeanList = null;

	private static final Logger logger = LoggerFactory.getLogger(SapientFeeCalculatorService.class);
	/**
	 * @param transaction
	 */
	public List<TransactionBean> calculateTransactionFee(List<TransactionBean> transactionbean) {

		logger.info("------------------------------- Service Class Start --------------------------------------------");
		if (transactionbean != null) {
			if (transactionBeanList == null) {
				transactionBeanList = new ArrayList<TransactionBean>();
			}
			transactionBeanList.addAll(transactionbean);

			if (transactionBeanList.size() > 0) {
				for (TransactionBean trans : transactionBeanList) {
					if (trans.getClientId().equalsIgnoreCase("AS") || trans.getClientId().equalsIgnoreCase("GS")) {
						trans.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
					} else {
						if (trans.getPriority()) {
							trans.setTransactionFees(TRANSACTIONFEES.FIVE_HUNDREAD.getFees());

						} else {
							if (trans.getTransactionType().equalsIgnoreCase(TRANSACTIONTYPE.SELL.getName()) || trans
									.getTransactionType().equalsIgnoreCase(TRANSACTIONTYPE.WITHDRAW.getName())) {

								trans.setTransactionFees(TRANSACTIONFEES.HUNDREAD.getFees());

							} else if (trans.getTransactionType() == TRANSACTIONTYPE.BUY.getName()
									|| trans.getTransactionType() == TRANSACTIONTYPE.DEPOSIT.getName()) {

								trans.setTransactionFees(TRANSACTIONFEES.FIFTY.getFees());
							}

						}

					}
					transactionbean.add(trans);
				}
			}
			displayTransactionReport(transactionBeanList);

		}

		return transactionbean;
	}

	/**
	 * This method will be display Transaction Report.
	 */
	public void displayTransactionReport(List<TransactionBean> transactionBeanList) {
		Collections.sort(transactionBeanList, new TransactionBean());
		logger.info("-------------------------------------------Sapient Calculated Fees:-------------------------------------------------------------");
		logger.info(
				"External Transaction ID | Client Id | Security Id | Transaction Type | Transaction Date | Market Value | Priority | Processing Fee    |");
		for (TransactionBean transaction : transactionBeanList) {
			logger.info("----------------------------------------------------------------------------------------------------------------------------");
			logger.info(transaction.getExternalTransactionID() + "\t| " + transaction.getClientId() + "\t| "
					+ transaction.getSecurityId() + "\t| " + transaction.getTransactionType() + "\t| "
					+ transaction.getMarketValue() + "\t| " + "\t| " + transaction.getTransactionDate() + "\t| "
					+ (transaction.getPriority() ? "HIGH\t" : "NORMAL") + "\t| " + transaction.getTransactionFees()
					+ "\t|");
		}
		logger.info("-------------------------------------------------------------------------------------------------------------------------------");
	}
}