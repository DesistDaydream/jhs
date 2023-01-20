package com.moor.imkf.lib.jsoup.nodes;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.moor.imkf.lib.jsoup.helper.ChangeNotifyingArrayList;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.Tag;
import com.moor.imkf.lib.jsoup.select.Collector;
import com.moor.imkf.lib.jsoup.select.Elements;
import com.moor.imkf.lib.jsoup.select.Evaluator;
import com.moor.imkf.lib.jsoup.select.NodeFilter;
import com.moor.imkf.lib.jsoup.select.NodeTraversor;
import com.moor.imkf.lib.jsoup.select.NodeVisitor;
import com.moor.imkf.lib.jsoup.select.QueryParser;
import com.moor.imkf.lib.jsoup.select.Selector;
import com.tencent.android.tpns.mqtt.MqttTopic;
import h.t2.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes2.dex */
public class Element extends Node {
    private Attributes attributes;
    public List<Node> childNodes;
    private WeakReference<List<Element>> shadowChildrenRef;
    private Tag tag;
    private static final List<Node> EMPTY_NODES = Collections.emptyList();
    private static final Pattern classSplit = Pattern.compile("\\s+");
    private static final String baseUriKey = Attributes.internalKey("baseUri");

    /* loaded from: classes2.dex */
    public static final class NodeList extends ChangeNotifyingArrayList<Node> {
        private final Element owner;

        public NodeList(Element element, int i2) {
            super(i2);
            this.owner = element;
        }

