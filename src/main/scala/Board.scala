case class Board(rows: Int, columns: Int, alivePositions: (Int, Int)*) {
  private val NEIGHBORS = Seq(
    (-1, -1),(-1, 0),(-1, 1),
    ( 0, -1),        ( 0, 1),
    ( 1, -1),(+1, 0),( 1, 1)
  )

  private val board: Array[Array[Cell]] = {
    val board = Array.ofDim[Cell](rows, columns)
    positions().foreach {
      case (row, column) => board(row)(column) = Cell(alivePositions.contains((row,column)))
    }
    board
  }

  def getCellFrom(row: Int, column: Int): Cell = {
    board(row)(column)
  }

  def getNeighborsFrom(row: Int, column: Int): Seq[Cell] = {
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
    val result = new StringBuilder()
    board.foreach( row => {
      result.append("\n")
      row.foreach( cell => result.append(cell))
    })
    result.toString
  }

}