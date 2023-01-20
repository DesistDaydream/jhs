package androidx.emoji2.text.flatbuffer;

import com.umeng.analytics.pro.cb;
import j.p0;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    /* loaded from: classes.dex */
    public static class DecodeUtil {
        public static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i2) throws IllegalArgumentException {
            if (!isNotTrailingByte(b2) && (((b << 28) + (b2 + 112)) >> 30) == 0 && !isNotTrailingByte(b3) && !isNotTrailingByte(b4)) {
                int trailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
                cArr[i2] = highSurrogate(trailingByteValue);
                cArr[i2 + 1] = lowSurrogate(trailingByteValue);
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleOneByte(byte b, char[] cArr, int i2) {
            cArr[i2] = (char) b;
        }

        public static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i2) throws IllegalArgumentException {
            if (!isNotTrailingByte(b2) && ((b != -32 || b2 >= -96) && ((b != -19 || b2 < -96) && !isNotTrailingByte(b3)))) {
                cArr[i2] = (char) (((b & cb.f7124m) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
                return;
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i2) throws IllegalArgumentException {
            if (b >= -62) {
                if (!isNotTrailingByte(b2)) {
                    cArr[i2] = (char) (((b & 31) << 6) | trailingByteValue(b2));
                    return;
                }
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }

        private static char highSurrogate(int i2) {
            return (char) ((i2 >>> 10) + p0.f15999d);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i2) {
            return (char) ((i2 & 1023) + p0.f16000e);
        }

        private static int trailingByteValue(byte b) {
            return b & p0.a;
        }
    }

    /* loaded from: classes.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i2, int i3);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
