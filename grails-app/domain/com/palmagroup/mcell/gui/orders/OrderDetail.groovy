package com.palmagroup.mcell.gui.orders

class OrderDetail {
	int id
	Integer displaySeq
	String code
	String name
	Double number
	String measure
	double price
	double summ
	double summPay
	String serialNumber
	int orderRef

	double numberAccepted

	static mapping = {
		table 'v_gui_order_detail'
		version false
		id generator : 'identity'
		qty column : 'number'
	}

	static constraints = {
	}
}
