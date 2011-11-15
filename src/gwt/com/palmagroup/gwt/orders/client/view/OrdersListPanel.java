package com.palmagroup.gwt.orders.client.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.WidgetExpander;
import com.extjs.gxt.ui.client.widget.grid.WidgetRowRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;

@Singleton
public class OrdersListPanel extends ContentPanel implements MultiEntityView {

	private ListStore<ModelData> store;
	private Grid<ModelData> grid;

	@Override
	public void displayData(List<ModelData> data) {
		GWT.log("displaying orders: " + data);
		store.removeAll();
		store.add(data);
	}

	@Inject
	public OrdersListPanel(final Dispatcher dispatcher, final @OrderEditPanel.Key FormPanel orderForm) {
		ensureDebugId("ORDERS_LIST_PANEL");
		setLayout(new FillLayout(Orientation.HORIZONTAL));
		setHeading("Orders");

		final WidgetExpander<ModelData> expander = new WidgetExpander<ModelData>(new WidgetRowRenderer<ModelData>() {

			public Widget render(final ModelData model, final int rowIdx) {
				final FormPanel retval = orderForm;
				return retval;

			}
		});

		expander.addListener(Events.BeforeExpand, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				expander.collapseAllRows();
			}
		});

		expander.addListener(Events.Expand, new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				OrdersInquiryEvents.ExpandRow event = new OrdersInquiryEvents.ExpandRow();
				event.setData(grid.getSelectionModel().getSelectedItem());
				dispatcher.dispatch(event);
				GWT.log(event.getType() + " Has been dispatched");
			}
		});
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(expander);

		ColumnConfig columnConfig = new ColumnConfig("number", "Order Number", 150);
		configs.add(columnConfig);

		ColumnConfig clmncnfgSeller = new ColumnConfig("seller", "Seller", 150);
		configs.add(clmncnfgSeller);
		ColumnConfig clmncnfgCustomer = new ColumnConfig("customer", "Customer", 150);
		configs.add(clmncnfgCustomer);
		ColumnConfig clmncnfgSum = new ColumnConfig("summ", "Sum", 150);
		configs.add(clmncnfgSum);
		ColumnConfig clmncnfgCustomeradress = new ColumnConfig("customerAddress", "Customer Address", 150);
		configs.add(clmncnfgCustomeradress);
		ColumnConfig clmncnfgStatus = new ColumnConfig("status", "Status", 150);
		configs.add(clmncnfgStatus);
		ColumnConfig clmncnfgType = new ColumnConfig("orderType", "Type", 150);
		configs.add(clmncnfgType);
		ColumnConfig columnConfig_1 = new ColumnConfig("orderedDate", "Order Date", 150);
		GridCellRenderer renderer = new GridCellRenderer<ModelData>() {

			@Override
			public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex,
					ListStore<ModelData> store, Grid<ModelData> grid) {
				return model.get(property);

			}
		};
		columnConfig_1.setRenderer(renderer);
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

		store = new ListStore<ModelData>();

		grid = new Grid<ModelData>(store, cm);
		grid.setColumnLines(true);
		grid.addPlugin(expander);
		add(grid);
		grid.setBorders(true);
		grid.ensureDebugId("ORDERS_GRID");
		grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<ModelData>() {

			@Override
			public void selectionChanged(SelectionChangedEvent<ModelData> se) {
				orderForm.setData("customerRef", se.getSelectedItem().get("customerRef"));
				orderForm.setData("orderRef", se.getSelectedItem().get("id"));

			}
		});
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}
}
