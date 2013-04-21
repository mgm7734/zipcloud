import zipcloud.State

class BootStrap {

    def init = { servletContext ->
      if (State.count() == 0) {
	initStatesTable()
      }
    }
    def destroy = {
    }

    def initStatesTable() {
      new File('grails-app/conf/states.txt').eachLine {
	def (name, code) = it.split('\t')
	new State(name: name, code: code).save(flush: true)
      }
    }
}
