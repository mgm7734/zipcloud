package zipcloud

import grails.plugins.rest.client.RestBuilder
import org.springframework.web.client.RestClientException
  
class GeoDataService {
  static scope = "request"

  def restBuilder = new RestBuilder()

  static def maxRows = 500
  
  // Note: This daily data dump would be more effient
  // http://download.geonames.org/export/zip/US.zip
  def zipCodeDataForState(String stateCode) {
    def resp = restBuilder.get(
      """http://api.geonames.org/postalCodeSearchJSON?placename=${
            stateCode
	  }&maxRows=${
	    maxRows
	  }&username=mgm7734""")
        
    if(resp.status == 200) {
      resp.json.postalCodes
    }
    else {
      log.warning "HTTP error retrieving data for ${stateCode}: ${resp.status}, ${resp.text}"
      []
    }
  }
}
