package com.palmagroup.gwt.orders.client.gin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DefaultHttpCustomerService implements HttpCustomerService<ModelData> {


	private HttpService httpService;

	@Inject
	public DefaultHttpCustomerService(@DefaultHttpService.Key HttpService httpService) {
		super();
		this.httpService = httpService;
	}

	@Override
	public void retrieveCustomerInfo(String customerId, final AsyncCallback<ModelData> callback) {
		RequestParametersHolder paramsHolder = new RequestParametersHolder();
		paramsHolder.addGWTModuleName("ordersControl");
		paramsHolder.addGrailsControllerName("customer");
		paramsHolder.addGrailsControllerClosure("retrieveCustomer");
		paramsHolder.addHttpParam("customerId", customerId);

		JsonParser<ModelData> parser = new JsonParser<ModelData>() {

			@Override
			public ModelData parse(String response) {
				Map<String, Object> decode = JsonConverter.decode(response);
				return new BaseModelData(decode);
			}
		};
		httpService.processRequest(paramsHolder, parser, callback);
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}

}
