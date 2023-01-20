package com.moor.imkf.lib.jsoup.parser;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Entities;
import com.moor.imkf.lib.jsoup.parser.Token;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import com.umeng.analytics.pro.o;
import h.t2.y;
import java.util.Arrays;
import k.b.a.a.n.l;

/* loaded from: classes2.dex */
public final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    public static final char replacementChar = 65533;
    public static final int[] win1252Extensions;
    public static final int win1252ExtensionsStart = 128;
    private Token emitPending;
    private final ParseErrorList errors;
    private String lastStartTag;
    private final CharacterReader reader;
    public Token.Tag tagPending;
    private TokeniserState state = TokeniserState.Data;
    private boolean isEmitPending = false;
    private String charsString = null;
    private StringBuilder charsBuilder = new StringBuilder(1024);
    public StringBuilder dataBuffer = new StringBuilder(1024);
    public Token.StartTag startPending = new Token.StartTag();
    public Token.EndTag endPending = new Token.EndTag();
    public Token.Character charPending = new Token.Character();
    public Token.Doctype doctypePending = new Token.Doctype();
    public Token.Comment commentPending = new Token.Comment();
    private final int[] codepointHolder = new int[1];
    private final int[] multipointHolder = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', y.f15691d, y.f15690c};
        notCharRefCharsSorted = cArr;
        win1252Extensions = new int[]{8364, ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, CameraInterface.TYPE_RECORDER, 8216, 8217, 8220, 8221, 8226, o.a.B, o.a.C, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    public String appropriateEndTagName() {
        return this.lastStartTag;
    }

    public int[] consumeCharacterReference(Character ch, boolean z) {
        int i2;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch == null || ch.charValue() != this.reader.current()) && !this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            int[] iArr = this.codepointHolder;
            this.reader.mark();
            if (this.reader.matchConsume(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                boolean matchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
                CharacterReader characterReader = this.reader;
                String consumeHexSequence = matchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
                if (consumeHexSequence.length() == 0) {
                    characterReferenceError("numeric reference with no numerals");
                    this.reader.rewindToMark();
                    return null;
                }
                this.reader.unmark();
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                try {
                    i2 = Integer.valueOf(consumeHexSequence, matchConsumeIgnoreCase ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i2 = -1;
                }
                if (i2 != -1 && ((i2 < 55296 || i2 > 57343) && i2 <= 1114111)) {
                    if (i2 >= 128) {
                        int[] iArr2 = win1252Extensions;
                        if (i2 < iArr2.length + 128) {
                            characterReferenceError("character is not a valid unicode code point");
                            i2 = iArr2[i2 - 128];
                        }
                    }
                    iArr[0] = i2;
                    return iArr;
                }
                characterReferenceError("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            String consumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
            boolean matches = this.reader.matches(';');
            if (!(Entities.isBaseNamedEntity(consumeLetterThenDigitSequence) || (Entities.isNamedEntity(consumeLetterThenDigitSequence) && matches))) {
                this.reader.rewindToMark();
                if (matches) {
                    characterReferenceError("invalid named reference");
                }
                return null;
            } else if (z && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny('=', l.f16189d, '_'))) {
                this.reader.rewindToMark();
                return null;
            } else {
                this.reader.unmark();
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                int codepointsForName = Entities.codepointsForName(consumeLetterThenDigitSequence, this.multipointHolder);
                if (codepointsForName == 1) {
                    iArr[0] = this.multipointHolder[0];
                    return iArr;
                } else if (codepointsForName == 2) {
                    return this.multipointHolder;
                } else {
                    Validate.fail("Unexpected characters returned for " + consumeLetterThenDigitSequence);
                    return this.multipointHolder;
                }
            }
        }
        return null;
    }

    public void createBogusCommentPending() {
        this.commentPending.reset();
        this.commentPending.bogus = true;
    }

    public void createCommentPending() {
        this.commentPending.reset();
    }

    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    public Token.Tag createTagPending(boolean z) {
        Token.Tag reset = z ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = reset;
        return reset;
    }

    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    public boolean currentNodeInHtmlNS() {
        return true;
    }

    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending);
        this.emitPending = token;
        this.isEmitPending = true;
        Token.TokenType tokenType = token.type;
        if (tokenType == Token.TokenType.StartTag) {
            this.lastStartTag = ((Token.StartTag) token).tagName;
        } else if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).attributes == null) {
        } else {
            error("Attributes incorrectly present on end tag");
        }
    }

    public void emitCommentPending() {
        emit(this.commentPending);
    }

    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    public TokeniserState getState() {
        return this.state;
    }

    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag);
    }

    public Token read() {
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        StringBuilder sb = this.charsBuilder;
        if (sb.length() != 0) {
            String sb2 = sb.toString();
            sb.delete(0, sb.length());
            this.charsString = null;
            return this.charPending.data(sb2);
        }
        String str = this.charsString;
        if (str != null) {
            Token.Character data = this.charPending.data(str);
            this.charsString = null;
            return data;
        }
        this.isEmitPending = false;
        return this.emitPending;
    }

    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    public String unescapeEntities(boolean z) {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!this.reader.isEmpty()) {
            borrowBuilder.append(this.reader.consumeTo(y.f15690c));
            if (this.reader.matches(y.f15690c)) {
                this.reader.consume();
                int[] consumeCharacterReference = consumeCharacterReference(null, z);
                if (consumeCharacterReference != null && consumeCharacterReference.length != 0) {
                    borrowBuilder.appendCodePoint(consumeCharacterReference[0]);
                    if (consumeCharacterReference.length == 2) {
                        borrowBuilder.appendCodePoint(consumeCharacterReference[1]);
                    }
                } else {
                    borrowBuilder.append(y.f15690c);
                }
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    public void emit(StringBuilder sb) {
        if (this.charsString == null) {
            this.charsString = sb.toString();
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append((CharSequence) sb);
    }

    public void emit(char c2) {
        if (this.charsString == null) {
            this.charsString = String.valueOf(c2);
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(c2);
    }

    public void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    public void emit(int[] iArr) {
        emit(new String(iArr, 0, iArr.length));
    }
}
