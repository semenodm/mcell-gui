package com.palmagroup.gwt.orders.client.gin;

public interface JsonParser<MODEL> {
	MODEL parse(String response);
}
