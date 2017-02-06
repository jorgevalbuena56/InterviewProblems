/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.linkedlist;

/**
 * Given a singly linked list: 1->2->3->4->5
 * Change it to 1->5->2->4->3 using O(1) space
 * 
 * Firstly, use slow and fast point to get the middle point;
 * Secondly, reverse the list after the middle point;
 * Finally, merge the the init linked list and the reversed linked list.
 * 
 * @author valgood
 */
public class RearrangeSortedLinkList {
    public static void main(String args[]) {
        Link head = new Link(1);
        head.next = new Link(2);
        head.next.next = new Link(3);
        head.next.next.next = new Link(4);
        head.next.next.next.next = new Link(5);        
        
        head.display();
        
        //find the middle node using slow-fast approach
        Link slowP = head;
        Link fastP = head;
        
        while(fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }               
        //reverse the second half
        Link currentNode = slowP;
        Link previousNode = null;
        Link nextNode = null;
        
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        //at the end of the above while, PN keeps pointing to the last element
        //that now is the first in our reverse list
        currentNode = previousNode;
        //merge initial list with second reverse list
        Link tmpLink = currentNode.next;
        currentNode.next = head.next;
        currentNode.next.next = tmpLink;        
        head.next = currentNode;
        head.display();
    }
}

class Link {
    public int data;
    public Link next;
    
    Link(int data) {
        this.data = data;
    }
    
    public void display() {
        Link currentNode = this;
        while (currentNode != null) {
            if (currentNode.next == null) {
                System.out.print(currentNode.data);
            } else {
                System.out.print(currentNode.data + "->");
            }
            currentNode = currentNode.next;
        }
        System.out.println(" ");
    }
}