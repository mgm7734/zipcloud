package zipcloud

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ZipCloudController)
class ZipCloudControllerTests {

  def testIndex() {
    def expectedData = [["MN": 10], ["BB": 40]]
    def mc = mockFor(ZipCloudService)
    mc.demand.calculateCloudData { expectedData }

    def controller = new ZipCloudController()
    controller.zipCloudService = mc.createMock()

    def model = controller.index();

    assert model == expectedData
  }
}
