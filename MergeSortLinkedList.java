//java program to sort the linkedlist using merge sort

public class MergeSortLinkedList {
    // Node class for the linked list
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // Method to sort the linked list
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return merge(left, right);
    }

    // Method to merge two sorted linked lists
    public Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // Method to get the midpoint of the linked list
    public Node getMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // Break the list into two halves
        }

        return slow;
    }

    // Method to add elements to the linked list
    public Node add(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode; // Return the new node as the new head
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head; // Return the unchanged head
    }

    // Main method to test sorting
    public static void main(String[] args) {
        MergeSortLinkedList list = new MergeSortLinkedList();
        Node head = null;

        // Adding elements to the linked list
        head = list.add(head, 84);
        head = list.add(head, 21);
        head = list.add(head, 190);
        head = list.add(head, 123);
        head = list.add(head, 75);
        head = list.add(head, 58);
        head = list.add(head, 5);
        head = list.add(head, 182);
        head = list.add(head, 45);
        head = list.add(head, 21);

        System.out.println("Original list:");
        list.display(head);

        // Sorting the list
        head = list.sortList(head);

        System.out.println("Sorted list:");
        list.display(head);
    }

    // Method to display the linked list
    public void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}