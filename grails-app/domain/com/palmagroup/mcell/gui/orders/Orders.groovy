package com.palmagroup.mcell.gui.orders

import java.util.Date

class Orders {
	Long id
	byte orderType
	String number
	Date orderedDate
	Date shippedDate
	float discount
	float summ
	float vaTax
	float summPay
	byte status
	short stage
	boolean isSynchronized
	boolean isReserved
	boolean isNeedConfirm
	//	private Member member = null;
	//
	//	private Visit visit = null;
	//
	//	private Payment payment = null;
	//
	//	private SaleOutlet saleOutlet = null;
	//
	//	private Price price = null;

	//private Set ordersDetails = new HashSet();

	//private Set appliedDiscounts = new HashSet();
	String description
	static constraints = {
	}
	static mapping = {
		table 'v_gui_orders'
		version false
		id generator : 'identity'
	}
}
