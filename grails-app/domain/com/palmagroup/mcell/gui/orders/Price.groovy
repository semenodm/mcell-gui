package com.palmagroup.mcell.gui.orders

class Price {
	String name
	int code
	static constraints = {
	}
	static mapping = {
		table 'v_gui_prices'
		version false
		code generator:"assigned"
	}
}
