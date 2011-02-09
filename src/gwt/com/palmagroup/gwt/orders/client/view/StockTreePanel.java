package com.palmagroup.gwt.orders.client.view;

import java.util.ArrayList;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;

public class StockTreePanel extends ContentPanel {

	public StockTreePanel() {
		setLayout(new FillLayout(Orientation.VERTICAL));

		TreeGrid treeGrid = new TreeGrid(new TreeStore(), new ColumnModel(new ArrayList<ColumnConfig>()));

		add(treeGrid);
		treeGrid.setBorders(true);
	}

}
