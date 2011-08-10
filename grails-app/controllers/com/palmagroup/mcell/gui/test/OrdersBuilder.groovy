package com.palmagroup.mcell.gui.test
import groovy.lang.Closure

import com.palmagroup.mcell.gui.orders.Orders




class OrdersBuilder {

	def orders = [:]

	public static build(Closure c){
		def builder = new OrdersBuilder()
		c.delegate = builder
		c()
		builder.orders
	}

	def orders(String... ordersNums){
		ordersNums.each { orders[it] = Orders.build(number:it) }
	}

	def order(String orderNum){
		assert orders.containsKey(orderNum), "Invalid order number $orderNum"
		new OrderBuilder(order : orders[orderNum])
	}
}
