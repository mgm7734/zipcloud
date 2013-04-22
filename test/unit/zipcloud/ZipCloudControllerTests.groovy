package zipcloud

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ZipCloudController)
class ZipCloudControllerTests {

	void testIndex() {
		def ctl = mockFor(ZipCloudService)
		ctl.demand.stateNameAndZipCounts() { ->
			[ [name: "MN", zipCount: 10],
			  [name: "OP", zipCount: 25],
			  [name: "QR", zipCount: 40] ]
		}
		def controller = new ZipCloudController()
		controller.zipCloudService = ctl.createMock()

		def model = controller.index();

		assert model == 
			[ states: [ [name: "MN", fontSize:  8, zipCount: 10],
						[name: "OP", fontSize: 19, zipCount: 25],
						[name: "QR", fontSize: 30, zipCount: 40] ] ]
	}
}
