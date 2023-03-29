/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import business.GameBarter;
import java.util.List;

/**
 *
 * @author Samue
 */
interface GameBarterDaoInterface {
    
    public List<GameBarter> findAllBarters();
    
    public GameBarter findGameBarterBygameToTrade(String gameTitle);
}
