package com.moor.imkf.lib.jsoup.parser;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.xiaomi.mipush.sdk.Constants;
import k.b.a.a.n.l;

/* loaded from: classes2.dex */
public class TokenQueue {
    private static final char ESC = '\\';
    private int pos = 0;
    private String queue;

    public TokenQueue(String str) {
        Validate.notNull(str);
        this.queue = str;
    }

    private int remainingLength() {
        return this.queue.length() - this.pos;
    }

    public static String unescape(String str) {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        char c2 = 0;
        while (i2 < length) {
            char c3 = charArray[i2];
            if (c3 != '\\') {
                borrowBuilder.append(c3);
            } else if (c2 != 0 && c2 == '\\') {
                borrowBuilder.append(c3);
            }
            i2++;
            c2 = c3;
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public void addFirst(Character ch) {
        addFirst(ch.toString());
    }

    public void advance() {
        if (isEmpty()) {
            return;
        }
        this.pos++;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0048 A[EDGE_INSN: B:40:0x0048->B:34:0x0048 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String chompBalanced(char r10, char r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L7:
            boolean r7 = r9.isEmpty()
            if (r7 == 0) goto Le
            goto L48
        Le:
            char r7 = r9.consume()
            if (r0 == 0) goto L18
            r8 = 92
            if (r0 == r8) goto L3f
        L18:
            r8 = 39
            if (r7 != r8) goto L23
            if (r7 == r10) goto L23
            if (r2 != 0) goto L23
            r3 = r3 ^ 1
            goto L2d
        L23:
            r8 = 34
            if (r7 != r8) goto L2d
            if (r7 == r10) goto L2d
            if (r3 != 0) goto L2d
            r2 = r2 ^ 1
        L2d:
            if (r3 != 0) goto L46
            if (r2 == 0) goto L32
            goto L46
        L32:
            if (r7 != r10) goto L3b
            int r4 = r4 + 1
            if (r5 != r1) goto L3f
            int r5 = r9.pos
            goto L3f
        L3b:
            if (r7 != r11) goto L3f
            int r4 = r4 + (-1)
        L3f:
            if (r4 <= 0) goto L45
            if (r0 == 0) goto L45
            int r6 = r9.pos
        L45:
            r0 = r7
        L46:
            if (r4 > 0) goto L7
        L48:
            if (r6 < 0) goto L51
            java.lang.String r10 = r9.queue
            java.lang.String r10 = r10.substring(r5, r6)
            goto L53
        L51:
            java.lang.String r10 = ""
        L53:
            if (r4 <= 0) goto L6e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Did not find balanced marker at '"
            r11.append(r0)
            r11.append(r10)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.moor.imkf.lib.jsoup.helper.Validate.fail(r11)
        L6e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.parser.TokenQueue.chompBalanced(char, char):java.lang.String");
    }

    public String chompTo(String str) {
        String consumeTo = consumeTo(str);
        matchChomp(str);
        return consumeTo;
    }

    public String chompToIgnoreCase(String str) {
        String consumeToIgnoreCase = consumeToIgnoreCase(str);
        matchChomp(str);
        return consumeToIgnoreCase;
    }

    public char consume() {
        String str = this.queue;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return str.charAt(i2);
    }

    public String consumeAttributeKey() {
        int i2 = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny(l.f16189d, '_', ':'))) {
            this.pos++;
        }
        return this.queue.substring(i2, this.pos);
    }

    public String consumeCssIdentifier() {
        int i2 = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny(l.f16189d, '_'))) {
            this.pos++;
        }
        return this.queue.substring(i2, this.pos);
    }

    public String consumeElementSelector() {
        int i2 = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny("*|", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "_", Constants.ACCEPT_TIME_SEPARATOR_SERVER))) {
            this.pos++;
        }
        return this.queue.substring(i2, this.pos);
    }

    public String consumeTagName() {
        int i2 = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny(':', '_', l.f16189d))) {
            this.pos++;
        }
        return this.queue.substring(i2, this.pos);
    }

    public String consumeTo(String str) {
        int indexOf = this.queue.indexOf(str, this.pos);
        if (indexOf != -1) {
            String substring = this.queue.substring(this.pos, indexOf);
            this.pos += substring.length();
            return substring;
        }
        return remainder();
    }

    public String consumeToAny(String... strArr) {
        int i2 = this.pos;
        while (!isEmpty() && !matchesAny(strArr)) {
            this.pos++;
        }
        return this.queue.substring(i2, this.pos);
    }

    public String consumeToIgnoreCase(String str) {
        int i2 = this.pos;
        String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!isEmpty() && !matches(str)) {
            if (equals) {
                int indexOf = this.queue.indexOf(substring, this.pos);
                int i3 = this.pos;
                int i4 = indexOf - i3;
                if (i4 == 0) {
                    this.pos = i3 + 1;
                } else if (i4 < 0) {
                    this.pos = this.queue.length();
                } else {
                    this.pos = i3 + i4;
                }
            } else {
                this.pos++;
            }
        }
        return this.queue.substring(i2, this.pos);
    }

    public boolean consumeWhitespace() {
        boolean z = false;
        while (matchesWhitespace()) {
            this.pos++;
            z = true;
        }
        return z;
    }

    public String consumeWord() {
        int i2 = this.pos;
        while (matchesWord()) {
            this.pos++;
        }
        return this.queue.substring(i2, this.pos);
    }

    public boolean isEmpty() {
        return remainingLength() == 0;
    }

    public boolean matchChomp(String str) {
        if (matches(str)) {
            this.pos += str.length();
            return true;
        }
        return false;
    }

    public boolean matches(String str) {
        return this.queue.regionMatches(true, this.pos, str, 0, str.length());
    }

    public boolean matchesAny(String... strArr) {
        for (String str : strArr) {
            if (matches(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesCS(String str) {
        return this.queue.startsWith(str, this.pos);
    }

    public boolean matchesStartTag() {
        return remainingLength() >= 2 && this.queue.charAt(this.pos) == '<' && Character.isLetter(this.queue.charAt(this.pos + 1));
    }

    public boolean matchesWhitespace() {
        return !isEmpty() && StringUtil.isWhitespace(this.queue.charAt(this.pos));
    }

    public boolean matchesWord() {
        return !isEmpty() && Character.isLetterOrDigit(this.queue.charAt(this.pos));
    }

    public char peek() {
        if (isEmpty()) {
            return (char) 0;
        }
        return this.queue.charAt(this.pos);
    }

    public String remainder() {
        String str = this.queue;
        String substring = str.substring(this.pos, str.length());
        this.pos = this.queue.length();
        return substring;
    }

    public String toString() {
        return this.queue.substring(this.pos);
    }

    public void addFirst(String str) {
        this.queue = str + this.queue.substring(this.pos);
        this.pos = 0;
    }

    public void consume(String str) {
        if (matches(str)) {
            int length = str.length();
            if (length <= remainingLength()) {
                this.pos += length;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        for (char c2 : cArr) {
            if (this.queue.charAt(this.pos) == c2) {
                return true;
            }
        }
        return false;
    }
}
