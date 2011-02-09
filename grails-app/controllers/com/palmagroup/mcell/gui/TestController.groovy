package com.palmagroup.mcell.gui

import com.palmagroup.mcell.gui.orders.Orders



class TestController {

	def generateOrders = {
		def order = Orders.build(number:'test number')
		order.save()
	}
}
