/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import business.LFG;
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
public class LFGDao extends Dao implements LFGDaoInterface  {
    public LFGDao(String dbName) {
        super(dbName);
    } 
    
    public List<LFG> findAllLFGs() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<LFG> lfg = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM LFG";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String gameTitle = rs.getString("gameTitle");
                boolean haveMic = rs.getBoolean("haveMic");
                String language = rs.getString("language");
                String region = rs.getString("region");
                String info = rs.getString("info");
                String platform = rs.getString("platform");
                LFG l = new LFG(user_id, gameTitle, platform,haveMic, language, region,info);
                lfg.add(l);
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
        return lfg;    // may be empty
    }
    
    public LFG findLFGByTitle(String title) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LFG l = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM lfg WHERE gameTitle = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            
            rs = ps.executeQuery();
            if (rs.next()) 
            {
            	int user_id = rs.getInt("user_id");
                String gameTitle = rs.getString("gameTitle");
                boolean haveMic = rs.getBoolean("haveMic");
                String language = rs.getString("language");
                String region = rs.getString("region");
                String info = rs.getString("info");
                String platform = rs.getString("platform");
                l = new LFG(user_id, gameTitle, platform,haveMic, language, region,info);
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
        return l;     // u may be null 
    }
}
