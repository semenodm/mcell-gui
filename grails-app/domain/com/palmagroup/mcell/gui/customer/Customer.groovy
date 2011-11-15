package com.palmagroup.mcell.gui.customer

import java.util.Date

class Customer {
	int id

	String name

	String legalForm

	String contactPerson

	String okpo

	String mfo

	String account

	String accountName

	String taxNumber

	String taxLicense

	Date dateRegister

	byte status

	byte type
	double customerDept
	double deptOverdue
	double creditLimit
	//	CustomerAccount customerAccount = null;
	//
	//	private Customer customerPay = null;
	//
	//	private CustomerAddress customerAddress = null;
	//
	//	private Set salesOutlets = new HashSet();
	//
	//	private Set discounts = new HashSet();
	//
	//	private Set payments = new HashSet();

	static constraints = {
	}
	static mapping = {
		table 'v_gui_customer'
		version false
		id generator : 'identity'
	}
	static expose = 'customers'
	static api = [
		excludedFields: [],
		list : { params ->
			Customer.enquire(params)
		},
		count : { params ->
			Customer.enquireCount(params)
		}
	]
}
