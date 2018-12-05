// written by pidap008

public class ArrayList<T extends Comparable<T>> implements List<T> {
    private static boolean isSorted = true;
    private T[] a;
    private int size = 0;

    public ArrayList(){
        a = (T[]) new Comparable[2];
    } // constructor

    public boolean add(T other){  //adds to end, doesn't insert
        if(other == null){ // checks for null
            return false;
        }
        if (size < a.length){ // checks if array large enough
            a[size] = other;
            size ++;
        }
        else{ // if not big enough, grows and copies
            growAndCopy();
            a[size] = other;
            size++;
        }
        isSorted();
        return true;
    } // add to end method

    public boolean add(int index, T other){ // inserts
        if(other == null | index >= a.length | index < 0){ // checks if null or out of bounds
            return false;
        }
        T[] tempArray = (T[]) new Comparable[a.length + 1];
        tempArray[index] = other;
        int originalIndex = 0;
        for(int i = 0; i < tempArray.length; i ++){
            if (tempArray[i] == null){ // if place in tempArray is null, inserts value, otherwise, it moves on
                tempArray[i] = a[originalIndex];
            }
            else{
                originalIndex --; // offsets indexing of original array after other is passed so
            }                     // that the original value is placed after other
            originalIndex ++;
        }
        a = tempArray;
        isSorted();
        return true;
    } // insertion add method

    public void clear(){
        size = 0;
        a = (T[]) new Comparable[2];
    } // clear method

    public boolean contains(T obj){
        boolean contains = false;
        if(isSorted) {
            int index = findObjLower(0, size, obj);
            if(index != -1){
                contains = true;
            }
        }
        for(int i = 0; i < a.length; i ++){
            if(a[i] == obj){
                return true;
            }
        }
        return contains;
    } // contains method

    public T get(int index) {
        if (index < a.length && index >= 0) { //checks if index is in bounds
            return a[index];
        }
        else {
            return null;
        }
    } // get method

    public int indexOf(T obj){
        if(obj ==  null){
            return -1;
        }
        if(isSorted){
            int i = 0;
            while(i + 2 < a.length){
                if(a[i].compareTo(obj) < 0 && a[i + 2].compareTo(obj) > 0){
                    if(a[i + 1] == obj){
                        return i + 1;
                    }
                }
                else if(a[i].compareTo(obj) > 0){
                    return -1;
                }
                else if(a[i].compareTo(obj) < 0 && a[i + 2].compareTo(obj) < 0){
                    i = i + 2;
                }
                i++;
            }
        }
        for(int i = 0; i < a.length - 1; i ++){
            if(a[i] == obj){
                return i;
            }

        }
        return -1;
    } // indexOf method

    public boolean isEmpty() {
        boolean isEmpty = true; //assumes is empty, iterates through to find non-null object
        for(int i = 0; i < a.length; i++){
            if(a[i] != null){
                return false;
            }
        }
        return isEmpty;
    } // isempty method

    public int lastIndexOf(T obj){
        if(obj == null){
            return -1;
        }
        if(isSorted){
            return findObjUpper(0, size, obj);
        }
        int i = a.length - 1;
        while(i >= 0){
            if(a[i] == obj){
                return i;
            }
            i --;
        }
        return -1;
    } // index of method

    public T set(int index, T obj){
        if(index >= a.length | index < 0 | obj == null){
            return null;
        }
        T tempObj = a[index];
        a[index] = obj;
        return tempObj;
    } // set index

    public int size(){
        isSorted();
        return size;
    } // size method

    public void sort(boolean order) {
        if(isSorted == false) { // checks if not sorted already
            T currentObj = a[0];
            T[] tempArray = (T[]) new Comparable[a.length];
            int newArrayIndex = 0;
            int objectCount = 0;
            while(objectCount < size) {
                if (order) {    // finds smallest object to place in first spot
                        for (int i = 0; i < a.length; i++) {
                            if (currentObj != null && a[i] != null && currentObj.compareTo(a[i]) >= 0) {
                                currentObj = a[i];
                            }
                        }
                    }
                else {    // finds largest object to place in first spot
                        for (int i = 0; i < a.length; i++) {
                            if (currentObj != null && a[i] != null && currentObj.compareTo(a[i]) < 0) {
                                currentObj = a[i];
                            }
                        }
                    }
                tempArray[newArrayIndex] = currentObj;
                for (int i = 0; i < a.length; i++) {    //nulls the object in the original array, so it doesn't trip up
                    if (a[i] == currentObj) {           // finding the largest/smallest object
                        a[i] = null;
                        i = a.length;
                    }
                }
                for (int i = 0; i < a.length; i++) {    // finds first object that is not null
                    if (a[i] != null) {
                        currentObj = a[i];
                        i = a.length;
                    }
                }
                objectCount++;
                newArrayIndex++;
            }
            a = tempArray;
            isSorted = true;
        }
    } // sort method

