/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import business.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samue
 */
    public class ReviewDao extends Dao implements ReviewDaoInterface {

    public ReviewDao(String dbName) {
        super(dbName);
    } 
    
    public List<Review> findAllReviews() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> review = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM review";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String Description = rs.getString("description");
                String gameTitle = rs.getString("gameTitle");
                float Rating = rs.getFloat("rating");
                int user_id  = rs.getInt("user_id");
                Review r = new Review(id,Description, gameTitle,Rating, user_id);
                review.add(r);
               
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
        return review;    // may be empty
    }
     public Review findReviewByTitle(String title) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Review r = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM review WHERE gameTitle = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            
            rs = ps.executeQuery();
            if (rs.next()) 
            {
            	int id = rs.getInt("id");
                String Description = rs.getString("description");
                String gameTitle = rs.getString("gameTitle");
                float Rating = rs.getFloat("rating");
                int user_id  = rs.getInt("user_id");
                r = new Review(id,Description, gameTitle,Rating, user_id);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("An error occurred in the findUserById() method: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                System.out.println("An error occurred when shutting down the findUserById() method: " + e.getMessage());
            }
        }
        return r;     // u may be null 
    }
}
 