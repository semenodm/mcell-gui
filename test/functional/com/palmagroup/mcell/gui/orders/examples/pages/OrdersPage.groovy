package com.palmagroup.mcell.gui.orders.examples.pages

class OrdersPage {

	Grid ordersGrid
	def driver

	public OrdersPage(def driver){
		this.driver = driver;
		ordersGrid = new Grid(driver)
	}

	void open(){
		driver.get("http://localhost:8080/mcell-gui/ordersControl/orders")
	}
}