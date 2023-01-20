package okhttp3.internal.http2;

import com.bytedance.msdk.api.reward.RewardItem;
import h.k2.d;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/StreamResetException;", "Ljava/io/IOException;", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "Lokhttp3/internal/http2/ErrorCode;", "<init>", "(Lokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StreamResetException extends IOException {
    @d
    @k.e.a.d
    public final ErrorCode errorCode;

    public StreamResetException(@k.e.a.d ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.errorCode = errorCode;
    }
}
