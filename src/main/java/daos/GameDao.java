

package daos;

import business.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDao extends Dao implements GameDaoInterface {

    public GameDao(String dbName) {
        super(dbName);
    }

    @Override
    public List<Game> findAllGames() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Game> games = new ArrayList<Game>();

        try {
            //Get connection object using the methods in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM game";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String ageRating = rs.getString("ageRating");
                double price = rs.getDouble("price");
                String info = rs.getString("info");
                String platform = rs.getString("platform");
                Game g = new Game(id, title, genre, ageRating, price, info, platform);
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
                System.out.println("An error occurred when shutting down the findAllUsers() method: " + e.getMessage());
            }
        }
        return games;     // may be empty
    }

    @Override
    public Game findGameById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game g = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM game WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String ageRating = rs.getString("ageRating");
                double price = rs.getDouble("price");
                String info = rs.getString("info");
                String platform = rs.getString("platform");
                g = new Game(id, title, genre, ageRating, price, info, platform);
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
                System.out.println("An error occurred when shutting down the findUserById() method: " + e.getMessage());
            }
        }
        return g;     // u may be null 
    }

//    @Override
//    public int addUser(String uname, String pword, String fName, String lName) {
//        Connection con = null;
//        PreparedStatement ps = null;
//        // This will be used to hold the generated ID (i.e. the value auto-generated
//        // by MySQL when inserting this entry into the database
//        ResultSet generatedKeys = null;
//        // Set the newId value to a default of -1
//        // If the value returned by the method is -1, we know that the update failed
//        // as the id value was never updated
//        int newId = -1;
//        try {
//            con = this.getConnection();
//
//            String query = "INSERT INTO user(first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
//
//            // Need to get the id back, so have to tell the database to return the id it generates
//            // That is why we include the Statement.RETURN_GENERATED_KEYS parameter
//            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//
//            ps.setString(1, fName);
//            ps.setString(2, lName);
//            ps.setString(3, uname);
//            ps.setString(4, pword);
//
//            // Because this is CHANGING the database, use the executeUpdate method
//            ps.executeUpdate();
//
//            // Find out what the id generated for this entry was
//            generatedKeys = ps.getGeneratedKeys();
//            // If there was a result, i.e. if the entry was inserted successfully
//            if (generatedKeys.next()) {
//                // Get the id value that was generated by MySQL when the entry was inserted
//                newId = generatedKeys.getInt(1);
//            }
//        } catch (SQLException e) {
//            System.err.println("\tA problem occurred during the addUser method:");
//            System.err.println("\t" + e.getMessage());
//            newId = -1;
//        } finally {
//            try {
//                if (generatedKeys != null) {
//                    generatedKeys.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    freeConnection(con);
//                }
//            } catch (SQLException e) {
//                System.err.println("A problem occurred when closing down the addUser method:\n" + e.getMessage());
//            }
//        }
//        return newId;
//    }
//
//    public static void main(String[] args) {
//        UserDao userDao = new UserDao("user_database");
//        int id = userDao.addUser("Michelle", "password", "Michelle", "Graham");
//        System.out.println("The new id is: " + id);
//    }


}






