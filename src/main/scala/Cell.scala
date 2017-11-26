class Cell(var isAlive: Boolean) {

  def checkNeighbors(neighbors: Cell*): Unit = {
    val livingNeighbors = neighbors.count(_.isAlive)
    isAlive = (isAlive && livingNeighbors >= 2 && livingNeighbors <= 3) || (!isAlive && livingNeighbors == 3)
  }

  override def toString: String = {
    if (isAlive) "*" else "_"
  }

  def resurrect(): Unit = isAlive = true

}
