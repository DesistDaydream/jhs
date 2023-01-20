package okhttp3;

import java.net.Socket;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lokhttp3/Connection;", "", "Lokhttp3/Route;", "route", "()Lokhttp3/Route;", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "Lokhttp3/Handshake;", "handshake", "()Lokhttp3/Handshake;", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface Connection {
    @e
    Handshake handshake();

    @d
    Protocol protocol();

    @d
    Route route();

    @d
    Socket socket();
}
