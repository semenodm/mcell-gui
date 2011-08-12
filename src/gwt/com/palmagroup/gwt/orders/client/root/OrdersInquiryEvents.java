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
			// TODO Auto-generated constructor stub
		}

	}

}
