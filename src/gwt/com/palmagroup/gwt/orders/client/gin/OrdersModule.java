package com.palmagroup.gwt.orders.client.gin;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.inject.client.AbstractGinModule;
import com.palmagroup.gwt.orders.client.controller.OrderInfoController;
import com.palmagroup.gwt.orders.client.root.DispatcherProvider;
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

	}

	private void setupControllers() {
		bind(OrderInfoController.class).asEagerSingleton();
		
	}

	private void setupViews() {
		bind(ContentPanel.class).annotatedWith(OrdersPanel.Key.class).to(OrdersPanel.class);
		bind(FormPanel.class).annotatedWith(OrderEditPanel.Key.class).to(OrderEditPanel.class);
		bind(SingleEntityView.class).annotatedWith(OrderInfoTab.Key.class).to(OrderInfoTab.class);
		bind(TabItem.class).annotatedWith(OrderInfoTab.Key.class).to(OrderInfoTab.class);
	}

}
