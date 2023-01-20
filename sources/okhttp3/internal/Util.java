package okhttp3.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.c.m.o;
import h.a2.l0;
import h.a2.u;
import h.h2.b;
import h.k2.d;
import h.k2.g;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.s0;
import h.k2.v.t0;
import h.m;
import h.o2.k;
import h.o2.q;
import h.t1;
import j.c0;
import j.k0;
import j.m0;
import j.n;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.ByteString;

@g(name = "Util")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010,\u001a\u0011\u0010-\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002020\u000e\"\u000202¢\u0006\u0004\b1\u00104\u001a\u0019\u00108\u001a\u000206*\u0002052\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109\u001a'\u0010=\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>\u001a\u0011\u0010?\u001a\u00020\u001b*\u00020*¢\u0006\u0004\b?\u0010@\u001a\u0017\u0010D\u001a\u00020C*\b\u0012\u0004\u0012\u00020B0A¢\u0006\u0004\bD\u0010E\u001a\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020B0A*\u00020C¢\u0006\u0004\bF\u0010G\u001a\u0019\u0010H\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\bH\u0010I\u001a\u0011\u0010L\u001a\u00020K*\u00020J¢\u0006\u0004\bL\u0010M\u001a\u001c\u0010P\u001a\u00020\u001b*\u00020N2\u0006\u0010O\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bP\u0010Q\u001a\u001c\u0010P\u001a\u00020\u001b*\u00020R2\u0006\u0010O\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bP\u0010S\u001a\u001c\u0010P\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010O\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bP\u0010T\u001a\u0019\u0010W\u001a\u00020\u0004*\u00020U2\u0006\u0010V\u001a\u00020\u001b¢\u0006\u0004\bW\u0010X\u001a\u0011\u0010Y\u001a\u00020\u001b*\u000205¢\u0006\u0004\bY\u0010Z\u001a!\u0010]\u001a\u00020\t*\u00020[2\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020;¢\u0006\u0004\b]\u0010^\u001a!\u0010`\u001a\u00020\t*\u00020[2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020;¢\u0006\u0004\b`\u0010^\u001a\u0011\u0010b\u001a\u00020\u0007*\u00020a¢\u0006\u0004\bb\u0010c\u001a\u0019\u0010e\u001a\u00020\t*\u00020a2\u0006\u0010d\u001a\u000205¢\u0006\u0004\be\u0010f\u001a!\u0010i\u001a\u00020\u00042\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040gH\u0086\bø\u0001\u0000¢\u0006\u0004\bi\u0010j\u001a)\u0010k\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040gH\u0086\bø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a\u0019\u0010]\u001a\u00020\u001b*\u00020m2\u0006\u0010n\u001a\u00020N¢\u0006\u0004\b]\u0010o\u001a\u001b\u0010p\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bp\u0010q\u001a\u0011\u0010s\u001a\u00020\u0000*\u00020r¢\u0006\u0004\bs\u0010t\u001a\u0019\u0010v\u001a\u00020\u0000*\u00020\u00072\u0006\u0010u\u001a\u00020\u0000¢\u0006\u0004\bv\u0010w\u001a\u001b\u0010x\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010u\u001a\u00020\u001b¢\u0006\u0004\bx\u0010q\u001a#\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y*\b\u0012\u0004\u0012\u00028\u00000A¢\u0006\u0004\bz\u0010{\u001a/\u0010}\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y2\u0012\u0010|\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\b}\u0010~\u001a;\u0010\u0082\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0081\u0001\"\u0004\b\u0000\u0010\u007f\"\u0005\b\u0001\u0010\u0080\u0001*\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0081\u0001¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0015\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0084\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0014\u0010\u0085\u0001\u001a\u00020\u0004*\u00020a¢\u0006\u0006\b\u0085\u0001\u0010\u0087\u0001\u001a\u0015\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0088\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0089\u0001\u001a\u001f\u0010\u008d\u0001\u001a\u00020\t*\u00030\u008a\u00012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0014\u0010\u008f\u0001\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0014\u0010\u008f\u0001\u001a\u00020\u0007*\u00020\u001b¢\u0006\u0006\b\u008f\u0001\u0010\u0091\u0001\u001a\u0017\u0010\u0092\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0017\u0010\u0094\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0094\u0001\u0010\u0093\u0001\u001a\u0017\u0010\u0095\u0001\u001a\u00020\u0004*\u000202H\u0086\b¢\u0006\u0006\b\u0095\u0001\u0010\u0093\u0001\u001a:\u0010\u009a\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010y2\u0007\u0010\u0096\u0001\u001a\u0002022\u000e\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0097\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a-\u0010\u009f\u0001\u001a\u00020\u0004\"\u0005\b\u0000\u0010\u009c\u0001*\t\u0012\u0004\u0012\u00028\u00000\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0017\u0010¡\u0001\u001a\u00020\u0004*\u000202H\u0080\b¢\u0006\u0006\b¡\u0001\u0010\u0093\u0001\u001a\u0017\u0010¢\u0001\u001a\u00020\u0004*\u000202H\u0080\b¢\u0006\u0006\b¢\u0001\u0010\u0093\u0001\u001a0\u0010§\u0001\u001a\u00030¦\u0001*\b0£\u0001j\u0003`¤\u00012\u0013\u0010¥\u0001\u001a\u000e\u0012\n\u0012\b0£\u0001j\u0003`¤\u00010A¢\u0006\u0006\b§\u0001\u0010¨\u0001\u001aI\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000A\"\u0004\b\u0000\u0010y*\t\u0012\u0004\u0012\u00028\u00000©\u00012\u001a\u0010¬\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0ª\u0001¢\u0006\u0003\b«\u0001H\u0086\bø\u0001\u0000¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001\"\u001a\u0010°\u0001\u001a\u00030¯\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001\"\u001a\u0010³\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001\"\u001a\u0010¶\u0001\u001a\u00030µ\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001\"\u0019\u0010¸\u0001\u001a\u00020\t8\u0000@\u0001X\u0081\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001\"\u0019\u0010º\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001\"\u001a\u0010½\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001\"\u001a\u0010À\u0001\u001a\u00030¿\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001\"\u0019\u0010Â\u0001\u001a\u00020C8\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001\"\u001a\u0010Å\u0001\u001a\u00030Ä\u00018\u0006@\u0007X\u0087\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001\"\u0019\u0010Ç\u0001\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010»\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006È\u0001"}, d2 = {"", "arrayLength", "offset", "count", "Lh/t1;", "checkOffsetAndCount", "(JJJ)V", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", "value", "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lj/o;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Lj/o;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", "", "mask", "and", "(BI)I", "", "(SI)I", "(IJ)J", "Lj/n;", "medium", "writeMedium", "(Lj/n;I)V", "readMedium", "(Lj/o;)I", "Lj/m0;", "timeUnit", "skipAll", "(Lj/m0;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "discard", "Ljava/net/Socket;", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", MessageKey.MSG_SOURCE, "isHealthy", "(Ljava/net/Socket;Lj/o;)Z", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "ignoreIoExceptions", "(Lh/k2/u/a;)V", "threadName", "(Ljava/lang/String;Lh/k2/u/a;)V", "Lj/m;", "b", "(Lj/m;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", ExifInterface.GPS_DIRECTION_TRUE, "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;)Z", "toHexString", "(J)Ljava/lang/String;", "(I)Ljava/lang/String;", "wait", "(Ljava/lang/Object;)V", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "", "Lkotlin/Function1;", "Lh/q;", "predicate", "filterList", "(Ljava/lang/Iterable;Lh/k2/u/l;)Ljava/util/List;", "", "EMPTY_BYTE_ARRAY", "[B", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "assertionsEnabled", "Z", TTDownloadField.TT_USERAGENT, "Ljava/lang/String;", "Lj/c0;", "UNICODE_BOMS", "Lj/c0;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "Ljava/util/TimeZone;", o.a, "Ljava/util/TimeZone;", "okHttpName", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Util {
    @d
    @k.e.a.d
    public static final byte[] EMPTY_BYTE_ARRAY;
    @d
    @k.e.a.d
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    @d
    @k.e.a.d
    public static final RequestBody EMPTY_REQUEST;
    @d
    @k.e.a.d
    public static final ResponseBody EMPTY_RESPONSE;
    private static final c0 UNICODE_BOMS;
    @d
    @k.e.a.d
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    @d
    public static final boolean assertionsEnabled;
    @d
    @k.e.a.d
    public static final String okHttpName;
    @k.e.a.d
    public static final String userAgent = "okhttp/4.9.1";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        c0.a aVar = c0.f15959d;
        ByteString.a aVar2 = ByteString.Companion;
        UNICODE_BOMS = aVar.d(aVar2.i("efbbbf"), aVar2.i("feff"), aVar2.i("fffe"), aVar2.i("0000ffff"), aVar2.i("ffff0000"));
        UTC = TimeZone.getTimeZone("GMT");
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        okHttpName = StringsKt__StringsKt.i4(StringsKt__StringsKt.c4(OkHttpClient.class.getName(), "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(@k.e.a.d List<E> list, E e2) {
        if (list.contains(e2)) {
            return;
        }
        list.add(e2);
    }

    public static final int and(byte b, int i2) {
        return b & i2;
    }

    public static final int and(short s, int i2) {
        return s & i2;
    }

    public static final long and(int i2, long j2) {
        return i2 & j2;
    }

    @k.e.a.d
    public static final EventListener.Factory asFactory(@k.e.a.d final EventListener eventListener) {
        return new EventListener.Factory() { // from class: okhttp3.internal.Util$asFactory$1
            @Override // okhttp3.EventListener.Factory
            @k.e.a.d
            public final EventListener create(@k.e.a.d Call call) {
                return eventListener;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(@k.e.a.d Object obj) {
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(@k.e.a.d Object obj) {
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(@k.e.a.d String str) {
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(@k.e.a.d HttpUrl httpUrl, @k.e.a.d HttpUrl httpUrl2) {
        return f0.g(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && f0.g(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(@k.e.a.d String str, long j2, @e TimeUnit timeUnit) {
        boolean z = true;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalStateException((str + " < 0").toString());
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (!(millis <= ((long) Integer.MAX_VALUE))) {
                throw new IllegalArgumentException((str + " too large.").toString());
            }
            if (millis == 0 && i2 > 0) {
                z = false;
            }
            if (z) {
                return (int) millis;
            }
            throw new IllegalArgumentException((str + " too small.").toString());
        }
        throw new IllegalStateException("unit == null".toString());
    }

    public static final void checkOffsetAndCount(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@k.e.a.d Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    @k.e.a.d
    public static final String[] concat(@k.e.a.d String[] strArr, @k.e.a.d String str) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
        strArr2[ArraysKt___ArraysKt.Td(strArr2)] = str;
        Objects.requireNonNull(strArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        return strArr2;
    }

    public static final int delimiterOffset(@k.e.a.d String str, @k.e.a.d String str2, int i2, int i3) {
        while (i2 < i3) {
            if (StringsKt__StringsKt.U2(str2, str.charAt(i2), false, 2, null)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, str2, i2, i3);
    }

    public static final boolean discard(@k.e.a.d m0 m0Var, int i2, @k.e.a.d TimeUnit timeUnit) {
        try {
            return skipAll(m0Var, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @k.e.a.d
    public static final <T> List<T> filterList(@k.e.a.d Iterable<? extends T> iterable, @k.e.a.d l<? super T, Boolean> lVar) {
        List<T> E = CollectionsKt__CollectionsKt.E();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (lVar.invoke(obj).booleanValue()) {
                if (E.isEmpty()) {
                    E = new ArrayList<>();
                }
                Objects.requireNonNull(E, "null cannot be cast to non-null type kotlin.collections.MutableList<T>");
                t0.g(E).add(obj);
            }
        }
        return E;
    }

    @k.e.a.d
    public static final String format(@k.e.a.d String str, @k.e.a.d Object... objArr) {
        s0 s0Var = s0.a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
    }

    public static final boolean hasIntersection(@k.e.a.d String[] strArr, @e String[] strArr2, @k.e.a.d Comparator<? super String> comparator) {
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@k.e.a.d Response response) {
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(@k.e.a.d a<t1> aVar) {
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @k.e.a.d
    public static final <T> List<T> immutableListOf(@k.e.a.d T... tArr) {
        Object[] objArr = (Object[]) tArr.clone();
        return Collections.unmodifiableList(CollectionsKt__CollectionsKt.L(Arrays.copyOf(objArr, objArr.length)));
    }

    public static final int indexOf(@k.e.a.d String[] strArr, @k.e.a.d String str, @k.e.a.d Comparator<String> comparator) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@k.e.a.d String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (f0.t(charAt, 31) <= 0 || f0.t(charAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@k.e.a.d String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfLastNonAsciiWhitespace(@k.e.a.d String str, int i2, int i3) {
        int i4 = i3 - 1;
        if (i4 >= i2) {
            while (true) {
                char charAt = str.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfNonWhitespace(@k.e.a.d String str, int i2) {
        int length = str.length();
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != ' ' && charAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    @k.e.a.d
    public static final String[] intersect(@k.e.a.d String[] strArr, @k.e.a.d String[] strArr2, @k.e.a.d Comparator<? super String> comparator) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static final boolean isCivilized(@k.e.a.d FileSystem fileSystem, @k.e.a.d File file) {
        k0 sink = fileSystem.sink(file);
        try {
            try {
                fileSystem.delete(file);
                b.a(sink, null);
                return true;
            } catch (IOException unused) {
                t1 t1Var = t1.a;
                b.a(sink, null);
                fileSystem.delete(file);
                return false;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(sink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(@k.e.a.d Socket socket, @k.e.a.d j.o oVar) {
        boolean z = true;
        try {
            int soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(1);
            boolean z2 = !oVar.b0();
            socket.setSoTimeout(soTimeout);
            z = z2;
            return z;
        } catch (SocketTimeoutException unused) {
            return z;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void notify(@k.e.a.d Object obj) {
        obj.notify();
    }

    public static final void notifyAll(@k.e.a.d Object obj) {
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    @k.e.a.d
    public static final String peerName(@k.e.a.d Socket socket) {
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        return remoteSocketAddress instanceof InetSocketAddress ? ((InetSocketAddress) remoteSocketAddress).getHostName() : remoteSocketAddress.toString();
    }

    @k.e.a.d
    public static final Charset readBomAsCharset(@k.e.a.d j.o oVar, @k.e.a.d Charset charset) throws IOException {
        int y0 = oVar.y0(UNICODE_BOMS);
        if (y0 != -1) {
            if (y0 != 0) {
                if (y0 != 1) {
                    if (y0 != 2) {
                        if (y0 != 3) {
                            if (y0 == 4) {
                                return h.t2.d.f15683j.c();
                            }
                            throw new AssertionError();
                        }
                        return h.t2.d.f15683j.b();
                    }
                    return StandardCharsets.UTF_16LE;
                }
                return StandardCharsets.UTF_16BE;
            }
            return StandardCharsets.UTF_8;
        }
        return charset;
    }

    @e
    public static final <T> T readFieldOrNull(@k.e.a.d Object obj, @k.e.a.d Class<T> cls, @k.e.a.d String str) {
        T t;
        Object readFieldOrNull;
        Class<?> cls2 = obj.getClass();
        while (true) {
            t = null;
            if (!f0.g(cls2, Object.class)) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (!cls.isInstance(obj2)) {
                        break;
                    }
                    t = cls.cast(obj2);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                }
            } else if (!(!f0.g(str, "delegate")) || (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                return null;
            } else {
                return (T) readFieldOrNull(readFieldOrNull, cls, str);
            }
        }
        return t;
    }

    public static final int readMedium(@k.e.a.d j.o oVar) throws IOException {
        return and(oVar.readByte(), 255) | (and(oVar.readByte(), 255) << 16) | (and(oVar.readByte(), 255) << 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0047, code lost:
        if (r5 == Long.MAX_VALUE) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0049, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0051, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0074, code lost:
        if (r5 != Long.MAX_VALUE) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0077, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean skipAll(@k.e.a.d j.m0 r11, int r12, @k.e.a.d java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /*
            long r0 = java.lang.System.nanoTime()
            j.o0 r2 = r11.timeout()
            boolean r2 = r2.hasDeadline()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == 0) goto L1d
            j.o0 r2 = r11.timeout()
            long r5 = r2.deadlineNanoTime()
            long r5 = r5 - r0
            goto L1e
        L1d:
            r5 = r3
        L1e:
            j.o0 r2 = r11.timeout()
            long r7 = (long) r12
            long r12 = r13.toNanos(r7)
            long r12 = java.lang.Math.min(r5, r12)
            long r12 = r12 + r0
            r2.deadlineNanoTime(r12)
            j.m r12 = new j.m     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
            r12.<init>()     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
        L34:
            r7 = 8192(0x2000, double:4.0474E-320)
            long r7 = r11.read(r12, r7)     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
            r9 = -1
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 == 0) goto L44
            r12.l()     // Catch: java.lang.Throwable -> L5a java.io.InterruptedIOException -> L70
            goto L34
        L44:
            r12 = 1
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L51
        L49:
            j.o0 r11 = r11.timeout()
            r11.clearDeadline()
            goto L77
        L51:
            j.o0 r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
            goto L77
        L5a:
            r12 = move-exception
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L67
            j.o0 r11 = r11.timeout()
            r11.clearDeadline()
            goto L6f
        L67:
            j.o0 r11 = r11.timeout()
            long r0 = r0 + r5
            r11.deadlineNanoTime(r0)
        L6f:
            throw r12
        L70:
            r12 = 0
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 != 0) goto L51
            goto L49
        L77:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.skipAll(j.m0, int, java.util.concurrent.TimeUnit):boolean");
    }

    @k.e.a.d
    public static final ThreadFactory threadFactory(@k.e.a.d final String str, final boolean z) {
        return new ThreadFactory() { // from class: okhttp3.internal.Util$threadFactory$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static final void threadName(@k.e.a.d String str, @k.e.a.d a<t1> aVar) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            h.k2.v.c0.d(1);
            currentThread.setName(name);
            h.k2.v.c0.c(1);
        }
    }

    @k.e.a.d
    public static final List<Header> toHeaderList(@k.e.a.d Headers headers) {
        k n1 = q.n1(0, headers.size());
        ArrayList arrayList = new ArrayList(u.Y(n1, 10));
        Iterator<Integer> it = n1.iterator();
        while (it.hasNext()) {
            int nextInt = ((l0) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    @k.e.a.d
    public static final Headers toHeaders(@k.e.a.d List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    @k.e.a.d
    public static final String toHexString(long j2) {
        return Long.toHexString(j2);
    }

    @k.e.a.d
    public static final String toHostHeader(@k.e.a.d HttpUrl httpUrl, boolean z) {
        String host;
        if (StringsKt__StringsKt.V2(httpUrl.host(), Constants.COLON_SEPARATOR, false, 2, null)) {
            host = '[' + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (z || httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host + ':' + httpUrl.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    @k.e.a.d
    public static final <T> List<T> toImmutableList(@k.e.a.d List<? extends T> list) {
        return Collections.unmodifiableList(CollectionsKt___CollectionsKt.L5(list));
    }

    @k.e.a.d
    public static final <K, V> Map<K, V> toImmutableMap(@k.e.a.d Map<K, ? extends V> map) {
        if (map.isEmpty()) {
            return h.a2.t0.z();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static final long toLongOrDefault(@k.e.a.d String str, long j2) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static final int toNonNegativeInt(@e String str, int i2) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    @k.e.a.d
    public static final String trimSubstring(@k.e.a.d String str, int i2, int i3) {
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i2, i3);
        return str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i3));
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return trimSubstring(str, i2, i3);
    }

    public static final void wait(@k.e.a.d Object obj) {
        obj.wait();
    }

    @k.e.a.d
    public static final Throwable withSuppressed(@k.e.a.d Exception exc, @k.e.a.d List<? extends Exception> list) {
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception exc2 : list) {
            m.a(exc, exc2);
        }
        return exc;
    }

    public static final void writeMedium(@k.e.a.d n nVar, int i2) throws IOException {
        nVar.writeByte((i2 >>> 16) & 255);
        nVar.writeByte((i2 >>> 8) & 255);
        nVar.writeByte(i2 & 255);
    }

    public static final int delimiterOffset(@k.e.a.d String str, char c2, int i2, int i3) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, c2, i2, i3);
    }

    @k.e.a.d
    public static final String toHexString(int i2) {
        return Integer.toHexString(i2);
    }

    public static final void closeQuietly(@k.e.a.d Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!f0.g(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@k.e.a.d ServerSocket serverSocket) {
        try {
            serverSocket.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(@k.e.a.d j.m mVar, byte b) {
        int i2 = 0;
        while (!mVar.b0() && mVar.m0(0L) == b) {
            i2++;
            mVar.readByte();
        }
        return i2;
    }
}
