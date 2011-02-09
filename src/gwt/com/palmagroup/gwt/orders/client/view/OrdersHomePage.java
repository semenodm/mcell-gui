package com.palmagroup.gwt.orders.client.view;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class OrdersHomePage extends Viewport {
	public OrdersHomePage() {
		setBorders(true);
		setLayout(new BorderLayout());

		OrdersPanel ordersPanel = new OrdersPanel();
		BorderLayoutData bld_ordersPanel = new BorderLayoutData(LayoutRegion.CENTER);
		bld_ordersPanel.setFloatable(false);
		add(ordersPanel, bld_ordersPanel);

		// StockTreePanel stockTreePanel = new StockTreePanel();
		// add(stockTreePanel, new BorderLayoutData(LayoutRegion.WEST));
	}

}
