import org.scalatest._
class GameOfLifeSpec extends FlatSpec with Matchers {

  it should "create a 5x5 board" in {
    val game = GameOfLife(5, 5)

    game.toString shouldBe "\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"
  }

  it should "create a 5x5 board with some alive cell" in {
    val game = GameOfLife(5, 5)
    game.resurrect((2,3), (1,1), (4,1))

    game.toString shouldBe "\n"+
      "_____\n"+
      "_*___\n"+
      "___*_\n"+
      "_____\n"+
      "_*___\n"
  }

  "Living cell" should "die with less than 2 living neighbors" in {
    val game = GameOfLife(5, 5)
    game.resurrect((1,1))

    game.toString shouldBe "\n"+
      "_____\n"+
      "_*___\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"

    game.nextGeneration()

    game.toString shouldBe "\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"+
      "_____\n"
  }

  "Living cell" should "keep alive if it has 2 living neighbors" in {
    val game = GameOfLife(1, 3)
    game.resurrect((0,0),(0,1),(0,2))

    game.toString shouldBe "\n"+
      "***\n"

    game.nextGeneration()

    game.toString shouldBe "\n"+
      "_*_\n"
  }

  "Living cell" should "die if it has more than 3 living neighbors" in {
    val game = GameOfLife(2, 3)
    game.resurrect(
      (0,0),(0,1),(0,2),
            (1,1),(1,2)
    )

    game.toString shouldBe "\n"+
      "***\n"+
      "_**\n"

    game.nextGeneration()

    game.toString shouldBe "\n"+
      "*_*\n"+
      "*_*\n"
  }

}
