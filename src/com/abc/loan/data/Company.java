package com.abc.loan.data;

/**
 *
 * <p>Title: Company</p>
 *
 * <p>Description: Class representing a company</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J.Developer
 * @version 1.0
 */
public class Company
{
	private String m_id;
	private String m_shortName;
	private String m_fullName;

	/**
	 * Construtor
	 *
	 * @param id String
	 * @param shortName String
	 * @param fullName String
	 */
	public Company(String id, String shortName, String fullName)
	{
		m_id = id;
		m_shortName = shortName;
		m_fullName = fullName;
	}

	/**
	 * Returns the Company's ID number
	 *
	 * @return String
	 */
	public String getId()
	{
		return m_id;
	}

	/**
	 * Returns the short name of the Company, eg "GM".
	 *
	 * @return String
	 */
	public String getShortName()
	{
		return m_shortName;
	}

	/**
	 * Returns the full name of the Company, eg "General Motors Corporation".
	 *
	 * @return String
	 */
	public String getFullName()
	{
		return m_fullName;
	}

}

