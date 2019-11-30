import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration._

object Example extends App {

  case class Shopper(name: String, id: Option[Long] = None)

  class ShopperDB(tag: Tag) extends Table[Shopper](tag, "shoppers") {
    def id = column[Long]("shopper_id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("shopper_name", O.Unique)
    def * = (name, id.?).mapTo[Shopper]
  }

  val shoppers = TableQuery[ShopperDB]

  val action =
    (shoppers.schema.create.asTry) andThen
    (shoppers += Shopper("Alice")) andThen
    (shoppers.result)

  println("Running:")
  val db = Database.forConfig("example")
  try 
    println(Await.result(db.run(action), 2.seconds))
  finally db.close

}
