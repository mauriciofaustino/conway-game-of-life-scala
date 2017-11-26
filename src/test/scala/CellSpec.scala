import org.scalatest._

class CellSpec extends FlatSpec with Matchers {

  "Living cell" should "die with less than 2 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    var result = cell.checkNeighbors(neighbors:_*)

    result.isAlive shouldBe false
  }

  "Living cell" should "keep alive if it has 2 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    var result = cell.checkNeighbors(neighbors:_*)

    result.isAlive shouldBe true
  }

  "Living cell" should "keep alive if it has 3 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(true), new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    var result = cell.checkNeighbors(neighbors:_*)

    result.isAlive shouldBe true
  }

  "Living cell" should "die if it has more than 3 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(true), new Cell(true),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    var result = cell.checkNeighbors(neighbors:_*)

    result.isAlive shouldBe false
  }

  "Living cell" should "be * in string" in {
    val cell = new Cell(true)

    cell.toString shouldBe "*"
  }

  "Died cell" should "lives if it has exact 3 living neighbors" in {
    val cell = new Cell(false)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(true), new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    var result = cell.checkNeighbors(neighbors:_*)

    result.isAlive shouldBe true
  }

  "Died cell" should "be _ in string" in {
    val cell = new Cell(false)

    cell.toString shouldBe "_"
  }
}