case class Board(board: Array[Array[Cell]]) {
  private val NEIGHBORS = Array(
    (-1, -1),(-1, 0),(-1, 1),
    ( 0, -1),        ( 0, 1),
    ( 1, -1),(+1, 0),( 1, 1)
  )

  val rows: Int = board.length
  val columns: Int = board(0).length

  def getCellFrom(row: Int, column: Int): Cell = {
    board(row)(column)
  }

  def getNeighborsFrom(row: Int, column: Int): Array[Cell] = {
    NEIGHBORS
      .map   { case (neighborRow, neighborColumn) => (neighborRow+row, neighborColumn+column) }
      .filter{ case (neighborRow, neighborColumn) => isValidPosition(neighborRow,neighborColumn) }
      .map   { case (neighborRow, neighborColumn) => getCellFrom(neighborRow, neighborColumn) }
  }

  def positions(): Seq[(Int, Int)] = {
    for {
      row <- 0 until rows
      column <- 0 until columns
    } yield (row,column)
  }

  private def isValidPosition(row: Int, column: Int): Boolean = {
    row >= 0 &&
      row < rows &&
      column >= 0 &&
      column < columns
  }

  override def toString: String = {
    val result = new StringBuilder("\n")
    positions().map {
      case(row, column) => {
        result.append(getCellFrom(row,column))
        if(column == columns-1) result.append("\n")
      }
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