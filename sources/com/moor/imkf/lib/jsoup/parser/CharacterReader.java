package com.moor.imkf.lib.jsoup.parser;

import androidx.core.app.FrameMetricsAggregator;
import com.moor.imkf.lib.jsoup.UncheckedIOException;
import com.moor.imkf.lib.jsoup.helper.Validate;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class CharacterReader {
    public static final char EOF = 65535;
    public static final int maxBufferLen = 32768;
    private static final int maxStringCacheLen = 12;
    private static final int minReadAheadLen = 1024;
    public static final int readAheadLimit = 24576;
    private static final int stringCacheSize = 512;
    private int bufLength;
    private int bufMark;
    private int bufPos;
    private int bufSplitPoint;
    private char[] charBuf;
    private boolean readFully;
    private Reader reader;
    private int readerPos;
    private String[] stringCache;

    public CharacterReader(Reader reader, int i2) {
        this.bufMark = -1;
        this.stringCache = new String[512];
        Validate.notNull(reader);
        Validate.isTrue(reader.markSupported());
        this.reader = reader;
        this.charBuf = new char[i2 > 32768 ? 32768 : i2];
        bufferUp();
    }

    private void bufferUp() {
        int i2;
        int i3;
        boolean z;
        if (this.readFully || (i2 = this.bufPos) < this.bufSplitPoint) {
            return;
        }
        int i4 = this.bufMark;
        if (i4 != -1) {
            i3 = i2 - i4;
            i2 = i4;
        } else {
            i3 = 0;
        }
        try {
            long j2 = i2;
            long skip = this.reader.skip(j2);
            this.reader.mark(32768);
            int i5 = 0;
            while (true) {
                z = true;
                if (i5 > 1024) {
                    break;
                }
                Reader reader = this.reader;
                char[] cArr = this.charBuf;
                int read = reader.read(cArr, i5, cArr.length - i5);
                if (read == -1) {
                    this.readFully = true;
                }
                if (read <= 0) {
                    break;
                }
                i5 += read;
            }
            this.reader.reset();
            if (i5 > 0) {
                if (skip != j2) {
                    z = false;
                }
                Validate.isTrue(z);
                this.bufLength = i5;
                this.readerPos += i2;
                this.bufPos = i3;
                if (this.bufMark != -1) {
                    this.bufMark = 0;
                }
                if (i5 > 24576) {
                    i5 = readAheadLimit;
                }
                this.bufSplitPoint = i5;
            }
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }

    private static String cacheString(char[] cArr, String[] strArr, int i2, int i3) {
        if (i3 > 12) {
            return new String(cArr, i2, i3);
        }
        if (i3 < 1) {
            return "";
        }
        int i4 = i3 * 31;
        int i5 = 0;
        int i6 = i2;
        while (i5 < i3) {
            i4 = (i4 * 31) + cArr[i6];
            i5++;
            i6++;
        }
        int i7 = i4 & FrameMetricsAggregator.EVERY_DURATION;
        String str = strArr[i7];
        if (str == null) {
            String str2 = new String(cArr, i2, i3);
            strArr[i7] = str2;
            return str2;
        } else if (rangeEquals(cArr, i2, i3, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i2, i3);
            strArr[i7] = str3;
            return str3;
        }
    }

    private boolean isEmptyNoBufferUp() {
        return this.bufPos >= this.bufLength;
    }

    public static boolean rangeEquals(char[] cArr, int i2, int i3, String str) {
        if (i3 != str.length()) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 == 0) {
                return true;
            }
            int i6 = i2 + 1;
            int i7 = i4 + 1;
            if (cArr[i2] != str.charAt(i4)) {
                return false;
            }
            i2 = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    public void advance() {
        this.bufPos++;
    }

    public void close() {
        Reader reader = this.reader;
        if (reader == null) {
            return;
        }
        try {
            reader.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.reader = null;
            this.charBuf = null;
            this.stringCache = null;
            throw th;
        }
        this.reader = null;
        this.charBuf = null;
        this.stringCache = null;
    }

    public char consume() {
        bufferUp();
        char c2 = isEmptyNoBufferUp() ? (char) 65535 : this.charBuf[this.bufPos];
        this.bufPos++;
        return c2;
    }

    public String consumeAttributeQuoted(boolean z) {
        int i2 = this.bufPos;
        int i3 = this.bufLength;
        char[] cArr = this.charBuf;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0) {
                break;
            }
            if (c2 != '\"') {
                if (c2 == '&') {
                    break;
                } else if (c2 != '\'') {
                    continue;
                    i4++;
                } else if (z) {
                    break;
                }
            }
            if (!z) {
                break;
            }
            i4++;
        }
        this.bufPos = i4;
        return i4 > i2 ? cacheString(this.charBuf, this.stringCache, i2, i4 - i2) : "";
    }

    public String consumeData() {
        int i2 = this.bufPos;
        int i3 = this.bufLength;
        char[] cArr = this.charBuf;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == '&' || c2 == '<') {
                break;
            }
            i4++;
        }
        this.bufPos = i4;
        return i4 > i2 ? cacheString(this.charBuf, this.stringCache, i2, i4 - i2) : "";
    }

    public String consumeDigitSequence() {
        int i2;
        char c2;
        bufferUp();
        int i3 = this.bufPos;
        while (true) {
            i2 = this.bufPos;
            if (i2 >= this.bufLength || (c2 = this.charBuf[i2]) < '0' || c2 > '9') {
                break;
            }
            this.bufPos = i2 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i3, i2 - i3);
    }

    public String consumeHexSequence() {
        int i2;
        char c2;
        bufferUp();
        int i3 = this.bufPos;
        while (true) {
            i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c2 = this.charBuf[i2]) < '0' || c2 > '9') && ((c2 < 'A' || c2 > 'F') && (c2 < 'a' || c2 > 'f')))) {
                break;
            }
            this.bufPos = i2 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i3, i2 - i3);
    }

    public String consumeLetterSequence() {
        char c2;
        bufferUp();
        int i2 = this.bufPos;
        while (true) {
            int i3 = this.bufPos;
            if (i3 >= this.bufLength || (((c2 = this.charBuf[i3]) < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2)))) {
                break;
            }
            this.bufPos++;
        }
        return cacheString(this.charBuf, this.stringCache, i2, this.bufPos - i2);
    }

    public String consumeLetterThenDigitSequence() {
        char c2;
        bufferUp();
        int i2 = this.bufPos;
        while (true) {
            int i3 = this.bufPos;
            if (i3 >= this.bufLength || (((c2 = this.charBuf[i3]) < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2)))) {
                break;
            }
            this.bufPos++;
        }
        while (!isEmptyNoBufferUp()) {
            char[] cArr = this.charBuf;
            int i4 = this.bufPos;
            char c3 = cArr[i4];
            if (c3 < '0' || c3 > '9') {
                break;
            }
            this.bufPos = i4 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i2, this.bufPos - i2);
    }

    public String consumeRawData() {
        int i2 = this.bufPos;
        int i3 = this.bufLength;
        char[] cArr = this.charBuf;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == '<') {
                break;
            }
            i4++;
        }
        this.bufPos = i4;
        return i4 > i2 ? cacheString(this.charBuf, this.stringCache, i2, i4 - i2) : "";
    }

    public String consumeTagName() {
        bufferUp();
        int i2 = this.bufPos;
        int i3 = this.bufLength;
        char[] cArr = this.charBuf;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == ' ' || c2 == '/' || c2 == '<' || c2 == '>' || c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r') {
                break;
            }
            i4++;
        }
        this.bufPos = i4;
        return i4 > i2 ? cacheString(this.charBuf, this.stringCache, i2, i4 - i2) : "";
    }

    public String consumeTo(char c2) {
        int nextIndexOf = nextIndexOf(c2);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        }
        return consumeToEnd();
    }

    public String consumeToAny(char... cArr) {
        bufferUp();
        int i2 = this.bufPos;
        int i3 = this.bufLength;
        char[] cArr2 = this.charBuf;
        int i4 = i2;
        loop0: while (i4 < i3) {
            for (char c2 : cArr) {
                if (cArr2[i4] == c2) {
                    break loop0;
                }
            }
            i4++;
        }
        this.bufPos = i4;
        return i4 > i2 ? cacheString(this.charBuf, this.stringCache, i2, i4 - i2) : "";
    }

    public String consumeToAnySorted(char... cArr) {
        bufferUp();
        int i2 = this.bufPos;
        int i3 = this.bufLength;
        char[] cArr2 = this.charBuf;
        int i4 = i2;
        while (i4 < i3 && Arrays.binarySearch(cArr, cArr2[i4]) < 0) {
            i4++;
        }
        this.bufPos = i4;
        return i4 > i2 ? cacheString(this.charBuf, this.stringCache, i2, i4 - i2) : "";
    }

    public String consumeToEnd() {
        bufferUp();
        char[] cArr = this.charBuf;
        String[] strArr = this.stringCache;
        int i2 = this.bufPos;
        String cacheString = cacheString(cArr, strArr, i2, this.bufLength - i2);
        this.bufPos = this.bufLength;
        return cacheString;
    }

    public boolean containsIgnoreCase(String str) {
        Locale locale = Locale.ENGLISH;
        return nextIndexOf(str.toLowerCase(locale)) > -1 || nextIndexOf(str.toUpperCase(locale)) > -1;
    }

    public char current() {
        bufferUp();
        if (isEmptyNoBufferUp()) {
            return (char) 65535;
        }
        return this.charBuf[this.bufPos];
    }

    public boolean isEmpty() {
        bufferUp();
        return this.bufPos >= this.bufLength;
    }

    public void mark() {
        if (this.bufLength - this.bufPos < 1024) {
            this.bufSplitPoint = 0;
        }
        bufferUp();
        this.bufMark = this.bufPos;
    }

    public boolean matchConsume(String str) {
        bufferUp();
        if (matches(str)) {
            this.bufPos += str.length();
            return true;
        }
        return false;
    }

    public boolean matchConsumeIgnoreCase(String str) {
        if (matchesIgnoreCase(str)) {
            this.bufPos += str.length();
            return true;
        }
        return false;
    }

    public boolean matches(char c2) {
        return !isEmpty() && this.charBuf[this.bufPos] == c2;
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        bufferUp();
        char c2 = this.charBuf[this.bufPos];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesAnySorted(char[] cArr) {
        bufferUp();
        return !isEmpty() && Arrays.binarySearch(cArr, this.charBuf[this.bufPos]) >= 0;
    }

    public boolean matchesDigit() {
        char c2;
        return !isEmpty() && (c2 = this.charBuf[this.bufPos]) >= '0' && c2 <= '9';
    }

    public boolean matchesIgnoreCase(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.charBuf[this.bufPos + i2])) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesLetter() {
        if (isEmpty()) {
            return false;
        }
        char c2 = this.charBuf[this.bufPos];
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2);
    }

    public int nextIndexOf(char c2) {
        bufferUp();
        for (int i2 = this.bufPos; i2 < this.bufLength; i2++) {
            if (c2 == this.charBuf[i2]) {
                return i2 - this.bufPos;
            }
        }
        return -1;
    }

    public int pos() {
        return this.readerPos + this.bufPos;
    }

    public void rewindToMark() {
        int i2 = this.bufMark;
        if (i2 != -1) {
            this.bufPos = i2;
            unmark();
            return;
        }
        throw new UncheckedIOException(new IOException("Mark invalid"));
    }

    public String toString() {
        if (this.bufLength - this.bufPos < 0) {
            return "";
        }
        char[] cArr = this.charBuf;
        int i2 = this.bufPos;
        return new String(cArr, i2, this.bufLength - i2);
    }

    public void unconsume() {
        int i2 = this.bufPos;
        if (i2 >= 1) {
            this.bufPos = i2 - 1;
            return;
        }
        throw new UncheckedIOException(new IOException("No buffer left to unconsume"));
    }

    public void unmark() {
        this.bufMark = -1;
    }

    public boolean matches(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != this.charBuf[this.bufPos + i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean rangeEquals(int i2, int i3, String str) {
        return rangeEquals(this.charBuf, i2, i3, str);
    }

    public String consumeTo(String str) {
        int nextIndexOf = nextIndexOf(str);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        } else if (this.bufLength - this.bufPos < str.length()) {
            return consumeToEnd();
        } else {
            int length = (this.bufLength - str.length()) + 1;
            char[] cArr = this.charBuf;
            String[] strArr = this.stringCache;
            int i2 = this.bufPos;
            String cacheString2 = cacheString(cArr, strArr, i2, length - i2);
            this.bufPos = length;
            return cacheString2;
        }
    }

    public int nextIndexOf(CharSequence charSequence) {
        bufferUp();
        char charAt = charSequence.charAt(0);
        int i2 = this.bufPos;
        while (i2 < this.bufLength) {
            if (charAt != this.charBuf[i2]) {
                do {
                    i2++;
                    if (i2 >= this.bufLength) {
                        break;
                    }
                } while (charAt != this.charBuf[i2]);
            }
            int i3 = i2 + 1;
            int length = (charSequence.length() + i3) - 1;
            int i4 = this.bufLength;
            if (i2 < i4 && length <= i4) {
                int i5 = i3;
                for (int i6 = 1; i5 < length && charSequence.charAt(i6) == this.charBuf[i5]; i6++) {
                    i5++;
                }
                if (i5 == length) {
                    return i2 - this.bufPos;
                }
            }
            i2 = i3;
        }
        return -1;
    }

    public CharacterReader(Reader reader) {
        this(reader, 32768);
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }
}
