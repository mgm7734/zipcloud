package zipcloud

import grails.plugins.rest.client.RestBuilder
import org.springframework.web.client.RestClientException

class ZipCloudService {
  
  def calculateCloudData() {
    State.list(sort: "name").collect {
      [name:     it.name,
       zipCount: it.zipCodeAreas.size()] }
  }

  def refreshZipData() {
    def client = new RestBuilder()

    State.list().each { st->
      println "updating ${st.code}"
      try {
	updateZipsForState(st, client)
      }
      catch( RestClientException e ) {
	log.info "update failed for ${st.code}", e
      }
    }
  }

  def updateZipsForState(st, client) {
    def resp = client.get(
      """http://api.geonames.org/postalCodeSearchJSON?placename=${
          st.code
        }&username=mgm7734""")
    if (resp.status == 200) {
      resp.json.postalCodes.each {data ->
	st.addToZipCodeAreas( new ZipCodeArea(code: data.postalCode) )
      }
      st.save(flush: true)
    }
  }
}
