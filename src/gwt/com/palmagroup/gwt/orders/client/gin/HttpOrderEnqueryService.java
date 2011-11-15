package com.palmagroup.gwt.orders.client.gin;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface HttpOrderEnqueryService<DATA> {

	void enquery(Map<String, String> params, AsyncCallback<DATA> controller);

}
