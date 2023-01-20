package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class e extends RuntimeException {
    private static final Method b;
    private IOException a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        b = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.a = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = b;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public IOException a() {
        return this.a;
    }

    public void a(IOException iOException) {
        a(iOException, this.a);
        this.a = iOException;
    }
}
