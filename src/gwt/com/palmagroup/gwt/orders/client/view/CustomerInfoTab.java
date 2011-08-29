package com.palmagroup.gwt.orders.client.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CustomerInfoTab extends TabItem implements SingleEntityView {

	private ComboBox<ModelData> customerCombo;
	private ComboBox<ModelData> cmbxSalesOutlet;
	private TextField<Double> txtfldCustomerDept;
	private TextField<Double> txtfldDeptOverdue;
	private TextField<Double> txtfldCreditLimit;

	@Inject
	public CustomerInfoTab(final Dispatcher dispatcher) {
		super("Customer Info");
		setStyleAttribute("padding", "10px");
		setLayout(new FormLayout());

		customerCombo = new ComboBox<ModelData>();
		customerCombo.setStore(new ListStore());
		customerCombo.setDisplayField("name");
		add(customerCombo, new FormData("100%"));
		customerCombo.setFieldLabel("Customer");

		cmbxSalesOutlet = new ComboBox<ModelData>();
		cmbxSalesOutlet.setStore(new ListStore());
		add(cmbxSalesOutlet, new FormData("100%"));
		cmbxSalesOutlet.setFieldLabel("Sales Outlet");

		txtfldCustomerDept = new TextField<Double>();
		add(txtfldCustomerDept, new FormData("100%"));
		txtfldCustomerDept.setFieldLabel("Customer Dept");

		txtfldDeptOverdue = new TextField<Double>();
		add(txtfldDeptOverdue, new FormData("100%"));
		txtfldDeptOverdue.setFieldLabel("Dept Overdue");

		txtfldCreditLimit = new TextField<Double>();
		add(txtfldCreditLimit, new FormData("100%"));
		txtfldCreditLimit.setFieldLabel("Credit Limit");
		ensureDebugId("CUSTOMER_INFO_TAB");


	}

	@Override
	public void displayData(ModelData model) {
		customerCombo.setValue(model);
		//cmbxSalesOutlet;
		txtfldCustomerDept.setValue((Double) model.get("customerDept"));
		txtfldDeptOverdue.setValue((Double) model.get("deptOverdue"));
		txtfldCreditLimit.setValue((Double) model.get("creditLimit"));

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}

}
