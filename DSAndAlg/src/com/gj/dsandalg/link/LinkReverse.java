package com.gj.dsandalg.link;

/**
 * 单链表反转
 */
public class LinkReverse {

    private static OneNode head = null;

    private static OneNode buildNodes() {
        OneNode tmpHead = null;

        for (int i = 0; i < 10; i++) {
            OneNode oneNode = new OneNode();

            oneNode.value = i;
            oneNode.next = null;

            if (tmpHead == null) {
                tmpHead = oneNode;
            } else {
                LinkUtils.addNode(tmpHead, oneNode);
            }

        }

        return tmpHead;
    }

    public static void main(String[] args) {
        head = buildNodes();

        LinkUtils.printNode(head);

        head = LinkUtils.reverseNodeLink(head);

        LinkUtils.printNode(head);
    }
}
