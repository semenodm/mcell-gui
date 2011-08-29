package com.palmagroup.mcell.gui.test
import groovy.lang.Closure

import com.palmagroup.mcell.gui.orders.Orders

import groovy.lang.Closure

import com.palmagroup.mcell.gui.customer.Customer
import com.palmagroup.mcell.gui.orders.OrderDetail
import com.palmagroup.mcell.gui.orders.Orders




class OrdersBuilder {

	def orders = [:]
	def customers = [:]
	def orderDetails = [:]
	public static build(Closure c){
		def builder = new OrdersBuilder()
		c.delegate = builder
		c()
		//builder.customers.each { it.value.save(flush:true) }
		builder.orders
	}

	def orders(String... ordersNums){
		ordersNums.each {
			orders[it] = Orders.build(number:it)
			orders[it].save(flush:true)
		}
	}

	def customers(String... customersNames){
		customersNames.each {
			customers[it] = Customer.build(name:it)
			customers[it].save(flush:true)
		}
	}

	def order(String orderNum){
		assert orders.containsKey(orderNum), "Invalid order number ${orderNum}"
		new OrderBuilder(parent:this,order : orders[orderNum])
	}
	def customer(String customerName){
		assert customers.containsKey(customerName), "Invalid order number ${customerName}"
		new CustomerBuilder(customer : customers[customerName])
	}

	def order_details(String... nomNumbers){
		nomNumbers.each {
			orderDetails[it] = OrderDetail.build(code:it)
			orderDetails[it].save(flush:true)
		}
	}

	def propertyMissing(String propertyName){
		System.out.println(propertyName);
		switch(propertyName){
			case 'all_order_details':
				return new MultipleOrderDetailsBuilder(orderDetails : orderDetails.values(), parent : this)
			default:
				this
		}
	}
}
