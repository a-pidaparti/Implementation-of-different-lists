// written by pidap008

import static org.junit.Assert.*;

public class ArrayListTest {

    @org.junit.Test
    public void firstAddTest1() { // add to end
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        assertTrue(a.get(0) == b);
    }

    @org.junit.Test
    public void firstAddTest2(){
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        assertTrue(a.size() != a.length());
    }

    @org.junit.Test
    public void secondAddTest1() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        Elephant c = new Elephant( "Jensen", 31, 5.8);
        a.add(1,c);
        assertTrue(a.get(1) == c);
    }

    @org.junit.Test
    public void clear() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        a.clear();
        ArrayList<Elephant> c = new ArrayList<>();
        assertTrue(a.size() == c.size() && a.get(0) == c.get(0));
    }

    @org.junit.Test
    public void contains() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        assertTrue(a.contains(b));
    }

    @org.junit.Test
    public void get() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        assertTrue(a.get(0) == b);
    }

    @org.junit.Test
    public void indexOf() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        Elephant c = new Elephant( "Jensen", 31, 5.8);
        a.add(1,c);
        assertTrue(a.indexOf(c) == 1);
    }

    @org.junit.Test
    public void isEmpty() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        a.clear();
        assertTrue(a.isEmpty());
    }

    @org.junit.Test
    public void lastIndexOf() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        assertTrue(a.lastIndexOf(b) == 2);
    }

    @org.junit.Test
    public void set() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        Elephant c = new Elephant( "Jensen", 31, 5.8);
        a.set(1,c);
        assertTrue(a.get(1) == c);
    }

    @org.junit.Test
    public void size() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis", 30, 6.0);
        a.add(b);
        a.add(b);
        a.add(b);
        assertTrue(a.size() == 3);
    }

    @org.junit.Test
    public void sort1() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis2", 31, 6.0);
        Elephant c = new Elephant("Dovolis3", 33, 6.1);
        Elephant d = new Elephant("Dovolis1", 32, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);

        a.sort(true);
        boolean result = true;

        if(a.get(0) != d || a.get(1) != b || a.get(2) != c ){
                result = false;
        }
        assert(result);
    }

    @org.junit.Test
    public void sort2(){
        ArrayList<Elephant> a = new ArrayList<>();
        ArrayList<Elephant> e = new ArrayList<>();
        Elephant b = new Elephant("Dovolis3", 31, 6.0);
        Elephant c = new Elephant("Dovolis1", 33, 6.1);
        Elephant d = new Elephant("Dovolis2", 32, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);

        a.sort(false);
        boolean result = true;
        if(a.get(0) != b || a.get(1) != d || a.get(2) != c ){
            result = false;
        }
        assert(result);
    }

    @org.junit.Test
    public void firstRemove() {
        ArrayList<Elephant> a = new ArrayList<>();
        Elephant b = new Elephant("Dovolis1", 31, 6.0);
        Elephant c = new Elephant("Dovolis2", 33, 6.1);
        Elephant d = new Elephant("Dovolis3", 32, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);
        a.remove(b);

        boolean result = true;
        if(a.contains(b)){
            result = false;
        }
        assert(result);
    }

    @org.junit.Test
    public void secondRemove() {
        ArrayList<Elephant> a = new ArrayList<>();
        ArrayList<Elephant> e = new ArrayList<>();
        Elephant b = new Elephant("Dovolis3", 31, 6.0);
        Elephant c = new Elephant("Dovolis1", 33, 6.1);
        Elephant d = new Elephant("Dovolis2", 32, 6.2);
        a.add(b);
        a.add(c);
        a.add(d);
        a.remove(1);

        boolean result = true;
        if(a.contains(c)){
            result = false;
        }
        assert(result);
    }

    @org.junit.Test
    public void isSorted() {
        ArrayList<Elephant> a = new ArrayList<>();
        ArrayList<Elephant> e = new ArrayList<>();
        Elephant b = new Elephant("Dovolis3", 31, 6.0);
        Elephant c = new Elephant("Dovolis1", 33, 6.1);
        Elephant d = new Elephant("Dovolis2", 32, 6.2);
        a.add(c);
        a.add(d);
        a.add(d);
        a.sort(true);
        a.isSorted();
    }
}