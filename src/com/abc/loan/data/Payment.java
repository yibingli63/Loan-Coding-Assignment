package com.abc.loan.data;

import java.util.Date;

/**
 *
 * <p>Title: Payment</p>
 *
 * <p>Description: Class representing a loan payment</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J.Developer
 * @version 1.0
 */
public class Payment
{
	private Loan    m_loan;
	private Person  m_payer;
	private Date    m_date;
	private double  m_amount;

	/**
	 * Constructor
	 *
	 * @param loanId String
	 * @param payer Person
	 * @param date Date
	 * @param amount double
	 */
	public Payment(Loan loan, Person payer, Date date, double amount)
	{
		m_loan = loan;
		m_payer = payer;
		m_date = date;
		m_amount = amount;
	}

	/**
	 * Returns the Loan associated with this Payment.
	 *
	 * @return Loan
	 */
	public Loan getLoan()
	{
		return m_loan;
	}

	/**
	 * Returns the Person who made the payment.
	 *
	 * @return Person
	 */
	public Person getPayer()
	{
		return m_payer;
	}

	/**
	 * Returns the payment date.
	 *
	 * @return Date
	 */
	public Date getDate()
	{
		return m_date;
	}

	/**
	 * Returns the amount paid.
	 *
	 * @return double
	 */
	public double getAmount()
	{
		return m_amount;
	}

}

