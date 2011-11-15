package com.palmagroup.mcell.gui.orders.pages

import geb.Page

class OrdersPage extends Page {
	static url = "http://localhost:8080/mcell-gui/ordersControl/orders"
	static content = {
		enqueryPanel{module OrdersEqueryPanelPageObject, debugId:'ORDERS_ENQUERY_PANEL'}
		ordersGrid(wait: [20, 1]){ module ExpandableGrid, debugId:'ORDERS_LIST_PANEL' }
	}
}
