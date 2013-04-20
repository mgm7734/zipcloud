package zipcloud

class ZipCloudService {
  
  def calculateCloudData() {
    State.list().collect { [stateName: it.name, zipCount: it.zipCodeAreas.size()] }
  }    
}
