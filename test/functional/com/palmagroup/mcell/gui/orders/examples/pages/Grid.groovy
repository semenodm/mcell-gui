package com.palmagroup.mcell.gui.orders.examples.pages

import org.openqa.selenium.By

class Grid {
	def driver
	def gridWebElement
	def rows
	public Grid(Object driver) {
		super();
		this.driver = driver;
		gridWebElement = driver.findElement(By.id("//div[@id='gwt-debug-ORDERS_GRID']"))
		rows =	gridWebElement.findElements(By.xpath("//table[@class='x-grid3-row-table']"))
	}

	int size(){
		rows.size()
	}
}
