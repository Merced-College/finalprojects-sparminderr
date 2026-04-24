// Parminder Singh
// 4/21/26
// player attributes

import java.util.*;
public class Player {
    
    // player properties
    String name;
    int hp;
    String weapon;
    Inventory inventory;

    // creates hasmaps for the weapon
    HashMap<String, Integer> weaponDamage = new HashMap<>();

    // constructor for the player, and runs when player object is created
    public Player(String name) {
        this.name = name;
        this.hp = 20;
        this.weapon = "Knife";

        inventory = new Inventory();

        // data structure
        weaponDamage.put("Knife", 5);
        weaponDamage.put("Sword", 8);
    }

    // does the damage calculation
    public int attack() {
        int maxDamage = weaponDamage.get(weapon);
        return (int)(Math.random() * maxDamage);
    }

    // handles damage taken to player hp
    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println("Player HP: " + hp);
    }

}