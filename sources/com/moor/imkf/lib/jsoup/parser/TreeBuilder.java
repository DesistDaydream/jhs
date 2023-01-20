package com.moor.imkf.lib.jsoup.parser;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.parser.Token;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class TreeBuilder {
    public String baseUri;
    public Token currentToken;
    public Document doc;
    public Parser parser;
    public CharacterReader reader;
    public ParseSettings settings;
    public ArrayList<Element> stack;
    public Tokeniser tokeniser;
    private Token.StartTag start = new Token.StartTag();
    private Token.EndTag end = new Token.EndTag();

    public Element currentElement() {
        int size = this.stack.size();
        if (size > 0) {
            return this.stack.get(size - 1);
        }
        return null;
    }

    public abstract ParseSettings defaultSettings();

    public void error(String str) {
        ParseErrorList errors = this.parser.getErrors();
        if (errors.canAddError()) {
            errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    public void initialiseParse(Reader reader, String str, Parser parser) {
        Validate.notNull(reader, "String input must not be null");
        Validate.notNull(str, "BaseURI must not be null");
        Document document = new Document(str);
        this.doc = document;
        document.parser(parser);
        this.parser = parser;
        this.settings = parser.settings();
        this.reader = new CharacterReader(reader);
        this.currentToken = null;
        this.tokeniser = new Tokeniser(this.reader, parser.getErrors());
        this.stack = new ArrayList<>(32);
        this.baseUri = str;
    }

    public Document parse(Reader reader, String str, Parser parser) {
        initialiseParse(reader, str, parser);
        runParser();
        this.reader.close();
        this.reader = null;
        this.tokeniser = null;
        this.stack = null;
        return this.doc;
    }

    public abstract List<Node> parseFragment(String str, Element element, String str2, Parser parser);

    public abstract boolean process(Token token);

    public boolean processEndTag(String str) {
        Token token = this.currentToken;
        Token.EndTag endTag = this.end;
        if (token == endTag) {
            return process(new Token.EndTag().name(str));
        }
        return process(endTag.reset().name(str));
    }

    public boolean processStartTag(String str) {
        Token.StartTag startTag = this.start;
        if (this.currentToken == startTag) {
            return process(new Token.StartTag().name(str));
        }
        return process(startTag.reset().name(str));
    }

    public void runParser() {
        Token read;
        Tokeniser tokeniser = this.tokeniser;
        Token.TokenType tokenType = Token.TokenType.EOF;
        do {
            read = tokeniser.read();
            process(read);
            read.reset();
        } while (read.type != tokenType);
    }

    public boolean processStartTag(String str, Attributes attributes) {
        Token.StartTag startTag = this.start;
        if (this.currentToken == startTag) {
            return process(new Token.StartTag().nameAttr(str, attributes));
        }
        startTag.reset();
        startTag.nameAttr(str, attributes);
        return process(startTag);
    }
}
