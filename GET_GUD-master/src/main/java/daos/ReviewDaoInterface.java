/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import business.Review;
import java.util.List;

/**
 *
 * @author Samue
 */
interface ReviewDaoInterface {
   
    public List<Review> findAllReviews();
    
    public Review findReviewByTitle(String title);
}
