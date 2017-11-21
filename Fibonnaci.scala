object Fibonacci {
  def fib(end: BigInt): List[BigInt] = {
  	def fibR(list: List[BigInt], end: BigInt): List[BigInt] = {
  		if(end <= 0) list
  		else fibR(list ++ List((list(list.size-2) + list(list.size-1))), (end - 1))
  	}
  	fibR(List(0,1), (end - 1))
  }                                               
}
