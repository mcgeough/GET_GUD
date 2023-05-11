package daos;

import business.Game;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class GameDao extends Dao implements GameDaoInterface {

    public GameDao(String dbName) {
        super(dbName);
    }

    @Override
    public List<Game> findAllGames() throws IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Game> games = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM games";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int ageRating = rs.getInt("ageRating");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String platform = rs.getString("platform");
                Blob blob = rs.getBlob("image");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                Game g = new Game(id, title, genre, ageRating, price, description, platform, base64Image);
                games.add(g);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred in the findAllGames() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An error occurred when shutting down the findAllGames() method: " + e.getMessage());
            }
        }
        return games;     // may be empty
    }

    @Override
    public Game findGameById(int id) throws IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game g = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM games WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int ageRating = rs.getInt("ageRating");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String platform = rs.getString("platform");
                Blob blob = rs.getBlob("image");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                g = new Game(userId, title, genre, ageRating, price, description, platform, base64Image);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred in the findGameById() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An error occurred when shutting down the findGameById() method: " + e.getMessage());
            }
        }
        return g;     // u may be null 
    }
    /*
    @Override
    public int addGame(String title, String genre, int ageRating, Double price, String description, String platform ) {
        Connection con = null;
        PreparedStatement ps = null;
        // This will be used to hold the generated ID (i.e. the value auto-generated
        // by MySQL when inserting this entry into the database
        ResultSet generatedKeys = null;
        // Set the newId value to a default of -1
        // If the value returned by the method is -1, we know that the update failed
        // as the id value was never updated
        int newId = -1;
        try {
            con = this.getConnection();

            String query = "INSERT INTO users(username, password, email, firstname, lastname, dob, isCritic, isAdmin) VALUES (?,?,?,?,?,?,?,?)";

            // Need to get the id back, so have to tell the database to return the id it generates
            // That is why we include the Statement.RETURN_GENERATED_KEYS parameter
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, uname);
            ps.setString(2, pword);
            ps.setString(3, email);
            ps.setString(4, fName);
            ps.setString(5, lName);
            ps.setString(6, dob);
            ps.setInt(7, isCrit);
            ps.setInt(8, isAd);

            // Because this is CHANGING the database, use the executeUpdate method
            ps.executeUpdate();

            // Find out what the id generated for this entry was
            generatedKeys = ps.getGeneratedKeys();
            // If there was a result, i.e. if the entry was inserted successfully
            if (generatedKeys.next()) {
                // Get the id value that was generated by MySQL when the entry was inserted
                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the addUser method:");
            System.err.println("\t" + e.getMessage());
            newId = -1;
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the addUser method:\n" + e.getMessage());
            }
        }
        return newId;
    }
     */

}
