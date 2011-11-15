package com.palmagroup.gwt.orders.client.view;

public enum EnqueryOperators {
	EQ("=", "eq"), LIKE("like", "like"), MORE(">", "more"), LESS("<", "less"), BETWEEN("between", "between");

	private String criteriaOperator;
	private String gormPresentation;

	private EnqueryOperators(String criteriaOperator, String presentation) {
		this.criteriaOperator = criteriaOperator;
		this.gormPresentation = presentation;
	}

	public String toString() {
		return criteriaOperator;
	}

	public String getGormPresentation() {
		return gormPresentation;
	}

}