package com.palmagroup.mcellgui.orders

import grails.converters.JSON

import com.palmagroup.mcell.gui.orders.CompleteOrder
import com.palmagroup.mcell.gui.orders.OrderDetail
import com.palmagroup.mcell.gui.orders.Orders
import com.palmagroup.mcell.gui.orders.Price

class OrdersController {

	def index = {
		def orders = Orders.findAll()
		render ([orders : orders] as JSON)
	}
	def prices = {
		def prices = Price.findAll ()
		render ([prices : prices] as JSON)
	}

	def retrieveOrderDetails = {
		def orderDetails = OrderDetail.findAllByOrderRef(params["orderRef"])
		//def orderDetails = OrderDetail.findAll()
		render ([orderDetails : orderDetails] as JSON)
	}
	def completeOrders = {
		JSON.registerObjectMarshaller(Price) {
			def returnArray = [:]
			returnArray['name'] = it.name
			return returnArray
		}
		def completeOrders = CompleteOrder.findAll()
		render ([orders : completeOrders] as JSON)
	}
}
