package com.palmagroup.mcell.gui

import java.text.SimpleDateFormat
import java.util.Date

import org.codehaus.groovy.runtime.DateGroovyMethods

import com.palmagroup.mcell.gui.orders.CompleteOrder
import com.palmagroup.mcell.gui.orders.Orders
import com.palmagroup.mcell.gui.orders.Price
import com.palmagroup.mcell.gui.test.OrdersBuilder


class TestController {

	def generateOrders = {
		Date now = new Date()
		OrdersBuilder.build{
			orders '000-00000-00', '000-00000-01', '000-00000-02', '000-00000-03'

			order('000-00000-00').hasType('Local Storage').hasSeller('Seller 1').hasSumm(10.30).and().hasOrderDate(now)
			order('000-00000-01').hasType('Main Stoarage ').hasSeller('Seller 2').hasSumm(11.30).and().hasOrderDate(DateGroovyMethods.previous(now))
			order('000-00000-02').hasType('Direct Move').hasSeller('Seller 3').hasSumm(12.30).and().hasOrderDate(DateGroovyMethods.previous(DateGroovyMethods.previous(now)))
			order('000-00000-03').hasType('indirrect Move').hasSeller('Seller 4').hasSumm(13.30).and().hasOrderDate(DateGroovyMethods.previous(DateGroovyMethods.previous(DateGroovyMethods.previous(now))))
		}.each {
			it.value.save(flush:true)
		}
		def df = new SimpleDateFormat('yyyy-MM-dd')
		render "orders generated succesfully ${df.format(now)}"
	}

	def deleteOrders = {

		Orders.findAll().each { it.delete()  }
		render 'orders deleted succesfully'
	}

	def generateCompleteOrders = {
		def price = Price.build()
		price.save(flush:true)
		def completeOrder = CompleteOrder.build(price: price)
		completeOrder.save(flush:true)
		render 'complete orders generated succesfully'
	}

	def generatePrices = {
		def price = Price.build()
		price.save(flush:true)
		render 'prices generated succesfully'
	}
}
