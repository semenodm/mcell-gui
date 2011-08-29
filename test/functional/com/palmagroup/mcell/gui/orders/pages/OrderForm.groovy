package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class OrderForm extends Module {
	static content = {
		orderInfoTab{ module OrderInfoTabPageObject }
		customerInfoTab{ module CustomerInfoTabPageObject }
		orderDetailsTab{module OrderDetailsPageObject}
	}
}
