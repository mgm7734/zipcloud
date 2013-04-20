package zipcloud

class State {
  String name
  String code

  //static hasMany = [zipCodes: String]
  static hasMany = [zipCodeAreas: ZipCodeArea]
  static constraints = {
  }
}
