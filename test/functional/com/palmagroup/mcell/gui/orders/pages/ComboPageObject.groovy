package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class ComboPageObject extends Module {
	def debugId
	static content ={
		panel {
			$('div', id: "gwt-debug-${debugId}")
		}
	}
	def select(def operation){
		panel.find('input', id:"gwt-debug-COMBO_CRITERIA-input").click()
		$('div', class:'x-combo-list-item', text:contains(operation))
	}
}
