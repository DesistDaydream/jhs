package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.SerializationException;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.CharacterReader;
import com.moor.imkf.lib.jsoup.parser.Parser;
import h.t2.y;
import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import k.b.a.a.c;

/* loaded from: classes2.dex */
public class Entities {
    public static final int codepointRadix = 36;
    private static final int empty = -1;
    private static final String emptyName = "";
    private static final char[] codeDelims = {',', ';'};
    private static final HashMap<String, String> multipoints = new HashMap<>();
    private static final Document.OutputSettings DefaultOutput = new Document.OutputSettings();

    /* renamed from: com.moor.imkf.lib.jsoup.nodes.Entities$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$moor$imkf$lib$jsoup$nodes$Entities$CoreCharset;

        static {
            int[] iArr = new int[CoreCharset.values().length];
            $SwitchMap$com$moor$imkf$lib$jsoup$nodes$Entities$CoreCharset = iArr;
            try {
                iArr[CoreCharset.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jsoup$nodes$Entities$CoreCharset[CoreCharset.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum CoreCharset {
        ascii,
        utf,
        fallback;

        public static CoreCharset byName(String str) {
            if (str.equals(c.b)) {
                return ascii;
            }
            if (str.startsWith("UTF-")) {
                return utf;
            }
            return fallback;
        }
    }

    /* loaded from: classes2.dex */
    public enum EscapeMode {
        xhtml(EntitiesData.xmlPoints, 4),
        base(EntitiesData.basePoints, 106),
        extended(EntitiesData.fullPoints, 2125);
        
        private int[] codeKeys;
        private int[] codeVals;
        private String[] nameKeys;
        private String[] nameVals;

        EscapeMode(String str, int i2) {
            Entities.load(this, str, i2);
        }

        private int size() {
            return this.nameKeys.length;
        }

        public int codepointForName(String str) {
            int binarySearch = Arrays.binarySearch(this.nameKeys, str);
            if (binarySearch >= 0) {
                return this.codeVals[binarySearch];
            }
            return -1;
        }

        public String nameForCodepoint(int i2) {
            int binarySearch = Arrays.binarySearch(this.codeKeys, i2);
            if (binarySearch >= 0) {
                String[] strArr = this.nameVals;
                if (binarySearch < strArr.length - 1) {
                    int i3 = binarySearch + 1;
                    if (this.codeKeys[i3] == i2) {
                        return strArr[i3];
                    }
                }
                return strArr[binarySearch];
            }
            return "";
        }
    }

    private Entities() {
    }

    private static void appendEncoded(Appendable appendable, EscapeMode escapeMode, int i2) throws IOException {
        String nameForCodepoint = escapeMode.nameForCodepoint(i2);
        if (!"".equals(nameForCodepoint)) {
            appendable.append(y.f15690c).append(nameForCodepoint).append(';');
        } else {
            appendable.append("&#x").append(Integer.toHexString(i2)).append(';');
        }
    }

    private static boolean canEncode(CoreCharset coreCharset, char c2, CharsetEncoder charsetEncoder) {
        int i2 = AnonymousClass1.$SwitchMap$com$moor$imkf$lib$jsoup$nodes$Entities$CoreCharset[coreCharset.ordinal()];
        if (i2 == 1) {
            return c2 < 128;
        } else if (i2 != 2) {
            return charsetEncoder.canEncode(c2);
        } else {
            return true;
        }
    }

