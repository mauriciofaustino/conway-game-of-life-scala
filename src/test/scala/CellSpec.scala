import org.scalatest._

class CellSpec extends FlatSpec with Matchers {

  it should "die with less than 2 living neighbors" in {
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

  it should "keep alive if it has 2 living neighbors" in {
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

  it should "keep alive if it has 3 living neighbors" in {
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

  it should "die if it has more than 3 living neighbors" in {
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

  it should "resurrect if it has exact 3 living neighbors" in {
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



  it should "be * in string when it's alive" in {
    val cell = new Cell(true)

    cell.toString shouldBe "*"
  }

  it should "be _ in string when it's died" in {
    val cell = new Cell(false)

    cell.toString shouldBe "_"
  }
}