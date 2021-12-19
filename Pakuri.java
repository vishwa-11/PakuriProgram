public class Pakuri {
    //creates necessary fields
    private String species;
    private int attack, defense, speed;
//initializes variables in constructor
    public Pakuri(String species) {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }
// all get methods return the necessary variable
    public String getSpecies() {
        return species;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
// the set methods change the necessary variables
    public void setAttack(int newAttack) {
        attack = newAttack;
    }

    public void setDefense(int newDefense) {
        defense = newDefense;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }
//the evolve method increases the fields and uses the set methods to do so
    public void evolve() {
        setAttack(attack * 2);
        setDefense(defense * 4);
        setSpeed(speed * 3);
    }
}
