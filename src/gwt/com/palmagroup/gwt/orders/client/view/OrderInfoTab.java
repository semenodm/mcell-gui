package com.palmagroup.gwt.orders.client.view;

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
import com.google.gwt.i18n.client.DateTimeFormat;

public class OrderInfoTab extends TabItem {

	public OrderInfoTab(ModelData model) {
		super();
		setText("Order Info");
		setStyleAttribute("padding", "5px");
		setLayout(new ColumnLayout());
		add(getLeftContainer(model), new ColumnData(.5));
		add(getRightContainer(model), new ColumnData(.5));
		ensureDebugId("ORDER_INFO_TAB");
	}

	private LayoutContainer getLeftContainer(ModelData model) {
		LayoutContainer left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		TextField<String> txtfldOrderedNumber = new TextField<String>();
		left.add(txtfldOrderedNumber, new FormData("100%"));
		txtfldOrderedNumber.setFieldLabel("Order Number");
		txtfldOrderedNumber.setValue((String) model.get("orderNum"));
		txtfldOrderedNumber.ensureDebugId("ORDER_NUMBER_TEXT_FIELD");

		NumberField nmbrfldOrderSumm = new NumberField();
		nmbrfldOrderSumm.setReadOnly(true);
		left.add(nmbrfldOrderSumm, new FormData("100%"));
		nmbrfldOrderSumm.setFieldLabel("Order Sum");
		nmbrfldOrderSumm.setValue((Double) model.get("sum"));

		DateField dtfldOrderedDate = new DateField();
		left.add(dtfldOrderedDate, new FormData("100%"));
		dtfldOrderedDate.setFieldLabel("Ordered Date");
		DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy-MM-dd\'T\'HH:mm:ss");
		dtfldOrderedDate.setValue(dateFormat.parse((String) model.get("orderDate")));

		DateField dtfldShippedDate = new DateField();
		left.add(dtfldShippedDate, new FormData("100%"));
		dtfldShippedDate.setFieldLabel("Shipped Date");
		Object shippedDate = model.get("shippedDate");
		if (shippedDate != null) {
			dtfldShippedDate.setValue(dateFormat.parse((String) shippedDate));
		}

		return left;
	}

	private LayoutContainer getRightContainer(ModelData model) {
		LayoutContainer right = new LayoutContainer();
		right.setStyleAttribute("paddingLeft", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		right.setLayout(layout);

		TextField txtfldSeller = new TextField();
		txtfldSeller.setReadOnly(true);
		right.add(txtfldSeller, new FormData("100%"));
		txtfldSeller.setFieldLabel("Seller");
		txtfldSeller.setValue(model.get("seller"));

		TextArea txtfldDescription = new TextArea();
		right.add(txtfldDescription, new FormData("100%"));
		txtfldDescription.setFieldLabel("Description");
		txtfldDescription.setValue((String) model.get("description"));
		txtfldDescription.ensureDebugId("DESCRIPTION_TEXT_AREA");


		return right;
	}
}
