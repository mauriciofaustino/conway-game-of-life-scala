import org.scalatest._

class CellSpec extends FlatSpec with Matchers {

  it should "die with less than 2 living neighbors" in {
    val cell = Cell(true)
    val neighbors: Array[Cell] =  Array(
      Cell(true), Cell(false),
      Cell(false),Cell(false),
      Cell(false),Cell(false),
      Cell(false),Cell(false)
    )

    cell.willSurvive(neighbors:_*) shouldBe false
  }

  it should "keep alive if it has 2 living neighbors" in {
    val cell = Cell(true)
    val neighbors: Array[Cell] =  Array(
      Cell(true), Cell(true),
      Cell(false),Cell(false),
      Cell(false),Cell(false),
      Cell(false),Cell(false)
    )

    cell.willSurvive(neighbors:_*) shouldBe true
  }

  it should "keep alive if it has 3 living neighbors" in {
    val cell = Cell(true)
    val neighbors: Array[Cell] =  Array(
      Cell(true), Cell(true),
      Cell(true), Cell(false),
      Cell(false),Cell(false),
      Cell(false),Cell(false)
    )

    cell.willSurvive(neighbors:_*) shouldBe true
  }

  it should "die if it has more than 3 living neighbors" in {
    val cell = Cell(true)
    val neighbors: Array[Cell] =  Array(
      Cell(true), Cell(true),
      Cell(true), Cell(true),
      Cell(false),Cell(false),
      Cell(false),Cell(false)
    )

    cell.willSurvive(neighbors:_*) shouldBe false
  }

  it should "resurrect if it has exact 3 living neighbors" in {
    val cell = Cell(false)
    val neighbors: Array[Cell] =  Array(
      Cell(true), Cell(true),
      Cell(true), Cell(false),
      Cell(false),Cell(false),
      Cell(false),Cell(false)
    )

    cell.willSurvive(neighbors:_*) shouldBe true
  }

  it should "be * in string when it's alive" in {
    val cell = Cell(true)

    cell.toString shouldBe "*"
  }

  it should "be _ in string when it's died" in {
    val cell = Cell(false)

    cell.toString shouldBe "_"
  }
}