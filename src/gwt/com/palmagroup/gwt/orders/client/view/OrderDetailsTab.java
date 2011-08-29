package com.palmagroup.gwt.orders.client.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class OrderDetailsTab extends TabItem implements MultiEntityView {
	private Grid<ModelData> grid;
	private ListStore<ModelData> listStore;

	@Inject
	public OrderDetailsTab(final Dispatcher dispatcher) {
		super("Order Details");
		// ContentPanel cp = new ContentPanel();
		setStyleAttribute("padding", "10px");
		// setBodyBorder(true);
		// setHeading("Orders");
		// setButtonAlign(HorizontalAlignment.CENTER);
		setLayout(new FillLayout(Orientation.HORIZONTAL));
		// getHeader().setIconAltText("Grid Icon");
		setSize(600, 300);

		// setTitleCollapse(true);
		// add(cp);
		// FillLayout fillLayout = new FillLayout(Orientation.HORIZONTAL);
		// fillLayout.setAdjustForScroll(true);
		// setLayout(fillLayout);
		// setLayout(new FlowLayout(10));
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		

		ColumnConfig columnConfig = new ColumnConfig("displaySeq", "Display Sequence", 150);
		configs.add(columnConfig);

		columnConfig = new ColumnConfig("code", "Nomenclature <br> Number", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("name", "Nomenclature <br> Name", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("number", "Qty", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("measure", "Goods Measure", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("price", "Goods Price", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("summ", "Summ", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("summPay", "Summ and Tax", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("serialNumber", "Serial Number", 150);
		configs.add(columnConfig);
		
		columnConfig = new ColumnConfig("numberAccepted", "Accepted Count", 150);
		configs.add(columnConfig);

		listStore = new ListStore<ModelData>();
		grid = new Grid<ModelData>(listStore, new ColumnModel(configs));
		grid.setColumnLines(true);

		add(grid);
		grid.setBorders(true);
		grid.ensureDebugId("ORDER_DETAILS_GRID");
		ensureDebugId("ORDER_DETAILS_TAB"); // setTopComponent(grid);
	}

	@Override
	public void displayData(List<ModelData> data) {
		listStore.removeAll();
		listStore.add(data);
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}

}
