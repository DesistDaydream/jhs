package com.moor.imkf.lib.jsoup.parser;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.CDataNode;
import com.moor.imkf.lib.jsoup.nodes.Comment;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.DocumentType;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.nodes.TextNode;
import com.moor.imkf.lib.jsoup.nodes.XmlDeclaration;
import com.moor.imkf.lib.jsoup.parser.Token;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/* loaded from: classes2.dex */
public class XmlTreeBuilder extends TreeBuilder {

    /* renamed from: com.moor.imkf.lib.jsoup.parser.XmlTreeBuilder$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.Comment.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void insertNode(Node node) {
        currentElement().appendChild(node);
    }

    private void popStackToClose(Token.EndTag endTag) {
        Element element;
        String normalizeTag = this.settings.normalizeTag(endTag.tagName);
        int size = this.stack.size() - 1;
        while (true) {
            if (size < 0) {
                element = null;
                break;
            }
            element = this.stack.get(size);
            if (element.nodeName().equals(normalizeTag)) {
                break;
            }
            size--;
        }
        if (element == null) {
            return;
        }
        for (int size2 = this.stack.size() - 1; size2 >= 0; size2--) {
            Element element2 = this.stack.get(size2);
            this.stack.remove(size2);
            if (element2 == element) {
                return;
            }
        }
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public ParseSettings defaultSettings() {
        return ParseSettings.preserveCase;
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.stack.add(this.doc);
        this.doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
    }

    public Element insert(Token.StartTag startTag) {
        Tag valueOf = Tag.valueOf(startTag.name(), this.settings);
        Attributes attributes = startTag.attributes;
        if (attributes != null) {
            attributes.deduplicate(this.settings);
        }
        Element element = new Element(valueOf, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (!valueOf.isKnownTag()) {
                valueOf.setSelfClosing();
            }
        } else {
            this.stack.add(element);
        }
        return element;
    }

    public Document parse(Reader reader, String str) {
        return parse(reader, str, new Parser(this));
    }

    public List<Node> parseFragment(String str, String str2, Parser parser) {
        initialiseParse(new StringReader(str), str2, parser);
        runParser();
        return this.doc.childNodes();
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        switch (AnonymousClass1.$SwitchMap$com$moor$imkf$lib$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
            case 1:
                insert(token.asStartTag());
                return true;
            case 2:
                popStackToClose(token.asEndTag());
                return true;
            case 3:
                insert(token.asComment());
                return true;
            case 4:
                insert(token.asCharacter());
                return true;
            case 5:
                insert(token.asDoctype());
                return true;
            case 6:
                return true;
            default:
                Validate.fail("Unexpected token type: " + token.type);
                return true;
        }
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    public Document parse(String str, String str2) {
        return parse(new StringReader(str), str2, new Parser(this));
    }

    @Override // com.moor.imkf.lib.jsoup.parser.TreeBuilder
    public List<Node> parseFragment(String str, Element element, String str2, Parser parser) {
        return parseFragment(str, str2, parser);
    }

    public void insert(Token.Comment comment) {
        XmlDeclaration asXmlDeclaration;
        Comment comment2 = new Comment(comment.getData());
        if (comment.bogus && comment2.isXmlDeclaration() && (asXmlDeclaration = comment2.asXmlDeclaration()) != null) {
            comment2 = asXmlDeclaration;
        }
        insertNode(comment2);
    }

    public void insert(Token.Character character) {
        String data = character.getData();
        insertNode(character.isCData() ? new CDataNode(data) : new TextNode(data));
    }

    public void insert(Token.Doctype doctype) {
        DocumentType documentType = new DocumentType(this.settings.normalizeTag(doctype.getName()), doctype.getPublicIdentifier(), doctype.getSystemIdentifier());
        documentType.setPubSysKey(doctype.getPubSysKey());
        insertNode(documentType);
    }
}
