package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class Grid extends Module{
	def debugId

	static content = {
		grid {
			$('div', id: "gwt-debug-${debugId}")//.find('.x-grid3-body')
		}
		rows(wait: [20, 1]){grid.find('div', class:'x-grid3-row')}
	}

	def row(def rowNum){
		rows[row]
	}
	def size(){
		rows.size()
	}
}
