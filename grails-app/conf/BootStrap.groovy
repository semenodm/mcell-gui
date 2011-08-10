import grails.converters.JSON

class BootStrap {

	def init = { servletContext ->
		JSON.registerObjectMarshaller(Date) {
			return it?.format("yyyy-MM-dd'T'hh:mm:ss")
		}
	}
	def destroy = {
	}
}
