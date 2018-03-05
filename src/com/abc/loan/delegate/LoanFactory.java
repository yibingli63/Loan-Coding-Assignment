package com.abc.loan.delegate;

import com.abc.loan.data.*;

import java.util.Date;

/**
 *
 * <p>Title: LoanFactory</p>
 *
 * <p>Description: Factory for all loan-related objects</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J. Developer
 * @version 1.0
 */
public class LoanFactory
{
	private static LoanFactory m_instance = new LoanFactory();

	/**
	 * Private constructor.
	 */
	private LoanFactory()
	{
	}

	/**
	 * Gets single instance.
	 */
	public static LoanFactory getInstance()
	{
		return m_instance;
	}

	/**
	 * Creates new Loan object.
	 *
	 * @param id String
	 * @param loanType LoanType
	 * @param lender Company
	 * @param borrower Person
	 * @param date Date
	 * @param amount double
	 * @param rate double
	 * @return Loan
	 */
	public Loan createLoan(String id,
						   LoanType loanType,
						   Company lender,
						   Person borrower,
						   Date date,
						   double amount,
						   double rate)
	{
		return new Loan(id, loanType, lender, borrower, date, amount, rate);
	}

	/**
	 * Creates new Payment object.
	 *
	 * @param loan Loan
	 * @param payer Person
	 * @param date Date
	 * @param amount double
	 * @return Payment
	 */
	public Payment createPayment(Loan loan, Person payer, Date date, double amount)
	{
		return new Payment(loan, payer, date, amount);
	}

	/**
	 * Creates new LoanType object.
	 *
	 * @param id String
	 * @param name String
	 * @return LoanType
	 */
	public LoanType createLoanType(String id, String name)
	{
		return new LoanType(id, name);
	}

	/**
	 * Creates new Company object.
	 *
	 * @param id String
	 * @param shortName String
	 * @param fullName String
	 * @return Company
	 */
	public Company createCompany(String id, String shortName, String fullName)
	{
		return new Company(id, shortName, fullName);
	}

	/**
	 * Creates new Person object.
	 *
	 * @param id String
	 * @param lastName String
	 * @param firstName String
	 * @return Person
	 */
	public Person createPerson(String id, String lastName, String firstName)
	{
		return new Person(id, lastName, firstName);
	}

}