    public static int codepointsForName(String str, int[] iArr) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int codepointForName = EscapeMode.extended.codepointForName(str);
        if (codepointForName != -1) {
            iArr[0] = codepointForName;
            return 1;
        }
        return 0;
    }

    public static String escape(String str, Document.OutputSettings outputSettings) {
        if (str == null) {
            return "";
        }
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            escape(borrowBuilder, str, outputSettings, false, false, false);
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public static String getByName(String str) {
        String str2 = multipoints.get(str);
        if (str2 != null) {
            return str2;
        }
        int codepointForName = EscapeMode.extended.codepointForName(str);
        return codepointForName != -1 ? new String(new int[]{codepointForName}, 0, 1) : "";
    }

    public static boolean isBaseNamedEntity(String str) {
        return EscapeMode.base.codepointForName(str) != -1;
    }

    public static boolean isNamedEntity(String str) {
        return EscapeMode.extended.codepointForName(str) != -1;
    }

    public static void load(EscapeMode escapeMode, String str, int i2) {
        int i3;
        escapeMode.nameKeys = new String[i2];
        escapeMode.codeVals = new int[i2];
        escapeMode.codeKeys = new int[i2];
        escapeMode.nameVals = new String[i2];
        CharacterReader characterReader = new CharacterReader(str);
        int i4 = 0;
        while (!characterReader.isEmpty()) {
            String consumeTo = characterReader.consumeTo('=');
            characterReader.advance();
            int parseInt = Integer.parseInt(characterReader.consumeToAny(codeDelims), 36);
            char current = characterReader.current();
            characterReader.advance();
            if (current == ',') {
                i3 = Integer.parseInt(characterReader.consumeTo(';'), 36);
                characterReader.advance();
            } else {
                i3 = -1;
            }
            int parseInt2 = Integer.parseInt(characterReader.consumeTo(y.f15690c), 36);
            characterReader.advance();
            escapeMode.nameKeys[i4] = consumeTo;
            escapeMode.codeVals[i4] = parseInt;
            escapeMode.codeKeys[parseInt2] = parseInt;
            escapeMode.nameVals[parseInt2] = consumeTo;
            if (i3 != -1) {
                multipoints.put(consumeTo, new String(new int[]{parseInt, i3}, 0, 2));
            }
            i4++;
        }
        Validate.isTrue(i4 == i2, "Unexpected count of entities loaded");
    }

    public static String unescape(String str) {
        return unescape(str, false);
    }

    public static String unescape(String str, boolean z) {
        return Parser.unescapeEntities(str, z);
    }

    public static String escape(String str) {
        return escape(str, DefaultOutput);
    }

    public static void escape(Appendable appendable, String str, Document.OutputSettings outputSettings, boolean z, boolean z2, boolean z3) throws IOException {
        EscapeMode escapeMode = outputSettings.escapeMode();
        CharsetEncoder encoder = outputSettings.encoder();
        CoreCharset coreCharset = outputSettings.coreCharset;
        int length = str.length();
        int i2 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (z2) {
                if (StringUtil.isWhitespace(codePointAt)) {
                    if ((!z3 || z4) && !z5) {
                        appendable.append(' ');
                        z5 = true;
                    }
                    i2 += Character.charCount(codePointAt);
                } else {
                    z4 = true;
                    z5 = false;
                }
            }
            if (codePointAt < 65536) {
                char c2 = (char) codePointAt;
                if (c2 != '\"') {
                    if (c2 == '&') {
                        appendable.append("&amp;");
                    } else if (c2 != '<') {
                        if (c2 != '>') {
                            if (c2 != 160) {
                                if (canEncode(coreCharset, c2, encoder)) {
                                    appendable.append(c2);
                                } else {
                                    appendEncoded(appendable, escapeMode, codePointAt);
                                }
                            } else if (escapeMode != EscapeMode.xhtml) {
                                appendable.append("&nbsp;");
                            } else {
                                appendable.append("&#xa0;");
                            }
                        } else if (!z) {
                            appendable.append("&gt;");
                        } else {
                            appendable.append(c2);
                        }
                    } else if (z && escapeMode != EscapeMode.xhtml) {
                        appendable.append(c2);
                    } else {
                        appendable.append("&lt;");
                    }
                } else if (z) {
                    appendable.append("&quot;");
                } else {
                    appendable.append(c2);
                }
            } else {
                String str2 = new String(Character.toChars(codePointAt));
                if (encoder.canEncode(str2)) {
                    appendable.append(str2);
                } else {
                    appendEncoded(appendable, escapeMode, codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }
}
