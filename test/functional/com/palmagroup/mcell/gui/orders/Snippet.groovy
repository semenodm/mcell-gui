package com.palmagroup.mcell.gui.orders
import geb.*

Browser.drive {
	go "http://google.com"
	$("input[name=q]").value() << "Chuck Norris"
	$("input[value=Google ]").click()
	assert $("li.g", 0).get("a.l").text() ==~ /Chuck/
}