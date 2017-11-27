case class Board(board: Array[Array[Cell]]) {
  private val NEIGHBORS = Array(
    (-1, -1),(-1, 0),(-1, 1),
    ( 0, -1),        ( 0, 1),
    ( 1, -1),(+1, 0),( 1, 1)
  )

  val rows: Int = board.length
  val columns: Int = board(0).length

  def getCellFrom(row: Int, column: Int) = {
    board(row)(column)
  }

  def getNeighborsFrom(row: Int, column: Int): Array[Cell] = {
    NEIGHBORS
      .map(position => (position._1+row, position._2+column))
      .filter(position => isValidPosition(position))
      .map(position => getCellFrom(position._1, position._2))
  }

  private def isValidPosition(position: (Int, Int)) = {
    position._1 >= 0 &&
      position._1 < rows &&
      position._2 >= 0 &&
      position._2 < columns
  }

  override def toString: String = {
    val result = new StringBuilder("\n")
    for {
      row <- board.indices
      column <- board(row).indices
    } yield {
      result.append(getCellFrom(row,column))
      if(column == columns-1) result.append("\n")
    }
    result.toString
  }

}

object Board {
  def apply(rows: Int, columns: Int, alivePositions: (Int, Int)*): Board = {
    val board = Array.ofDim[Cell](rows, columns)
    for {
      row <- 0 until rows
      col <- 0 until columns
    } yield {
      board(row)(col) = new Cell(alivePositions.contains((row,col)))
    }
    new Board(board)
  }
}