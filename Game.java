// Parminder Singh
// 4/21/26
// controls game flow and the navigation of the main world

import java.util.*;
public class Game {

    // keyboard usage as wel lass player and monster objects 
    Scanner scanner = new Scanner(System.in);
    Player player;
    Monster monster;
    Stack<String> history = new Stack<>();

    // 
    public void start() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        player = new Player(name);
        monster = new Monster("Goblin", 15);
        townGate();
    }

    // from before, town gate start of the game, and saves it to the history stack
    // holds player choices and logics
    public void townGate() {
        history.push("Town Gate");

        System.out.println("\nYou are at the town gate!");
        System.out.println("\n1: Go to the forest");
        System.out.println("\n2: View Inventory");

        int choice = scanner.nextInt();

        if (choice == 1) {
            forest();
        } 
        else if (choice == 2){
            player.inventory.showItems();
            townGate();
        }
        // recursion
        else {
            retry(townGateLoop -> townGate()); 
        }
    }

    // another location 
    public void forest() {
        history.push("Forest");

        System.println("\nA Monster jumps out!");
        fight();
    }

    // handles fight logic in the game, taking and receiving damage. Also deals with defeating/win condition for the enemy.
    public void fight() {
        System.out.println("1: Attack \n2: Run");
        int choice = scanner.nextInt();

        if (choice == 1) {
            int damage = player.attack();
            monster.takeDamage(damage);

            if (monster.isAlive()) {
                player.takeDamage(monster.attack());
                fight();
            }
            else {
                System.out.println("You win!");
                player.Inventory.addItem("Silver Ring");
                townGate();
            }
            else {
                townGate();
            }
        }
    }

    // recursion
        public void retry(Runnable action) {
            System.out.println("Invalid choice. Try again.");
            action.run();
        }
}