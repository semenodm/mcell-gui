package com.palmagroup.gwt.orders.client.gin;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.inject.client.AbstractGinModule;
import com.palmagroup.gwt.orders.client.controller.CustomerInfoController;
import com.palmagroup.gwt.orders.client.controller.OrderDetailsController;
import com.palmagroup.gwt.orders.client.controller.OrderInfoController;
import com.palmagroup.gwt.orders.client.root.DispatcherProvider;
import com.palmagroup.gwt.orders.client.view.CustomerInfoTab;
import com.palmagroup.gwt.orders.client.view.MultiEntityView;
import com.palmagroup.gwt.orders.client.view.OrderDetailsTab;
import com.palmagroup.gwt.orders.client.view.OrderEditPanel;
import com.palmagroup.gwt.orders.client.view.OrderInfoTab;
import com.palmagroup.gwt.orders.client.view.OrdersPanel;
import com.palmagroup.gwt.orders.client.view.SingleEntityView;


public class OrdersModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(Dispatcher.class).toProvider(DispatcherProvider.class);
		setupViews();
		setupControllers();
		setupServices();
	}

	private void setupServices() {
		bind(HttpCustomerService.class).annotatedWith(DefaultHttpCustomerService.Key.class).to(
				DefaultHttpCustomerService.class);
		bind(HttpOrderService.class).annotatedWith(DefaultHttpOrderService.Key.class).to(
				DefaultHttpOrderService.class);
		bind(HttpService.class).annotatedWith(DefaultHttpService.Key.class).to(DefaultHttpService.class);
	}

	private void setupControllers() {
		bind(OrderInfoController.class).asEagerSingleton();
		bind(CustomerInfoController.class).asEagerSingleton();
		bind(OrderDetailsController.class).asEagerSingleton();
	}

	private void setupViews() {
		bind(ContentPanel.class).annotatedWith(OrdersPanel.Key.class).to(OrdersPanel.class);
		bind(FormPanel.class).annotatedWith(OrderEditPanel.Key.class).to(OrderEditPanel.class);
		bind(SingleEntityView.class).annotatedWith(OrderInfoTab.Key.class).to(OrderInfoTab.class);
		bind(TabItem.class).annotatedWith(OrderInfoTab.Key.class).to(OrderInfoTab.class);
		bind(SingleEntityView.class).annotatedWith(CustomerInfoTab.Key.class).to(CustomerInfoTab.class);
		bind(TabItem.class).annotatedWith(CustomerInfoTab.Key.class).to(CustomerInfoTab.class);
		bind(TabItem.class).annotatedWith(OrderDetailsTab.Key.class).to(OrderDetailsTab.class);
		bind(MultiEntityView.class).annotatedWith(OrderDetailsTab.Key.class).to(OrderDetailsTab.class);
	}

}
