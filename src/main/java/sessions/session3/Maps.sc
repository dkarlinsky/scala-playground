import scala.util.Try

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 5:41 PM
 */

val map = Map((1,"Jan"),
    (2, "Feb"),
    (3,"Mar"),
    (4,"Apr"),
    (5,"May"),
    (6,"Jun"),
    (7,"Jul"),
    (8,"Aug"),
    (9,"Sep"),
    (10,"Oct"),
    (11,"Nov"),
    (12,"Dec")
)



val mapWithDefault = map.withDefaultValue("Unknown Month")




val months1 = (1 to 15).map(i=> Try(map(i)))





val months2 = (1 to 15).map(mapWithDefault)


