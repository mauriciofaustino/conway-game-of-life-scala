class Cell(var alive: Boolean) {
  def checkNeighbors(neighbors: Cell*) = {
    val livingNeighbors = neighbors.count(_.alive)
    if(livingNeighbors < 2 || livingNeighbors > 3) {
      alive = false
    }
    if(livingNeighbors == 3) {
      alive = true
    }
  }

}
