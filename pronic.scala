def pronic(i: Int, j: Int): List[Int] = {
    if (i < 0 || j < 0) throw new Exception("All values must be greater than zero.")
    def pronicR(s: Int, e: Int, res: List[Int]): List[Int] = {
        if (e < s) res
        else pronicR(s, e - 1, (e * (e - 1)) :: res)
    }
    pronicR(i, j, Nil)
}
