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
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.extjs.gxt.ui.client.widget.grid.WidgetRowRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.ui.Widget;

public class OrdersPanel extends ContentPanel {

	public OrdersPanel() {
		setHeading("Orders");
		setTitleCollapse(true);
		FillLayout fillLayout = new FillLayout(Orientation.HORIZONTAL);
		fillLayout.setAdjustForScroll(true);
		setLayout(fillLayout);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		
		final WidgetExpander<ModelData> expander = new WidgetExpander<ModelData>(new WidgetRowRenderer<ModelData>() {

            public Widget render(final ModelData model, final int rowIdx) {
                final OrderEditPanel retval = new OrderEditPanel(model);                

                return retval;
            }
        });
        
		configs.add(expander);

		ColumnConfig columnConfig = new ColumnConfig("orderNum", "Order Number", 150);
		configs.add(columnConfig);

		ColumnConfig clmncnfgSeller = new ColumnConfig("seller", "Seller", 150);
		configs.add(clmncnfgSeller);

		ColumnConfig clmncnfgCustomer = new ColumnConfig("customer", "Customer", 150);
		configs.add(clmncnfgCustomer);

		ColumnConfig clmncnfgSum = new ColumnConfig("sum", "Sum", 150);
		configs.add(clmncnfgSum);

		ColumnConfig clmncnfgCustomeradress = new ColumnConfig("customerAddress", "Customer Address", 150);
		configs.add(clmncnfgCustomeradress);

		ColumnConfig clmncnfgStatus = new ColumnConfig("status", "Status", 150);
		configs.add(clmncnfgStatus);

		ColumnConfig clmncnfgType = new ColumnConfig("type", "Type", 150);
		configs.add(clmncnfgType);

		ColumnConfig columnConfig_1 = new ColumnConfig("orderDate", "Order Date", 150);
		configs.add(columnConfig_1);
		
		ColumnConfig clmncnfgDiscount = new ColumnConfig("discount", "Discount", 150);
		configs.add(clmncnfgDiscount);

		ColumnConfig clmncnfgDiscount_1 = new ColumnConfig("discountPercent", "Discount %", 150);
		configs.add(clmncnfgDiscount_1);

		ColumnConfig clmncnfgPayment = new ColumnConfig("payment", "Payment", 150);
		configs.add(clmncnfgPayment);

		ColumnConfig clmncnfgPrice = new ColumnConfig("price", "Price", 150);
		configs.add(clmncnfgPrice);

		ColumnConfig clmncnfgCreditLimitPathed = new ColumnConfig("creditLimit", "Credit Limit <br> Pathed", 150);
		configs.add(clmncnfgCreditLimitPathed);

		ColumnConfig clmncnfgStockRemainsPathed = new ColumnConfig("stockLimit", "Stock remains <br> Pathed", 150);
		configs.add(clmncnfgStockRemainsPathed);

		ColumnConfig clmncnfgShippedDate = new ColumnConfig("shippedDate", "Shipped Date", 150);
		configs.add(clmncnfgShippedDate);
		
		ColumnConfig clmncnfgDescription = new ColumnConfig("description", "Description", 150);
		configs.add(clmncnfgDescription);

		ColumnModel cm = new ColumnModel(configs);

		String path = GWT.getHostPageBaseURL() + "../" + "orders/index";
		GWT.log(path);
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, path);  
	    HttpProxy<String> proxy = new HttpProxy<String>(builder);  

		ModelType type = new ModelType();
		type.setRoot("orders");
		type.addField("orderNum", "number");
		type.addField("orderDate", "orderedDate");
		type.addField("shippedDate", "shippedDate");
		type.addField("description", "description");
		type.addField("seller", "seller");
		type.addField("type", "orderType");
		type.addField("sum", "summPay");
		type.addField("seller", "seller");

	    JsonLoadResultReader<ListLoadResult<ModelData>> reader = new JsonLoadResultReader<ListLoadResult<ModelData>>(type);  
	  
	    final BaseListLoader<ListLoadResult<ModelData>> loader = new BaseListLoader<ListLoadResult<ModelData>>(proxy,  
	        reader);  
	  
	    ListStore<ModelData> store = new ListStore<ModelData>(loader);  

		final Grid<ModelData> grid = new Grid<ModelData>(store, cm);
		grid.setColumnLines(true);
		grid.addPlugin(expander);
		add(grid);
		grid.setBorders(true);
		grid.ensureDebugId("ORDERS_GRID");
		loader.load();
	}

}
