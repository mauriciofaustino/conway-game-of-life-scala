import org.scalatest._

class CellSpec extends FlatSpec with Matchers {

  "Living cell" should "die with less then 2 living neighbors" in {
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

  
}