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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DefaultHttpOrderService implements HttpOrderService<List<ModelData>> {

	private HttpService httpService;

	@Inject
	public DefaultHttpOrderService(@DefaultHttpService.Key HttpService httpService) {
		super();
		this.httpService = httpService;
	}

	@Override
	public void retrieveOrderDetails(String orderRef, final AsyncCallback<List<ModelData>> modelController) {

		RequestParametersHolder paramsHolder = new RequestParametersHolder();
		paramsHolder.addGWTModuleName("ordersControl");
		paramsHolder.addGrailsControllerName("orders");
		paramsHolder.addGrailsControllerClosure("retrieveOrderDetails");
		paramsHolder.addHttpParam("orderRef", orderRef);

		JsonParser<List<ModelData>> parser = new JsonParser<List<ModelData>>() {

			@Override
			public List<ModelData> parse(String response) {
				Map<String, Object> decode = JsonConverter.decode(response);

				List<ModelData> orderDetails = new ArrayList<ModelData>();
				for (Map<String, Object> model : (List<Map<String, Object>>) decode.get("orderDetails")) {
					orderDetails.add(new BaseModelData(model));
				}

				return orderDetails;
			}
		};
		httpService.processRequest(paramsHolder, parser, modelController);

	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}
}
