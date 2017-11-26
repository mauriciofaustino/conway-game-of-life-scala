import org.scalatest._
class GameOfLifeSpec extends FlatSpec with Matchers {

  it should "create a 5x5 board" in {
    val game = GameOfLife(5, 5)

    game.getBoard.length shouldBe 5
    game.getBoard(0).length shouldBe 5
    game.getBoard(0)(0).isAlive shouldBe false
  }

  it should "create a 5x5 board with some alive cell" in {
    val game = GameOfLife(5, 5)
    game.resurrect((2,3), (1,1), (4,1))

    game.getBoard.length shouldBe 5
    game.getBoard(0).length shouldBe 5
    game.getBoard(0)(0).isAlive shouldBe false
    game.getBoard(2)(3).isAlive shouldBe true
  }

  it should "calculate next generation" in {
    val game = GameOfLife(5, 5)
    game.resurrect((1,1))

    game.nextGeneration()

    game.getBoard(1)(1).isAlive shouldBe false
  }

}
