/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.Objects;

/**
 *
 * @author Samue
 */
public class GameBarter {
  private int Barter_id;
  private int user_id;
  private String username; 
  private String gameToTrade; 
  private String wanted_game; 
  private String Misc; 

    public GameBarter(int Barter_id, int user_id, String username, String gameToTrade, String wanted_game, String Misc) {
        this.Barter_id = Barter_id;
        this.user_id = user_id;
        this.username = username;
        this.gameToTrade = gameToTrade;
        this.wanted_game = wanted_game;
        this.Misc = Misc;
    }

    public int getBarter_id() {
        return Barter_id;
    }

    public void setBarter_id(int Barter_id) {
        this.Barter_id = Barter_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGameToTrade() {
        return gameToTrade;
    }

    public void setGameToTrade(String gameToTrade) {
        this.gameToTrade = gameToTrade;
    }

    public String getWanted_game() {
        return wanted_game;
    }

    public void setWanted_game(String wanted_game) {
        this.wanted_game = wanted_game;
    }

    public String getMisc() {
        return Misc;
    }

    public void setMisc(String Misc) {
        this.Misc = Misc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.Barter_id;
        hash = 37 * hash + this.user_id;
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.gameToTrade);
        hash = 37 * hash + Objects.hashCode(this.wanted_game);
        hash = 37 * hash + Objects.hashCode(this.Misc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameBarter other = (GameBarter) obj;
        if (this.Barter_id != other.Barter_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.gameToTrade, other.gameToTrade)) {
            return false;
        }
        if (!Objects.equals(this.wanted_game, other.wanted_game)) {
            return false;
        }
        return Objects.equals(this.Misc, other.Misc);
    }

    @Override
    public String toString() {
        return "GameBarter{" + "Barter_id=" + Barter_id + ", user_id=" + user_id + ", username=" + username + ", gameToTrade=" + gameToTrade + ", wanted_game=" + wanted_game + ", Misc=" + Misc + '}';
    }
       
  
}
