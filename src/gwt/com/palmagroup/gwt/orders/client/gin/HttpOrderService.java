package com.palmagroup.gwt.orders.client.gin;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HttpOrderService<DATA> {

	void retrieveOrderDetails(String orderRef, AsyncCallback<DATA> orderDetailsController);

}
