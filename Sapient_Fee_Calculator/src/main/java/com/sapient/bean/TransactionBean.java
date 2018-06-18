/**
 * 
 */
package com.sapient.bean;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionBean implements Comparator<TransactionBean> {

	/**
	 * 
	 */
	private List<TransactionBean> transactionBeanList;
	private String externalTransactionID;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDate;
	private Double marketValue;
	private Boolean priority;
	private Double transactionFees;

	public TransactionBean(){
		
	}
	
	
	/**
	 * @param externalTransactionID
	 * @param clientId
	 * @param securityId
	 * @param transactionType
	 * @param transactionDate
	 * @param marketValue
	 * @param priority
	 * @param transactionFees
	 */
	public TransactionBean(String externalTransactionID, String clientId, String securityId, String transactionType,
			String transactionDate, Double marketValue, Boolean priority, Double transactionFees) {
		
		this.externalTransactionID = externalTransactionID;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priority = priority;
		this.transactionFees = transactionFees;
	}



	/**
	 * @return the externalTransactionID
	 */
	public String getExternalTransactionID() {
		return externalTransactionID;
	}

	/**
	 * @param externalTransactionID
	 *            the externalTransactionID to set
	 */
	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the securityId
	 */
	public String getSecurityId() {
		return securityId;
	}

	/**
	 * @param securityId
	 *            the securityId to set
	 */
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate
	 *            the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the marketValue
	 */
	public Double getMarketValue() {
		return marketValue;
	}

	/**
	 * @param marketValue
	 *            the marketValue to set
	 */
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}

	/**
	 * @return the priority
	 */
	public Boolean getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Boolean priority) {
		this.priority = priority;
	}

	/**
	 * @return the transactionFees
	 */
	public Double getTransactionFees() {
		return transactionFees;
	}

	/**
	 * @param transactionFees
	 *            the transactionFees to set
	 */
	public void setTransactionFees(Double transactionFees) {
		this.transactionFees = transactionFees;
	}
	

	/**
	 * @return the transactionBeanList
	 */
	public List<TransactionBean> getTransactionBeanList() {
		return transactionBeanList;
	}


	/**
	 * @param transactionBeanList the transactionBeanList to set
	 */
	public void setTransactionBeanList(List<TransactionBean> transactionBeanList) {
		this.transactionBeanList = transactionBeanList;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [externalTransactionID=" + externalTransactionID + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priority=" + priority + ", transactionFees="
				+ transactionFees + "]";
	}

	@Override
	public int compare(TransactionBean obj1, TransactionBean obj2) {
		int value1 = obj1.getClientId().compareTo(obj2.getClientId());
		if (value1 == 0) {
			int value2 = obj1.getTransactionType().compareTo(obj2.getTransactionType());
			if (value2 == 0) {
				int value3 = obj1.getTransactionDate().compareTo(obj2.getTransactionDate());
				if (value3 == 0) {
					return obj1.getPriority().compareTo(obj2.getPriority());
				} else {
					return value3;
				}

			} else {
				return value2;
			}
		}
		return value1;
	}

}
