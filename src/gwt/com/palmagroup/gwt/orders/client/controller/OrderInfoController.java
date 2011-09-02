package com.palmagroup.gwt.orders.client.controller;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;
import com.palmagroup.gwt.orders.client.view.OrderInfoTab;
import com.palmagroup.gwt.orders.client.view.SingleEntityView;


@Singleton
public class OrderInfoController extends Controller {
	private SingleEntityView orderInfoView;

	@Inject
	public OrderInfoController(Dispatcher dispatcher, @OrderInfoTab.Key SingleEntityView orderInfoView) {
		dispatcher.addController(this);
		registerEventTypes(OrdersInquiryEvents.ExpandRow.ORDER_ROW_EXPANDED);
		this.orderInfoView = orderInfoView;
	}

	@Override
	public String toString() {
		return "OrderInfoController";
	}

	@Override
	public void handleEvent(AppEvent event) {
		GWT.log(event + " has been handled by: " + this);
		orderInfoView.displayData((ModelData) event.getData());
	}


}
