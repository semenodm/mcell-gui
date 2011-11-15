package com.palmagroup.mcell.gui.orders.examples;

import static org.junit.Assert.*

import org.codehaus.groovy.grails.plugins.webdriver.WebDriverTestCase
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class OrdersControlWebTest extends WebDriverTestCase {
	WebDriver driver
	@Override
	protected void tearDown() throws Exception {
		driver.get("http://localhost:8080/mcell-gui/test/deleteOrders")
		driver.quit()
	}

	public void testThatNumberOfRowsAre4(){
		driver.get("http://localhost:8080/mcell-gui/ordersControl/orders")
		assert driver.findElement(By.xpath("//div[@id='gwt-debug-ORDERS_GRID']"))
		.findElements(By.xpath("//table[@class='x-grid3-row-table']"))
		.size() == 5
	}

	@Override
	protected void setUp() throws Exception {
		driver = new FirefoxDriver()
		driver.get("http://localhost:8080/mcell-gui/test/generateOrders")
	}
}
