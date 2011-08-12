package com.palmagroup.gwt.orders.client.root;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.inject.Provider;

public class DispatcherProvider implements Provider<Dispatcher> {

	@Override
	public Dispatcher get() {
		return Dispatcher.get();
	}

}
