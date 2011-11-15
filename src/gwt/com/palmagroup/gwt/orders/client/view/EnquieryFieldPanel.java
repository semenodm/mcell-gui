package com.palmagroup.gwt.orders.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;

public class EnquieryFieldPanel extends LayoutContainer implements ParamHolder {

	private Label label;
	private SimpleComboBox<EnqueryOperators> comboBox;
	private TextField<String> text;

	public static class QueryFieldBuilder {
		private String fieldNameLabel;
		private List<EnqueryOperators> queryOperators = new ArrayList<EnqueryOperators>(2);
		private String fieldName;
		public QueryFieldBuilder setEnqueryFieldLabel(String string) {
			this.fieldNameLabel = string;
			return this;
		}

		public QueryFieldBuilder addQueryOperator(EnqueryOperators operator) {
			queryOperators.add(operator);
			return this;
		}

		public EnquieryFieldPanel build() {
			EnquieryFieldPanel enquieryFieldPanel = new EnquieryFieldPanel();
			enquieryFieldPanel.label.setText(fieldNameLabel);
			enquieryFieldPanel.text.setEmptyText(fieldName);
			
			for (EnqueryOperators queryOperator : queryOperators) {
				enquieryFieldPanel.comboBox.add(queryOperator);
			}
			return enquieryFieldPanel;
		}

		public QueryFieldBuilder setEnqueryFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
	}

	public EnquieryFieldPanel() {
		this(new RowLayout(Orientation.HORIZONTAL));

	}

	private EnquieryFieldPanel(Layout layout) {
		super(layout);
		label = new Label();
		add(label, new RowData(0.35, 1, new Margins(1)));
		comboBox = new SimpleComboBox<EnqueryOperators>();
		comboBox.setForceSelection(true);
		comboBox.setTriggerAction(TriggerAction.ALL);
		comboBox.setEditable(false);
		add(comboBox, new RowData(0.15, -1, new Margins(1)));
		comboBox.ensureDebugId("COMBO_CRITERIA");
		text = new TextField<String>();
		add(text, new RowData(0.5, 1, new Margins(1)));
		text.ensureDebugId("CRITERIA_VALUE");
		setSize(300, 30);
	}

	@Override
	public String getFieldName() {
		return text.getEmptyText();
	}

	@Override
	public String getFieldValue() {
		if (text.getValue() == null) {
			return null;
		}
		return comboBox.getSimpleValue().getGormPresentation() + ":" + text.getValue();
	}

}
