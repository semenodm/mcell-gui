package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class Grid extends Module{
	def debugId

	static content = {
		grid {
			$('div', id: "gwt-debug-${debugId}").find('.x-grid3-body')
		}
		rows{ grid.find('table[class*=row-table]') }
		size{ rows.size() }
		row{row-> rows[row] }
	}
}
