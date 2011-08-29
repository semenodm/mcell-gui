package com.palmagroup.mcellgui.customer

import grails.converters.JSON

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.palmagroup.mcell.gui.customer.Customer

class CustomerController {
	private Logger LOG = LoggerFactory.getLogger(CustomerController.class)
	def retrieveCustomer = {
		LOG.debug("PARAMS ${params}");
		def custId = params['customerId']
		LOG.debug("getting customer by ${custId}");
		def customer = Customer.get(custId as Integer)
		render customer as JSON
	}
}
