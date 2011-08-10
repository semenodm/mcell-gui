package com.palmagroup.gwt.orders.client.view;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class OrderEditPanel extends FormPanel {

	public OrderEditPanel(ModelData model) {
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

		TabItem orderInfoTab = new OrderInfoTab(model);
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

}
