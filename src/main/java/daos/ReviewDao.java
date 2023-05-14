/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import business.Game;
import business.Review;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

/**
 *
 * @author mcgeo
 */
public class ReviewDao extends Dao implements ReviewDaoInterface {

    public ReviewDao(String dbName) {
        super(dbName);
    }

    @Override
    public Review findReviewByGameId(int id) throws IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Review r = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM games WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                int review_id = rs.getInt("id");
                int rating = rs.getInt("rating");
                String review = rs.getString("review");

                r = new Review(review_id, rating, review);
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
        return r;     // u may be null 
    }
}
