class Cell(var alive: Boolean) {
  def checkNeighbors(neighbors: Cell*) = {
    val livingNeighbors = neighbors.count(_.alive)
    alive = (alive && livingNeighbors >= 2 && livingNeighbors <= 3) || (!alive && livingNeighbors == 3)
  }
}
