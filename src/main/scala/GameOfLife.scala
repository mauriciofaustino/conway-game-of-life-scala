class GameOfLife() {

  def nextGeneration(board: Board): Board = {
    val alivePositions = scala.collection.mutable.SortedSet[(Int, Int)]()
    for {
      row <- 0 until board.rows
      column <- 0 until board.columns
    } yield {
      val cell = board.getCellFrom(row,column)
      val neighbors = board.getNeighborsFrom(row,column)
      if(cell.willSurvive(neighbors:_*)) {
        val alivePosition: (Int, Int) = (row, column)
        alivePositions += alivePosition
      }
    }
    Board(board.rows, board.columns, alivePositions.toArray:_*)
  }

}