package zipcloud

class ZipCodeArea {
  String code

  static belongsTo = [state: State]

  static constraints = {
  }
}
