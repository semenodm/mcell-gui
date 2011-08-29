package com.palmagroup.gwt.orders.client.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.palmagroup.gwt.orders.client.root.OrdersInquiryEvents;

public class OrderEditPanel extends FormPanel {
	private TabItem orderInfoTab;
	private TabItem customerInfoTab;
	private TabItem orderDetailsTab;
	private Dispatcher dispatcher;

	@Inject
	public OrderEditPanel(Dispatcher dispatcher, @OrderInfoTab.Key TabItem orderInfoTab,
			@CustomerInfoTab.Key TabItem customerInfoTab, @OrderDetailsTab.Key TabItem orderDetailsTab) {
		this.orderInfoTab = orderInfoTab;
		this.customerInfoTab = customerInfoTab;
		this.orderDetailsTab = orderDetailsTab;
		this.dispatcher = dispatcher;
		initForm();

	}

	private void initForm() {
		setLabelAlign(LabelAlign.TOP);
		setButtonAlign(HorizontalAlignment.CENTER);
		setHeaderVisible(false);
		setSize(600, -1);
		setLayout(new FitLayout());

		ComboBox cmbxStock = new ComboBox();
		cmbxStock.setStore(new ListStore());
		// right.add(cmbxStock, new FormData("100%"));
		cmbxStock.setFieldLabel("Stock");

		ComboBox cmbxPrice = new ComboBox();
		cmbxPrice.setStore(new ListStore());
		// left.add(cmbxPrice, new FormData("100%"));
		cmbxPrice.setFieldLabel("Price");

		ComboBox cmbxPayment = new ComboBox();
		cmbxPayment.setStore(new ListStore());
		// left.add(cmbxPayment, new FormData("100%"));
		cmbxPayment.setFieldLabel("Payment");



		TabPanel tabPanel = new TabPanel();


		tabPanel.add(orderInfoTab);
		tabPanel.add(customerInfoTab);
		customerInfoTab.addListener(Events.Select, new Listener<TabPanelEvent>() {

			@Override
			public void handleEvent(TabPanelEvent be) {
				OrdersInquiryEvents.ClickOrderEditorTab event = new OrdersInquiryEvents.ClickOrderEditorTab(be
						.getItem().getId());
				event.setData(getData("customerRef"));
				dispatcher.dispatch(event);
			}
		});
		tabPanel.add(orderDetailsTab);
		orderDetailsTab.addListener(Events.Select, new Listener<TabPanelEvent>() {
			@Override
			public void handleEvent(TabPanelEvent be) {
				OrdersInquiryEvents.ClickOrderEditorTab event = new OrdersInquiryEvents.ClickOrderEditorTab(be
						.getItem().getId());
				event.setData(getData("orderRef"));
				dispatcher.dispatch(event);
			}
		});

		add(tabPanel);
		setTopComponent(tabPanel);


		Button btnCancel = new Button("Cancel");
		addButton(btnCancel);

		Button btnSave = new Button("Save");
		addButton(btnSave);
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}
}
