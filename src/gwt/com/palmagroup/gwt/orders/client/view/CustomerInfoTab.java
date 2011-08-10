package com.palmagroup.gwt.orders.client.view;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class CustomerInfoTab extends TabItem {

	public CustomerInfoTab() {
		super("Customer Info");
		setStyleAttribute("padding", "10px");
		setLayout(new FormLayout());

		ComboBox customerCombo = new ComboBox();
		customerCombo.setStore(new ListStore());
		add(customerCombo, new FormData("100%"));
		customerCombo.setFieldLabel("Customer");

		ComboBox cmbxSalesOutlet = new ComboBox();
		cmbxSalesOutlet.setStore(new ListStore());
		add(cmbxSalesOutlet, new FormData("100%"));
		cmbxSalesOutlet.setFieldLabel("Sales Outlet");

		TextField txtfldCustomerDept = new TextField();
		add(txtfldCustomerDept, new FormData("100%"));
		txtfldCustomerDept.setFieldLabel("Customer Dept");

		TextField txtfldDeptOverdue = new TextField();
		add(txtfldDeptOverdue, new FormData("100%"));
		txtfldDeptOverdue.setFieldLabel("Dept Overdue");

		TextField txtfldCreditLimit = new TextField();
		add(txtfldCreditLimit, new FormData("100%"));
		txtfldCreditLimit.setFieldLabel("Credit Limit");
		ensureDebugId("CUSTOMER_INFO_TAB");
	}
}
