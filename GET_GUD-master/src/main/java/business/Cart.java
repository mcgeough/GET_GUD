/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author mcgeo
 */
public class Cart {

    private int id;
    private ArrayList<Game> games;

    public Cart() {
        this.games = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public int cartSize() {
        return games.size();
    }

    public void setBooks(ArrayList<Game> Games) {
        this.games = Games;
    }

    public void addToCart(Game game) {
        this.games.add(game);
    }

    public void clearCart() {
        games.clear();
    }
}
