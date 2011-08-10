package com.palmagroup.mcell.gui.test
import java.util.Date

import com.palmagroup.mcell.gui.orders.Orders

class OrderBuilder {
	Orders order

	def hasType(String type){
		order.orderType = type
		this
	}
	def and(){
		this
	}
	def hasOrderDate(Date date){
		order.orderedDate = date
	}

	def hasSumm(double summ){
		order.summPay = summ
		this
	}
	def hasSeller(String seller){
		order.seller = seller
		this
	}
}
