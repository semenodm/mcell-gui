package com.palmagroup.gwt.orders.client.gin;

import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HttpCustomerService {
	
	public void retrieveCustomerInfo(String customerId, AsyncCallback<ModelData> callback);

}