    public boolean remove(T obj) {
        T[] tempArray = (T[]) new Comparable[a.length - 1];
        for (int i = 0; i < a.length; i++) {    // finds index of object to be removed
            if (a[i] == obj) {  //
                int tempIndex = 0;
                a[i] = null;
                while (tempIndex < i){  // adds all objects before removed object to tempArray
                    tempArray[tempIndex] = a[tempIndex];
                    tempIndex ++;
                }
                while (tempIndex < tempArray.length){   // adds all objects after removed object to tempArray
                    tempArray[tempIndex] = a[tempIndex + 1];
                    tempIndex ++;
                }
                a = tempArray;
                return true;
            }
        }
        return false;
    } // remove by index

    public T remove(int index){
        if(index > a.length - 1 | index < 0){
            return null;
        }
        T tempObj = a[index];
        int tempIndex = 0;
        T[] tempArray = (T[]) new Comparable[a.length - 1];
        a[index] = null;
        while (tempIndex < index){  // adds objects before removed object to tempArray
            tempArray[tempIndex] = a[tempIndex];
            tempIndex ++;
        }
        while (tempIndex < tempArray.length){   // adds objects after removed object to tempArray
            tempArray[tempIndex] = a[tempIndex + 1];
            tempIndex ++;
        }
        a = tempArray;
        return tempObj;
    } // remove by index method

    public String toString(){
        String outString = "";
        for(int i = 0; i < a.length; i++){  // iterates through list and adds non-null elements to outString
            if(a[i] != null){
                outString = outString + a[i] + "\n";
            }
        }
        return outString;
    } // toString method

    public void isSorted(){
        int index = 0;
        boolean forwardSorted = true;
        boolean backwardSorted = true;
        while(index < a.length - 1){
            if(a[index + 1] != null && a[index]!= null && a[index].compareTo(a[index + 1]) < 0){
                forwardSorted = false;
                index = a.length;
            }
            index++;
        }
        index = 0;
        while(index < a.length - 1) {
            if (a[index + 1] != null && a[index] != null && a[index].compareTo(a[index + 1]) > 0) {
                backwardSorted = false;
                index = a.length;
            }
            index++;
        }
        if(forwardSorted | backwardSorted){
            isSorted = true;
        }
        else{
            isSorted = false;
        }
    } // isSorted method

    public void growAndCopy(){
        T[] tempArray = (T[]) new Comparable[a.length * 2];
        System.arraycopy(a, 0, tempArray, 0, a.length);
        a = tempArray;
    } // growAndCopy method

    public int length(){
        return a.length;
    }

    public int findObjLower(int lower, int upper, T obj){       // recursively finds first object
        upper--;
        if(a[lower] == obj){    //checks if a[lower] is object      also base cases
            return lower;
        }
        if(upper == lower){     //if a[lower] != object and upper == lower, then there are no more objects left to check, it doesn't contain it
            return -1;
        }
        else{   //begin actual recursion section / reduction cases
            int newBound = upper - lower;
            if(a[upper - lower] != null && obj.compareTo(a[upper - lower]) > 0){    // checks nullity and if object is in upper half of array
                return findObjLower(newBound, upper, obj);
            }
            return findObjLower(lower, newBound, obj);  // reduce if a[upper - lower] <= obj to lower half
        }
    }

    public int findObjUpper(int lower, int upper, T obj){
        upper--;
        if(a[upper] == obj){    //checks if a[upper] is object and base cases
            return upper;
        }
        if(upper == lower){     // if a[upper] == a[lower] and a[upper] != lower, there is no more reduction possible, it doesn't contain it
                return -1;
            }
        else{
            int newBound = upper - lower;
            if(a[upper - lower] != null && obj.compareTo(a[upper - lower]) > 0){    // if a[upper - lower] > obj, then reduces list to upper half
                return findObjLower(newBound, upper, obj);
            }
            return findObjLower(lower, newBound, obj);  // if a[upper - lower] <= obj, then reduces to lower half
        }
    }

} // class
