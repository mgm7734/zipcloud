package zipcloud

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ZipCloudService)
@Mock([State, ZipCodeArea])
class ZipCloudServiceTests {

  void setUp() {
    def mn = new State(name: "Minnesota", code: "MN")
    def wi = new State(name: "Wisconsin", code: "WI")
    mn.save()
    wi.save()

    9.times { mn.addToZipCodeAreas( new ZipCodeArea( code: (55401 + it).toString() ) ) }
    5.times { wi.addToZipCodeAreas( new ZipCodeArea( code: (66600 + it).toString() ) ) }
    mn.save(flush: true)
  }
  
  def testgetCloudDataHappyPath() {
    def result = service.stateNameAndZipCounts()

    assert [ [name: "Minnesota", zipCount: 9],
		     [name: "Wisconsin", zipCount: 5]
		   ] == result
  }
}
