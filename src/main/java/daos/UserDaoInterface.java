/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import business.User;
import java.sql.Date;
import java.util.List;

public interface UserDaoInterface {

    public List<User> findAllUsers();

    public User findUserByUsernamePassword(String uname, String pword);

    public User findUserById(int id);

    public int addUser(String uname, String pword, String mail, String fName, String lName,int isCrit, int isAd);
}
