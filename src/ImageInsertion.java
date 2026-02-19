
package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class ImageInsertion {

	private static String url = "jdbc:postgresql://localhost:5432/demoo";
	public static String usrn = "postgres";
	public static String pswd = "123";
	
	//IMAGE INSERTION

public static void main(String[] args) {
		String path = "E:\\wallpapers\\icandoit.jpg";
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");

			Connection connection = DriverManager.getConnection(url, usrn, pswd);
			System.out.println("Connection done");

			String sql = "INSERT into image_table(image_data) values (?)";

			FileInputStream fileInputStream = new FileInputStream(path);
			byte[] image_data = new byte[fileInputStream.available()];
			fileInputStream.read(image_data);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBytes(1, image_data);

			int affectedrows = preparedStatement.executeUpdate();

			if (affectedrows > 0) {
				System.out.println("Insertion Succesful");
			} else {
				System.out.println("Not Inserted");
			}

			connection.close();
			System.out.println("connection close");

		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	


}
