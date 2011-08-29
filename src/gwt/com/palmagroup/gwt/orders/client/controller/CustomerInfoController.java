package com.palmagroup.gwt.orders.client.controller;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.palmagroup.gwt.orders.client.gin.DefaultHttpCustomerService;
import com.palmagroup.gwt.orders.client.gin.HttpCustomerService;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents.ClickOrderEditorTab;
import com.palmagroup.gwt.orders.client.view.CustomerInfoTab;
import com.palmagroup.gwt.orders.client.view.SingleEntityView;

@Singleton
public class CustomerInfoController extends Controller implements AsyncCallback<ModelData> {

	private SingleEntityView customerEntityView;
	private HttpCustomerService customerService;

	@Inject
	public CustomerInfoController(Dispatcher dispatcher, @CustomerInfoTab.Key SingleEntityView customerEntityView,
			@DefaultHttpCustomerService.Key HttpCustomerService customerService) {
		super();
		dispatcher.addController(this);
		this.customerEntityView = customerEntityView;
		this.customerService = customerService;
		registerEventTypes(OrdersInquiryEvents.ClickOrderEditorTab.ORDER_EDIT_PANEL_TAB_CLICKED);

	}

	@Override
	public void handleEvent(AppEvent event) {
		OrdersInquiryEvents.ClickOrderEditorTab clickOrderEditorTabEvent = (ClickOrderEditorTab) event;
		if (clickOrderEditorTabEvent.getTabId().contains("CUSTOMER_INFO_TAB")) {
			customerService.retrieveCustomerInfo(event.getData().toString(), this);
		}
	}

	@Override
	public void onFailure(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSuccess(ModelData data) {
		customerEntityView.displayData(data);
	}

}
