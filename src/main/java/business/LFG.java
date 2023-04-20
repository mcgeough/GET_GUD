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
public class LFG {

    private int id;
    private int user_id;
    private String gameTitle;
    private String platform;
    private boolean haveMic;
    private String language;
    private String region;
    private String info;

    
    public LFG(int id, int user_id, String gameTitle, String platform, boolean haveMic, String language, String region, String info) {
        this.id = id;
        this.user_id = user_id;
        this.gameTitle = gameTitle;
        this.platform = platform;
        this.haveMic = haveMic;
        this.language = language;
        this.region = region;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isHaveMic() {
        return haveMic;
    }

    public void setHaveMic(boolean haveMic) {
        this.haveMic = haveMic;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.user_id;
        hash = 53 * hash + Objects.hashCode(this.gameTitle);
        hash = 53 * hash + Objects.hashCode(this.platform);
        hash = 53 * hash + (this.haveMic ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.language);
        hash = 53 * hash + Objects.hashCode(this.region);
        hash = 53 * hash + Objects.hashCode(this.info);
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
        final LFG other = (LFG) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.haveMic != other.haveMic) {
            return false;
        }
        if (!Objects.equals(this.gameTitle, other.gameTitle)) {
            return false;
        }
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        return Objects.equals(this.info, other.info);
    }

    @Override
    public String toString() {
        return "LFG{" + "id=" + id + ", user_id=" + user_id + ", gameTitle=" + gameTitle + ", platform=" + platform + ", haveMic=" + haveMic + ", language=" + language + ", region=" + region + ", info=" + info + '}';
    }

}
