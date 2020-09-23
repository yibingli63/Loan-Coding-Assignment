package com.abc.loan.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.abc.loan.data.Loan;
import com.abc.loan.data.LoanType;
import com.abc.loan.data.Payment;
import com.abc.loan.delegate.LoanDelegate;

/**
 * Class containing tests for Loan module
 */
public class LoanTest
{	
	/**
	 * Main method to execute all tests.
	 *
	 * @param args String[]
	 */
	public static void main(String[] args)
	{
		try
		{
			LoanTest test = new LoanTest();
			test.testAllLoansReport();
			test.testLoansByTypeReport();
			test.testLoanTypeHierarchyReport();
			test.traveseTree();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void traveseTree() throws Exception {
		Tree tree = new Tree();
		File fileDir = new File("c:\\temp\\report-D.txt");
   	 
		Writer out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(fileDir), "UTF8"));
		
		System.out.println("Report D");
		System.out.println("--------------------------------------------------------");	
		out.append("Report D").append("\r\n");
		out.append("--------------------------------------------------------").append("\r\n");
	
		tree.addNode("ALL");
		tree.buildTree("ALL");	
		tree.display1("ALL", 0, out);
		out.flush();
		out.close();		
	}
	
	/**
	 * Tests the "All Loans" report - exercise LOAN I step A
	 *
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void testAllLoansReport() throws Exception
	{
		Tree tree = new Tree();
		Loan loan = new Loan(null, null, null, null, null, 0, 0);
		List<Loan> reportLists = new ArrayList<Loan>();
		
		File fileDir = new File("c:\\temp\\report-A.txt");
	   	 
		Writer out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(fileDir), "UTF8"));
		
		reportLists = LoanDelegate.getLoans();
		System.out.println("Report A");
		System.out.println("--------------------------------------------------------");	
		out.append("Report A").append("\r\n");
		out.append("--------------------------------------------------------").append("\r\n");
		
		for (int i=0; i<reportLists.size(); i++ ){
			loan = reportLists.get(i);
			tree.showLoanDetails(loan, "");
			tree.writeLoanDetails(loan, "", out);
		}
		out.flush();
		out.close();
	}

	/**
	 * Tests the "Loans by Type" report - exer0cise LOAN I step B
	 *
	 * @throws Exception
	 */

	public void testLoansByTypeReport() throws Exception
	{
		Tree tree = new Tree();
		
		File fileDir = new File("c:\\temp\\report-B.txt");
   	 
		Writer out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(fileDir), "UTF8"));
		
		System.out.println("Report B");
		System.out.println("--------------------------------------------------------");	
		out.append("Report B").append("\r\n");
		out.append("--------------------------------------------------------").append("\r\n");
	
		tree.addNode("ALL");
		tree.buildNodeSet("All");
		tree.displayNodeSet("ALL", 0, out);
		out.flush();
		out.close();
	}
	
	/**
	 * Tests the "Loan Type Hierarhcy" report - exercise LOAN I step C
	 *
	 * @throws Exception
	 */

	public void testLoanTypeHierarchyReport() throws Exception
	{
		Tree tree = new Tree();

		File fileDir = new File("c:\\temp\\report-C.txt");
	   	 
		Writer out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(fileDir), "UTF8"));
		
		System.out.println("Report C");
		System.out.println("--------------------------------------------------------");	
		out.append("Report C").append("\r\n");
		out.append("--------------------------------------------------------").append("\r\n");
		
		tree.addNode("ALL");
		tree.buildTree1("ALL");
		tree.display("ALL", 0, out);
		out.flush();
		out.close();

	}
}
