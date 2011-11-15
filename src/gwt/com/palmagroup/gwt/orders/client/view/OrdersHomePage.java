package com.palmagroup.gwt.orders.client.view;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.inject.Inject;

public class OrdersHomePage extends Viewport {

	@Inject
	public OrdersHomePage(@OrdersEnqueryPanel.Key ContentPanel ordersPanel) {
		setBorders(true);
		setLayout(new BorderLayout());

		BorderLayoutData bld_ordersPanel = new BorderLayoutData(LayoutRegion.CENTER);
		bld_ordersPanel.setFloatable(false);
		add(ordersPanel, bld_ordersPanel);

		// StockTreePanel stockTreePanel = new StockTreePanel();
		// add(stockTreePanel, new BorderLayoutData(LayoutRegion.WEST));
	}

}
