package com.moor.imkf.lib.socket.java_websocket.util;

import androidx.annotation.RequiresApi;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public class Charsetfunctions {
    private static final CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
    private static final int[] utf8d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 1, 2, 3, 5, 8, 7, 1, 1, 1, 4, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    private Charsetfunctions() {
    }

    @RequiresApi(api = 19)
    public static byte[] asciiBytes(String str) {
        return str.getBytes(StandardCharsets.US_ASCII);
    }

    public static boolean isValidUTF8(ByteBuffer byteBuffer, int i2) {
        int remaining = byteBuffer.remaining();
        if (remaining < i2) {
            return false;
        }
        int i3 = 0;
        while (i2 < remaining) {
            int[] iArr = utf8d;
            i3 = iArr[(i3 << 4) + 256 + iArr[byteBuffer.get(i2) & 255]];
            if (i3 == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static String stringAscii(byte[] bArr) {
        return stringAscii(bArr, 0, bArr.length);
    }

    @RequiresApi(api = 19)
    public static String stringUtf8(byte[] bArr) throws InvalidDataException {
        return stringUtf8(ByteBuffer.wrap(bArr));
    }

    @RequiresApi(api = 19)
    public static byte[] utf8Bytes(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    @RequiresApi(api = 19)
    public static String stringAscii(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, StandardCharsets.US_ASCII);
    }

    @RequiresApi(api = 19)
    public static String stringUtf8(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder newDecoder = StandardCharsets.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction2 = codingErrorAction;
        newDecoder.onMalformedInput(codingErrorAction2);
        newDecoder.onUnmappableCharacter(codingErrorAction2);
        try {
            byteBuffer.mark();
            String charBuffer = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return charBuffer;
        } catch (CharacterCodingException e2) {
            throw new InvalidDataException(1007, e2);
        }
    }

    public static boolean isValidUTF8(ByteBuffer byteBuffer) {
        return isValidUTF8(byteBuffer, 0);
    }
}
