package com.moor.imkf.lib.jsoup.select;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.select.NodeFilter;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class NodeTraversor {
    public static NodeFilter.FilterResult filter(NodeFilter nodeFilter, Node node) {
        Node node2 = node;
        int i2 = 0;
        while (node2 != null) {
            NodeFilter.FilterResult head = nodeFilter.head(node2, i2);
            if (head == NodeFilter.FilterResult.STOP) {
                return head;
            }
            if (head == NodeFilter.FilterResult.CONTINUE && node2.childNodeSize() > 0) {
                node2 = node2.childNode(0);
                i2++;
            } else {
                while (node2.nextSibling() == null && i2 > 0) {
                    NodeFilter.FilterResult filterResult = NodeFilter.FilterResult.CONTINUE;
                    if ((head == filterResult || head == NodeFilter.FilterResult.SKIP_CHILDREN) && (head = nodeFilter.tail(node2, i2)) == NodeFilter.FilterResult.STOP) {
                        return head;
                    }
                    Node parentNode = node2.parentNode();
                    i2--;
                    if (head == NodeFilter.FilterResult.REMOVE) {
                        node2.remove();
                    }
                    head = filterResult;
                    node2 = parentNode;
                }
                if ((head == NodeFilter.FilterResult.CONTINUE || head == NodeFilter.FilterResult.SKIP_CHILDREN) && (head = nodeFilter.tail(node2, i2)) == NodeFilter.FilterResult.STOP) {
                    return head;
                }
                if (node2 == node) {
                    return head;
                }
                Node nextSibling = node2.nextSibling();
                if (head == NodeFilter.FilterResult.REMOVE) {
                    node2.remove();
                }
                node2 = nextSibling;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void traverse(NodeVisitor nodeVisitor, Node node) {
        Node node2 = node;
        int i2 = 0;
        while (node2 != null) {
            nodeVisitor.head(node2, i2);
            if (node2.childNodeSize() > 0) {
                node2 = node2.childNode(0);
                i2++;
            } else {
                while (node2.nextSibling() == null && i2 > 0) {
                    nodeVisitor.tail(node2, i2);
                    node2 = node2.parentNode();
                    i2--;
                }
                nodeVisitor.tail(node2, i2);
                if (node2 == node) {
                    return;
                }
                node2 = node2.nextSibling();
            }
        }
    }

    public static void traverse(NodeVisitor nodeVisitor, Elements elements) {
        Validate.notNull(nodeVisitor);
        Validate.notNull(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            traverse(nodeVisitor, it.next());
        }
    }

    public static void filter(NodeFilter nodeFilter, Elements elements) {
        Validate.notNull(nodeFilter);
        Validate.notNull(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext() && filter(nodeFilter, it.next()) != NodeFilter.FilterResult.STOP) {
        }
    }
}
