package com.palmagroup.gwt.orders.client.gin;



import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HttpService {
	public <DATA> void processRequest(RequestParametersHolder paramsHolder, JsonParser<DATA> parser,
			AsyncCallback<DATA> callback);

}
