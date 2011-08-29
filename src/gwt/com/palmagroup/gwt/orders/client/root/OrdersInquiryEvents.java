package com.palmagroup.gwt.orders.client.root;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;

public class OrdersInquiryEvents {

	public static class ExpandRow extends AppEvent {
		@Override
		public String toString() {

			return "ORDER_ROW_EXPANDED";
		}

		public static final EventType ORDER_ROW_EXPANDED = new EventType();

		public ExpandRow() {
			super(ORDER_ROW_EXPANDED);
		}

	}

	public static class ClickOrderEditorTab extends AppEvent {
		private String tabId;

		@Override
		public String toString() {
			return "ORDEREDIT_PANEL_TAB_CLICKED";
		}

		public static final EventType ORDER_EDIT_PANEL_TAB_CLICKED = new EventType();

		public ClickOrderEditorTab(String tabId) {
			super(ORDER_EDIT_PANEL_TAB_CLICKED);
			this.setTabId(tabId);
		}

		public void setTabId(String tabId) {
			this.tabId = tabId;
		}

		public String getTabId() {
			return tabId;
		}

	}

}
