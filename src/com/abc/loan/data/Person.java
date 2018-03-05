package com.abc.loan.data;

/**
 *
 * <p>Title: Person</p>
 *
 * <p>Description: Class representing a person</p>
 *
 * <p>Copyright: Copyright (c) 2006 ABC Co.</p>
 *
 * <p>Company: ABC Co.</p>
 *
 * @author J.Developer
 * @version 1.0
 */
public class Person
{
	private String m_id;
	private String m_lastName;
	private String m_firstName;

	/**
	 * Constructor
	 *
	 * @param id String
	 * @param lastName String
	 * @param firstName String
	 */
	public Person(String id, String lastName, String firstName)
	{
		m_id = id;
		m_lastName = lastName;
		m_firstName = firstName;
	}

	/**
	 * Returns the Person's ID number
	 *
	 * @return String
	 */
	public String getId()
	{
		return m_id;
	}

	/**
	 * Returns the Person's last name
	 *
	 * @return String
	 */
	public String getLastName()
	{
		return m_lastName;
	}

	/**
	 * Returns the Person's first name
	 *
	 * @return String
	 */
	public String getFirstName()
	{
		return m_firstName;
	}

	/**
	 * Returns last name, first name
	 *
	 * @return String
	 */
	public String getFullName()
	{
		return m_lastName + ", " + m_firstName;
	}

}
