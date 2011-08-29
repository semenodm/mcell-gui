package com.palmagroup.mcell.gui.test
import com.palmagroup.mcell.gui.customer.Customer


import com.palmagroup.mcell.gui.customer.Customer

class CustomerBuilder {
	Customer customer

	def hasDept(double dept){
		customer.customerDept = dept
		this
	}
	def hasDeptOverdue(double overdue){
		customer.deptOverdue = overdue
		this
	}
	def hasCreditLimit(double limit){
		customer.creditLimit = limit
		this
	}

	def propertyMissing(String propertyName){
		System.out.println(propertyName);
		switch(propertyName){
			case 'and':
				return this
			default:
				this
		}
	}
}
