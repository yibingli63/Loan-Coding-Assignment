package com.abc.loan.data;

/**
 *
 * <p>Title: LoanType</p>
 *
 * <p>Description: Class representing classification of a loan</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J.Developer
 * @version 1.0
 */
public class LoanType
{
	private String    m_id;
	private String    m_name;

	private LoanType  m_parentType;

	public LoanType()
	{
		
	}

	
	/**
	 * Constructor
	 *
	 * @param id String
	 * @param name String
	 */
	public LoanType(String id, String name)
	{
		m_id = id;
		m_name = name;
	}

	/**
	 * Returns the unique id of the Loan Type.
	 *
	 * @return String
	 */
	public String getId()
	{
		return m_id;
	}

	/**
	 * Returns the name of the Loan Type.
	 *
	 * @return String
	 */
	public String getName()
	{
		return m_name;
	}

	/**
	 * Returns the "parent" Loan Type.
	 *
	 * @return LoanType
	 */
	public LoanType getParentType()
	{
		return m_parentType;
	}

	/**
	 * Sets the "parent" Loan Type
	 *
	 * @param parentType LoanType
	 */
	public void setParentType(LoanType parentType)
	{
		m_parentType = parentType;
	}

}

