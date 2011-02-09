package com.palmagroup.gwt.orders.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.JsonLoadResultReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;

public class OrdersPanel extends ContentPanel {

	public OrdersPanel() {
		setTitleCollapse(true);
		FillLayout fillLayout = new FillLayout(Orientation.HORIZONTAL);
		fillLayout.setAdjustForScroll(true);
		setLayout(fillLayout);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();


		ColumnConfig columnConfig = new ColumnConfig("orderNum", "Order Number", 150);
		configs.add(columnConfig);

		ColumnConfig columnConfig_1 = new ColumnConfig("orderDate", "Order Date", 150);
		configs.add(columnConfig_1);

		ColumnModel cm = new ColumnModel(configs);

		String path = GWT.getHostPageBaseURL() + "../" + "orders/index";
		GWT.log(path);
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, path);  
	    HttpProxy<String> proxy = new HttpProxy<String>(builder);  

		ModelType type = new ModelType();
		type.setRoot("orders");
		type.addField("orderNum", "number");
		type.addField("orderDate", "orderedDate");

	    JsonLoadResultReader<ListLoadResult<ModelData>> reader = new JsonLoadResultReader<ListLoadResult<ModelData>>(type);  
	  
	    final BaseListLoader<ListLoadResult<ModelData>> loader = new BaseListLoader<ListLoadResult<ModelData>>(proxy,  
	        reader);  
	  
	    ListStore<ModelData> store = new ListStore<ModelData>(loader);  

		final Grid<ModelData> grid = new Grid<ModelData>(store, cm);
		grid.setColumnLines(true);
		add(grid);
		grid.setBorders(true);
		loader.load();
	}

}
