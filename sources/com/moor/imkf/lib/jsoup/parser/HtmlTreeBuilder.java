package com.moor.imkf.lib.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.CDataNode;
import com.moor.imkf.lib.jsoup.nodes.Comment;
import com.moor.imkf.lib.jsoup.nodes.DataNode;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.FormElement;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.nodes.TextNode;
import com.moor.imkf.lib.jsoup.parser.Token;
import com.moor.imkf.lib.jsoup.select.Elements;
import com.moor.imkf.model.entity.FromToMessage;
import com.umeng.analytics.pro.am;
import com.vector.util.IntentAction;
import e.t.u.b0;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MaxScopeSearchDepth = 100;
    private boolean baseUriSetFromDoc;
    private Element contextElement;
    private Token.EndTag emptyEnd;
    private FormElement formElement;
    private ArrayList<Element> formattingElements;
    private boolean fosterInserts;
    private boolean fragmentParsing;
    private boolean framesetOk;
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private List<String> pendingTableCharacters;
    private String[] specificScopeTarget = {null};
    private HtmlTreeBuilderState state;
    public static final String[] TagsSearchInScope = {"applet", "caption", a.f1401f, "marquee", "object", "table", TimeDisplaySetting.TIME_DISPLAY, "th"};
    public static final String[] TagSearchList = {"ol", "ul"};
    public static final String[] TagSearchButton = {"button"};
    public static final String[] TagSearchTableScope = {a.f1401f, "table"};
    public static final String[] TagSearchSelectScope = {"optgroup", "option"};
    public static final String[] TagSearchEndTags = {b0.a.f14655f, "dt", AppIconSetting.LARGE_ICON_URL, "optgroup", "option", am.ax, "rp", "rt"};
    public static final String[] TagSearchSpecial = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", BrightRemindSetting.BRIGHT_REMIND, "button", "caption", "center", "col", "colgroup", b.y, b0.a.f14655f, "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TypedValues.Attributes.S_FRAME, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", a.f1401f, FromToMessage.MSG_TYPE_IFRAME, IntentAction.o.f7891j, "input", "isindex", AppIconSetting.LARGE_ICON_URL, "link", "listing", "marquee", "menu", TTDownloadField.TT_META, "nav", "noembed", "noframes", "noscript", "object", "ol", am.ax, RemoteMessageConst.MessageBody.PARAM, "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", TimeDisplaySetting.TIME_DISPLAY, "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};

    private void clearStackToContext(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (StringUtil.in(element.normalName(), strArr) || element.normalName().equals(a.f1401f)) {
                return;
            }
            this.stack.remove(size);
        }
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    private void insertNode(Node node) {
        FormElement formElement;
        if (this.stack.isEmpty()) {
            this.doc.appendChild(node);
        } else if (isFosterInserts()) {
            insertInFosterParent(node);
        } else {
            currentElement().appendChild(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (!element.tag().isFormListed() || (formElement = this.formElement) == null) {
                return;
            }
            formElement.addElement(element);
        }
    }

    private boolean isElementInQueue(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.normalName().equals(element2.normalName()) && element.attributes().equals(element2.attributes());
    }

    private void replaceInQueue(ArrayList<Element> arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    public Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                return this.stack.get(size - 1);
            }
        }
        return null;
    }

    public void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty() && removeLastFormattingElement() != null) {
        }
    }

    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead", "template");
    }

    public void clearStackToTableContext() {
        clearStackToContext("table");
    }

    public void clearStackToTableRowContext() {
        clearStackToContext("tr", "template");
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public ParseSettings defaultSettings() {
        return ParseSettings.htmlDefault;
    }

    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.parser.getErrors().canAddError()) {
            this.parser.getErrors().add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.tokenType(), htmlTreeBuilderState));
        }
    }

    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    public void generateImpliedEndTags(String str) {
        while (str != null && !currentElement().normalName().equals(str) && StringUtil.inSorted(currentElement().normalName(), TagSearchEndTags)) {
            pop();
        }
    }

    public Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public String getBaseUri() {
        return this.baseUri;
    }

    public Document getDocument() {
        return this.doc;
    }

    public FormElement getFormElement() {
        return this.formElement;
    }

    public Element getFromStack(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public Element getHeadElement() {
        return this.headElement;
    }

    public List<String> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    public ArrayList<Element> getStack() {
        return this.stack;
    }

    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    public boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String normalName = this.stack.get(size).normalName();
            if (normalName.equals(str)) {
                return true;
            }
            if (!StringUtil.inSorted(normalName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.state = HtmlTreeBuilderState.Initial;
        this.originalState = null;
        this.baseUriSetFromDoc = false;
        this.headElement = null;
        this.formElement = null;
        this.contextElement = null;
        this.formattingElements = new ArrayList<>();
        this.pendingTableCharacters = new ArrayList();
        this.emptyEnd = new Token.EndTag();
        this.framesetOk = true;
        this.fosterInserts = false;
        this.fragmentParsing = false;
    }

    public Element insert(Token.StartTag startTag) {
        Attributes attributes = startTag.attributes;
        if (attributes != null && !attributes.isEmpty() && startTag.attributes.deduplicate(this.settings) > 0) {
            error("Duplicate attribute");
        }
        if (startTag.isSelfClosing()) {
            Element insertEmpty = insertEmpty(startTag);
            this.stack.add(insertEmpty);
            this.tokeniser.transition(TokeniserState.Data);
            this.tokeniser.emit(this.emptyEnd.reset().name(insertEmpty.tagName()));
            return insertEmpty;
        }
        Element element = new Element(Tag.valueOf(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        insert(element);
        return element;
    }

    public Element insertEmpty(Token.StartTag startTag) {
        Tag valueOf = Tag.valueOf(startTag.name(), this.settings);
        Element element = new Element(valueOf, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (valueOf.isKnownTag()) {
                if (!valueOf.isEmpty()) {
                    this.tokeniser.error("Tag cannot be self closing; not a void tag");
                }
            } else {
                valueOf.setSelfClosing();
            }
        }
        return element;
    }

    public FormElement insertForm(Token.StartTag startTag, boolean z) {
        FormElement formElement = new FormElement(Tag.valueOf(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        setFormElement(formElement);
        insertNode(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    public void insertInFosterParent(Node node) {
        Element element;
        Element fromStack = getFromStack("table");
        boolean z = false;
        if (fromStack != null) {
            if (fromStack.parent() != null) {
                element = fromStack.parent();
                z = true;
            } else {
                element = aboveOnStack(fromStack);
            }
        } else {
            element = this.stack.get(0);
        }
        if (z) {
            Validate.notNull(fromStack);
            fromStack.before(node);
            return;
        }
        element.appendChild(node);
    }

    public void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    public void insertOnStackAfter(Element element, Element element2) {
        int lastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        this.stack.add(lastIndexOf + 1, element2);
    }

    public Element insertStartTag(String str) {
        Element element = new Element(Tag.valueOf(str, this.settings), null);
        insert(element);
        return element;
    }

    public boolean isFosterInserts() {
        return this.fosterInserts;
    }

    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    public boolean isInActiveFormattingElements(Element element) {
        return isElementInQueue(this.formattingElements, element);
    }

    public boolean isSpecial(Element element) {
        return StringUtil.inSorted(element.normalName(), TagSearchSpecial);
    }

    public Element lastFormattingElement() {
        if (this.formattingElements.size() > 0) {
            ArrayList<Element> arrayList = this.formattingElements;
            return arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    public void markInsertionMode() {
        this.originalState = this.state;
    }

    public void maybeSetBaseUri(Element element) {
        if (this.baseUriSetFromDoc) {
            return;
        }
        String absUrl = element.absUrl("href");
        if (absUrl.length() != 0) {
            this.baseUri = absUrl;
            this.baseUriSetFromDoc = true;
            this.doc.setBaseUri(absUrl);
        }
    }

    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    public boolean onStack(Element element) {
        return isElementInQueue(this.stack, element);
    }

    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public List<Node> parseFragment(String str, Element element, String str2, Parser parser) {
        Element element2;
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(new StringReader(str), str2, parser);
        this.contextElement = element;
        this.fragmentParsing = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String normalName = element.normalName();
            if (StringUtil.in(normalName, "title", "textarea")) {
                this.tokeniser.transition(TokeniserState.Rcdata);
            } else if (StringUtil.in(normalName, FromToMessage.MSG_TYPE_IFRAME, "noembed", "noframes", "style", "xmp")) {
                this.tokeniser.transition(TokeniserState.Rawtext);
            } else if (normalName.equals("script")) {
                this.tokeniser.transition(TokeniserState.ScriptData);
            } else if (normalName.equals("noscript")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else if (normalName.equals("plaintext")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else {
                this.tokeniser.transition(TokeniserState.Data);
            }
            element2 = new Element(Tag.valueOf(a.f1401f, this.settings), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            resetInsertionMode();
            Elements parents = element.parents();
            parents.add(0, element);
            Iterator<Element> it = parents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element next = it.next();
                if (next instanceof FormElement) {
                    this.formElement = (FormElement) next;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        if (element != null) {
            return element2.childNodes();
        }
        return this.doc.childNodes();
    }

    public Element pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    public void popStackToBefore(String str) {
        for (int size = this.stack.size() - 1; size >= 0 && !this.stack.get(size).normalName().equals(str); size--) {
            this.stack.remove(size);
        }
    }

    public Element popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    public void push(Element element) {
        this.stack.add(element);
    }

    public void pushActiveFormattingElements(Element element) {
        int size = this.formattingElements.size() - 1;
        int i2 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.formattingElements.get(size);
                if (element2 == null) {
                    break;
                }
                if (isSameFormattingElement(element, element2)) {
                    i2++;
                }
                if (i2 == 3) {
                    this.formattingElements.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.formattingElements.add(element);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reconstructFormattingElements() {
        /*
            r7 = this;
            com.moor.imkf.lib.jsoup.nodes.Element r0 = r7.lastFormattingElement()
            if (r0 == 0) goto L56
            boolean r1 = r7.onStack(r0)
            if (r1 == 0) goto Ld
            goto L56
        Ld:
            java.util.ArrayList<com.moor.imkf.lib.jsoup.nodes.Element> r1 = r7.formattingElements
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            r3 = r1
        L16:
            r4 = 0
            if (r3 != 0) goto L1a
            goto L2d
        L1a:
            java.util.ArrayList<com.moor.imkf.lib.jsoup.nodes.Element> r0 = r7.formattingElements
            int r3 = r3 + (-1)
            java.lang.Object r0 = r0.get(r3)
            com.moor.imkf.lib.jsoup.nodes.Element r0 = (com.moor.imkf.lib.jsoup.nodes.Element) r0
            if (r0 == 0) goto L2c
            boolean r5 = r7.onStack(r0)
            if (r5 == 0) goto L16
        L2c:
            r2 = 0
        L2d:
            if (r2 != 0) goto L39
            java.util.ArrayList<com.moor.imkf.lib.jsoup.nodes.Element> r0 = r7.formattingElements
            int r3 = r3 + 1
            java.lang.Object r0 = r0.get(r3)
            com.moor.imkf.lib.jsoup.nodes.Element r0 = (com.moor.imkf.lib.jsoup.nodes.Element) r0
        L39:
            com.moor.imkf.lib.jsoup.helper.Validate.notNull(r0)
            java.lang.String r2 = r0.normalName()
            com.moor.imkf.lib.jsoup.nodes.Element r2 = r7.insertStartTag(r2)
            com.moor.imkf.lib.jsoup.nodes.Attributes r5 = r2.attributes()
            com.moor.imkf.lib.jsoup.nodes.Attributes r6 = r0.attributes()
            r5.addAll(r6)
            java.util.ArrayList<com.moor.imkf.lib.jsoup.nodes.Element> r5 = r7.formattingElements
            r5.set(r3, r2)
            if (r3 != r1) goto L2c
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilder.reconstructFormattingElements():void");
    }

    public void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (this.formattingElements.get(size) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    public boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    public Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return this.formattingElements.remove(size - 1);
        }
        return null;
    }

    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    public void resetInsertionMode() {
        boolean z = false;
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (size == 0) {
                element = this.contextElement;
                z = true;
            }
            String normalName = element.normalName();
            if ("select".equals(normalName)) {
                transition(HtmlTreeBuilderState.InSelect);
                return;
            } else if (!TimeDisplaySetting.TIME_DISPLAY.equals(normalName) && (!"th".equals(normalName) || z)) {
                if ("tr".equals(normalName)) {
                    transition(HtmlTreeBuilderState.InRow);
                    return;
                } else if (!"tbody".equals(normalName) && !"thead".equals(normalName) && !"tfoot".equals(normalName)) {
                    if ("caption".equals(normalName)) {
                        transition(HtmlTreeBuilderState.InCaption);
                        return;
                    } else if ("colgroup".equals(normalName)) {
                        transition(HtmlTreeBuilderState.InColumnGroup);
                        return;
                    } else if ("table".equals(normalName)) {
                        transition(HtmlTreeBuilderState.InTable);
                        return;
                    } else if ("head".equals(normalName)) {
                        transition(HtmlTreeBuilderState.InBody);
                        return;
                    } else if ("body".equals(normalName)) {
                        transition(HtmlTreeBuilderState.InBody);
                        return;
                    } else if ("frameset".equals(normalName)) {
                        transition(HtmlTreeBuilderState.InFrameset);
                        return;
                    } else if (a.f1401f.equals(normalName)) {
                        transition(HtmlTreeBuilderState.BeforeHead);
                        return;
                    } else if (z) {
                        transition(HtmlTreeBuilderState.InBody);
                        return;
                    }
                } else {
                    transition(HtmlTreeBuilderState.InTableBody);
                    return;
                }
            } else {
                transition(HtmlTreeBuilderState.InCell);
                return;
            }
        }
    }

    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    public HtmlTreeBuilderState state() {
        return this.state;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }

    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    public boolean framesetOk() {
        return this.framesetOk;
    }

    public boolean inScope(String str) {
        return inScope(str, null);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.stack.size() - 1;
        int i2 = size > 100 ? size - 100 : 0;
        while (size >= i2) {
            String normalName = this.stack.get(size).normalName();
            if (StringUtil.inSorted(normalName, strArr)) {
                return true;
            }
            if (StringUtil.inSorted(normalName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.inSorted(normalName, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    public boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    public void generateImpliedEndTags() {
        generateImpliedEndTags(null);
    }

    public void popStackToClose(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            this.stack.remove(size);
            if (StringUtil.inSorted(this.stack.get(size).normalName(), strArr)) {
                return;
            }
        }
    }

    public void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData()));
    }

    public void insert(Token.Character character) {
        Node dataNode;
        Element currentElement = currentElement();
        if (currentElement == null) {
            currentElement = this.doc;
        }
        String normalName = currentElement.normalName();
        String data = character.getData();
        if (character.isCData()) {
            dataNode = new CDataNode(data);
        } else if (!normalName.equals("script") && !normalName.equals("style")) {
            dataNode = new TextNode(data);
        } else {
            dataNode = new DataNode(data);
        }
        currentElement.appendChild(dataNode);
    }
}
