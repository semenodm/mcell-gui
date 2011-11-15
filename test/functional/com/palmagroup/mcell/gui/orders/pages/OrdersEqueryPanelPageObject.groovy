package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class OrdersEqueryPanelPageObject extends Module {
	def debugId
	static content ={
		panel {
			$('div', id: "gwt-debug-${debugId}")
		}
		orderNumberField{module EnqueryField, debugId:'ORDER_NUMBER_FIELD'}

		applyButton {$('button', text:'Apply filter')}
	}
}