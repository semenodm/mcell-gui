package com.palmagroup.mcell.gui.orders

import java.util.Date

class Orders {
	int id
	String orderType
	String number
	Date orderedDate
	String seller
	String customer
	String customerAddres
	Date shippedDate
	String payment
	String price
	Boolean stockBalPathed
	Boolean creditApproved
	double discount
	double discountPercent
	double summ
	double vaTax
	double summPay
	byte status
	short stage
	boolean isSynchronized
	boolean isReserved
	boolean isNeedConfirm
	String description
	Integer customerRef
	static constraints = {
		customer(nullable:true)
		payment(nullable:true)
		price(nullable:true)
		customerAddres(nullable:true)
		shippedDate(nullable:true)
		customerRef(nullable:true)
	}
	static mapping = {
		table 'v_gui_orders'
		version false
		id generator : 'identity'
		id column:'id_order'
	}
}
