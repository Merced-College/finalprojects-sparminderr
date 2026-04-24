// Parminder Singh
// 4/21/26
// controls game flow and the navigation of the main world

import java.util.*;
public class Game {

    // keyboard usage, player,monster,and choice objects
    Scanner scanner = new Scanner(System.in);
    Player player;
    Monster monster;
    int choice;

    //  starts the game, write the name, and handles the enemy
    public void start() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        player = new Player(name);
        monster = new Monster("Goblin", 15);
        townGate();
    }

    // from before, town gate start of the game, and saves it to the history stack
    // handles player choices and logics
    public void townGate() {

        System.out.println("\nYou are at the town gate!");
        System.out.println("\n1: Talk to the guard");
        System.out.println("\n2: Go to the crossroad");

        int choice = scanner.nextInt();

        if (choice == 1) {
            if (player.inventory.hasAllItems()){
                ending();
            } 
            else {
                System.out.println("Guard: You do not have all the items.");
                townGate();
            }
            else if (choice == 2){
                crossroad();
            }
            else {
                townGate();
            }
    }

    // first location, handles multiple paths
    public void crossroad() {

        System.out.println("\n~~Crossroad~~");
        System.out.println("1: North (River)");
        System.out.println("2: East (Sword)");
        System.out.println("3: West (Forest)");
        System.out.println("4: Back to town");

        choice = scanner.nextInt();

        if (choice == 1){
            river();
        }
        else if (choice == 2) {
            SwordPath();
        }
        else if ( choice == 3){
            forestFight();
        }
        else {
            townGate();
        }
    }

    // handles the north
    public void river() {
        System.out.println("You find a resting place (+1 HP");
        player.hp += 1;
        crossroad();
    }
    // handles the east 
    public void SwordPath() {
        System.out.println("You found a sword!");
        player.weapon = "Sword";
        crossroad();
    }

    // handles the west
    public void forestFight() {
        monster = new Monster("Goblin", 10);
        fight("Silver Ring");
    }

    //

    // handles fight logic in the game, taking and receiving damage. Also deals with defeating/win condition for the enemy.
    public void fight(String rewardItem) {
        System.out.println("\n FIGHT STARTS");
        while (monster.hp > 0 && player.hp > 0){
            System.out.println("1: Attack");
            System.out.println("2: Run");

            choice = scanner.nextInt();

            if (choice == 1) {
                int damage = player.attack();
                monster.hp -= damage;
                System.out.println("You Win!");
                player.inventory.addItem(rewardItem);
                crossroad();
                return;
            }

            int monsterDamage = monster.attack();
            player.hp -= monsterDamage;
            System.out.println("Monster hits you for " + monsterDamage);

            if (player.hp <= 0) {
                dead();
                return;
            }
            else {
                crossroad();
                return;
            }
        }
    }

    // handles the ending of the game, prints out whether you won or lost
    public void ending(){

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("GUARD: You proved worthy, well done!");
        System.out.println("You collected all 3  items!");
        System.out.println("WELCOME TO THE TOWN!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

    // handles when player dies
    public void dead() {
        System.out.println("\nYou Died!");
    }
}