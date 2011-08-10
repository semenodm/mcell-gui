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
	static constraints = {
	}
	static mapping = {
		table 'v_gui_orders'
		version false
		id generator : 'identity'
	}
}
