package com.abc.loan.delegate;

import com.abc.loan.data.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;
import java.util.TreeMap;

/**
 * Stub to simulate communication with loan server
 */
public abstract class LoanServerStub
{
	private static List m_loans;
	private static Map  m_loanMap;
	private static Map  m_paymentListMap;
	private static Map  m_loanTypeMap;
	private static Map  m_companyMap;
	private static Map  m_personMap;

	public static List getLoans() throws Exception
	{
		return new ArrayList(m_loans);
	}

	public static Loan getLoan(String id) throws Exception
	{
		return (Loan) m_loanMap.get(id);
	}

	public static List getPayments(Loan loan) throws Exception
	{
		List payments = (List) m_paymentListMap.get(loan.getId());

		// don't return null List
		if (payments == null)
		{
			payments = new ArrayList();
		}

		return new ArrayList(payments);
	}

	@SuppressWarnings("unchecked")
	public static List getLoanTypes() throws Exception
	{
		return new ArrayList(m_loanTypeMap.entrySet());
	}

	public static LoanType getLoanType(String id) throws Exception
	{
		return (LoanType) m_loanTypeMap.get(id);
	}

	public static Company getCompany(String tid) throws Exception
	{
		return (Company) m_companyMap.get(tid);
	}

	public static Person getPerson(String ssn) throws Exception
	{
		return (Person) m_personMap.get(ssn);
	}

	public static void saveLoan(Loan loan) throws Exception
	{
		// Add or replace in List
		int index = m_loans.indexOf(loan);
		if (index != -1)
		{
			m_loans.set(index, loan);
		}
		else
		{
			m_loans.add(loan);
		}

		// Add or replace in Map
		m_loanMap.put(loan.getId(), loan);
	}

	public static void savePayment(Payment payment) throws Exception
	{
		List payments = (List) m_paymentListMap.get(payment.getLoan().getId());

		// create payment List if null
		if (payments == null)
		{
			payments = new ArrayList();
			m_paymentListMap.put(payment.getLoan().getId(), payments);
		}

		// Add to list
		payments.add(payment);
	}

	public static void saveLoanType(LoanType loanType) throws Exception
	{
		m_loanTypeMap.put(loanType.getId(), loanType);
	}

	public static void saveCompany(Company company) throws Exception
	{
		m_companyMap.put(company.getId(), company);
	}

	public static void savePerson(Person person) throws Exception
	{
		m_personMap.put(person.getId(), person);
	}

	public static void deleteLoan(Loan loan) throws Exception
	{
		m_loans.remove(loan);
		m_loanMap.remove(loan);
		List payments = (List) m_paymentListMap.get(loan.getId());
		if (payments != null)
		{
			m_paymentListMap.remove(payments);
		}
	}

	public static void deletePayment(Payment payment) throws Exception
	{
		List payments = (List) m_paymentListMap.get(payment.getLoan().getId());
		if (payments != null)
		{
			payments.remove(payment);
		}
	}

	public static void deleteLoanType(LoanType loanType) throws Exception
	{
		m_loanTypeMap.remove(loanType);
	}

	public static void deleteCompany(Company company) throws Exception
	{
		m_companyMap.remove(company);
	}

	public static void deletePerson(Person person) throws Exception
	{
		m_personMap.remove(person);
	}

