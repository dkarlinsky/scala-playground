package sessions.session6

import com.escalatesoft.subcut.inject._
import java.sql.{PreparedStatement, ResultSet, DriverManager, Connection}
import java.util.Date
import sessions.session6.BindingKeys.DbTime

object BindingKeys {   // in some other file?
    object Database extends BindingId
    object DbOps extends BindingId
    object DbTime extends BindingId
}

trait Database
{
    def connection : Connection
}

case class JDBCDatabase(jdbcUrl: String, jdbcDriver: String, userName: String, password: String) extends Database
{
    def connection: Connection = {
        Class.forName(jdbcDriver)
        DriverManager.getConnection(jdbcUrl, userName, password)
    }
}

trait DbOps
{
    val dataBase: Database

    def withConnection[T](func: Connection => T):T = {
        val connection = dataBase.connection
        try
        {
            func(connection)
        }
        finally
        {
            connection.close()
        }

    }

    def query[T](sql:String) (setParams: PreparedStatement=>Unit = {p=>}) (func: ResultSet => T ): Seq[T] = {
        withConnection { (connection) =>
            val statement = connection.prepareStatement(sql)
            setParams(statement)
            val rs = statement.executeQuery(sql)

            var result: List[T] = Nil
            try
            {
                while (rs.next())
                {
                    result = func(rs) :: result
                }
                result.reverse
            }
            finally
            {
                rs.close()
                statement.close()
            }
        }
    }
}

class DbOpsImpl (implicit val bindingModule: BindingModule) extends DbOps with Injectable
{
    val dataBase:Database = inject
}

class DbTime (implicit val bindingModule: BindingModule) extends Injectable
{
    val dbOps:DbOps = inject
    def dbTime:Date = dbOps.query("select sysdate from dual")() { rs =>
        rs.getTimestamp(1)
    }.head
}

object ProjectConfiguration extends NewBindingModule(implicit module => {
    import module._   // can now use bind directly

    import BindingKeys._  // use the Binding IDs conveniently

    bind [Database] idBy  Database toSingle new JDBCDatabase(
        jdbcUrl = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = IL-INTDB-scan.fiftyone.com)(PORT = 1521))(CONNECT_DATA =(LOAD_BALANCE = no)(SERVER = DEDICATED)(SERVICE_NAME = INTDB)))",
        jdbcDriver = "oracle.jdbc.driver.OracleDriver", userName =  "DMITRY_CBMS", password = "DMITRY_CBMS")

    bind [DbOps] toSingle new DbOpsImpl

    bind [DbTime] idBy DbTime toSingle new DbTime

})


object Test extends App with Injectable
{
    implicit  val bindingModule = ProjectConfiguration
    val dbTime: DbTime = inject[DbTime]

    println(s"db time: ${dbTime.dbTime}")

}