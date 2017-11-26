class GameOfLife(board: Array[Array[Cell]]) {
  val NEIGHBORS = Array(
    (-1, -1),(-1, 0),(-1, 1),
    ( 0, -1),        ( 0, 1),
    ( 1, -1),(+1, 0),( 1, 1)
  )

  def getNeighbors(row: Int, column: Int): Array[Cell] = {
    NEIGHBORS
      .map(position => (position._1+row, position._2+column))
         .filter(position => position._1 > 0 && position._1 < board.length
           && position._2 > 0 && position._2 < board(position._1).length)
        .map(position => board(position._1)(position._2))
  }

  def nextGeneration() = {
    for {
      row <- board.indices
      column <- board(row).indices
    } yield {
      val cell = board(row)(column)
      val neighbors = getNeighbors(row,column)
      cell.checkNeighbors(neighbors:_*)
    }
  }

  def resurrect(positions: (Int, Int)*) = positions.foreach(position => board(position._1)(position._2).resurrect())

  def getBoard = board
}

object GameOfLife {
  def apply(rows: Int, columns: Int) = {
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
