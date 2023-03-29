/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import business.LFG;
import java.util.List;

/**
 *
 * @author Samue
 */
interface LFGDaoInterface {
    
     public List<LFG> findAllLFGs();
     
      public LFG findLFGByTitle(String title);
}
