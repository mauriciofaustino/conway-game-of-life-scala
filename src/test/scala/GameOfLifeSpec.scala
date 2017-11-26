import org.scalatest._
class GameOfLifeSpec extends FlatSpec with Matchers {

  it should "create a 5x5 board" in {
    val game = GameOfLife(5, 5)

    game.board.size shouldBe 5
    game.board(0).size shouldBe 5
  }

}
