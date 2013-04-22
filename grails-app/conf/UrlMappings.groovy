class UrlMappings {

	static mappings = {
		"/zipCloud/refresh "(controller:"zipCloud") {
			action = [POST:"refresh"]
		}
	 
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
