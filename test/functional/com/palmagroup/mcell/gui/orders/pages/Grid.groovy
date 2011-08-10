package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class Grid extends Module{
	def debugId

	static content = {
		grid {
			$('div', id: "gwt-debug-${debugId}").find('.x-grid3-body')
		}
		rows{ grid.find('table[class*=row-table]') }
		expandRow { row ->
			grid.find('.x-grid3-row-expander')[row]
		}
		size{ rows.size() }
		row{row-> rows[row] }

		expandedForm{ module OrderForm}
	}
}