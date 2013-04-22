package zipcloud

class ZipCloudController {

  def zipCloudService
  def grailsApplication

  def index() {
    [states: nameAndFontSizes( zipCloudService.stateNameAndZipCounts() )]
  }
  
  def refresh() {
  	zipCloudService.refreshZipData()
	redirect(action: "index")
  }

  private def nameAndFontSizes( rawData ) {
    def (minFontSize,maxFontSize) = [8, 30] // grailsApplication.config.fontSizeRange
    def vals = rawData.collect { it.zipCount }
    def minCount = vals.min()
    def maxCount = vals.max()
    if (minCount == maxCount) {
      maxCount += 1
    }
    def f = (maxFontSize - minFontSize) / (maxCount - minCount)
    rawData.collect {
      def fontSize = minFontSize + f * (it.zipCount - minCount) + 0.5
      [name: it.name, fontSize: fontSize.toInteger(),  zipCount: it.zipCount]
    }
  }
}
