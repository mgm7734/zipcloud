package zipcloud

class ZipCloudController {

  def zipCloudService

  def index() {
    println "here we are"
    [states: zipCloudService.calculateCloudData() ]
  }
}
