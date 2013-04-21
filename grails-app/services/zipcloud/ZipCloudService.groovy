package zipcloud

class ZipCloudService {
  
  def calculateCloudData() {
    State.list().collect { [name: it.name, zipCount: it.zipCodeAreas.size()] }
  }    
}
