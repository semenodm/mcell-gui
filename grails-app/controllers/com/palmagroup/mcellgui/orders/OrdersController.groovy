package com.palmagroup.mcellgui.orders

import grails.converters.JSON

import com.palmagroup.mcell.gui.orders.Orders

class OrdersController {

	def index = {
		def orders = Orders.findAllByNumber('test number')
		render ([orders : orders] as JSON)
	}
}
