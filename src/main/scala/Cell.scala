class Cell(var isAlive: Boolean) {
  def checkNeighbors(neighbors: Cell*) = {
    val livingNeighbors = neighbors.count(_.isAlive)
    isAlive = (isAlive && livingNeighbors >= 2 && livingNeighbors <= 3) || (!isAlive && livingNeighbors == 3)
  }
}
