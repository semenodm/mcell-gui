import grails.converters.JSON

class BootStrap {
	def enqueryService
	def init = { servletContext ->
		JSON.registerObjectMarshaller(Date) {
			return it?.format("yyyy-MM-dd'T'hh:mm:ss")
		}
		enqueryService.serviceMethod()
	}
	def destroy = {
	}
}
