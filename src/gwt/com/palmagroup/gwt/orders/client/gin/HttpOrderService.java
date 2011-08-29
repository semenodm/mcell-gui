package com.palmagroup.gwt.orders.client.gin;

import com.palmagroup.gwt.orders.client.controller.OrderDetailsController;

public interface HttpOrderService {

	void retrieveOrderDetails(String orderRef, OrderDetailsController orderDetailsController);

}
