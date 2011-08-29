package com.palmagroup.gwt.orders.client.gin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.inject.BindingAnnotation;
import com.google.inject.Singleton;
import com.palmagroup.gwt.orders.client.controller.OrderDetailsController;

@Singleton
public class DefaultHttpOrderService implements HttpOrderService {

	@Override
	public void retrieveOrderDetails(String orderRef, final OrderDetailsController orderDetailsController) {
		String baseUrl = GWT.getHostPageBaseURL().replace("ordersControl", "orders");
		GWT.log("URL = " + baseUrl);
		String URL = baseUrl + "retrieveOrderDetails";
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, URL);
		requestBuilder.setHeader("Content-type", "application/x-www-form-urlencoded");
		GWT.log("orderRef=" + orderRef);
		try {
			requestBuilder.sendRequest("orderRef=" + orderRef, new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {

					Map<String, Object> decode = JsonConverter.decode(response.getText());

					List<ModelData> orderDetails = new ArrayList<ModelData>();
					for (Map model : (List<Map>)decode.get("orderDetails")) {
						orderDetails.add(new BaseModelData(model));
					} 

					orderDetailsController.onSuccess(orderDetails);
					// GWT.log("Data retrieved" + decode);
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
