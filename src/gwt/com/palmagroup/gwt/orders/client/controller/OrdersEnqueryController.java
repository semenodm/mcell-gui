package com.palmagroup.gwt.orders.client.controller;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.palmagroup.gwt.orders.client.gin.DefaultHttpEnqueryService;
import com.palmagroup.gwt.orders.client.gin.HttpOrderEnqueryService;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents.ApplyFilterEvent;
import com.palmagroup.gwt.orders.client.view.MultiEntityView;
import com.palmagroup.gwt.orders.client.view.OrdersListPanel;

@Singleton
public class OrdersEnqueryController extends Controller implements AsyncCallback<List<ModelData>> {
	private MultiEntityView ordersView;
	private HttpOrderEnqueryService orderEnqueryService;

	@Inject
	public OrdersEnqueryController(Dispatcher dispatcher, @OrdersListPanel.Key MultiEntityView ordersView,
			@DefaultHttpEnqueryService.Key HttpOrderEnqueryService orderEnqueryService) {
		super();
		this.ordersView = ordersView;
		this.orderEnqueryService = orderEnqueryService;
		dispatcher.addController(this);
		registerEventTypes(OrdersInquiryEvents.ApplyFilterEvent.APPLY_ENQUERY_FILTER);
	}

	@Override
	public void handleEvent(AppEvent event) {
		ApplyFilterEvent applyFilterEvent = (ApplyFilterEvent) event;
		orderEnqueryService.enquery(applyFilterEvent.getParams(), this);

	}

	@Override
	public void onFailure(Throwable caught) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSuccess(List<ModelData> result) {
		ordersView.displayData(result);
	}
}
