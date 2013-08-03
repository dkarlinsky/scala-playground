val nums = List(1,2,3,4,5,6)
val strs  = List("a", "b", "bb", "c", "ccc" , "d")
val bools = List(true, false, true, false)

for {
  n <- nums if n % 2 == 1
  s <- strs if n < 5 && s.size > 1
  b <- bools if b
} yield n+"-"+s+"-"+b



nums.withFilter(n=> n%2 == 1).flatMap{ n=>
    strs.withFilter(s => n < 5 && s.size >1 ).flatMap(s =>
      bools.withFilter(b=>b).map(b=>
          n+"-"+s+"-"+b
      )
    )
}



