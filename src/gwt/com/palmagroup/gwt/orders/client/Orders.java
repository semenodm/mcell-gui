package com.palmagroup.gwt.orders.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.palmagroup.gwt.orders.client.gin.OrdersGinjector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Orders implements EntryPoint {
	public void onModuleLoad() {
		OrdersGinjector ginjector = GWT.create(OrdersGinjector.class);
		RootPanel.get().add(ginjector.getHomepage());
	}
}
