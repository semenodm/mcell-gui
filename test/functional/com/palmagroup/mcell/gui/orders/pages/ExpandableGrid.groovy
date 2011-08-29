package com.palmagroup.mcell.gui.orders.pages


class ExpandableGrid extends Grid{
	static content = {
		expandRow { row ->
			grid.find('.x-grid3-row-expander')[row]
		}
		expandedForm{ module OrderForm}
	}
}