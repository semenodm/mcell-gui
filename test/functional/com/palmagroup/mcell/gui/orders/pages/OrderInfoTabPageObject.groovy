package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class OrderInfoTabPageObject extends Module {
	static content = {
		tab{
			$('div',id:contains(~/.*ORDER_INFO_TAB/))
		}
		nomNumber{
			tab.find("label", text:"Order Number:").next().find("input")
		}
		orderedDate{
			tab.find("label", text:"Ordered Date:").next().find("input")
		}
		shippedDate{
			tab.find("label", text:"Shipped Date:").next().find("input")
		}
		summ{
			tab.find("label", text:"Order Sum:").next().find("input")
		}
		seller{
			tab.find("label", text:"Seller:").next().find("input")
		}
		description{
			tab.find("textarea", id:"gwt-debug-DESCRIPTION_TEXT_AREA-input")
		}
	}
}