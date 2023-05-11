/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import business.Game;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author mcgeo
 */
public interface GameDaoInterface {

    public List<Game> findAllGames() throws IOException;

    public Game findGameById(int id) throws IOException;

}
