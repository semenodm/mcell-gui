package com.palmagroup.gwt.orders.client.gin;



import java.util.HashMap;
import java.util.Map;



public class RequestParametersHolder {

	private String gwtModuleName;
	private String grailsControllerName;
	private String grailsControllerClosure;
	private Map<String, String> httpParams = new HashMap<String, String>();

	public String getGWTModuleName() {
		return gwtModuleName;
	}

	public String getGrailsControllerName() {

		return grailsControllerName;
	}

	public String getGrailsControllerClosure() {
		return grailsControllerClosure;
	}

	public String getHttpParams() {
		StringBuilder params = new StringBuilder();
		for (String key : httpParams.keySet()) {
			params.append(key + "=" + httpParams.get(key) + "&");
		}
		return params.toString();
	}

	public RequestParametersHolder addGWTModuleName(String moduleName) {
		this.gwtModuleName = moduleName;
		return this;

	}

	public RequestParametersHolder addGrailsControllerName(String controllerName) {
		this.grailsControllerName = controllerName;
		return this;
	}

	public RequestParametersHolder addGrailsControllerClosure(String closureName) {
		this.grailsControllerClosure = closureName;
		return this;
	}

	public RequestParametersHolder addHttpParam(String key, String value) {
		httpParams.put(key, value);
		return this;
	}

}
