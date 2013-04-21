package zipcloud

class ZipCloudController {

  def zipCloudService
  def grailsApplication

  def index() {
    [states: nameAndFontSizes( zipCloudService.calculateCloudData() )]
  }

  private def nameAndFontSizes( rawData ) {
    def (minSize,maxSize) = [8, 60] // grailsApplication.config.fontSizeRange
    def vals = rawData.collect { it.zipCount }
    def minCount = vals.min()
    def maxCount = vals.max()
    if (minCount == maxCount) {
      maxCount += 1
    }
    def f = (maxSize - minSize) / (maxCount - minCount)
    rawData.collect { [name: it.name,
      fontSize: minSize + f * (it.zipCount - minCount)]
    }
  }
}
