package com.palmagroup.mcell.gui.orders
import geb.spock.GebReportingSpec

import geb.*
import geb.spock.GebReportingSpec

import java.text.SimpleDateFormat

import spock.lang.*

import com.palmagroup.mcell.gui.orders.pages.OrderDestroyerPage
import com.palmagroup.mcell.gui.orders.pages.OrdersGeneratorPage
import com.palmagroup.mcell.gui.orders.pages.OrdersPage
class OrdersPageSpec extends GebReportingSpec {
	def "lets open order page and vlidate if 4 orders are seen"(){
		when:
		to OrderDestroyerPage
		and:
		to OrdersGeneratorPage
		and:
		to OrdersPage
		then:
		assert ordersGrid.size == 4
	}

	def "i would like to expand rows to see order info"(){
		when:
		to OrderDestroyerPage
		and:
		to OrdersGeneratorPage
		and:
		to OrdersPage
		and:
		ordersGrid.expandRow(0).click()
		then:
		def now = new Date()
		def df = new SimpleDateFormat('yyyy-MM-dd')
		ordersGrid.expandedForm.orderInfoTab.nomNumber.value() == '000-00000-00'
		ordersGrid.expandedForm.orderInfoTab.orderedDate.value() == df.format(now)
		ordersGrid.expandedForm.orderInfoTab.shippedDate.value() == df.format(now)
		ordersGrid.expandedForm.orderInfoTab.description.attr('value') == 'description'
		ordersGrid.expandedForm.orderInfoTab.summ.value() == '10.3'
		ordersGrid.expandedForm.orderInfoTab.seller.value() == 'Seller 1'
	}

	def "i would like to expand rows to see customer info"(){
		when:
		to OrderDestroyerPage
		and:
		to OrdersGeneratorPage
		and:
		to OrdersPage
		and:
		ordersGrid.expandRow(0).click()
		and:
		ordersGrid.expandedForm.customerInfoTab.tabName.click()
		then:
		ordersGrid.expandedForm.customerInfoTab.customer.value() == 'customer_1'
		//ordersGrid.expandedForm.customerInfoTab.salesOutlet.value() == 'Customers 1 SalesOutlet'
		ordersGrid.expandedForm.customerInfoTab.dept.value() == '100.1'
		ordersGrid.expandedForm.customerInfoTab.deptOverdue.value() == '0'
		ordersGrid.expandedForm.customerInfoTab.creditLimit.value() == '1000.1'
	}

	def "i would like to expand rows to see order rows"(){
		when:
		to OrderDestroyerPage
		and:
		to OrdersGeneratorPage
		and:
		to OrdersPage
		and:
		ordersGrid.expandRow(0).click()
		and:
		ordersGrid.expandedForm.orderDetailsTab.tabName.click()
		then:
		ordersGrid.expandedForm.orderDetailsTab.details.size() == 3
	}
}