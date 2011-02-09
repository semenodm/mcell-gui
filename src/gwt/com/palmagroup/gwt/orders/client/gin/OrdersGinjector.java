package com.palmagroup.gwt.orders.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.palmagroup.gwt.orders.client.view.OrdersHomePage;

@GinModules(OrdersModule.class)
public interface OrdersGinjector extends Ginjector {
	OrdersHomePage getHomepage();
}
