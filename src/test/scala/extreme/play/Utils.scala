package extreme.play


object Utils {

  type Attempts = Int
  type Pause =  () => Unit
  type ResultBlock[A] = () => Option[A]
  type Eventually[A] = Attempts => Pause => ResultBlock[A] => Option[A]

  def breather(n: Int) : Pause = () => {
    Thread.sleep(n)
  }

  def eventually[A]: Eventually[A] = n => p => rb => {
    def eventually0: Attempts => Option[A] = counter => {
      (counter, rb()) match {
        case (0, r) => r
        case (c,  None) => p(); eventually0(c - 1)
        case (_,  r) => r
      }
    }

    eventually0(n)
  }


}
