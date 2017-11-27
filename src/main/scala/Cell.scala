class Cell(var isAlive: Boolean) {

  def willSurvive(neighbors: Cell*): Boolean = {
    val livingNeighbors = neighbors.count(_.isAlive)
    (isAlive && livingNeighbors >= 2 && livingNeighbors <= 3) || (!isAlive && livingNeighbors == 3)
  }

  override def toString: String = {
    if (isAlive) "*" else "_"
  }

}
