// written by pidap008

import javax.annotation.processing.SupportedSourceVersion;

import static org.junit.Assert.*;

public class LinkedListTest {

    @org.junit.Test
    public void add() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        boolean result = test1.toString().equals("Dovolis\n");
        System.out.println(test1.toString());
        assertTrue(result);
    }

    @org.junit.Test
    public void add1() {
        LinkedList test1 = new LinkedList();
        System.out.println();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        test1.add(1,"Vuk");
        boolean result = test1.toString().equals("Dovolis\nVuk\nJensen\nLarson\nChallou\n");
        assertTrue(result);
    }

    @org.junit.Test
    public void clear() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        test1.clear();
        LinkedList test2 = new LinkedList();
        boolean result = test1.toString() == test2.toString();
        assertTrue(result);
    }

    @org.junit.Test
    public void contains() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        assertTrue(test1.contains("Larson"));
    }

    @org.junit.Test
    public void get() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        boolean result = test1.get(1).equals("Jensen");
        assertTrue(result);
    }

    @org.junit.Test
    public void indexOf() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        boolean result = test1.indexOf("Jensen") == 1;
        assertTrue(result);
    }

    @org.junit.Test
    public void isEmpty() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        test1.clear();
        System.out.println(test1);
        boolean result = test1.isEmpty();
        assertTrue(result);
    }

    @org.junit.Test
    public void lastIndexOf() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Jensen");
        boolean result = test1.lastIndexOf("Jensen") == 3;
        assertTrue(result);
    }

    @org.junit.Test
    public void set() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        test1.set(2, "Dovolis");
        boolean result = test1.get(2).equals("Dovolis");
        assertTrue(result);
    }

    @org.junit.Test
    public void size() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        test1.add("Jensen");
        test1.add("Larson");
        test1.add("Challou");
        boolean result = test1.size() == 4;
        assertTrue(result);
    }

    @org.junit.Test
    public void sort() {
        LinkedList test1 = new LinkedList();
        test1.add("2");
        test1.add("1");
        test1.add("4");
        test1.add("3");
        test1.sort(true);
        boolean result = test1.toString().equals("1\n2\n3\n4\n");
        assertTrue(result);
    }

    @org.junit.Test
    public void remove() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        String s = "Jensen";
        test1.add(s);
        test1.add("Larson");
        test1.add("Challou");
        test1.remove(s);
        boolean result = false;
        if(!test1.contains(s)){
            result = true;
        }
        assertTrue(result);
    }

    @org.junit.Test
    public void remove1() {
        LinkedList test1 = new LinkedList();
        test1.add("Dovolis");
        String s = "Jensen";
        test1.add(s);
        test1.add("Larson");
        test1.add("Challou");
        test1.remove(1);
        boolean result = !test1.contains(s);
        assertTrue(result);
    }
}