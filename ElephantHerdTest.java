// written by pidap008

public class ElephantHerdTest {

    @org.junit.Test
    public void add() {
        ElephantHerd a = new ElephantHerd();
        Elephant b = new Elephant("Dovolis2", 31, 6.0);
        a.add(b);
        boolean result = false;
        if(a.find("Dovolis2") == b){
            result = true;
        }
        assert(result);
    }

    @org.junit.Test
    public void findTest() {
        ElephantHerd a = new ElephantHerd();
        Elephant b = new Elephant("Dovolis2", 31, 6.0);
        Elephant c = new Elephant("Dovolis3", 33, 6.1);
        Elephant d = new Elephant("Dovolis1", 32, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);

        boolean result = false;
        if(a.find("Dovolis3") == c){
            result = true;
        }
        assert(result);
    }

    @org.junit.Test
    public void remove() {
        ElephantHerd a = new ElephantHerd();
        Elephant b = new Elephant("Dovolis2", 31, 6.0);
        Elephant c = new Elephant("Dovolis3", 33, 6.1);
        Elephant d = new Elephant("Dovolis1", 32, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);

        boolean result = false;
        if(a.remove(1) == c){
            result = true;
        }
        assert(result);
    }

    @org.junit.Test
    public void sort() {
        ElephantHerd a = new ElephantHerd();
        ElephantHerd e = new ElephantHerd();

        Elephant b = new Elephant("Dovolis1", 31, 6.0);
        Elephant c = new Elephant("Dovolis2", 32, 6.1);
        Elephant d = new Elephant("Dovolis3", 33, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);
        a.sort();

        e.add(d);
        e.add(c);
        e.add(b);

        boolean result = false;
        if(a.toString().equals(e.toString())){
            result = true;
        }
        assert(result);
    }

    @org.junit.Test
    public void getTopKLargestElephants() {
        ElephantHerd a = new ElephantHerd();

        Elephant b = new Elephant("Dovolis1", 31, 6.0);
        Elephant c = new Elephant("Dovolis2", 32, 6.1);
        Elephant d = new Elephant("Dovolis3", 33, 6.2);
        Elephant e = new Elephant("Dovolis4", 34, 6.3);
        Elephant f = new Elephant("Dovolis5", 35, 6.4);
        a.add(c);
        a.add(e);
        a.add(b);
        a.add(f);
        a.add(d);

        Elephant[] herdArray = new Elephant[3];
        herdArray[0] = f;
        herdArray[1] = e;
        herdArray[2] = d;

        boolean result = true;
        Elephant[] top3Elephants = a.getTopKLargestElephants(3);
        for(int i = 0; i < top3Elephants.length; i++){
            if(top3Elephants[i].equals(herdArray[i]) == false){
                result = false;
            }
        }
        assert(result);
    }
}