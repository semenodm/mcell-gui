package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class OrderForm extends Module {
	static content = {
		orderInfoTab{ module OrderInfoTabPageObject }
		customerInfoTab(required: false){ module CustomerInfoTabPageObject }
		orderDetailsTab(required: false){module OrderDetailsPageObject}
	}
}
