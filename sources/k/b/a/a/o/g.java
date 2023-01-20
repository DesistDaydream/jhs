package k.b.a.a.o;

import org.apache.commons.codec.DecoderException;

/* loaded from: classes4.dex */
public class g {
    private static final int a = 16;

    public static int a(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b));
    }

    public static char b(int i2) {
        return Character.toUpperCase(Character.forDigit(i2 & 15, 16));
    }
}
