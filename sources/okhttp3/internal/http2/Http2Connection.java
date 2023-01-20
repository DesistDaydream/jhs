package okhttp3.internal.http2;

import androidx.appcompat.widget.ActivityChooserModel;
import com.bytedance.msdk.api.reward.RewardItem;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.moor.imkf.YKFConstants;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import e.j.a.b.c.r.c0;
import h.k2.h;
import h.k2.u.a;
import h.k2.v.u;
import h.t1;
import j.m;
import j.n;
import j.o;
import j.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 º\u00012\u00020\u0001:\b»\u0001º\u0001¼\u0001½\u0001B\u0015\b\u0000\u0012\b\u0010·\u0001\u001a\u00030¶\u0001¢\u0006\u0006\b¸\u0001\u0010¹\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ#\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u001fJ-\u0010$\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\"\u0010#J/\u0010(\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010/\u001a\u00020*H\u0000¢\u0006\u0004\b0\u0010-J\u001f\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0019H\u0000¢\u0006\u0004\b3\u00104J%\u00109\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u000e¢\u0006\u0004\b;\u0010<J\r\u00109\u001a\u00020\u000e¢\u0006\u0004\b9\u0010<J\r\u0010=\u001a\u00020\u000e¢\u0006\u0004\b=\u0010<J\r\u0010>\u001a\u00020\u000e¢\u0006\u0004\b>\u0010<J\u0015\u0010?\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020*¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000eH\u0016¢\u0006\u0004\bA\u0010<J)\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\bE\u0010FJ#\u0010J\u001a\u00020\u000e2\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020HH\u0007¢\u0006\u0004\bJ\u0010KJ\u0015\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u0015\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0019¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u000eH\u0000¢\u0006\u0004\bS\u0010<J\u0017\u0010W\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0000¢\u0006\u0004\bU\u0010VJ%\u0010Z\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\bX\u0010YJ-\u0010^\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\\\u0010]J/\u0010c\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010`\u001a\u00020_2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0004\ba\u0010bJ\u001f\u0010e\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\bd\u0010-R\"\u0010f\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010\u0012\"\u0004\bi\u0010jR$\u0010l\u001a\u00020\u00192\u0006\u0010k\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010pR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00020q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR$\u0010t\u001a\u00020\u00192\u0006\u0010k\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bt\u0010m\u001a\u0004\bu\u0010oR\u0016\u0010v\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\"\u0010x\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bx\u0010g\u001a\u0004\by\u0010\u0012\"\u0004\bz\u0010jR\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010~\u001a\u00020L8\u0006@\u0006¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0082\u0001\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010\u007f\u001a\u0006\b\u0083\u0001\u0010\u0081\u0001\"\u0005\b\u0084\u0001\u0010OR\"\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001f\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R \u0010\u0092\u0001\u001a\u00020\u00078\u0000@\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0092\u0001\u0010w\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R.\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0095\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009a\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010mR\u001a\u0010\u009b\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0091\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010mR'\u0010\u009d\u0001\u001a\u00020\u00192\u0006\u0010k\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010m\u001a\u0005\b\u009e\u0001\u0010oR#\u0010 \u0001\u001a\u00070\u009f\u0001R\u00020\u00008\u0006@\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010mR\"\u0010¦\u0001\u001a\u00030¥\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R'\u0010ª\u0001\u001a\u00020\u00192\u0006\u0010k\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\bª\u0001\u0010m\u001a\u0005\b«\u0001\u0010oR\u001a\u0010¬\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u0091\u0001R\u0018\u0010\u00ad\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010mR\u0018\u0010®\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010mR\u0018\u0010¯\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010mR\"\u0010±\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u0018\u0010µ\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bµ\u0001\u0010m¨\u0006¾\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", YKFConstants.INVESTIGATE_TYPE_OUT, "Lokhttp3/internal/http2/Http2Stream;", "newStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "Ljava/io/IOException;", e.a, "Lh/t1;", "failConnection", "(Ljava/io/IOException;)V", "openStreamCount", "()I", "id", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "streamId", "removeStream$okhttp", "removeStream", "", "read", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "pushStream", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "outFinished", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "Lj/m;", "buffer", "byteCount", "writeData", "(IZLj/m;J)V", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "writeSynResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "writeSynResetLater", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "writeSynReset$okhttp", "writeSynReset", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "reply", "payload1", "payload2", "writePing", "(ZII)V", "writePingAndAwaitPong", "()V", "awaitPong", "flush", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", MessageKey.MSG_ACCEPT_TIME_START, "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "nowNs", "isHealthy", "(J)Z", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "pushedStream$okhttp", "(I)Z", "pushedStream", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "inFinished", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "Lj/o;", MessageKey.MSG_SOURCE, "pushDataLater$okhttp", "(ILj/o;IZ)V", "pushDataLater", "pushResetLater$okhttp", "pushResetLater", "nextStreamId", ExpandableTextView.P, "getNextStreamId$okhttp", "setNextStreamId$okhttp", "(I)V", "<set-?>", "readBytesTotal", "J", "getReadBytesTotal", "()J", "Lokhttp3/internal/concurrent/TaskRunner;", "", "currentPushRequests", "Ljava/util/Set;", "readBytesAcknowledged", "getReadBytesAcknowledged", "isShutdown", "Z", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "Lokhttp3/internal/concurrent/TaskQueue;", "settingsListenerQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "client", "getClient$okhttp", "()Z", "", "streams", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "awaitPongsReceived", "writerQueue", "degradedPongsReceived", "writeBytesMaximum", "getWriteBytesMaximum", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "awaitPingsSent", "Lokhttp3/internal/http2/Http2Connection$Listener;", c0.a.a, "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "writeBytesTotal", "getWriteBytesTotal", "pushQueue", "intervalPingsSent", "degradedPongDeadlineNs", "intervalPongsReceived", "", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "degradedPingsSent", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    @d
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    @d
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    @d
    private final Listener listener;
    private int nextStreamId;
    @d
    private final Settings okHttpSettings;
    @d
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    @d
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    @d
    private final Socket socket;
    @d
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    @d
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bG\u0010HJ5\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00048\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0007\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Lj/o;", MessageKey.MSG_SOURCE, "Lj/n;", "sink", "(Ljava/net/Socket;Ljava/lang/String;Lj/o;Lj/n;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection$Listener;", c0.a.a, "(Lokhttp3/internal/http2/Http2Connection$Listener;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "(Lokhttp3/internal/http2/PushObserver;)Lokhttp3/internal/http2/Http2Connection$Builder;", "", "pingIntervalMillis", "(I)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection;", "build", "()Lokhttp3/internal/http2/Http2Connection;", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "Lj/n;", "getSink$okhttp", "()Lj/n;", "setSink$okhttp", "(Lj/n;)V", "", "client", "Z", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "Lj/o;", "getSource$okhttp", "()Lj/o;", "setSource$okhttp", "(Lj/o;)V", ExpandableTextView.P, "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        private boolean client;
        @d
        public String connectionName;
        private int pingIntervalMillis;
        @d
        public n sink;
        @d
        public Socket socket;
        @d
        public o source;
        @d
        private final TaskRunner taskRunner;
        @d
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        @d
        private PushObserver pushObserver = PushObserver.CANCEL;

        public Builder(boolean z, @d TaskRunner taskRunner) {
            this.client = z;
            this.taskRunner = taskRunner;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, o oVar, n nVar, int i2, Object obj) throws IOException {
            if ((i2 & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i2 & 4) != 0) {
                oVar = z.d(z.n(socket));
            }
            if ((i2 & 8) != 0) {
                nVar = z.c(z.i(socket));
            }
            return builder.socket(socket, str, oVar, nVar);
        }

        @d
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        @d
        public final String getConnectionName$okhttp() {
            return this.connectionName;
        }

        @d
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        @d
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        @d
        public final n getSink$okhttp() {
            return this.sink;
        }

        @d
        public final Socket getSocket$okhttp() {
            return this.socket;
        }

        @d
        public final o getSource$okhttp() {
            return this.source;
        }

        @d
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @d
        public final Builder listener(@d Listener listener) {
            this.listener = listener;
            return this;
        }

        @d
        public final Builder pingIntervalMillis(int i2) {
            this.pingIntervalMillis = i2;
            return this;
        }

        @d
        public final Builder pushObserver(@d PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(@d String str) {
            this.connectionName = str;
        }

        public final void setListener$okhttp(@d Listener listener) {
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i2) {
            this.pingIntervalMillis = i2;
        }

        public final void setPushObserver$okhttp(@d PushObserver pushObserver) {
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(@d n nVar) {
            this.sink = nVar;
        }

        public final void setSocket$okhttp(@d Socket socket) {
            this.socket = socket;
        }

        public final void setSource$okhttp(@d o oVar) {
            this.source = oVar;
        }

        @h
        @d
        public final Builder socket(@d Socket socket) throws IOException {
            return socket$default(this, socket, null, null, null, 14, null);
        }

        @h
        @d
        public final Builder socket(@d Socket socket, @d String str) throws IOException {
            return socket$default(this, socket, str, null, null, 12, null);
        }

        @h
        @d
        public final Builder socket(@d Socket socket, @d String str, @d o oVar) throws IOException {
            return socket$default(this, socket, str, oVar, null, 8, null);
        }

        @h
        @d
        public final Builder socket(@d Socket socket, @d String str, @d o oVar, @d n nVar) throws IOException {
            String str2;
            this.socket = socket;
            if (this.client) {
                str2 = Util.okHttpName + ' ' + str;
            } else {
                str2 = "MockWebServer " + str;
            }
            this.connectionName = str2;
            this.source = oVar;
            this.sink = nVar;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "Lokhttp3/internal/http2/Settings;", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "", "AWAIT_PING", ExpandableTextView.P, "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "Lokhttp3/internal/http2/Http2Stream;", "stream", "Lh/t1;", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        @h.k2.d
        @d
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(@d Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "Lokhttp3/internal/http2/Http2Connection$Listener;", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(u uVar) {
                this();
            }
        }

        public void onSettings(@d Http2Connection http2Connection, @d Settings settings) {
        }

        public abstract void onStream(@d Http2Stream http2Stream) throws IOException;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J'\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#J'\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J/\u00100\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u00101J-\u00104\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b4\u00105J?\u0010<\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020)H\u0016¢\u0006\u0004\b<\u0010=R\u001c\u0010?\u001a\u00020>8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "Lh/t1;", "invoke", "()V", "", "inFinished", "", "streamId", "Lj/o;", MessageKey.MSG_SOURCE, "length", "data", "(ZILj/o;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", RewardItem.KEY_ERROR_CODE, "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "applyAndAckSettings", "ackSettings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", ActivityChooserModel.ATTRIBUTE_WEIGHT, "exclusive", RemoteMessageConst.Notification.PRIORITY, "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", ReportItem.RequestKeyHost, "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "Lokhttp3/internal/http2/Http2Reader;", "reader", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public final class ReaderRunnable implements Http2Reader.Handler, a<t1> {
        @d
        private final Http2Reader reader;

        public ReaderRunnable(@d Http2Reader http2Reader) {
            Http2Connection.this = r1;
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i2, @d String str, @d ByteString byteString, @d String str2, int i3, long j2) {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:(2:16|(14:18|19|20|21|22|24|25|26|27|28|29|30|31|(4:33|(3:35|ec|40)|45|46)(1:47))(2:60|61))|21|22|24|25|26|27|28|29|30|31|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x00d4, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x00d5, code lost:
            okhttp3.internal.http2.Http2Connection.this.failConnection(r0);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:180:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:190:0x00fb A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void applyAndAckSettings(final boolean r20, @k.e.a.d final okhttp3.internal.http2.Settings r21) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.applyAndAckSettings(boolean, okhttp3.internal.http2.Settings):void");
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i2, @d o oVar, int i3) throws IOException {
            if (Http2Connection.this.pushedStream$okhttp(i2)) {
                Http2Connection.this.pushDataLater$okhttp(i2, oVar, i3, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i2);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater$okhttp(i2, ErrorCode.PROTOCOL_ERROR);
                long j2 = i3;
                Http2Connection.this.updateConnectionFlowControl$okhttp(j2);
                oVar.skip(j2);
                return;
            }
            stream.receiveData(oVar, i3);
            if (z) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @d
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i2, @d ErrorCode errorCode, @d ByteString byteString) {
            int i3;
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                Object[] array = Http2Connection.this.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array != null) {
                    http2StreamArr = (Http2Stream[]) array;
                    Http2Connection.this.isShutdown = true;
                    t1 t1Var = t1.a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i2 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean z, final int i2, int i3, @d final List<Header> list) {
            if (Http2Connection.this.pushedStream$okhttp(i2)) {
                Http2Connection.this.pushHeadersLater$okhttp(i2, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                final Http2Stream stream = Http2Connection.this.getStream(i2);
                if (stream == null) {
                    if (Http2Connection.this.isShutdown) {
                        return;
                    }
                    if (i2 <= Http2Connection.this.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if (i2 % 2 == Http2Connection.this.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i2, Http2Connection.this, false, z, Util.toHeaders(list));
                    Http2Connection.this.setLastGoodStreamId$okhttp(i2);
                    Http2Connection.this.getStreams$okhttp().put(Integer.valueOf(i2), http2Stream);
                    final String str = Http2Connection.this.getConnectionName$okhttp() + '[' + i2 + "] onStream";
                    Http2Connection.this.taskRunner.newQueue().schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1
                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            try {
                                Http2Connection.this.getListener$okhttp().onStream(http2Stream);
                                return -1L;
                            } catch (IOException e2) {
                                Platform platform = Platform.Companion.get();
                                platform.log("Http2Connection.Listener failure for " + Http2Connection.this.getConnectionName$okhttp(), 4, e2);
                                try {
                                    http2Stream.close(ErrorCode.PROTOCOL_ERROR, e2);
                                    return -1L;
                                } catch (IOException unused) {
                                    return -1L;
                                }
                            }
                        }
                    }, 0L);
                    return;
                }
                t1 t1Var = t1.a;
                stream.receiveHeaders(Util.toHeaders(list), z);
            }
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, final int i2, final int i3) {
            if (z) {
                synchronized (Http2Connection.this) {
                    if (i2 == 1) {
                        Http2Connection.this.intervalPongsReceived++;
                    } else if (i2 != 2) {
                        if (i2 == 3) {
                            Http2Connection.this.awaitPongsReceived++;
                            Http2Connection http2Connection = Http2Connection.this;
                            if (http2Connection == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            http2Connection.notifyAll();
                        }
                        t1 t1Var = t1.a;
                    } else {
                        Http2Connection.this.degradedPongsReceived++;
                    }
                }
                return;
            }
            final String str = Http2Connection.this.getConnectionName$okhttp() + " ping";
            Http2Connection.this.writerQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    Http2Connection.this.writePing(true, i2, i3);
                    return -1L;
                }
            }, 0L);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i2, int i3, int i4, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i2, int i3, @d List<Header> list) {
            Http2Connection.this.pushRequestLater$okhttp(i3, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i2, @d ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream$okhttp(i2)) {
                Http2Connection.this.pushResetLater$okhttp(i2, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = Http2Connection.this.removeStream$okhttp(i2);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, @d final Settings settings) {
            final String str = Http2Connection.this.getConnectionName$okhttp() + " applyAndAckSettings";
            Http2Connection.this.writerQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.applyAndAckSettings(z, settings);
                    return -1L;
                }
            }, 0L);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i2, long j2) {
            if (i2 == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j2;
                    Http2Connection http2Connection2 = Http2Connection.this;
                    if (http2Connection2 != null) {
                        http2Connection2.notifyAll();
                        t1 t1Var = t1.a;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i2);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j2);
                    t1 t1Var2 = t1.a;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        @Override // h.k2.u.a
        /* renamed from: invoke */
        public void invoke2() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException e3) {
                    e2 = e3;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    Http2Connection.this.close$okhttp(errorCode, errorCode3, e2);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
                try {
                    Http2Connection.this.close$okhttp(errorCode2, ErrorCode.CANCEL, null);
                    errorCode = errorCode2;
                } catch (IOException e4) {
                    e2 = e4;
                    ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.close$okhttp(errorCode4, errorCode4, e2);
                    errorCode = http2Connection;
                    errorCode3 = this.reader;
                    Util.closeQuietly((Closeable) errorCode3);
                }
                errorCode3 = this.reader;
                Util.closeQuietly((Closeable) errorCode3);
            } catch (Throwable th2) {
                th = th2;
                Http2Connection.this.close$okhttp(errorCode, errorCode3, e2);
                Util.closeQuietly(this.reader);
                throw th;
            }
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(@d Builder builder) {
        Settings settings;
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings2 = new Settings();
        if (builder.getClient$okhttp()) {
            settings2.set(7, 16777216);
        }
        t1 t1Var = t1.a;
        this.okHttpSettings = settings2;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = settings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
            final String str = connectionName$okhttp + " ping";
            newQueue.schedule(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$$special$$inlined$schedule$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    long j2;
                    long j3;
                    boolean z;
                    synchronized (this) {
                        long j4 = this.intervalPongsReceived;
                        j2 = this.intervalPingsSent;
                        if (j4 < j2) {
                            z = true;
                        } else {
                            Http2Connection http2Connection = this;
                            j3 = http2Connection.intervalPingsSent;
                            http2Connection.intervalPingsSent = j3 + 1;
                            z = false;
                        }
                    }
                    if (z) {
                        this.failConnection(null);
                        return -1L;
                    }
                    this.writePing(false, 1, 0);
                    return nanos;
                }
            }, nanos);
        }
    }

    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, TaskRunner taskRunner, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z, taskRunner);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@d ErrorCode errorCode, @d ErrorCode errorCode2, @k.e.a.e IOException iOException) {
        int i2;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            shutdown(errorCode);
        } catch (IOException unused) {
        }
        Http2Stream[] http2StreamArr = null;
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                if (array != null) {
                    http2StreamArr = (Http2Stream[]) array;
                    this.streams.clear();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            t1 t1Var = t1.a;
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @d
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @d
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @d
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @d
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @d
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @d
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @k.e.a.e
    public final synchronized Http2Stream getStream(int i2) {
        return this.streams.get(Integer.valueOf(i2));
    }

    @d
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @d
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j2) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (j2 >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    @d
    public final Http2Stream newStream(@d List<Header> list, boolean z) throws IOException {
        return newStream(0, list, z);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(final int i2, @d o oVar, final int i3, final boolean z) throws IOException {
        final m mVar = new m();
        long j2 = i3;
        oVar.R(j2);
        oVar.read(mVar, j2);
        final String str = this.connectionName + '[' + i2 + "] onData";
        this.pushQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                try {
                    pushObserver = this.pushObserver;
                    boolean onData = pushObserver.onData(i2, mVar, i3, z);
                    if (onData) {
                        this.getWriter().rstStream(i2, ErrorCode.CANCEL);
                    }
                    if (onData || z) {
                        synchronized (this) {
                            set = this.currentPushRequests;
                            set.remove(Integer.valueOf(i2));
                        }
                        return -1L;
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void pushHeadersLater$okhttp(final int i2, @d final List<Header> list, final boolean z) {
        final String str = this.connectionName + '[' + i2 + "] onHeaders";
        this.pushQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                pushObserver = this.pushObserver;
                boolean onHeaders = pushObserver.onHeaders(i2, list, z);
                if (onHeaders) {
                    try {
                        this.getWriter().rstStream(i2, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (onHeaders || z) {
                    synchronized (this) {
                        set = this.currentPushRequests;
                        set.remove(Integer.valueOf(i2));
                    }
                    return -1L;
                }
                return -1L;
            }
        }, 0L);
    }

    public final void pushRequestLater$okhttp(final int i2, @d final List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i2))) {
                writeSynResetLater$okhttp(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i2));
            final String str = this.connectionName + '[' + i2 + "] onRequest";
            this.pushQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    PushObserver pushObserver;
                    Set set;
                    pushObserver = this.pushObserver;
                    if (pushObserver.onRequest(i2, list)) {
                        try {
                            this.getWriter().rstStream(i2, ErrorCode.CANCEL);
                            synchronized (this) {
                                set = this.currentPushRequests;
                                set.remove(Integer.valueOf(i2));
                            }
                            return -1L;
                        } catch (IOException unused) {
                            return -1L;
                        }
                    }
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void pushResetLater$okhttp(final int i2, @d final ErrorCode errorCode) {
        final String str = this.connectionName + '[' + i2 + "] onReset";
        this.pushQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                PushObserver pushObserver;
                Set set;
                pushObserver = this.pushObserver;
                pushObserver.onReset(i2, errorCode);
                synchronized (this) {
                    set = this.currentPushRequests;
                    set.remove(Integer.valueOf(i2));
                    t1 t1Var = t1.a;
                }
                return -1L;
            }
        }, 0L);
    }

    @d
    public final Http2Stream pushStream(int i2, @d List<Header> list, boolean z) throws IOException {
        if (!this.client) {
            return newStream(i2, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    @k.e.a.e
    public final synchronized Http2Stream removeStream$okhttp(int i2) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j2 = this.degradedPongsReceived;
            long j3 = this.degradedPingsSent;
            if (j2 < j3) {
                return;
            }
            this.degradedPingsSent = j3 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
            t1 t1Var = t1.a;
            final String str = this.connectionName + " ping";
            this.writerQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$1
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    this.writePing(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void setLastGoodStreamId$okhttp(int i2) {
        this.lastGoodStreamId = i2;
    }

    public final void setNextStreamId$okhttp(int i2) {
        this.nextStreamId = i2;
    }

    public final void setPeerSettings(@d Settings settings) {
        this.peerSettings = settings;
    }

    public final void setSettings(@d Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.okHttpSettings.merge(settings);
                    t1 t1Var = t1.a;
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(@d ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i2 = this.lastGoodStreamId;
                t1 t1Var = t1.a;
                this.writer.goAway(i2, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    @h
    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    @h
    public final void start(boolean z) throws IOException {
        start$default(this, z, null, 2, null);
    }

    @h
    public final void start(boolean z, @d TaskRunner taskRunner) throws IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - 65535);
            }
        }
        TaskQueue newQueue = taskRunner.newQueue();
        String str = this.connectionName;
        newQueue.schedule(new TaskQueue$execute$1(this.readerRunnable, str, true, str, true), 0L);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j2) {
        long j3 = this.readBytesTotal + j2;
        this.readBytesTotal = j3;
        long j4 = j3 - this.readBytesAcknowledged;
        if (j4 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j4);
            this.readBytesAcknowledged += j4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0031, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0033, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.writer.maxDataLength());
        r6 = r3;
        r8.writeBytesTotal += r6;
        r4 = h.t1.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeData(int r9, boolean r10, @k.e.a.e j.m r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L6c
            monitor-enter(r8)
        L12:
            long r3 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            long r5 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L32
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.streams     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            goto L12
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
            throw r9     // Catch: java.lang.Throwable -> L5b java.lang.InterruptedException -> L5d
        L32:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch: java.lang.Throwable -> L5b
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L5b
            okhttp3.internal.http2.Http2Writer r3 = r8.writer     // Catch: java.lang.Throwable -> L5b
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L5b
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L5b
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L5b
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L5b
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L5b
            h.t1 r4 = h.t1.a     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L56
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L56
            r5 = 1
            goto L57
        L56:
            r5 = 0
        L57:
            r4.data(r5, r9, r11, r3)
            goto Ld
        L5b:
            r9 = move-exception
            goto L6a
        L5d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L5b
            r9.interrupt()     // Catch: java.lang.Throwable -> L5b
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L5b
            r9.<init>()     // Catch: java.lang.Throwable -> L5b
            throw r9     // Catch: java.lang.Throwable -> L5b
        L6a:
            monitor-exit(r8)
            throw r9
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, j.m, long):void");
    }

    public final void writeHeaders$okhttp(int i2, boolean z, @d List<Header> list) throws IOException {
        this.writer.headers(z, i2, list);
    }

    public final void writePing(boolean z, int i2, int i3) {
        try {
            this.writer.ping(z, i2, i3);
        } catch (IOException e2) {
            failConnection(e2);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i2, @d ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i2, errorCode);
    }

    public final void writeSynResetLater$okhttp(final int i2, @d final ErrorCode errorCode) {
        final String str = this.connectionName + '[' + i2 + "] writeSynReset";
        this.writerQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.writeSynReset$okhttp(i2, errorCode);
                    return -1L;
                } catch (IOException e2) {
                    this.failConnection(e2);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i2, final long j2) {
        final String str = this.connectionName + '[' + i2 + "] windowUpdate";
        this.writerQueue.schedule(new Task(str, true) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.getWriter().windowUpdate(i2, j2);
                    return -1L;
                } catch (IOException e2) {
                    this.failConnection(e2);
                    return -1L;
                }
            }
        }, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0048 A[Catch: all -> 0x0081, TryCatch #1 {, blocks: (B:92:0x0006, B:111:0x0053, B:113:0x0056, B:114:0x005c, B:116:0x0061, B:121:0x006f, B:122:0x007a, B:93:0x0007, B:95:0x000e, B:96:0x0013, B:98:0x0017, B:100:0x002a, B:102:0x0032, B:107:0x0042, B:109:0x0048, B:110:0x0051, B:123:0x007b, B:124:0x0080), top: B:131:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.Http2Writer r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L84
            int r0 = r10.nextStreamId     // Catch: java.lang.Throwable -> L81
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L81
            r10.shutdown(r0)     // Catch: java.lang.Throwable -> L81
        L13:
            boolean r0 = r10.isShutdown     // Catch: java.lang.Throwable -> L81
            if (r0 != 0) goto L7b
            int r8 = r10.nextStreamId     // Catch: java.lang.Throwable -> L81
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch: java.lang.Throwable -> L81
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch: java.lang.Throwable -> L81
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            r0 = 1
            if (r13 == 0) goto L41
            long r1 = r10.writeBytesTotal     // Catch: java.lang.Throwable -> L81
            long r3 = r10.writeBytesMaximum     // Catch: java.lang.Throwable -> L81
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L41
            long r1 = r9.getWriteBytesTotal()     // Catch: java.lang.Throwable -> L81
            long r3 = r9.getWriteBytesMaximum()     // Catch: java.lang.Throwable -> L81
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L3f
            goto L41
        L3f:
            r13 = 0
            goto L42
        L41:
            r13 = 1
        L42:
            boolean r1 = r9.isOpen()     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L51
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r10.streams     // Catch: java.lang.Throwable -> L81
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L81
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L81
        L51:
            h.t1 r1 = h.t1.a     // Catch: java.lang.Throwable -> L81
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
            if (r11 != 0) goto L5c
            okhttp3.internal.http2.Http2Writer r11 = r10.writer     // Catch: java.lang.Throwable -> L84
            r11.headers(r6, r8, r12)     // Catch: java.lang.Throwable -> L84
            goto L66
        L5c:
            boolean r1 = r10.client     // Catch: java.lang.Throwable -> L84
            r0 = r0 ^ r1
            if (r0 == 0) goto L6f
            okhttp3.internal.http2.Http2Writer r0 = r10.writer     // Catch: java.lang.Throwable -> L84
            r0.pushPromise(r11, r8, r12)     // Catch: java.lang.Throwable -> L84
        L66:
            monitor-exit(r7)
            if (r13 == 0) goto L6e
            okhttp3.internal.http2.Http2Writer r11 = r10.writer
            r11.flush()
        L6e:
            return r9
        L6f:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L84
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L84
            r12.<init>(r11)     // Catch: java.lang.Throwable -> L84
            throw r12     // Catch: java.lang.Throwable -> L84
        L7b:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L81
            r11.<init>()     // Catch: java.lang.Throwable -> L81
            throw r11     // Catch: java.lang.Throwable -> L81
        L81:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L84
            throw r11     // Catch: java.lang.Throwable -> L84
        L84:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
