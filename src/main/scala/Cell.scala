class Cell(var alive: Boolean) {
  def checkNeighbors(neighbors: Cell*) = {
    if(neighbors.count(_.alive) < 2) {
      alive = false
    }
    if(neighbors.count(_.alive) > 3) {
      alive = false
    }
  }

}
