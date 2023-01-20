package h.u2;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.u.s;
import h.k2.v.u;
import h.p0;
import h.q0;
import h.s0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087@\u0018\u0000 ¥\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¥\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\\2\b\u0010Q\u001a\u0004\u0018\u00010]HÖ\u0003¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\tHÖ\u0001¢\u0006\u0004\ba\u0010\rJ\r\u0010b\u001a\u00020\\¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002¢\u0006\u0004\bh\u0010dJ\r\u0010i\u001a\u00020\\¢\u0006\u0004\bj\u0010dJ\r\u0010k\u001a\u00020\\¢\u0006\u0004\bl\u0010dJ\r\u0010m\u001a\u00020\\¢\u0006\u0004\bn\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010qJ\u0017\u0010t\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u000fH\u0002¢\u0006\u0004\bu\u0010vJ\u001e\u0010w\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010WJ\u001e\u0010w\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010XJ£\u0001\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z2y\u0010{\u001au\u0012\u0013\u0012\u00110\t¢\u0006\f\b}\u0012\b\b~\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0080\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0082\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001\u0012\u0004\u0012\u0002Hz0|H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u008f\u0001\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z2e\u0010{\u001aa\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0080\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0082\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001\u0012\u0004\u0012\u0002Hz0\u0086\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0087\u0001Jy\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z2O\u0010{\u001aK\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0082\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001\u0012\u0004\u0012\u0002Hz0\u0088\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0089\u0001Jc\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z29\u0010{\u001a5\u0012\u0014\u0012\u00120\u0003¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0082\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0083\u0001\u0012\u0004\u0012\u0002Hz0\u008a\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0084\u0001\u0010\u008b\u0001J\u001e\u0010\u008c\u0001\u001a\u00020\u000f2\f\u0010\u008d\u0001\u001a\u00070Dj\u0003`\u008e\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001e\u0010\u0091\u0001\u001a\u00020\t2\f\u0010\u008d\u0001\u001a\u00070Dj\u0003`\u008e\u0001¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00030\u0095\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001e\u0010\u0098\u0001\u001a\u00020\u00032\f\u0010\u008d\u0001\u001a\u00070Dj\u0003`\u008e\u0001¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u009c\u0001\u0010\u0005J\u0011\u0010\u009d\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u009e\u0001\u0010\u0005J\u0013\u0010\u009f\u0001\u001a\u00030\u0095\u0001H\u0016¢\u0006\u0006\b \u0001\u0010\u0097\u0001J*\u0010\u009f\u0001\u001a\u00030\u0095\u00012\f\u0010\u008d\u0001\u001a\u00070Dj\u0003`\u008e\u00012\t\b\u0002\u0010¡\u0001\u001a\u00020\t¢\u0006\u0006\b \u0001\u0010¢\u0001J\u0018\u0010£\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¤\u0001\u0010\u0005R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0015\u0010G\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006¦\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "precision", "precision-impl", "(JD)I", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.k2.e
@s0(version = "1.3")
@j
/* loaded from: classes4.dex */
public final class d implements Comparable<d> {
    private final long a;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final a f15705e = new a(null);
    private static final long b = i(0);

    /* renamed from: c  reason: collision with root package name */
    private static final long f15703c = e.b(e.f15706c);

    /* renamed from: d  reason: collision with root package name */
    private static final long f15704d = e.b(-4611686018427387903L);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0015J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006&"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public final double a(double d2, @k.e.a.d TimeUnit timeUnit, @k.e.a.d TimeUnit timeUnit2) {
            return h.b(d2, timeUnit, timeUnit2);
        }

        @s0(version = "1.5")
        public final long b(double d2) {
            return e.g0(d2, TimeUnit.DAYS);
        }

        @s0(version = "1.5")
        public final long c(int i2) {
            return e.h0(i2, TimeUnit.DAYS);
        }

        @s0(version = "1.5")
        public final long d(long j2) {
            return e.i0(j2, TimeUnit.DAYS);
        }

        public final long e() {
            return d.f15703c;
        }

        public final long f() {
            return d.f15704d;
        }

        public final long g() {
            return d.b;
        }

        @s0(version = "1.5")
        public final long h(double d2) {
            return e.g0(d2, TimeUnit.HOURS);
        }

        @s0(version = "1.5")
        public final long i(int i2) {
            return e.h0(i2, TimeUnit.HOURS);
        }

        @s0(version = "1.5")
        public final long j(long j2) {
            return e.i0(j2, TimeUnit.HOURS);
        }

        @s0(version = "1.5")
        public final long k(double d2) {
            return e.g0(d2, TimeUnit.MICROSECONDS);
        }

        @s0(version = "1.5")
        public final long l(int i2) {
            return e.h0(i2, TimeUnit.MICROSECONDS);
        }

        @s0(version = "1.5")
        public final long m(long j2) {
            return e.i0(j2, TimeUnit.MICROSECONDS);
        }

        @s0(version = "1.5")
        public final long n(double d2) {
            return e.g0(d2, TimeUnit.MILLISECONDS);
        }

        @s0(version = "1.5")
        public final long o(int i2) {
            return e.h0(i2, TimeUnit.MILLISECONDS);
        }

        @s0(version = "1.5")
        public final long p(long j2) {
            return e.i0(j2, TimeUnit.MILLISECONDS);
        }

        @s0(version = "1.5")
        public final long q(double d2) {
            return e.g0(d2, TimeUnit.MINUTES);
        }

        @s0(version = "1.5")
        public final long r(int i2) {
            return e.h0(i2, TimeUnit.MINUTES);
        }

        @s0(version = "1.5")
        public final long s(long j2) {
            return e.i0(j2, TimeUnit.MINUTES);
        }

        @s0(version = "1.5")
        public final long t(double d2) {
            return e.g0(d2, TimeUnit.NANOSECONDS);
        }

        @s0(version = "1.5")
        public final long u(int i2) {
            return e.h0(i2, TimeUnit.NANOSECONDS);
        }

        @s0(version = "1.5")
        public final long v(long j2) {
            return e.i0(j2, TimeUnit.NANOSECONDS);
        }

        @s0(version = "1.5")
        public final long w(double d2) {
            return e.g0(d2, TimeUnit.SECONDS);
        }

        @s0(version = "1.5")
        public final long x(int i2) {
            return e.h0(i2, TimeUnit.SECONDS);
        }

        @s0(version = "1.5")
        public final long y(long j2) {
            return e.i0(j2, TimeUnit.SECONDS);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    private /* synthetic */ d(long j2) {
        this.a = j2;
    }

    public static final double A(long j2) {
        return x0(j2, TimeUnit.MINUTES);
    }

    public static final long A0(long j2, @k.e.a.d TimeUnit timeUnit) {
        if (j2 == f15703c) {
            return Long.MAX_VALUE;
        }
        if (j2 == f15704d) {
            return Long.MIN_VALUE;
        }
        return h.c(g0(j2), e0(j2), timeUnit);
    }

    @h.i(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    public static /* synthetic */ void B() {
    }

    @h.i(message = "Use inWholeMilliseconds property instead.", replaceWith = @q0(expression = "this.inWholeMilliseconds", imports = {}))
    public static final long B0(long j2) {
        return R(j2);
    }

    public static final double C(long j2) {
        return x0(j2, TimeUnit.NANOSECONDS);
    }

    @h.i(message = "Use inWholeNanoseconds property instead.", replaceWith = @q0(expression = "this.inWholeNanoseconds", imports = {}))
    public static final long C0(long j2) {
        return V(j2);
    }

    @h.i(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    public static /* synthetic */ void D() {
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5  */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String D0(long r8) {
        /*
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            java.lang.String r8 = "0s"
            goto Lc6
        La:
            long r0 = h.u2.d.f15703c
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L14
            java.lang.String r8 = "Infinity"
            goto Lc6
        L14:
            long r0 = h.u2.d.f15704d
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L1e
            java.lang.String r8 = "-Infinity"
            goto Lc6
        L1e:
            long r0 = o(r8)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            double r0 = x0(r0, r2)
            r3 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            r5 = 0
            r6 = 1
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 >= 0) goto L38
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
        L35:
            r0 = 0
            r5 = 1
            goto L95
        L38:
            double r3 = (double) r6
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 >= 0) goto L3f
            r0 = 7
            goto L95
        L3f:
            r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 >= 0) goto L4a
        L48:
            r0 = 0
            goto L95
        L4a:
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L56
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MICROSECONDS
            goto L48
        L56:
            r2 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L62
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            goto L48
        L62:
            r2 = 4786511204640096256(0x426d1a94a2000000, double:1.0E12)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L6e
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
            goto L48
        L6e:
            r2 = 4813020802404319232(0x42cb48eb57e00000, double:6.0E13)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L7a
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES
            goto L48
        L7a:
            r2 = 4839562400168542208(0x4329945ca2620000, double:3.6E15)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L86
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.HOURS
            goto L48
        L86:
            r2 = 4920018990336211136(0x44476b344f2a78c0, double:8.64E20)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L92
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.DAYS
            goto L48
        L92:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.DAYS
            goto L35
        L95:
            double r3 = x0(r8, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            if (r5 == 0) goto La5
            java.lang.String r8 = h.u2.k.b(r3)
            goto Lb8
        La5:
            if (r0 <= 0) goto Lac
            java.lang.String r8 = h.u2.k.d(r3, r0)
            goto Lb8
        Lac:
            double r5 = java.lang.Math.abs(r3)
            int r8 = q0(r8, r5)
            java.lang.String r8 = h.u2.k.c(r3, r8)
        Lb8:
            r1.append(r8)
            java.lang.String r8 = h.u2.i.e(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
        Lc6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h.u2.d.D0(long):java.lang.String");
    }

    public static final double E(long j2) {
        return x0(j2, TimeUnit.SECONDS);
    }

    @k.e.a.d
    public static final String E0(long j2, @k.e.a.d TimeUnit timeUnit, int i2) {
        if (i2 >= 0) {
            double x0 = x0(j2, timeUnit);
            if (Double.isInfinite(x0)) {
                return String.valueOf(x0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Math.abs(x0) < 1.0E14d ? k.c(x0, h.o2.q.u(i2, 12)) : k.b(x0));
            sb.append(i.e(timeUnit));
            return sb.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i2).toString());
    }

    @s0(version = "1.5")
    public static /* synthetic */ void F() {
    }

    public static /* synthetic */ String F0(long j2, TimeUnit timeUnit, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return E0(j2, timeUnit, i2);
    }

    public static final long G(long j2) {
        return A0(j2, TimeUnit.DAYS);
    }

    public static final long G0(long j2) {
        return e.a(-g0(j2), ((int) j2) & 1);
    }

    @s0(version = "1.5")
    public static /* synthetic */ void M() {
    }

    public static final long N(long j2) {
        return A0(j2, TimeUnit.HOURS);
    }

    @s0(version = "1.5")
    public static /* synthetic */ void O() {
    }

    public static final long P(long j2) {
        return A0(j2, TimeUnit.MICROSECONDS);
    }

    @s0(version = "1.5")
    public static /* synthetic */ void Q() {
    }

    public static final long R(long j2) {
        return (j0(j2) && i0(j2)) ? g0(j2) : A0(j2, TimeUnit.MILLISECONDS);
    }

    @s0(version = "1.5")
    public static /* synthetic */ void S() {
    }

    public static final long T(long j2) {
        return A0(j2, TimeUnit.MINUTES);
    }

    @s0(version = "1.5")
    public static /* synthetic */ void U() {
    }

    public static final long V(long j2) {
        long g0 = g0(j2);
        if (k0(j2)) {
            return g0;
        }
        if (g0 > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (g0 < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return e.f(g0);
    }

    @s0(version = "1.5")
    public static /* synthetic */ void W() {
    }

    public static final long X(long j2) {
        return A0(j2, TimeUnit.SECONDS);
    }

    @p0
    public static /* synthetic */ void Y() {
    }

    public static final int Z(long j2) {
        if (l0(j2)) {
            return 0;
        }
        return (int) (T(j2) % 60);
    }

    @p0
    public static /* synthetic */ void a0() {
    }

    public static final int b0(long j2) {
        if (l0(j2)) {
            return 0;
        }
        return (int) (j0(j2) ? e.f(g0(j2) % 1000) : g0(j2) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
    }

    @p0
    public static /* synthetic */ void c0() {
    }

    public static final int d0(long j2) {
        if (l0(j2)) {
            return 0;
        }
        return (int) (X(j2) % 60);
    }

    private static final long e(long j2, long j3, long j4) {
        long g2 = e.g(j4);
        long j5 = j3 + g2;
        if (-4611686018426L <= j5 && 4611686018426L >= j5) {
            return e.d(e.f(j5) + (j4 - e.f(g2)));
        }
        return e.b(h.o2.q.D(j5, -4611686018427387903L, e.f15706c));
    }

    private static final TimeUnit e0(long j2) {
        return k0(j2) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    public static final /* synthetic */ d f(long j2) {
        return new d(j2);
    }

    private static final int f0(long j2) {
        return ((int) j2) & 1;
    }

    private static final long g0(long j2) {
        return j2 >> 1;
    }

    public static int h(long j2, long j3) {
        long j4 = j2 ^ j3;
        if (j4 < 0 || (((int) j4) & 1) == 0) {
            return (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        }
        int i2 = (((int) j2) & 1) - (((int) j3) & 1);
        return m0(j2) ? -i2 : i2;
    }

    public static int h0(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static long i(long j2) {
        if (k0(j2)) {
            long g0 = g0(j2);
            if (-4611686018426999999L > g0 || e.b < g0) {
                throw new AssertionError(g0(j2) + " ns is out of nanoseconds range");
            }
        } else {
            long g02 = g0(j2);
            if (-4611686018427387903L <= g02 && e.f15706c >= g02) {
                long g03 = g0(j2);
                if (-4611686018426L <= g03 && 4611686018426L >= g03) {
                    throw new AssertionError(g0(j2) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(g0(j2) + " ms is out of milliseconds range");
            }
        }
        return j2;
    }

    public static final boolean i0(long j2) {
        return !l0(j2);
    }

    public static final double j(long j2, long j3) {
        TimeUnit timeUnit = (TimeUnit) h.b2.c.O(e0(j2), e0(j3));
        return x0(j2, timeUnit) / x0(j3, timeUnit);
    }

    private static final boolean j0(long j2) {
        return (((int) j2) & 1) == 1;
    }

    public static final long k(long j2, double d2) {
        int G0 = h.l2.d.G0(d2);
        if (G0 == d2 && G0 != 0) {
            return l(j2, G0);
        }
        TimeUnit e0 = e0(j2);
        return e.g0(x0(j2, e0) / d2, e0);
    }

    private static final boolean k0(long j2) {
        return (((int) j2) & 1) == 0;
    }

    public static final long l(long j2, int i2) {
        if (i2 == 0) {
            if (n0(j2)) {
                return f15703c;
            }
            if (m0(j2)) {
                return f15704d;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (k0(j2)) {
            return e.d(g0(j2) / i2);
        } else {
            if (l0(j2)) {
                return s0(j2, h.l2.d.Q(i2));
            }
            long j3 = i2;
            long g0 = g0(j2) / j3;
            if (-4611686018426L <= g0 && 4611686018426L >= g0) {
                return e.d(e.f(g0) + (e.f(g0(j2) - (g0 * j3)) / j3));
            }
            return e.b(g0);
        }
    }

    public static final boolean l0(long j2) {
        return j2 == f15703c || j2 == f15704d;
    }

    public static boolean m(long j2, Object obj) {
        return (obj instanceof d) && j2 == ((d) obj).H0();
    }

    public static final boolean m0(long j2) {
        return j2 < 0;
    }

    public static final boolean n(long j2, long j3) {
        return j2 == j3;
    }

    public static final boolean n0(long j2) {
        return j2 > 0;
    }

    public static final long o(long j2) {
        return m0(j2) ? G0(j2) : j2;
    }

    public static final long o0(long j2, long j3) {
        return p0(j2, G0(j3));
    }

    @p0
    public static /* synthetic */ void p() {
    }

    public static final long p0(long j2, long j3) {
        if (l0(j2)) {
            if (i0(j3) || (j3 ^ j2) >= 0) {
                return j2;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (l0(j3)) {
            return j3;
        } else {
            if ((((int) j2) & 1) == (((int) j3) & 1)) {
                long g0 = g0(j2) + g0(j3);
                if (k0(j2)) {
                    return e.e(g0);
                }
                return e.c(g0);
            } else if (j0(j2)) {
                return e(j2, g0(j2), g0(j3));
            } else {
                return e(j2, g0(j3), g0(j2));
            }
        }
    }

    public static final int q(long j2) {
        if (l0(j2)) {
            return 0;
        }
        return (int) (N(j2) % 24);
    }

    private static final int q0(long j2, double d2) {
        if (d2 < 1) {
            return 3;
        }
        if (d2 < 10) {
            return 2;
        }
        return d2 < ((double) 100) ? 1 : 0;
    }

    @h.i(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    public static /* synthetic */ void r() {
    }

    public static final long r0(long j2, double d2) {
        int G0 = h.l2.d.G0(d2);
        if (G0 == d2) {
            return s0(j2, G0);
        }
        TimeUnit e0 = e0(j2);
        return e.g0(x0(j2, e0) * d2, e0);
    }

    public static final double s(long j2) {
        return x0(j2, TimeUnit.DAYS);
    }

    public static final long s0(long j2, int i2) {
        if (l0(j2)) {
            if (i2 != 0) {
                return i2 > 0 ? j2 : G0(j2);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i2 == 0) {
            return b;
        } else {
            long g0 = g0(j2);
            long j3 = i2;
            long j4 = g0 * j3;
            if (!k0(j2)) {
                if (j4 / j3 == g0) {
                    return e.b(h.o2.q.E(j4, new h.o2.n(-4611686018427387903L, e.f15706c)));
                }
                return h.l2.d.R(g0) * h.l2.d.Q(i2) > 0 ? f15703c : f15704d;
            } else if (-2147483647L <= g0 && 2147483647L >= g0) {
                return e.d(j4);
            } else {
                if (j4 / j3 == g0) {
                    return e.e(j4);
                }
                long g2 = e.g(g0);
                long j5 = g2 * j3;
                long g3 = e.g((g0 - e.f(g2)) * j3) + j5;
                if (j5 / j3 != g2 || (g3 ^ j5) < 0) {
                    return h.l2.d.R(g0) * h.l2.d.Q(i2) > 0 ? f15703c : f15704d;
                }
                return e.b(h.o2.q.E(g3, new h.o2.n(-4611686018427387903L, e.f15706c)));
            }
        }
    }

    @h.i(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    public static /* synthetic */ void t() {
    }

    public static final <T> T t0(long j2, @k.e.a.d h.k2.u.p<? super Long, ? super Integer, ? extends T> pVar) {
        return pVar.invoke(Long.valueOf(X(j2)), Integer.valueOf(b0(j2)));
    }

    public static final double u(long j2) {
        return x0(j2, TimeUnit.HOURS);
    }

    public static final <T> T u0(long j2, @k.e.a.d h.k2.u.q<? super Integer, ? super Integer, ? super Integer, ? extends T> qVar) {
        return qVar.invoke(Integer.valueOf(y0(j2, TimeUnit.MINUTES)), Integer.valueOf(d0(j2)), Integer.valueOf(b0(j2)));
    }

    @h.i(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    public static /* synthetic */ void v() {
    }

    public static final <T> T v0(long j2, @k.e.a.d h.k2.u.r<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> rVar) {
        return rVar.invoke(Integer.valueOf(y0(j2, TimeUnit.HOURS)), Integer.valueOf(Z(j2)), Integer.valueOf(d0(j2)), Integer.valueOf(b0(j2)));
    }

    public static final double w(long j2) {
        return x0(j2, TimeUnit.MICROSECONDS);
    }

    public static final <T> T w0(long j2, @k.e.a.d s<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> sVar) {
        return sVar.invoke(Integer.valueOf(y0(j2, TimeUnit.DAYS)), Integer.valueOf(q(j2)), Integer.valueOf(Z(j2)), Integer.valueOf(d0(j2)), Integer.valueOf(b0(j2)));
    }

    @h.i(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    public static /* synthetic */ void x() {
    }

    public static final double x0(long j2, @k.e.a.d TimeUnit timeUnit) {
        if (j2 == f15703c) {
            return Double.POSITIVE_INFINITY;
        }
        if (j2 == f15704d) {
            return Double.NEGATIVE_INFINITY;
        }
        return h.b(g0(j2), e0(j2), timeUnit);
    }

    public static final double y(long j2) {
        return x0(j2, TimeUnit.MILLISECONDS);
    }

    public static final int y0(long j2, @k.e.a.d TimeUnit timeUnit) {
        return (int) h.o2.q.D(A0(j2, timeUnit), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @h.i(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @q0(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    public static /* synthetic */ void z() {
    }

    @k.e.a.d
    public static final String z0(long j2) {
        StringBuilder sb = new StringBuilder();
        if (m0(j2)) {
            sb.append(k.b.a.a.n.l.f16189d);
        }
        sb.append("PT");
        long o = o(j2);
        int y0 = y0(o, TimeUnit.HOURS);
        int Z = Z(o);
        int d0 = d0(o);
        int b0 = b0(o);
        boolean z = true;
        boolean z2 = y0 != 0;
        boolean z3 = (d0 == 0 && b0 == 0) ? false : true;
        if (Z == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(y0);
            sb.append('H');
        }
        if (z) {
            sb.append(Z);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(d0);
            if (b0 != 0) {
                sb.append('.');
                String T3 = StringsKt__StringsKt.T3(String.valueOf(b0), 9, '0');
                if (b0 % e.a == 0) {
                    sb.append((CharSequence) T3, 0, 3);
                } else if (b0 % 1000 == 0) {
                    sb.append((CharSequence) T3, 0, 6);
                } else {
                    sb.append(T3);
                }
            }
            sb.append('S');
        }
        return sb.toString();
    }

    public final /* synthetic */ long H0() {
        return this.a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d dVar) {
        return g(dVar.H0());
    }

    public boolean equals(Object obj) {
        return m(this.a, obj);
    }

    public int g(long j2) {
        return h(this.a, j2);
    }

    public int hashCode() {
        return h0(this.a);
    }

    @k.e.a.d
    public String toString() {
        return D0(this.a);
    }
}
