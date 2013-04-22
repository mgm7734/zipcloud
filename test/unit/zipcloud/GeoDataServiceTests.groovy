package zipcloud

import grails.plugins.rest.client.RestBuilder

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GeoDataService)
class GeoDataServiceTests {
	void testZipCodeDataForStateHappyPath() {
		def ctl = mockFor(RestBuilder)
		ctl.demand.get() { url ->
			assert "http://api.geonames.org/postalCodeSearchJSON?placename=AA&maxRows=500&username=mgm7734"  == url
			[status: 200, json: [postalCodes: "list of postal codes"]]
		}
		
		def service = new GeoDataService()
		service.restBuilder = ctl.createMock()
		
		assert "list of postal codes" == service.zipCodeDataForState("AA")
	}
	
	void testZipCodeDataForStateWithHttpError() {
		def ctl = mockFor(RestBuilder)
		ctl.demand.get() { [status: 500] }
		
		def service = new GeoDataService()
		service.restBuilder = ctl.createMock()

		assert [] == service.zipCodeDataForState("AA")		
	}
}
