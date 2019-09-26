package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class TownSet {
    private static TownSet instance = null;
    private Set<Town> townSet;

    public static TownSet getInstance(){
        if (instance == null)
            instance = new TownSet();
        
        return instance;
    }
    public TownSet() {
        townSet = new HashSet<Town>();
        TownFactory townFactory = new TownFactory();
        Town town = townFactory.getNextTown(); ;
        while (town != null){
            townSet.add(town);
            town = townFactory.getNextTown();
        }
    }

    public void addTown(Town newTown) {
        townSet.add(newTown);
    }

    public void removeTown(Town oldTown) {
        townSet.remove(oldTown);
    }

    public int size() {
        return townSet.size();
    }

    public Set<Town> getTownSet(int from, int to) {
        Set<Town> result = new HashSet<Town>();
        int i = 0;
        for (Town town : townSet) {
            if (i >= from) {
                result.add(town);
            }
            if (i >= to) {
                return result;
            }
            i++;
        }
        return result;
    }
}