package l;

import j.o0;
import java.io.IOException;
import okhttp3.Request;

/* loaded from: classes4.dex */
public interface d<T> extends Cloneable {
    void cancel();

    d<T> clone();

    r<T> execute() throws IOException;

    void i(f<T> fVar);

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    o0 timeout();
}
