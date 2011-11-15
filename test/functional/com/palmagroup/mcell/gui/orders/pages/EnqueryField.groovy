package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class EnqueryField extends Module {
	def debugId

	static content ={
		panel {
			$('div', id: "gwt-debug-${debugId}")
		}
		criteria{module ComboPageObject, debugId:'ORDER_NUMBER_FIELD'}
		pattern{panel.find('input', id:"gwt-debug-CRITERIA_VALUE-input")}
	}

	def selectCriteria(def crt, def patternVal){
		criteria.select(crt).click()
		pattern << patternVal
	}
}
