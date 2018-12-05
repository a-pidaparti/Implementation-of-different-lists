// written by pidap008

import java.lang.reflect.Array;

public class ElephantHerd {
    private ArrayList<Elephant> list;

    public ElephantHerd(){
        list = new ArrayList<Elephant>();
    }

    public boolean add(Elephant ellie){
        return list.add(ellie);
    }

    public Elephant find(String name){
        for(int i = 0; i < list.size(); i++){
            Elephant tempElephant = list.get(i);
            if(tempElephant.getName().contains(name)){
                return tempElephant;
            }
        }
        return null;
    }

    public Elephant remove(int index){
        return list.remove(index);
    }

    public void sort() {
        Elephant tempElephant = list.get(0);
        ArrayList<Elephant> tempHerd = new ArrayList<>();
        int elephantCount = 0;
        while (elephantCount < list.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (tempElephant != null && list.get(i) != null && tempElephant.getHeight() <= list.get(i).getHeight()) {
                    tempElephant = list.get(i);
                }
            }
            tempHerd.add(tempElephant);
            list.remove(tempElephant);
            for (int i = 0; i < list.size(); i++) {    // finds first object that is not null
                if (list.get(i) != null) {
                    tempElephant = list.get(i);
                    i = list.size();
                }
            }
            elephantCount++;
        }
        list = tempHerd;
    }

    public Elephant[] getTopKLargestElephants(int k){
        if(k < 0 | k > list.size()){
            return null;
        }
        ArrayList<Elephant> sortedHerd = list;
        sortedHerd.sort(false); //sorts by ascending order
        Elephant [] tempArray = new Elephant[k];
        for(int i = 0; i < k; i ++){
            tempArray[i] = sortedHerd.get(i);
        }
        return tempArray;
    }

    public String toString(){
        String outString = "";
        for (int i = 0; i < list.size(); i ++){
            outString += list.get(i) + "\n";
        }
        return outString;
    }
}
