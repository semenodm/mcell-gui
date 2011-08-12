package com.palmagroup.gwt.orders.client.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;

public class OrderEditPanel extends FormPanel {
	private TabItem orderInfoTab;

	@Inject
	public OrderEditPanel(@OrderInfoTab.Key TabItem orderInfoTab) {
		this.orderInfoTab = orderInfoTab;
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

		TabItem customerInfoTab = new CustomerInfoTab();
		tabPanel.add(customerInfoTab);

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
