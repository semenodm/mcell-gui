package com.palmagroup.gwt.orders.client.gin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
public class DefaultHttpService implements HttpService {
	public <DATA> void processRequest(RequestParametersHolder paramsHolder, final JsonParser<DATA> parser,
			final AsyncCallback<DATA> callback) {

		String baseUrl = GWT.getHostPageBaseURL().replace(paramsHolder.getGWTModuleName(),
				paramsHolder.getGrailsControllerName());
		String URL = baseUrl + paramsHolder.getGrailsControllerClosure()+"?"+paramsHolder.getHttpParams();
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, URL);
		requestBuilder.setHeader("Content-type", "application/x-www-form-urlencoded");
		try {
			requestBuilder.sendRequest(null, new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						callback.onSuccess(parser.parse(response.getText()));
					} else {
						callback.onFailure(new Throwable("Error retrieving JSON data" + response.getStatusText()));
					}
				}

				@Override
				public void onError(Request arg0, Throwable e) {
					callback.onFailure(new Throwable("Error retrieving JSON data", e));
				}
			});
		} catch (RequestException e) {
			callback.onFailure(new Throwable("Error retrieving JSON data", e));
		}

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}

}