	private static Date getDate(int offsetDays)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, offsetDays);
		return cal.getTime();
	}

	// Static build of simulated loan database
	static
	{
		try
		{
			m_loans = new ArrayList();
			m_loanMap = new HashMap();
			m_paymentListMap = new HashMap();
			m_companyMap = new HashMap();
			m_personMap = new HashMap();
			m_loanTypeMap = new LinkedHashMap(); // changed from HashMap
		//	m_loanTypeMap = new HashMap();
			// COMPANIES
			saveCompany(LoanFactory.getInstance().createCompany("UK3726732",    "RBL",  "Royal Bank of London"));
			saveCompany(LoanFactory.getInstance().createCompany("23-2938347",   "ORMU", "Oregon Mutual"));
			saveCompany(LoanFactory.getInstance().createCompany("977-BT-00332", "BPOP", "Banco Popular"));

			// PEOPLE
			savePerson(LoanFactory.getInstance().createPerson("305-19-9019", "Matsunaga", "Carolyn"));
			savePerson(LoanFactory.getInstance().createPerson("232-58-9658", "Junnarkar", "Sandeep"));
			savePerson(LoanFactory.getInstance().createPerson("731-09-2209", "Jarnovich", "Josip"));

			// LOAN TYPES
			// Top level type
			saveLoanType(LoanFactory.getInstance().createLoanType("ALL", "All Loan Types"));
			// Second level types
			saveLoanType(LoanFactory.getInstance().createLoanType("CONSUMER", "Consumer Loans"));
			saveLoanType(LoanFactory.getInstance().createLoanType("SMALLBIZ", "Small Business Loans"));
			saveLoanType(LoanFactory.getInstance().createLoanType("CORPORATE", "Corporate Loans"));
			// Third level types
			saveLoanType(LoanFactory.getInstance().createLoanType("HOME", "Home Loans"));
			saveLoanType(LoanFactory.getInstance().createLoanType("AUTO", "Auto Loans"));
			saveLoanType(LoanFactory.getInstance().createLoanType("BOAT", "Boat Loans"));
			saveLoanType(LoanFactory.getInstance().createLoanType("SBREVOLVE", "Small Business Revolving Loans"));
			saveLoanType(LoanFactory.getInstance().createLoanType("SBLOC", "Small Business Lines of Credit"));
			saveLoanType(LoanFactory.getInstance().createLoanType("CORPLOC", "Corporate Letters of Credit"));
			// Fourth level types
			saveLoanType(LoanFactory.getInstance().createLoanType("FRM", "Fixed Rate Mortgages"));
			saveLoanType(LoanFactory.getInstance().createLoanType("ARM", "Adjustable Rate Mortgages"));
			saveLoanType(LoanFactory.getInstance().createLoanType("HOMELOC", "Home Equity Lines of Credit"));
			// Loan Type parent references
			getLoanType("CONSUMER").setParentType(getLoanType("ALL"));
			getLoanType("SMALLBIZ").setParentType(getLoanType("ALL"));
			getLoanType("CORPORATE").setParentType(getLoanType("ALL"));
			getLoanType("HOME").setParentType(getLoanType("CONSUMER"));
			getLoanType("AUTO").setParentType(getLoanType("CONSUMER"));
			getLoanType("BOAT").setParentType(getLoanType("CONSUMER"));
			getLoanType("FRM").setParentType(getLoanType("HOME"));
			getLoanType("ARM").setParentType(getLoanType("HOME"));
			getLoanType("HOMELOC").setParentType(getLoanType("HOME"));
			getLoanType("SBREVOLVE").setParentType(getLoanType("SMALLBIZ"));
			getLoanType("SBLOC").setParentType(getLoanType("SMALLBIZ"));
			getLoanType("CORPLOC").setParentType(getLoanType("CORPORATE"));

			// LOANS
			saveLoan(LoanFactory.getInstance().createLoan(
				"1000", getLoanType("FRM"), getCompany("UK3726732"), getPerson("305-19-9019"), getDate(-400), 2500000.00, 6.50));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1001", getLoanType("ARM"), getCompany("UK3726732"), getPerson("232-58-9658"), getDate(-330), 150000.00, 7.25));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1002", getLoanType("HOMELOC"), getCompany("977-BT-00332"), getPerson("232-58-9658"), getDate(-310), 98000.00, 6.95));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1003", getLoanType("ARM"), getCompany("23-2938347"), getPerson("305-19-9019"), getDate(-480), 49000.00, 6.15));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1004", getLoanType("BOAT"), getCompany("23-2938347"), getPerson("731-09-2209"), getDate(-525), 2000000.00, 7.85));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1005", getLoanType("AUTO"), getCompany("977-BT-00332"), getPerson("731-09-2209"), getDate(-415), 3299600.00, 8.99));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1006", getLoanType("SBREVOLVE"), getCompany("UK3726732"), getPerson("305-19-9019"), getDate(-385), 5689000.00, 6.50));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1007", getLoanType("SBLOC"), getCompany("977-BT-00332"), getPerson("305-19-9019"), getDate(-640), 660000.00, 7.75));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1008", getLoanType("CORPLOC"), getCompany("23-2938347"), getPerson("731-09-2209"), getDate(-590), 7140000.00, 6.75));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1009", getLoanType("FRM"), getCompany("977-BT-00332"), getPerson("232-58-9658"), getDate(-665), 645000.00, 7.10));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1010", getLoanType("AUTO"), getCompany("977-BT-00332"), getPerson("305-19-9019"), getDate(-445), 965000.00, 6.99));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1011", getLoanType("FRM"), getCompany("23-2938347"), getPerson("232-58-9658"), getDate(-925), 508000.00, 6.50));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1012", getLoanType("AUTO"), getCompany("977-BT-00332"), getPerson("305-19-9019"), getDate(-760), 77000.00, 7.25));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1013", getLoanType("SBLOC"), getCompany("23-2938347"), getPerson("731-09-2209"), getDate(-885), 8184500.00, 8.75));
			saveLoan(LoanFactory.getInstance().createLoan(
				"1014", getLoanType("AUTO"), getCompany("UK3726732"), getPerson("731-09-2209"), getDate(-910), 435000.00, 7.95));

			// PAYMENTS
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1000"), getPerson("305-19-9019"), getDate(-280), 2000.00));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1000"), getPerson("305-19-9019"), getDate(-250), 2100.00));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1000"), getPerson("232-58-9658"), getDate(-170), 2000.00));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1000"), getPerson("305-19-9019"), getDate(-110), 2000.00));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1001"), getPerson("305-19-9019"), getDate(-230), 1677.67));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1001"), getPerson("731-09-2209"), getDate(-200), 1677.67));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1001"), getPerson("305-19-9019"), getDate(-170), 1677.67));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1002"), getPerson("232-58-9658"), getDate(-122), 435.88));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1002"), getPerson("232-58-9658"), getDate(-92), 438.55));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1002"), getPerson("232-58-9658"), getDate(-62), 446.72));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1002"), getPerson("232-58-9658"), getDate(-32), 451.12));
			savePayment(LoanFactory.getInstance().createPayment(
				getLoan("1002"), getPerson("731-09-2209"), getDate(-2), 459.64));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
