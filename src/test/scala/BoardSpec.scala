import org.scalatest._

class BoardSpec extends FlatSpec with Matchers {

  it should "create a 5x5 board" in {
    val board = Board(5, 5)

    board.rows shouldBe 5
    board.columns shouldBe 5
    board.toString shouldBe "\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"
  }

  it should "create a 5x5 board with some alive cell" in {
    val board = Board(5, 5, alivePositions=(2,3), (1,1), (4,1))


    board.toString shouldBe "\n"+
      "_____\n"+
      "_*___\n"+
      "___*_\n"+
      "_____\n"+
      "_*___\n"
  }

  it should "provide 8 neighbors" in {
    val board = Board(3, 3, alivePositions=(0,1),(2,1))
    board.toString shouldBe "\n"+
      "_*_\n"+
      "___\n"+
      "_*_\n"

    val neighbors: Array[Cell] = board.getNeighborsFrom(1,1)

    neighbors.length shouldBe 8
    neighbors.count(_.isAlive) shouldBe 2
  }

  it should "provide 5 neighbors" in {
    val board = Board(3, 3, alivePositions=(0,1),(2,1))
    board.toString shouldBe "\n"+
      "_*_\n"+
      "___\n"+
      "_*_\n"

    val neighbors: Array[Cell] = board.getNeighborsFrom(1,0)

    neighbors.length shouldBe 5
    neighbors.count(_.isAlive) shouldBe 2
  }

  it should "provide 1 neighbors\"" in {
    val board = Board(1, 2, alivePositions=(0,1))
    board.toString shouldBe "\n"+
      "_*\n"

    val neighbors: Array[Cell] = board.getNeighborsFrom(0,0)

    neighbors.length shouldBe 1
    neighbors.count(_.isAlive) shouldBe 1
  }

}
