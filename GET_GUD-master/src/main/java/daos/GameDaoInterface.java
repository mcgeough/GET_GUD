/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import business.Game;
import java.util.List;

public interface GameDaoInterface {

    public List<Game> findAllGames();

    public Game findGameById(int id);
}
