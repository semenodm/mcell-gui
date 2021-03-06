package com.palmagroup.mcell.gui

class EnqueryService {

	def grailsApplication


	def serviceMethod() {
		grailsApplication.domainClasses.each{ domainClass ->
			domainClass.metaClass.'static'.enquire = { params ->
				this.createEnquiry(delegate, params, 'list')
			}
			domainClass.metaClass.'static'.enquireCount = { params ->
				this.createEnquiry(delegate, params, 'count')
			}
		}
	}

	def createEnquiry(def domainClass, Map params, def type){
		domainClass.createCriteria()."$type"{
			and{
				params.each{
					if(![
						'action',
						'domain',
						'controller',
						'entity',
						'sortField',
						'sortDir'
					].contains(it.getKey())){
						def val = it.getValue()?.split(':')
						println("val = $val")
						"${val[0]}" (it.getKey(), val[1])
					}
				}
			}
		}
		//domainClass.list(max:5, sort:"orderedDate", order:"desc", offset : params['offset'])
	}
}

