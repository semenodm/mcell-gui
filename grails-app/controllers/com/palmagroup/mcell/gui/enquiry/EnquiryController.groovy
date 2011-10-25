package com.palmagroup.mcell.gui.enquiry

import grails.converters.JSON

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.palmagroup.mcell.gui.orders.Orders

class EnquiryController {
	private Logger LOG = LoggerFactory.getLogger(EnquiryController.class)
	def index = {
	}

	def enquiry = {
		def parsedParams = JSON.parse(params.enquiry)
		String className = parsedParams['class']
		switch(className){
			case Orders:
				Orders.createCriteria()
				break;
		}
		className.createCriteria();
		render parsedParams as JSON
	}
}
