package zipcloud

import org.springframework.web.client.RestClientException

class ZipCloudService {
	def geoDataService

	def stateNameAndZipCounts() {
		State.list(sort: "name").collect {
			[name:     it.name,
				zipCount: it.zipCodeAreas.size()]
		}
	}

	def refreshZipData() {
		State.list().each { st->
			try {
				refreshZipDataForState(st)
			}
			catch( RestClientException e ) {
				log.info "update failed for ${st.code}", e
			}
		}
	}

	def refreshZipDataForState(State st) {
		def resp = geoDataService.zipCodeDataForState(st.code)
		if (resp == []) { 
			return
		}
		ZipCodeArea.where { state == st }.deleteAll()
		resp.each { data ->
			st.addToZipCodeAreas( new ZipCodeArea(code: data.postalCode) )
		}
		st.refreshedAt = new Date()
		st.save(flush: true)
	}
	
	def refreshedAt() {
		State.withCriteria(uniqueResult: true) {
			projections { 
				min('refreshedAt')
			}
		}.first()
	}
	
}
