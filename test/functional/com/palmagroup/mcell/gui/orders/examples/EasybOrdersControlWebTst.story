package com.palmagroup.mcell.gui.orders.examples

import org.openqa.selenium.firefox.FirefoxDriver

import com.palmagroup.mcell.gui.orders.examples.pages.OrdersPage

scenario "ensure that number of rows on Orders control is 4 and expandin available",{
	OrdersPage page

	before "Generate test Data", {
		driver = new FirefoxDriver()
		driver.get("http://localhost:8080/mcell-gui/test/generateOrders")
		page = new OrdersPage(driver)
	}

	given "An opened Orders Control",{ page.open() }

	when "Klick on expander", {
		page.ordersGreed.rows[1].expand()
	}

	then "Orders info is available", {
		page.ordersGreed.rows[1].nomNumber.shouldBe '000-00000-00'
	}

	after "Delete test data",{
		driver.get("http://localhost:8080/mcell-gui/test/deleteOrders")
		driver.quit()
	}
}
