package com.palmagroup.mcell.gui.orders.pages

import geb.Page

class OrdersPage extends Page {
	static url = "http://localhost:8080/mcell-gui/ordersControl/orders"
	static content = {
		ordersGrid{ module ExpandableGrid, debugId:'ORDERS_GRID' }
	}
}
