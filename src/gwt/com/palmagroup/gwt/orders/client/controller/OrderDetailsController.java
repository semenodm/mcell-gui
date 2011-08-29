package com.palmagroup.gwt.orders.client.controller;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.palmagroup.gwt.orders.client.gin.DefaultHttpOrderService;
import com.palmagroup.gwt.orders.client.gin.HttpOrderService;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents.ClickOrderEditorTab;
import com.palmagroup.gwt.orders.client.view.MultiEntityView;
import com.palmagroup.gwt.orders.client.view.OrderDetailsTab;

@Singleton
public class OrderDetailsController extends Controller implements AsyncCallback<List<ModelData>> {
	private MultiEntityView orderDetailsView;
	private HttpOrderService orderService;

	@Inject
	public OrderDetailsController(Dispatcher dispatcher, @OrderDetailsTab.Key MultiEntityView orderDetailsView,
			@DefaultHttpOrderService.Key HttpOrderService orderService) {
		super();
		dispatcher.addController(this);
		this.orderDetailsView = orderDetailsView;
		this.orderService = orderService;
		registerEventTypes(OrdersInquiryEvents.ClickOrderEditorTab.ORDER_EDIT_PANEL_TAB_CLICKED);
	}

	@Override
	public void handleEvent(AppEvent event) {
		OrdersInquiryEvents.ClickOrderEditorTab clickOrderEditorTabEvent = (ClickOrderEditorTab) event;
		if (clickOrderEditorTabEvent.getTabId().contains("ORDER_DETAILS_TAB")) {
			orderService.retrieveOrderDetails(event.getData().toString(), this);
		}

	}

	@Override
	public void onFailure(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSuccess(List<ModelData> data) {
		orderDetailsView.displayData(data);

	}

}