        @Override // com.moor.imkf.lib.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.nodelistChanged();
        }
    }

    public Element(String str) {
        this(Tag.valueOf(str), "", null);
    }

    private static void accumulateParents(Element element, Elements elements) {
        Element parent = element.parent();
        if (parent == null || parent.tagName().equals("#root")) {
            return;
        }
        elements.add(parent);
        accumulateParents(parent, elements);
    }

    public static void appendNormalisedText(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (!preserveWhitespace(textNode.parentNode) && !(textNode instanceof CDataNode)) {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.lastCharIsWhitespace(sb));
        } else {
            sb.append(wholeText);
        }
    }

    private static void appendWhitespaceIfBr(Element element, StringBuilder sb) {
        if (!element.tag.getName().equals(BrightRemindSetting.BRIGHT_REMIND) || TextNode.lastCharIsWhitespace(sb)) {
            return;
        }
        sb.append(ExpandableTextView.N);
    }

    private List<Element> childElementsList() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.shadowChildrenRef;
        if (weakReference == null || (list = weakReference.get()) == null) {
            int size = this.childNodes.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                Node node = this.childNodes.get(i2);
                if (node instanceof Element) {
                    arrayList.add((Element) node);
                }
            }
            this.shadowChildrenRef = new WeakReference<>(arrayList);
            return arrayList;
        }
        return list;
    }

    private static <E extends Element> int indexInList(Element element, List<E> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) == element) {
                return i2;
            }
        }
        return 0;
    }

    private boolean isFormatAsBlock(Document.OutputSettings outputSettings) {
        return this.tag.formatAsBlock() || (parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline();
    }

    private boolean isInlineable(Document.OutputSettings outputSettings) {
        return (!tag().isInline() || tag().isEmpty() || !parent().isBlock() || previousSibling() == null || outputSettings.outline()) ? false : true;
    }

    public static boolean preserveWhitespace(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            int i2 = 0;
            while (!element.tag.preserveWhitespace()) {
                element = element.parent();
                i2++;
                if (i2 < 6) {
                    if (element == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static String searchUpForAttribute(Element element, String str) {
        while (element != null) {
            if (element.hasAttributes() && element.attributes.hasKey(str)) {
                return element.attributes.get(str);
            }
            element = element.parent();
        }
        return "";
    }

    public Element addClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.add(str);
        classNames(classNames);
        return this;
    }

    public Element append(String str) {
        Validate.notNull(str);
        addChildren((Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.childNodes.add(node);
        node.setSiblingIndex(this.childNodes.size() - 1);
        return this;
    }

    public Element appendElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        appendChild(element);
        return element;
    }

    public Element appendText(String str) {
        Validate.notNull(str);
        appendChild(new TextNode(str));
        return this;
    }

    public Element appendTo(Element element) {
        Validate.notNull(element);
        element.appendChild(this);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Attributes attributes() {
        if (!hasAttributes()) {
            this.attributes = new Attributes();
        }
        return this.attributes;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String baseUri() {
        return searchUpForAttribute(this, baseUriKey);
    }

    public Element child(int i2) {
        return childElementsList().get(i2);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public int childNodeSize() {
        return this.childNodes.size();
    }

    public Elements children() {
        return new Elements(childElementsList());
    }

    public int childrenSize() {
        return childElementsList().size();
    }

    public String className() {
        return attr("class").trim();
    }

    public Set<String> classNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(classSplit.split(className())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element closest(String str) {
        return closest(QueryParser.parse(str));
    }

    public String cssSelector() {
        if (id().length() > 0) {
            return MqttTopic.MULTI_LEVEL_WILDCARD + id();
        }
        StringBuilder sb = new StringBuilder(tagName().replace(':', '|'));
        String join = StringUtil.join(classNames(), ".");
        if (join.length() > 0) {
            sb.append('.');
            sb.append(join);
        }
        if (parent() != null && !(parent() instanceof Document)) {
            sb.insert(0, " > ");
            if (parent().select(sb.toString()).size() > 1) {
                sb.append(String.format(":nth-child(%d)", Integer.valueOf(elementSiblingIndex() + 1)));
            }
            return parent().cssSelector() + sb.toString();
        }
        return sb.toString();
    }

    public String data() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                borrowBuilder.append(((DataNode) node).getWholeData());
            } else if (node instanceof Comment) {
                borrowBuilder.append(((Comment) node).getData());
            } else if (node instanceof Element) {
                borrowBuilder.append(((Element) node).data());
            } else if (node instanceof CDataNode) {
                borrowBuilder.append(((CDataNode) node).getWholeText());
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public List<DataNode> dataNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map<String, String> dataset() {
        return attributes().dataset();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
        attributes().put(baseUriKey, str);
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return indexInList(this, parent().childElementsList());
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        if (this.childNodes == EMPTY_NODES) {
            this.childNodes = new NodeList(this, 4);
        }
        return this.childNodes;
    }

    public Element firstElementSibling() {
        List<Element> childElementsList = parent().childElementsList();
        if (childElementsList.size() > 1) {
            return childElementsList.get(0);
        }
        return null;
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public Element getElementById(String str) {
        Validate.notEmpty(str);
        Elements collect = Collector.collect(new Evaluator.Id(str), this);
        if (collect.size() > 0) {
            return collect.get(0);
        }
        return null;
    }

    public Elements getElementsByAttribute(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Attribute(str.trim()), this);
    }

    public Elements getElementsByAttributeStarting(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public Elements getElementsByAttributeValue(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Elements getElementsByAttributeValueContaining(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Elements getElementsByAttributeValueEnding(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, Pattern pattern) {
        return Collector.collect(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    public Elements getElementsByAttributeValueNot(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    public Elements getElementsByAttributeValueStarting(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements getElementsByClass(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Class(str), this);
    }

    public Elements getElementsByIndexEquals(int i2) {
        return Collector.collect(new Evaluator.IndexEquals(i2), this);
    }

    public Elements getElementsByIndexGreaterThan(int i2) {
        return Collector.collect(new Evaluator.IndexGreaterThan(i2), this);
    }

    public Elements getElementsByIndexLessThan(int i2) {
        return Collector.collect(new Evaluator.IndexLessThan(i2), this);
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    public Elements getElementsContainingOwnText(String str) {
        return Collector.collect(new Evaluator.ContainsOwnText(str), this);
    }

    public Elements getElementsContainingText(String str) {
        return Collector.collect(new Evaluator.ContainsText(str), this);
    }

    public Elements getElementsMatchingOwnText(Pattern pattern) {
        return Collector.collect(new Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingText(Pattern pattern) {
        return Collector.collect(new Evaluator.Matches(pattern), this);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public boolean hasAttributes() {
        return this.attributes != null;
    }

    public boolean hasClass(String str) {
        if (hasAttributes()) {
            String ignoreCase = this.attributes.getIgnoreCase("class");
            int length = ignoreCase.length();
            int length2 = str.length();
            if (length != 0 && length >= length2) {
                if (length == length2) {
                    return str.equalsIgnoreCase(ignoreCase);
                }
                boolean z = false;
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    if (Character.isWhitespace(ignoreCase.charAt(i3))) {
                        if (!z) {
                            continue;
                        } else if (i3 - i2 == length2 && ignoreCase.regionMatches(true, i2, str, 0, length2)) {
                            return true;
                        } else {
                            z = false;
                        }
                    } else if (!z) {
                        i2 = i3;
                        z = true;
                    }
                }
                if (z && length - i2 == length2) {
                    return ignoreCase.regionMatches(true, i2, str, 0, length2);
                }
            }
            return false;
        }
        return false;
    }

    public boolean hasText() {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).isBlank()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).hasText()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        html((Element) borrowBuilder);
        String releaseBuilder = StringUtil.releaseBuilder(borrowBuilder);
        return NodeUtils.outputSettings(this).prettyPrint() ? releaseBuilder.trim() : releaseBuilder;
    }

    public String id() {
        return hasAttributes() ? this.attributes.getIgnoreCase("id") : "";
    }

    public Element insertChildren(int i2, Collection<? extends Node> collection) {
        Validate.notNull(collection, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i2 < 0) {
            i2 += childNodeSize + 1;
        }
        Validate.isTrue(i2 >= 0 && i2 <= childNodeSize, "Insert position out of bounds.");
        addChildren(i2, (Node[]) new ArrayList(collection).toArray(new Node[0]));
        return this;
    }

    public boolean is(String str) {
        return is(QueryParser.parse(str));
    }

    public boolean isBlock() {
        return this.tag.isBlock();
    }

    public Element lastElementSibling() {
        List<Element> childElementsList = parent().childElementsList();
        if (childElementsList.size() > 1) {
            return childElementsList.get(childElementsList.size() - 1);
        }
        return null;
    }

    public Element nextElementSibling() {
        if (this.parentNode == null) {
            return null;
        }
        List<Element> childElementsList = parent().childElementsList();
        int indexInList = indexInList(this, childElementsList) + 1;
        if (childElementsList.size() > indexInList) {
            return childElementsList.get(indexInList);
        }
        return null;
    }

    public Elements nextElementSiblings() {
        return nextElementSiblings(true);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return this.tag.getName();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void nodelistChanged() {
        super.nodelistChanged();
        this.shadowChildrenRef = null;
    }

    public String normalName() {
        return this.tag.normalName();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && isFormatAsBlock(outputSettings) && !isInlineable(outputSettings)) {
            if (appendable instanceof StringBuilder) {
                if (((StringBuilder) appendable).length() > 0) {
                    indent(appendable, i2, outputSettings);
                }
            } else {
                indent(appendable, i2, outputSettings);
            }
        }
        appendable.append(y.f15691d).append(tagName());
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.html(appendable, outputSettings);
        }
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
                appendable.append(y.f15692e);
                return;
            } else {
                appendable.append(" />");
                return;
            }
        }
        appendable.append(y.f15692e);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            return;
        }
        if (outputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (outputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && !(this.childNodes.get(0) instanceof TextNode)))))) {
            indent(appendable, i2, outputSettings);
        }
        appendable.append("</").append(tagName()).append(y.f15692e);
    }

    public String ownText() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        ownText(borrowBuilder);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    public Elements parents() {
        Elements elements = new Elements();
        accumulateParents(this, elements);
        return elements;
    }

    public Element prepend(String str) {
        Validate.notNull(str);
        addChildren(0, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element prependChild(Node node) {
        Validate.notNull(node);
        addChildren(0, node);
        return this;
    }

    public Element prependElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        prependChild(element);
        return element;
    }

    public Element prependText(String str) {
        Validate.notNull(str);
        prependChild(new TextNode(str));
        return this;
    }

    public Element previousElementSibling() {
        List<Element> childElementsList;
        int indexInList;
        if (this.parentNode != null && (indexInList = indexInList(this, (childElementsList = parent().childElementsList()))) > 0) {
            return childElementsList.get(indexInList - 1);
        }
        return null;
    }

    public Elements previousElementSiblings() {
        return nextElementSiblings(false);
    }

    public Element removeClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.remove(str);
        classNames(classNames);
        return this;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    public Elements siblingElements() {
        if (this.parentNode == null) {
            return new Elements(0);
        }
        List<Element> childElementsList = parent().childElementsList();
        Elements elements = new Elements(childElementsList.size() - 1);
        for (Element element : childElementsList) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public Tag tag() {
        return this.tag;
    }

    public String tagName() {
        return this.tag.getName();
    }

    public String text() {
        final StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: com.moor.imkf.lib.jsoup.nodes.Element.1
            {
                Element.this = this;
            }

            @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
            public void head(Node node, int i2) {
                if (node instanceof TextNode) {
                    Element.appendNormalisedText(borrowBuilder, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (borrowBuilder.length() > 0) {
                        if ((element.isBlock() || element.tag.getName().equals(BrightRemindSetting.BRIGHT_REMIND)) && !TextNode.lastCharIsWhitespace(borrowBuilder)) {
                            borrowBuilder.append(' ');
                        }
                    }
                }
            }

            @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
            public void tail(Node node, int i2) {
                if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode) && !TextNode.lastCharIsWhitespace(borrowBuilder)) {
                    borrowBuilder.append(' ');
                }
            }
        }, this);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element toggleClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        if (classNames.contains(str)) {
            classNames.remove(str);
        } else {
            classNames.add(str);
        }
        classNames(classNames);
        return this;
    }

    public String val() {
        if (normalName().equals("textarea")) {
            return text();
        }
        return attr("value");
    }

    public String wholeText() {
        final StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: com.moor.imkf.lib.jsoup.nodes.Element.2
            {
                Element.this = this;
            }

            @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
            public void head(Node node, int i2) {
                if (node instanceof TextNode) {
                    borrowBuilder.append(((TextNode) node).getWholeText());
                }
            }

            @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
            public void tail(Node node, int i2) {
            }
        }, this);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public Element(Tag tag, String str, Attributes attributes) {
        Validate.notNull(tag);
        this.childNodes = EMPTY_NODES;
        this.attributes = attributes;
        this.tag = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    private Elements nextElementSiblings(boolean z) {
        Elements elements = new Elements();
        if (this.parentNode == null) {
            return elements;
        }
        elements.add(this);
        return z ? elements.nextAll() : elements.prevAll();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element attr(String str, String str2) {
        super.attr(str, str2);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element clearAttributes() {
        if (this.attributes != null) {
            super.clearAttributes();
            this.attributes = null;
        }
        return this;
    }

    public Element closest(Evaluator evaluator) {
        Validate.notNull(evaluator);
        Element root = root();
        Element element = this;
        while (!evaluator.matches(root, element)) {
            element = element.parent();
            if (element == null) {
                return null;
            }
        }
        return element;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element doClone(Node node) {
        Element element = (Element) super.doClone(node);
        Attributes attributes = this.attributes;
        element.attributes = attributes != null ? attributes.m34clone() : null;
        NodeList nodeList = new NodeList(element, this.childNodes.size());
        element.childNodes = nodeList;
        nodeList.addAll(this.childNodes);
        element.setBaseUri(baseUri());
        return element;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element empty() {
        this.childNodes.clear();
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element filter(NodeFilter nodeFilter) {
        return (Element) super.filter(nodeFilter);
    }

    public Elements getElementsByAttributeValueMatching(String str, String str2) {
        try {
            return getElementsByAttributeValueMatching(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str2, e2);
        }
    }

    public Elements getElementsMatchingOwnText(String str) {
        try {
            return getElementsMatchingOwnText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e2);
        }
    }

    public Elements getElementsMatchingText(String str) {
        try {
            return getElementsMatchingText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e2);
        }
    }

    public boolean is(Evaluator evaluator) {
        return evaluator.matches(root(), this);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public final Element parent() {
        return (Element) this.parentNode;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element removeAttr(String str) {
        return (Element) super.removeAttr(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element root() {
        return (Element) super.root();
    }

    public Elements select(Evaluator evaluator) {
        return Selector.select(evaluator, this);
    }

    public Element selectFirst(Evaluator evaluator) {
        return Collector.findFirst(evaluator, this);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element shallowClone() {
        Tag tag = this.tag;
        String baseUri = baseUri();
        Attributes attributes = this.attributes;
        return new Element(tag, baseUri, attributes == null ? null : attributes.m34clone());
    }

    public Element tagName(String str) {
        Validate.notEmpty(str, "Tag name must not be empty.");
        this.tag = Tag.valueOf(str, NodeUtils.parser(this).settings());
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element traverse(NodeVisitor nodeVisitor) {
        return (Element) super.traverse(nodeVisitor);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element wrap(String str) {
        return (Element) super.wrap(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element after(String str) {
        return (Element) super.after(str);
    }

    public Element attr(String str, boolean z) {
        attributes().put(str, z);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element before(String str) {
        return (Element) super.before(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element clone() {
        return (Element) super.m36clone();
    }

    private void ownText(StringBuilder sb) {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                appendNormalisedText(sb, (TextNode) node);
            } else if (node instanceof Element) {
                appendWhitespaceIfBr((Element) node, sb);
            }
        }
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element after(Node node) {
        return (Element) super.after(node);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Element before(Node node) {
        return (Element) super.before(node);
    }

    public Element classNames(Set<String> set) {
        Validate.notNull(set);
        if (set.isEmpty()) {
            attributes().remove("class");
        } else {
            attributes().put("class", StringUtil.join(set, ExpandableTextView.N));
        }
        return this;
    }

    public Element text(String str) {
        Validate.notNull(str);
        empty();
        appendChild(new TextNode(str));
        return this;
    }

    public Element val(String str) {
        if (normalName().equals("textarea")) {
            text(str);
        } else {
            attr("value", str);
        }
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public <T extends Appendable> T html(T t) {
        int size = this.childNodes.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.childNodes.get(i2).outerHtml(t);
        }
        return t;
    }

    public Element html(String str) {
        empty();
        append(str);
        return this;
    }

    public Element insertChildren(int i2, Node... nodeArr) {
        Validate.notNull(nodeArr, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i2 < 0) {
            i2 += childNodeSize + 1;
        }
        Validate.isTrue(i2 >= 0 && i2 <= childNodeSize, "Insert position out of bounds.");
        addChildren(i2, nodeArr);
        return this;
    }

    public Element(Tag tag, String str) {
        this(tag, str, null);
    }
}
