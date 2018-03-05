package com.abc.loan.delegate;

import com.abc.loan.data.*;

import java.util.List;

/**
 *
 * <p>Title: LoanDelegate</p>
 *
 * <p>Description: UI delegate class used to retrieve, save, and delete
 * loan-related objects, and perform other useful functions.</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J. Developer
 * @version 1.0
 */
public class LoanDelegate
{
	/**
	 * Retrieves and returns all Loan data objects
	 *
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static List getLoans() throws Exception
	{
		return LoanServerStub.getLoans();
	}

	/**
	 * Retrieves and returns Loan data object for the specified id
	 *
	 * @param id String
	 * @return Loan
	 * @throws Exception
	 */
	public Loan getLoan(String id) throws Exception
	{
		return LoanServerStub.getLoan(id);
	}

	/**
	 * Retrieves and returns List of all existing LoanTypes.
	 *
	 * @return List
	 * @throws Exception
	 */
	public static List getLoanTypes() throws Exception
	{
		return LoanServerStub.getLoanTypes();
	}

	/**
	 * Retrieves and returns LoanType for the specified id.
	 *
	 * @param id String
	 * @return LoanType
	 * @throws Exception
	 */
	public static LoanType getLoanType(String id) throws Exception
	{
		return LoanServerStub.getLoanType(id);
	}

	/**
	 * Retrieves and returns List of Payment objects for the specified Loan
	 *
	 * @param loan Loan
	 * @return List
	 * @throws Exception
	 */
	public static List getPayments(Loan loan) throws Exception
	{
		return LoanServerStub.getPayments(loan);
	}

	/**
	 * Retrieves and returns Company for the specified tax ID number.
	 *
	 * @param tid String
	 * @return Company
	 * @throws Exception
	 */
	public Company getCompany(String tid) throws Exception
	{
		return LoanServerStub.getCompany(tid);
	}

	/**
	 * Retrieves and returns Person for the specified social security number.
	 *
	 * @param ssn String
	 * @return Person
	 * @throws Exception
	 */
	public Person getPerson(String ssn) throws Exception
	{
		return LoanServerStub.getPerson(ssn);
	}

	/**
	 * Saves new or updated Loan object.
	 *
	 * @param loan Loan
	 * @throws Exception
	 */
	public void saveLoan(Loan loan) throws Exception
	{
		LoanServerStub.saveLoan(loan);
	}

	/**
	 * Saves new or updated Payment object.
	 *
	 * @param payment Payment
	 * @throws Exception
	 */
	public void savePayment(Payment payment) throws Exception
	{
		LoanServerStub.savePayment(payment);
	}

	/**
	 * Saves new or updated LoanType object.
	 *
	 * @param loanType LoanType
	 * @throws Exception
	 */
	public void saveLoanType(LoanType loanType) throws Exception
	{
		LoanServerStub.saveLoanType(loanType);
	}

	/**
	 * Saves new or updated Company object.
	 *
	 * @param company Company
	 * @throws Exception
	 */
	public void saveCompany(Company company) throws Exception
	{
		LoanServerStub.saveCompany(company);
	}

	/**
	 * Saves new or updated Person object.
	 *
	 * @param person Person
	 * @throws Exception
	 */
	public void savePerson(Person person) throws Exception
	{
		LoanServerStub.savePerson(person);
	}

	/**
	 * Deletes Loan object.
	 *
	 * @param loan Loan
	 * @throws Exception
	 */
	public void deleteLoan(Loan loan) throws Exception
	{
		LoanServerStub.deleteLoan(loan);
	}

	/**
	 * Deletes Payment object.
	 *
	 * @param payment Payment
	 * @throws Exception
	 */
	public void deletePayment(Payment payment) throws Exception
	{
		LoanServerStub.deletePayment(payment);
	}

	/**
	 * Deletes Company object.
	 *
	 * @param company Company
	 * @throws Exception
	 */
	public void deleteCompany(Company company) throws Exception
	{
		LoanServerStub.deleteCompany(company);
	}

	/**
	 * Deletes Person object.
	 *
	 * @param person Person
	 * @throws Exception
	 */
	public void deletePerson(Person person) throws Exception
	{
		LoanServerStub.deletePerson(person);
	}

}
