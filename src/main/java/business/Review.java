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
public class Review {
  private int id ;
  private String Description;
  private String gameTitle;
  private float Rating;
  private int user_id ;

    public Review(int id, String Description, String gameTitle, float Rating, int user_id) {
        this.id = id;
        this.Description = Description;
        this.gameTitle = gameTitle;
        this.Rating = Rating;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float Rating) {
        this.Rating = Rating;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.Description);
        hash = 67 * hash + Objects.hashCode(this.gameTitle);
        hash = 67 * hash + Float.floatToIntBits(this.Rating);
        hash = 67 * hash + this.user_id;
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
        final Review other = (Review) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.Rating) != Float.floatToIntBits(other.Rating)) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        return Objects.equals(this.gameTitle, other.gameTitle);
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", Description=" + Description + ", gameTitle=" + gameTitle + ", Rating=" + Rating + ", user_id=" + user_id + '}';
    }
  
  
}
