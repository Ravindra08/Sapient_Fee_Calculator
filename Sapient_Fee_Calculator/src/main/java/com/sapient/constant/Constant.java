/**
 * 
 */
package com.sapient.constant;


/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
public class Constant {
	/*
	 * Define Fees for Transaction.
	 */
	public enum TRANSACTIONFEES {
		FIVE_HUNDREAD(500), HUNDREAD(100), FIFTY(50), TEN(10);
		private double fees;

		TRANSACTIONFEES(double fees) {
			this.fees = fees;
		}

		public double getFees() {
			return fees;
		}
	};

	public enum TRANSACTIONTYPE {
		BUY("BUY", "1"), SELL("SELL", "2"), DEPOSIT("DEPOSITE", "3"), WITHDRAW("WITHDRAW", "4");
		private String type;
		private String name;

		TRANSACTIONTYPE(String name, String type) {
			this.name = name;
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}
	};
}
