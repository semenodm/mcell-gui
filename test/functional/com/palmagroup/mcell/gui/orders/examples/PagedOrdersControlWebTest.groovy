package com.palmagroup.mcell.gui.orders.examples;

import static org.junit.Assert.*

import org.codehaus.groovy.grails.plugins.webdriver.WebDriverTestCase
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

import com.palmagroup.mcell.gui.orders.examples.pages.OrdersPage

class PagedOrdersControlWebTest extends WebDriverTestCase {
	WebDriver driver
	OrdersPage page

	@Override
	protected void tearDown() throws Exception {
		driver.get("http://localhost:8080/mcell-gui/test/deleteOrders")
		driver.quit()
	}

	public void testThatNumberOfRowsAre4(){
		page.open()
		page.ordersGrid.size() == 4
	}

	@Override
	protected void setUp() throws Exception {
		driver = new FirefoxDriver()
		driver.get("http://localhost:8080/mcell-gui/test/generateOrders")
		page = new OrdersPage(driver)
	}
}
