package com.palmagroup.mcell.gui.enquiry

import grails.test.*

class EnquiryControllerTests extends ControllerUnitTestCase {
	protected void setUp() {
		super.setUp()
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testEnquiryMainStorageOrders() {
		controller.request.contentType = "text/json"
		controller.params.enquiry= '''{"class":"com.palmagroup.mcell.gui.orders.Orders","groupOp":"OR", 
   "rules":[
      {
         "field":"foo1",
         "op":"le",
         "data":"9.5"
      },
      {
         "field":"foo2",
         "op":"eq",
         "data":"12345-123"
      },
      {
         "field":"foo3",
         "op":"cn",
         "data":"IDM"
      }
   ]}'''
		controller.enquiry()
		assert controller.response.contentAsString == '''{orders:[]}'''
	}
}
