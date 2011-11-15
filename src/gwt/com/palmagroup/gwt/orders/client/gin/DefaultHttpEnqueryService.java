package com.palmagroup.gwt.orders.client.gin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.extjs.gxt.ui.client.data.DataField;
import com.extjs.gxt.ui.client.data.JsonReader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class DefaultHttpEnqueryService implements HttpOrderEnqueryService<List<ModelData>> {

	HttpService service;

	@Inject
	public DefaultHttpEnqueryService(@DefaultHttpService.Key HttpService service) {
		super();
		this.service = service;
	}

	@Override
	public void enquery(Map<String, String> params, AsyncCallback<List<ModelData>> controller) {
		RequestParametersHolder paramsHolder = new RequestParametersHolder();
		paramsHolder.addGWTModuleName("ordersControl");
		paramsHolder.addGrailsControllerName("api");
		paramsHolder.addGrailsControllerClosure("orders");
		for (Entry<String, String> entry : params.entrySet()) {
			paramsHolder.addHttpParam(entry.getKey(), entry.getValue());
		}

		JsonParser<List<ModelData>> parser = new JsonParser<List<ModelData>>() {

			@Override
			public List<ModelData> parse(String response) {

				ModelType modelType = new ModelType();
				modelType.setRoot("data");
				modelType.addField("number", "number");
				modelType.addField("orderedDate", "orderedDate");
				modelType.addField("shippedDate", "shippedDate");
				modelType.addField("description", "description");
				modelType.addField("seller", "seller");
				modelType.addField("orderType", "orderType");
				modelType.addField("summ", "summ");
				modelType.addField("seller", "seller");
				DataField dataField = new DataField("customerRef", "customerRef");
				dataField.setType(Integer.class);
				modelType.addField(dataField);
				dataField = new DataField("id", "id");
				dataField.setType(Integer.class);
				modelType.addField(dataField);

				JsonReader<List<ModelData>> reader = new JsonReader<List<ModelData>>(modelType);
				List<ModelData> read = reader.read(null, response);
				// Map<String, Object> decode = JsonConverter.decode(response);
				//
				// List<ModelData> orders = new ArrayList<ModelData>();
				// for (Map<String, Object> model : (List<Map<String, Object>>)
				// decode.get("data")) {
				// orders.add(new BaseModelData(model));
				// }

				return read;
			}
		};
		service.processRequest(paramsHolder, parser, controller);
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD, ElementType.PARAMETER })
	@BindingAnnotation
	public @interface Key {

	}
}
