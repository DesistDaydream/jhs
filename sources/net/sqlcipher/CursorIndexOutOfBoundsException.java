package net.sqlcipher;

/* loaded from: classes4.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i2, int i3) {
        super("Index " + i2 + " requested, with a size of " + i3);
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
