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

    cell.checkNeighbors(neighbors:_*)

    cell.alive shouldBe false
  }

  "Living cell" should "keep alive if it has 2 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    cell.checkNeighbors(neighbors:_*)

    cell.alive shouldBe true
  }

  "Living cell" should "keep alive if it has 3 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(true), new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    cell.checkNeighbors(neighbors:_*)

    cell.alive shouldBe true
  }

  "Living cell" should "die if it has more than 3 living neighbors" in {
    val cell = new Cell(true)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(true), new Cell(true),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    cell.checkNeighbors(neighbors:_*)

    cell.alive shouldBe false
  }

  "Died cell" should "lives if it has exact 3 living neighbors" in {
    val cell = new Cell(false)
    val neighbors: Array[Cell] =  Array(
      new Cell(true), new Cell(true),
      new Cell(true), new Cell(false),
      new Cell(false),new Cell(false),
      new Cell(false),new Cell(false)
    )

    cell.checkNeighbors(neighbors:_*)

    cell.alive shouldBe true
  }
}