class GameOfLife() {

  def nextGeneration(board: Board): Board = {
    val alivePositions =
      board.positions()
        .map { case (row, column) => (
            (row,column),
            board.getCellFrom(row, column),
            board.getNeighborsFrom(row, column)
        )}
        .filter { case (_,cell,neighbors) => cell.willSurvive(neighbors:_*) }
        .map { case (position, _, _) => position }
    Board(board.rows, board.columns, alivePositions.toArray:_*)
  }

}