def printPyramid(n: Int): Unit = {
	def pyrR(i: Int, buffer: Int, res: List[List[Char]]): List[List[Char]] = {
		if (buffer < 0) res
		else pyrR(i + 2, buffer - 1, res :+ (List.fill(buffer)(' ') ::: List.fill(i)('#') ::: List.fill(buffer)(' ')))
	}
  pyrR(1, n, List()).map(i => i.mkString).foreach(println)
}
              
printPyramid(13)