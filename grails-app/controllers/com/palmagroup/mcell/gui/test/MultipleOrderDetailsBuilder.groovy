package com.palmagroup.mcell.gui.test

class MultipleOrderDetailsBuilder {
	def orderDetails
	OrdersBuilder parent

	def haveOrderRef(String orderRef){
		orderDetails.each { it.orderRef = parent.orders[orderRef].id }
	}
}
