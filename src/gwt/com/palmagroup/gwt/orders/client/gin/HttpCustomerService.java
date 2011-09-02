package com.palmagroup.gwt.orders.client.gin;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HttpCustomerService<MODEL> {
	
	public void retrieveCustomerInfo(String customerId, AsyncCallback<MODEL> callback);

}
