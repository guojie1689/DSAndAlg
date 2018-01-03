package com.gj.dsandalg.link;

public class LinkUtils {

    //返回头结点
    public static void addNode(OneNode head, OneNode newNode) {
        if (head == null) {
            return;
        }

        while (head.next != null) {
            head = head.next;
        }

        head.next = newNode;
    }

    public static OneNode reverseNodeLink(OneNode curNode) {
        OneNode prvNode = null;
        OneNode nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;

            curNode.next = prvNode;

            prvNode = curNode;
            curNode = nextNode;
        }

        return prvNode;

    }

    public static void printNode(OneNode head) {
        if (head == null) {
            System.out.println("head node is null return ");
            return;
        }

        StringBuffer sb = new StringBuffer();

        while (head.next != null) {
            sb.append(head.value);
            sb.append("->");
            head = head.next;
        }

        sb.append(head.value);
        sb.append("->NULL");

        System.out.println(sb.toString());
    }
}
