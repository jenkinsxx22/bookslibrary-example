import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class booksDao {

	public int SaveBook(books book) {

		   String INSERT_USERS_SQL = "INSERT INTO books" +
		            "  ( Title, Author, Publication) VALUES " +
		            " ( ?, ?, ?);";

		        int result = 0;

		        getConnection getcon = new getConnection();
		        try (Connection connection = DriverManager
		            .getConnection(getcon.getDbURL(),getcon.getDbUserName(), getcon.getDbPassword());
		        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
		            preparedStatement.setString(1, book.getTitle());
		            preparedStatement.setString(2, book.getAuthor());
		            preparedStatement.setString(3, book.getPublisher());
		            result = preparedStatement.executeUpdate();
		            
		            
		        } catch (SQLException e) {
		            // process sql exception
		            printSQLException(e);
		        }
		        return result;
	}
	
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

}
	
}
