
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

public class ImageFetch {

	private static String url = "jdbc:postgresql://localhost:5432/demoo";
	public static String usrn = "postgres";
	public static String pswd = "123";

	public static void main(String[] args) {
		String path = "E:\\wallpapers\\";
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");

			Connection connection = DriverManager.getConnection(url, usrn, pswd);
			System.out.println("Connection done");

			String sql = "SELECT  image_data from image_table where id=(?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				byte[] image_data = resultSet.getBytes("image_data");
				String image_path = path + "icandoit.jpg";
				OutputStream outputStream = new FileOutputStream(image_path);
				outputStream.write(image_data);
				System.out.println("Insertion Succesful");
			} else {
				System.out.println("image not found");
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
