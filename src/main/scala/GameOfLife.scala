class GameOfLife(var board: Array[Array[Cell]]) {

  private val NEIGHBORS = Array(
    (-1, -1),(-1, 0),(-1, 1),
    ( 0, -1),        ( 0, 1),
    ( 1, -1),(+1, 0),( 1, 1)
  )

  def resurrect(positions: (Int, Int)*): Unit = positions.foreach(position => board(position._1)(position._2).resurrect())

  def nextGeneration(): Unit = {
    val newBoard = Array.ofDim[Cell](board.length, board(0).length)
    for {
      row <- board.indices
      column <- board(row).indices
    } yield {
      val cell = board(row)(column)
      val neighbors = getNeighbors(row,column)
      newBoard(row)(column) = cell.checkNeighbors(neighbors:_*)
    }
    board = newBoard
  }

  override def toString: String = {
    val result = new StringBuilder()
    result.append("\n")
    for {
      row <- board.indices
      column <- board(row).indices
    } yield {
      val cell = board(row)(column)
      result.append(cell.toString)
      if(column == board(row).length-1) result.append("\n")
    }
    result.toString
  }

  private def getNeighbors(row: Int, column: Int): Array[Cell] = {
    NEIGHBORS
      .map(position => (position._1+row, position._2+column))
      .filter(position => isValidPosition(position))
      .map(position => board(position._1)(position._2))
  }

  private def isValidPosition(position: (Int, Int)) = {
    position._1 >= 0 && position._1 < board.length && position._2 >= 0 && position._2 < board(position._1).length
  }

}

object GameOfLife {
  def apply(rows: Int, columns: Int): GameOfLife = {
    val board = Array.ofDim[Cell](rows, columns)
    for {
      row <- 0 until rows
      col <- 0 until columns
    } yield {
      board(row)(col) = new Cell(false)
    }
    new GameOfLife(board)
  }
}
