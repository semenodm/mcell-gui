package com.palmagroup.gwt.orders.client.view;

import static com.palmagroup.gwt.orders.client.view.EnqueryOperators.EQ;
import static com.palmagroup.gwt.orders.client.view.EnqueryOperators.LIKE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;
public class OrdersEnqueryPanel extends ContentPanel {

	private Dispatcher dispatcher;

	@Inject
	public OrdersEnqueryPanel(final Dispatcher dispatcher, @OrdersListPanel.Key ContentPanel orderListPanel,
			final @OrderEditPanel.Key FormPanel orderEditPanel) {
		this.dispatcher = dispatcher;
		setHeaderVisible(false);
		setTitleCollapse(true);
		RowLayout rowLayout = new RowLayout(Orientation.VERTICAL);
		rowLayout.setAdjustForScroll(true);
		setLayout(rowLayout);
		add(buildEnqueryPanel());
		add(orderListPanel, new RowData(1, 1, new Margins(4)));
	}

	private LayoutContainer buildEnqueryPanel() {
		TableLayout tableLayout2 = new TableLayout(1);
		LayoutContainer layoutContainer = new LayoutContainer(tableLayout2);
		tableLayout2.setWidth("100%");
		layoutContainer.ensureDebugId("ORDERS_ENQUERY_PANEL");

		ContentPanel enqueryPanel = new ContentPanel();
		enqueryPanel.setHeading("Orders Enquery");
		TableLayout tablelayout = new TableLayout(4);
		tablelayout.setHeight("20%");
		tablelayout.setWidth("100%");
		tablelayout.setCellVerticalAlign(VerticalAlignment.TOP);
		tablelayout.setCellHorizontalAlign(HorizontalAlignment.LEFT);
		tablelayout.setCellPadding(3);
		enqueryPanel.setLayout(tablelayout);

		layoutContainer.add(enqueryPanel);

		TableData layoutData = new TableData();

		layoutData.setWidth("20%");
		layoutData.setHeight("100%");
		final List<ParamHolder> paramHolders = new LinkedList<ParamHolder>();
		EnquieryFieldPanel.QueryFieldBuilder queryFieldBuilder = new EnquieryFieldPanel.QueryFieldBuilder();
		queryFieldBuilder.setEnqueryFieldLabel("Order Number").setEnqueryFieldName("number").addQueryOperator(EQ)
				.addQueryOperator(LIKE);
		EnquieryFieldPanel fieldPanel = queryFieldBuilder.build();
		enqueryPanel.add(fieldPanel, layoutData);
		paramHolders.add(fieldPanel);
		fieldPanel.ensureDebugId("ORDER_NUMBER_FIELD");

		queryFieldBuilder = new EnquieryFieldPanel.QueryFieldBuilder();
		queryFieldBuilder.setEnqueryFieldLabel("Customer Name").setEnqueryFieldName("customer").addQueryOperator(EQ)
				.addQueryOperator(LIKE);
		fieldPanel = queryFieldBuilder.build();
		enqueryPanel.add(fieldPanel, layoutData);
		paramHolders.add(fieldPanel);
		fieldPanel.ensureDebugId("CUSTOMER_FIELD");

		queryFieldBuilder = new EnquieryFieldPanel.QueryFieldBuilder();
		queryFieldBuilder.setEnqueryFieldLabel("Seller Name").setEnqueryFieldName("seller").addQueryOperator(EQ)
				.addQueryOperator(LIKE);
		fieldPanel = queryFieldBuilder.build();
		enqueryPanel.add(fieldPanel, layoutData);
		paramHolders.add(fieldPanel);
		fieldPanel.ensureDebugId("SELLER_FIELD");

		queryFieldBuilder = new EnquieryFieldPanel.QueryFieldBuilder();
		queryFieldBuilder.setEnqueryFieldLabel("Outlet Name").setEnqueryFieldName("customerAddres")
				.addQueryOperator(EQ)
				.addQueryOperator(LIKE);
		fieldPanel = queryFieldBuilder.build();
		enqueryPanel.add(fieldPanel, layoutData);
		paramHolders.add(fieldPanel);
		fieldPanel.ensureDebugId("OUTLET_FIELD");

		queryFieldBuilder = new EnquieryFieldPanel.QueryFieldBuilder();
		queryFieldBuilder.setEnqueryFieldLabel("Order Status").setEnqueryFieldName("status").addQueryOperator(EQ);
		fieldPanel = queryFieldBuilder.build();
		enqueryPanel.add(fieldPanel, layoutData);
		paramHolders.add(fieldPanel);
		fieldPanel.ensureDebugId("ORDER_STATUS_FIELD");

		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.CENTER);
		buttonBar.setSpacing(5);
		Button applyFilter = new Button("Apply filter");
		applyFilter.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Map<String, String> params = new HashMap<String, String>();
				for (ParamHolder paramHolder : paramHolders) {
					if (paramHolder.getFieldValue() != null && !paramHolder.getFieldValue().isEmpty()) {
						params.put(paramHolder.getFieldName(), paramHolder.getFieldValue());
					}
				}
				AppEvent event = new OrdersInquiryEvents.ApplyFilterEvent(params);
				dispatcher.dispatch(event);
			}
		});
		buttonBar.add(applyFilter);
		TableData tableData = new TableData(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		layoutContainer.add(buttonBar, tableData);

		return layoutContainer;

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}

}
