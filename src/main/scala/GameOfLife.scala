class GameOfLife(board: Array[Array[Cell]]) {
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
