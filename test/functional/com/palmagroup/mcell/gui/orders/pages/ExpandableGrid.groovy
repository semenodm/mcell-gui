package com.palmagroup.mcell.gui.orders.pages


class ExpandableGrid extends Grid{
	static content = {
		expandedForm(wait: [20, 1]){ module OrderForm}
	}
	def expandRow(def row){
		grid.find('div', class:'x-grid3-row-expander')[row]
	}
}