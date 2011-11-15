package com.palmagroup.mcell.gui.orders;

import static org.hamcrest.core.Is.*
import static org.junit.Assert.*
import groovy.util.GroovyTestCase
import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

class OrdersRESTTest extends GroovyTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		actionOrders('generateOrders')
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		actionOrders('deleteOrders')
	}

	void actionOrders(def action){
		def client = new RESTClient("http://localhost:8080/mcell-gui/test/")
		client.get(path: action)
	}

	void testCRUD() {
		def client = new RESTClient("http://localhost:8080/mcell-gui/api/")
		def response
		response = client.get(
				path: "orders",
				params: [number: "eq:000-00000-01",
					orderType: "eq:Main Stoarage"],
				requestContentType : ContentType.JSON.toString()
				)
		assertThat(response.responseData.data.size(), is(1))
	}
}