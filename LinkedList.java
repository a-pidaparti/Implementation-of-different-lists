// written by pidap008
import javax.annotation.processing.SupportedSourceVersion;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    public boolean isSorted;
    public Node head = new Node();
    private int length;

    public LinkedList() {
        isSorted = true;
        length = 0;
    }

    public boolean add(T element) { // add at end
        Node tempNode = head;
        if (element == null) {
            return false;
        }
        if(tempNode.getData() == null && length == 0){
            head.setData(element);
            length ++;
            return true;
        }
        while (tempNode.getNext() != null) {    // goes to end of linked list
            tempNode = tempNode.getNext();
        }
        Node nextNode = new Node();
        nextNode.setData(element);
        tempNode.setNext(nextNode);
        isSorted = false;
        length++;
        return true;
    }

    public boolean add(int index, T element) {      // add at specific index
        if (index < length && element != null) {
            Node firstNode = head;
            for (int i = 0; i < index - 1; i++) { // finds object at index
                firstNode = firstNode.getNext();
            }
            Node secondNode = firstNode.getNext();    // node after index
            Node tempNode = new Node();
            tempNode.setData(element);  // inserts new node in between
            tempNode.setNext(secondNode);
            firstNode.setNext(tempNode);
            isSorted = false;
            length++;
            return true;
            /* This method finds the object right before the index, sets its pointer to the new object, and sets the
            new object's pointer to the next object
             */
        }
        return false;
    }

    public void clear() {
        Node tempNode = new Node();
        head = tempNode;
        length = 0;
    }

    public boolean contains(T element) {
        Node tempNode = head;
        if (!isSorted) {
            for (int i = 0; i < length; i++) {    // goes through list to see if object is in it
                if (tempNode.getData() == element) {
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        } else {
            Node endNode = tempNode;
            int count = 0;

            /* This searching method is more efficient because it divides total search time by 10. It skips ahead 5
            nodes and checks if the data is greater than the element. If it is, another node that is 5 nodes behind the
            first node iterates forward and checks if the element is in there.
             */
            while (count < length) {
                if (length - count < 10) {
                    for (int i = 0; i < length - count; i++) {   //skips ahead length - count
                        tempNode = tempNode.getNext();
                        count++;
                    }
                } else {
                    for (int i = 0; i < 10; i++) {   //skips ahead 10
                        tempNode = tempNode.getNext();
                        count++;
                    }
                }
                if (tempNode.getData() == element) { //if element is in tempNode
                    return true;
                }
                if (tempNode.getData().compareTo(element) > 0) {    // if the object has been passed
                    for (int i = 0; i < 10; i++) {
                        if (endNode.getNext() == null) {  //if there isn't another object
                            return false;
                        }
                        if (endNode.getData() != null && endNode.getData() == element) {    //if data isn't null and data equals element
                            return true;
                        }
                        endNode = endNode.getNext();
                    }
                    return false;   //if the for loop finishes without finding the object, and the tempNode is greater than the element, the element isn't in it
                }
            }
        }
        return false;
    }

    public T get(int index) {   // returns object at index
        Node tempNode = head;
        if (index >= length) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }
        T data = (T) tempNode.getData();
        return data;
    }

    public int indexOf(T element) {   // finds first instance of object
        Node tempNode = head;
        if (element == null) {    //checks null
            return -1;
        }
        if (isSorted) {
            Node endNode = tempNode;
            int count = 0;
            int index = 0;

            /* This searching method is more efficient because it divides total search time by 10. It skips ahead 10
            nodes and checks if the data is greater than the element. If it is, another node that is 10 nodes behind the
            first node iterates forward and checks if the element is in there.
             */
            while (count < length) {
                if (length - count < 10) {
                    for (int i = 0; i < length - count; i++) {   //skips ahead length - count
                        tempNode = tempNode.getNext();
                        count++;
                    }
                } else {
                    for (int i = 0; i < 10; i++) {   //skips ahead 10
                        tempNode = tempNode.getNext();
                        count++;
                    }
                }
                if (tempNode.getData() == element) { //if element is in tempNode
                    return index;
                }
                if (tempNode.getData().compareTo(element) > 0) {    // if the object has been passed
                    for (int i = 0; i < 10; i++) {
                        if (endNode.getNext() == null) {  //if there isn't another object
                            return -1;
                        }
                        if (endNode.getData() != null && endNode.getData() == element) {    //if data isn't null and data equals element
                            return index;
                        }
                        endNode = endNode.getNext();
                        index++;
                    }
                    return -1;   //if the for loop finishes without finding the object, and the tempNode is greater than the element, the element isn't in it
                }
            }
            return -1;
        } else {
            for (int i = 0; i < length; i++) {    //iterates by checking tempNode then setting tempNode to next
                if (tempNode.getData() == element) {
                    return i;
                }
                tempNode = tempNode.getNext();
            }
            return -1;
        }
    }

    public boolean isEmpty() {  // returns true if list is empty
        Node tempNode = head;
        for (int i = 0; i < length; i++) { // iterates through list to find any object that isn't null
            if (tempNode.getData() != null || tempNode != null) {
                return false;
            }
            tempNode = tempNode.getNext();
        }
        return true;
    }

    public int lastIndexOf(T element) {   // finds last instance of element in List
        int lastIndex = -1;
        Node tempNode = head;
        if (element == null) {    //checks null
            return -1;
        }
        if (isSorted) {
            Node endNode = tempNode;
            int count = 0;
            int index = 0;
            int outIndex = -1;

            /* This searching method is more efficient because it divides total search time by 10. It skips ahead 10
            nodes and checks if the data is less than the element. If it is, another node that is 10 nodes behind the
            first node iterates forward and checks if the element is in there.
             */
            while (count < length) {
                if (length - count < 10) {
                    for (int i = 0; i < length - count; i++) {   //skips ahead length - count
                        tempNode = tempNode.getNext();
                        count++;
                    }
                } else {
                    for (int i = 0; i < 10; i++) {   //skips ahead 10
                        tempNode = tempNode.getNext();
                        count++;
                    }
                }
                if (tempNode.getData() == element) { //if element is in tempNode
                    index = outIndex;
                }
                if (tempNode.getData().compareTo(element) > 0) {    // if the object has been passed
                    for (int i = 0; i < 10; i++) {
                        if (endNode.getNext() == null) {  //if there isn't another object
                            return -1;
                        }
                        if (endNode.getData() != null && endNode.getData() == element) {    //if data isn't null and data equals element
                            index = outIndex;
                        }
                        endNode = endNode.getNext();
                        index++;
                    }
                }
            }
            return outIndex;
        }
        else {
            for (int i = 0; i < length; i++) {
                if (tempNode.getData() == element) {
                    lastIndex = i;
                }
                tempNode = tempNode.getNext();
            }
            return lastIndex;
        }
    }

    public T set(int index, T element){
        Node tempNode = head;
        if(index < length && element != null){
            for(int i = 0; i < index; i++){
                tempNode = tempNode.getNext();
            }
            T tempData = (T) tempNode.getData();
            tempNode.setData(element);
            return tempData;
        }
        return null;
    }   // sets object at index

    public int size(){
        int count = 0;
        Node tempNode = head;
        while(tempNode != null){
            tempNode = tempNode.getNext();
            count++;
        }
        return count;
    }   // returns length

    public void sort(boolean order){
        if(isSorted){
            return;
        }
        head = mergeSort(head, order);
    }   // sorts list

    private Node mergeSort(Node a, boolean order){
        if(a == null || a.getNext() == null){
            return a;
        }
        Node center = findMiddle(a);    //get middle
        Node centerNext = center.getNext();
        center.setNext(null);
        Node first = mergeSort(a,order);    //recursively finds center of list to sort
        Node second = mergeSort(centerNext,order);
        Node outNode;
        if(order) {
            outNode = mergeListAscending(first, second);    //merges lists according to order
        }
        else{
            outNode = mergeListDescending(first,second);
        }
        return outNode;
    }

    private Node mergeListAscending(Node first, Node second){   //merges two linked lists in ascending order

        Node outNode = null;
        if(first == null){      // base case
            return second;
        }
        if(second == null){     // base case
            return first;
        }
        if(first.getData().compareTo(second.getData()) >= 0){    //finds smaller of two nodes and assigns to outNode
            outNode = second;
            outNode.setNext(mergeListAscending(first,second.getNext()));    //sets next node to smaller of non assigned node and the other nodes next
        }
        else{
            outNode = first;
            outNode.setNext(mergeListAscending(first.getNext(), second));
        }
        return outNode;
    }

    private Node mergeListDescending(Node first, Node second){
        Node outNode = null;
        if(first == null){      // base case
            return second;
        }
        if(second == null){     // base case
            return second;
        }
        if(first.getData().compareTo(second.getData()) > 0){    //finds larger of two nodes and assigns to outNode
            outNode = second;
            outNode.setNext(mergeListAscending(first,second.getNext()));    //sets next node to larger of non assigned node and the other nodes next
        }
        else{
            outNode = first;
            outNode.setNext(mergeListAscending(first.getNext(), second));
        }
        return outNode;
    }

    private Node findMiddle(Node a){
        long startTime = System.nanoTime();
        if(a == null){
            return a;
        }
        Node fast = a.getNext();
        Node slow = a;
        while(fast != null){
            fast = fast.getNext();
            if(fast != null){
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }

    public boolean remove(T element){
        if (this.contains(element) != true | element == null){
            return false;
        }
        Node tempNode = head;
        for(int index = 0; index < length; index++){
            if(tempNode.getData() == element){
                for(int moveInd = length - index; moveInd < length; moveInd ++){
                    tempNode.setData(tempNode.getNext().getData());
                    tempNode = tempNode.getNext();
                }
                length --;
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }   // removes first instance of element

    public T remove(int index){
        Node first = head;
        if(index >= length || index < 0){
            return null;
        }
        for(int i = 0; i < index - 1; i ++){
            first = first.getNext();
        }
        Node second = first.getNext().getNext();
        Node tempNode = first.getNext();
        first.setNext(second);
        T data = (T) tempNode.getData();
        length--;
        return data;
    }   // removes element at index

    public String toString(){
        String outString = "";
        Node tempNode = head;
        for(int i = 0; i < length; i++){
            if(tempNode == null){
                System.out.println("null");
            }
            if(tempNode.getData() == null){
                outString += "null\n";
            }
            else {
                outString += tempNode.getData() + "\n";
            }
            tempNode = tempNode.getNext();
        }
        return outString;
    }
}
