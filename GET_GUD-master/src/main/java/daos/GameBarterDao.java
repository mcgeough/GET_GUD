/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import business.GameBarter;
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
 public class GameBarterDao extends Dao implements GameBarterDaoInterface {

    public GameBarterDao(String dbName) {
        super(dbName);
    } 
    
    public List<GameBarter> findAllBarters() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<GameBarter> barter = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM gamebarter";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int Barter_id = rs.getInt("id");
                int user_id = rs.getInt("username");
                String username = rs.getString("password");
                String gameToTrade = rs.getString("ageRating");
                String wanted_game = rs.getString("price");
                String Misc = rs.getString("info");
                GameBarter b = new GameBarter(Barter_id, user_id,username, gameToTrade, wanted_game, Misc);
                barter.add(b);
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
        return barter;    // may be empty
    }
    
     public GameBarter findGameBarterBygameToTrade(String gameTitle) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        GameBarter b = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM game_barter WHERE gameToTrade = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, gameTitle);
            
            rs = ps.executeQuery();
            if (rs.next()) 
            {
            	int Barter_id = rs.getInt("id");
                int user_id = rs.getInt("username");
                String username = rs.getString("password");
                String gameToTrade = rs.getString("ageRating");
                String wanted_game = rs.getString("price");
                String Misc = rs.getString("info");
                b = new GameBarter(Barter_id, user_id,username, gameToTrade, wanted_game, Misc);
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
        return b;     // u may be null 
    }
 }