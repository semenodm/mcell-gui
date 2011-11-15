package com.palmagroup.mcell.gui.orders.pages

import geb.Module

class CustomerInfoTabPageObject extends Module {
	static content = {
		tabName{ $('li', id:contains(~/.*CUSTOMER_INFO_TAB/)) }
		tab{ $('div',id:contains(~/.*CUSTOMER_INFO_TAB/)) }
		customer{
			tab.find("label", text:"Customer:").next().find("input")
		}
		salesOutlet{
			tab.find("label", text:"Sales Outlet:").next().find("input")
		}
		dept{
			tab.find("label", text:"Customer Dept:").next().find("input")
		}
		deptOverdue{
			tab.find("label", text:"Dept Overdue:").next().find("input")
		}
		creditLimit{
			tab.find("label", text:"Credit Limit:").next().find("input")
		}
	}
}
