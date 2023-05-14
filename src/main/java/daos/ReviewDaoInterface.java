/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import business.Review;
import java.io.IOException;

/**
 *
 * @author mcgeo
 */
public interface ReviewDaoInterface {

    public Review findReviewByGameId(int id) throws IOException;
}
