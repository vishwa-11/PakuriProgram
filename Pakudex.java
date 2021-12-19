public class Pakudex {
//sets necessary fields
    private int size = 0;
    private int capacity;
    private Pakuri[] speciesArray = null;

    public Pakudex() {
        capacity = 20;
    }
//constructor
    public Pakudex(int capacity) {
        this.capacity = capacity;
        speciesArray = new Pakuri[capacity];
    }
    //these two methods return both size and capacity
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
//converts the Pakuri array to a String array
    public String[] getSpeciesArray() {
        //null is returned if no elements present
        if (size == 0) {
            return null;
        }
        //iteratively adds converted elements to string array using for loop and getSpecies method
        String[] species = new String[size];
        int i;
        for (i = 0; i < size; i++) {
            species[i] = speciesArray[i].getSpecies();
        }
        return species;
    }

    public int[] getStats(String species) {
        int[] speciesStats = new int[3];
        int i;
        //checks if the pakuri is present in the array, and then uses get methods from Pakuri class to equate the stats int array indices to the necessary values
        for (i = 0; i < size; i++) {
            Pakuri currentPakuri = speciesArray[i];
            if (currentPakuri.getSpecies().equalsIgnoreCase(species)) {
                speciesStats[0] = currentPakuri.getAttack();
                speciesStats[1] = currentPakuri.getDefense();
                speciesStats[2] = currentPakuri.getSpeed();
                break;
            }
        }
        // if the species is not present, a null value is returned
        if (checkIfSpeciesPresent(species) == false) {
            return null;
        }
        return speciesStats;
    }

    public void sortPakuri() {
        String[] species = new String[size];
        String[] sortedSpecies = new String[size];
        Pakuri[] pakuri = new Pakuri[capacity];
        int i, j, k, l, m, n, o;
        int alphabeticalCount = 0;
        //makes the string array from Pakuri array
        for (i = 0; i < size; i++) {
            species[i] = speciesArray[i].getSpecies();
        }
        // counts how many elements a certain element is less than lexicographically within the array
        for (j = 0; j < size; j++) {
            for (k = 0; k < size; k++) {
                if (species[j].compareTo(species[k]) < 0) {
                    alphabeticalCount++;
                }
            }
            //index is determined off this count
            sortedSpecies[size - alphabeticalCount - 1] = species[j];
            alphabeticalCount = 0;
        }
        //the sorted string array is used to amend the normal string array
        for (l = 0; l < size; l++) {
            species[l] = sortedSpecies[l];
        }
        //another loop is used to build a pakuri array that is sorted
        for (m = 0; m < size; m++) {
            for (n = 0; n < size; n++) {
                if (species[m].equalsIgnoreCase(speciesArray[n].getSpecies())) {
                    pakuri[m] = speciesArray[n];
                }
            }
        }
        // the original pakuri array is now sorted by equating its elements to the elements of the previously sorted pakuri array
        for (o = 0; o < size; o++) {
            speciesArray[o] = pakuri[o];
        }


    }

    public boolean addPakuri(String species) {
        int speciesMatch = 0;
        boolean success;
        String[] species1 = new String[size];
        int i;
        //checks if a species is present
        for (i = 0; i < size; i++) {
            species1[i] = speciesArray[i].getSpecies();
            if (species.equalsIgnoreCase(species1[i])) {
                speciesMatch = 1;
                break;
            }
        }
        //if not present, then it is added, otherwise it is not
        if (speciesMatch == 0) {
            success = true;
            Pakuri pakuri = new Pakuri(species);
            size++;
            speciesArray[size - 1] = pakuri;
        }
        else {
            success = false;
        }
        return success;
    }

    public boolean evolveSpecies(String species) {
        // checks if species is present. if so, then evolves the species
        int match = 0;
        boolean success;
        int i;
        for (i = 0; i < size; i++) {
            Pakuri currentPakuri = speciesArray[i];
            if (currentPakuri.getSpecies().equalsIgnoreCase(species)) {
                currentPakuri.evolve();
                match++;
                break;
            }
        }
        // if a match is reached, then that means something was evolved and true is returned. otherwise false
        if (match == 1) {
            success = true;
        }
        else {
            success = false;
        }
        return success;
    }
// this method is made to check if a species is already present in the pakuri array. This means i don't need to use the evolve method to check whether a species is present in the array when carrying out option 4 in the main method. This isolates this process.
    public boolean checkIfSpeciesPresent(String species) {
        boolean present;
        int i;
        int match = 0;
        for (i = 0; i < size; i++) {
            Pakuri currentPakuri = speciesArray[i];
            if (currentPakuri.getSpecies().equalsIgnoreCase(species)) {
                match++;
                break;
            }
        }
        //if a match is reached, then true. otherwise false.
        if (match == 1) {
            present = true;
        }
        else {
            present = false;
        }
        return present;
    }
}
