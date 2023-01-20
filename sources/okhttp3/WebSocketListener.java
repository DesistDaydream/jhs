package okhttp3;

import com.bytedance.msdk.api.reward.RewardItem;
import com.umeng.analytics.pro.am;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J)\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lokhttp3/WebSocketListener;", "", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "Lh/t1;", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "text", "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", "code", RewardItem.KEY_REASON, "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "", am.aI, "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class WebSocketListener {
    public void onClosed(@d WebSocket webSocket, int i2, @d String str) {
    }

    public void onClosing(@d WebSocket webSocket, int i2, @d String str) {
    }

    public void onFailure(@d WebSocket webSocket, @d Throwable th, @e Response response) {
    }

    public void onMessage(@d WebSocket webSocket, @d String str) {
    }

    public void onMessage(@d WebSocket webSocket, @d ByteString byteString) {
    }

    public void onOpen(@d WebSocket webSocket, @d Response response) {
    }
}
