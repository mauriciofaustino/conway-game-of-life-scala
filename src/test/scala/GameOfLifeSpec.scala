import org.scalatest._
class GameOfLifeSpec extends FlatSpec with Matchers {

  it should "die with less than 2 living neighbors" in {
    val board = Board(5, 5, alivePositions = (1,1))

    board.toString shouldBe "\n"+
      "_____\n"+
      "_*___\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"

    val newBoard = new GameOfLife().nextGeneration(board)

    newBoard.toString shouldBe "\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"
  }

  it should "keep alive if it has 2 living neighbors" in {

    val board = Board(1, 3, alivePositions = (0,0),(0,1),(0,2))

    board.toString shouldBe "\n"+
      "***\n"

    val newBoard = new GameOfLife().nextGeneration(board)

    newBoard.toString shouldBe "\n"+
      "_*_\n"
  }

  it should "die if it has more than 3 living neighbors" in {
    val board = Board(2, 3, alivePositions = (0,0),(0,1),(0,2),(1,1),(1,2))

    board.toString shouldBe "\n"+
      "***\n"+
      "_**\n"

    val newBoard = new GameOfLife().nextGeneration(board)

    newBoard.toString shouldBe "\n"+
      "*_*\n"+
      "*_*\n"
  }

}
