// Parminder Singh
// 4/21/26

public class Monster {

    String name;
    int hp;

    // constructor for the monster
    public Monster(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    // handles how much monster is dealing
    public int attack() {
        return (int)(Math.random() * 4);
    }

    // handles how much damage monster is taking
    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println(name + " HP: " + hp);
    }

    // checks if it's alive 
    public boolean isAlive() {
        return hp > 0;
    }
}