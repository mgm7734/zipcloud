package zipcloud

import grails.plugins.rest.client.RestBuilder
import org.springframework.web.client.RestClientException

class State {
  String name
  String code
  Date refreshedAt

  static hasMany = [zipCodeAreas: ZipCodeArea]
  static constraints = {
    refreshedAt nullable: true
  }

  String toString() {
    "<State: $name ($id)>"
  }
}
