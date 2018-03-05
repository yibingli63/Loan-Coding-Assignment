package com.abc.loan.data;

import java.util.Date;

/**
 *
 * <p>Title: Loan</p>
 *
 * <p>Description: Class representing a loan</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J.Developer
 * @version 1.0
 */
public class Loan
{
	private String    m_id;
	private LoanType  m_loanType;
	private Company   m_lender;
	private Person    m_borrower;
	private Date      m_date;
	private double    m_amount;
	private double    m_rate;

	/**
	 * Constructor
	 *
	 * @param id String
	 * @param lender Company
	 * @param borrower Person
	 * @param date Date
	 * @param amount double
	 * @param rate double
	 */
	public Loan(String id,
				LoanType loanType,
				Company lender,
				Person borrower,
				Date date,
				double amount,
				double rate)
	{
		m_id = id;
		m_loanType = loanType;
		m_lender = lender;
		m_borrower = borrower;
		m_date = date;
		m_amount = amount;
		m_rate = rate;
	}

	/**
	 * Returns the unique id of the Loan.
	 *
	 * @return String
	 */
	public String getId()
	{
		return m_id;
	}

	/**
	 * Returns the LoanType of this Loan.
	 *
	 * @return LoanType
	 */
	public LoanType getLoanType()
	{
		return m_loanType;
	}

	/**
	 * Returns the Company (bank, finance company, etc.) that lent the money.
	 *
	 * @return Company
	 */
	public Company getLender()
	{
		return m_lender;
	}

	/**
	 * Returns the Person who borrowed the money.
	 *
	 * @return Person
	 */
	public Person getBorrower()
	{
		return m_borrower;
	}

	/**
	 * Returns the loan date.
	 *
	 * @return Date
	 */
	public Date getDate()
	{
		return m_date;
	}

	/**
	 * Returns the loan amount.
	 *
	 * @return double
	 */
	public double getAmount()
	{
		return m_amount;
	}

	/**
	 * Returns the interest rate.
	 *
	 * @return double
	 */
	public double getRate()
	{
		return m_rate;
	}

}

