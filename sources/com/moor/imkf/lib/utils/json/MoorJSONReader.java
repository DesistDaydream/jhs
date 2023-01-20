package com.moor.imkf.lib.utils.json;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.t2.y;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MoorJSONReader {
    public static final int CURRENT = 1;
    public static final int FIRST = 0;
    public static final int NEXT = 2;
    private static Map<Character, Character> escapes;
    private StringBuffer buf = new StringBuffer();

    /* renamed from: c  reason: collision with root package name */
    private char f4970c;
    private CharacterIterator it;
    private Object token;
    private static final Object OBJECT_END = new Object();
    private static final Object ARRAY_END = new Object();
    private static final Object COLON = new Object();
    private static final Object COMMA = new Object();

    static {
        HashMap hashMap = new HashMap();
        escapes = hashMap;
        hashMap.put(new Character(y.a), new Character(y.a));
        escapes.put(new Character('\\'), new Character('\\'));
        escapes.put(new Character(Attributes.InternalPrefix), new Character(Attributes.InternalPrefix));
        escapes.put(new Character('b'), new Character('\b'));
        escapes.put(new Character('f'), new Character('\f'));
        escapes.put(new Character('n'), new Character('\n'));
        escapes.put(new Character('r'), new Character('\r'));
        escapes.put(new Character('t'), new Character('\t'));
    }

    private void add(char c2) {
        this.buf.append(c2);
        next();
    }

    private int addDigits() {
        int i2 = 0;
        while (Character.isDigit(this.f4970c)) {
            add();
            i2++;
        }
        return i2;
    }

    private Object array() throws Exception {
        ArrayList arrayList = new ArrayList();
        Object read = read();
        while (this.token != ARRAY_END && this.f4970c != 65535) {
            arrayList.add(read);
            if (read() == COMMA) {
                read = read();
            }
        }
        return arrayList;
    }

    private char next() {
        char next = this.it.next();
        this.f4970c = next;
        return next;
    }

    private Object number() {
        boolean z = false;
        this.buf.setLength(0);
        if (this.f4970c == '-') {
            add();
        }
        int addDigits = addDigits() + 0;
        boolean z2 = true;
        if (this.f4970c == '.') {
            add();
            addDigits += addDigits();
            z = true;
        }
        char c2 = this.f4970c;
        if (c2 == 'e' || c2 == 'E') {
            add();
            char c3 = this.f4970c;
            if (c3 == '+' || c3 == '-') {
                add();
            }
            addDigits();
        } else {
            z2 = z;
        }
        String stringBuffer = this.buf.toString();
        return z2 ? addDigits < 17 ? Double.valueOf(stringBuffer) : new BigDecimal(stringBuffer) : addDigits < 19 ? Long.valueOf(stringBuffer) : new BigInteger(stringBuffer);
    }

    private Object object() throws Exception {
        HashMap hashMap = new HashMap();
        Object read = read();
        while (true) {
            Object obj = this.token;
            Object obj2 = OBJECT_END;
            if (obj == obj2 || this.f4970c == 65535) {
                break;
            }
            read();
            if (this.token != obj2) {
                hashMap.put(read, read());
                if (read() == COMMA) {
                    read = read();
                }
            }
        }
        return hashMap;
    }

    private void skipWhiteSpace() {
        while (Character.isWhitespace(this.f4970c)) {
            next();
        }
    }

    private Object string() {
        this.buf.setLength(0);
        while (true) {
            char c2 = this.f4970c;
            if (c2 == '\"' || c2 == 65535) {
                break;
            } else if (c2 == '\\') {
                next();
                if (this.f4970c == 'u') {
                    add(unicode());
                } else {
                    Character ch = escapes.get(new Character(this.f4970c));
                    if (ch != null) {
                        add(ch.charValue());
                    }
                }
            } else {
                add();
            }
        }
        next();
        return this.buf.toString();
    }

    private char unicode() {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            char next = next();
            switch (next) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i4 = ((i4 << 4) + this.f4970c) - 48;
                    break;
                default:
                    switch (next) {
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            i2 = i4 << 4;
                            i3 = this.f4970c - 'A';
                            i4 = i2 + i3 + 10;
                            break;
                        default:
                            switch (next) {
                                case 'a':
                                case 'b':
                                case 'c':
                                case 'd':
                                case 'e':
                                case 'f':
                                    i2 = i4 << 4;
                                    i3 = this.f4970c - 'a';
                                    i4 = i2 + i3 + 10;
                                    break;
                            }
                    }
            }
        }
        return (char) i4;
    }

    public Object read(CharacterIterator characterIterator, int i2) throws Exception {
        this.it = characterIterator;
        if (i2 == 0) {
            this.f4970c = characterIterator.first();
        } else if (i2 == 1) {
            this.f4970c = characterIterator.current();
        } else if (i2 == 2) {
            this.f4970c = characterIterator.next();
        }
        return read();
    }

    private void add() {
        add(this.f4970c);
    }

    public Object read(CharacterIterator characterIterator) throws Exception {
        return read(characterIterator, 2);
    }

    public Object read(String str) throws Exception {
        return read(new StringCharacterIterator(str), 0);
    }

    private Object read() throws Exception {
        skipWhiteSpace();
        char c2 = this.f4970c;
        next();
        switch (c2) {
            case '\"':
                this.token = string();
                break;
            case ',':
                this.token = COMMA;
                break;
            case ':':
                this.token = COLON;
                break;
            case '[':
                this.token = array();
                break;
            case ']':
                this.token = ARRAY_END;
                break;
            case 'f':
                next();
                next();
                next();
                next();
                this.token = Boolean.FALSE;
                break;
            case 'n':
                next();
                next();
                next();
                this.token = null;
                break;
            case 't':
                next();
                next();
                next();
                this.token = Boolean.TRUE;
                break;
            case '{':
                this.token = object();
                break;
            case '}':
                this.token = OBJECT_END;
                break;
            case 65535:
                this.token = (char) 65535;
                break;
            default:
                char previous = this.it.previous();
                this.f4970c = previous;
                if (!Character.isDigit(previous) && this.f4970c != '-') {
                    throw new Exception("error json field");
                }
                this.token = number();
                break;
                break;
        }
        return this.token;
    }
}
