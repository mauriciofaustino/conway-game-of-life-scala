import org.scalatest._
class GameOfLifeSpec extends FlatSpec with Matchers {

  it should "create a 5x5 board" in {
    val game = GameOfLife(5, 5)

    game.getBoard.size shouldBe 5
    game.getBoard(0).size shouldBe 5
    game.getBoard(0)(0).isAlive shouldBe false
  }

  it should "create a 5x5 board with one alive cell" in {
    val game = GameOfLife(5, 5)
    game.resurrect((2,3))

    game.getBoard.size shouldBe 5
    game.getBoard(0).size shouldBe 5
    game.getBoard(0)(0).isAlive shouldBe false
    game.getBoard(2)(3).isAlive shouldBe true
  }

}
