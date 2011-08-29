package com.palmagroup.gwt.orders.client.gin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.BindingAnnotation;
import com.google.inject.Singleton;

@Singleton
public class DefaultHttpCustomerService implements HttpCustomerService {

	@Override
	public void retrieveCustomerInfo(String customerId, final AsyncCallback<ModelData> callback) {
		String baseUrl = GWT.getHostPageBaseURL().replace("ordersControl", "customer");
		String URL = baseUrl + "retrieveCustomer";
		GWT.log("URL = " + URL);
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, URL);
		requestBuilder.setHeader("Content-type", "application/x-www-form-urlencoded");
		try {
			requestBuilder.sendRequest("customerId=" + customerId, new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {

					Map<String, Object> decode = JsonConverter.decode(response.getText());
					
					callback.onSuccess(new BaseModelData(decode));
					// GWT.log("Data retrieved" + response.getText());
				}
				
				@Override
				public void onError(Request arg0, Throwable e) {
					GWT.log("Error retrieving JSON data", e);

				}
			});
		} catch (RequestException e) {
			GWT.log("Error retrieving JSON data", e);
		}
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}

}
