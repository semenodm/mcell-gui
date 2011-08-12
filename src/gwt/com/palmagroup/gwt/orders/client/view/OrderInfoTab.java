package com.palmagroup.gwt.orders.client.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.inject.BindingAnnotation;
import com.google.inject.Singleton;

@Singleton
public class OrderInfoTab extends TabItem implements SingleEntityView {

	private TextField<String> txtfldSeller;
	private TextArea txtfldDescription;
	private TextField<String> txtfldOrderedNumber;
	private NumberField nmbrfldOrderSumm;
	private DateField dtfldOrderedDate;
	private static DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy-MM-dd\'T\'HH:mm:ss");
	private DateField dtfldShippedDate;

	public OrderInfoTab() {
		super();
		setText("Order Info");
		setStyleAttribute("padding", "5px");
		setLayout(new ColumnLayout());
		add(getLeftContainer(), new ColumnData(.5));
		add(getRightContainer(), new ColumnData(.5));
		ensureDebugId("ORDER_INFO_TAB");
	}

	private LayoutContainer getLeftContainer() {
		LayoutContainer left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		txtfldOrderedNumber = new TextField<String>();
		left.add(txtfldOrderedNumber, new FormData("100%"));
		txtfldOrderedNumber.setFieldLabel("Order Number");
		txtfldOrderedNumber.ensureDebugId("ORDER_NUMBER_TEXT_FIELD");

		nmbrfldOrderSumm = new NumberField();
		nmbrfldOrderSumm.setReadOnly(true);
		left.add(nmbrfldOrderSumm, new FormData("100%"));
		nmbrfldOrderSumm.setFieldLabel("Order Sum");

		dtfldOrderedDate = new DateField();
		left.add(dtfldOrderedDate, new FormData("100%"));
		dtfldOrderedDate.setFieldLabel("Ordered Date");
		

		dtfldShippedDate = new DateField();
		left.add(dtfldShippedDate, new FormData("100%"));
		dtfldShippedDate.setFieldLabel("Shipped Date");

		return left;
	}

	private LayoutContainer getRightContainer() {
		LayoutContainer right = new LayoutContainer();
		right.setStyleAttribute("paddingLeft", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		right.setLayout(layout);

		txtfldSeller = new TextField<String>();
		txtfldSeller.setReadOnly(true);
		right.add(txtfldSeller, new FormData("100%"));
		txtfldSeller.setFieldLabel("Seller");

		txtfldDescription = new TextArea();
		right.add(txtfldDescription, new FormData("100%"));
		txtfldDescription.setFieldLabel("Description");
		txtfldDescription.ensureDebugId("DESCRIPTION_TEXT_AREA");


		return right;
	}

	@Override
	public void displayData(ModelData model) {
		GWT.log("Displaying data " + model);
		txtfldDescription.setValue((String) model.get("description"));
		txtfldSeller.setValue((String) model.get("seller"));
		txtfldOrderedNumber.setValue((String) model.get("orderNum"));
		nmbrfldOrderSumm.setValue((Double) model.get("sum"));
		dtfldOrderedDate.setValue(dateFormat.parse((String) model.get("orderDate")));

		Object shippedDate = model.get("shippedDate");
		if (shippedDate != null) {
			dtfldShippedDate.setValue(dateFormat.parse((String) shippedDate));
		}

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}
}
