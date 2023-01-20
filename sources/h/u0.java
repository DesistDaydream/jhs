package h;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.api.reward.RewardItem;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import kotlin.Metadata;
import kotlin.NotImplementedError;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u001a3\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a2\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u000f\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\u0011\u001a\u0002H\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\t¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0013\u001a<\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aA\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aB\u0010\u0016\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000b*\u0002H\u00102\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aG\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000b*\u0002H\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\t¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a>\u0010\u0017\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00190\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a>\u0010\u001a\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00190\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"TODO", "", RewardItem.KEY_REASON, "", "repeat", "", "times", "", "action", "Lkotlin/Function1;", "run", "R", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "with", ExifInterface.GPS_DIRECTION_TRUE, "receiver", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "also", TUIChatConstants.Group.MEMBER_APPLY, "let", "takeIf", "predicate", "", "takeUnless", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/StandardKt")
/* loaded from: classes3.dex */
public class u0 {
    @h.g2.f
    private static final Void a() {
        throw new NotImplementedError(null, 1, null);
    }

    @h.g2.f
    private static final Void b(String str) {
        throw new NotImplementedError("An operation is not implemented: " + str);
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final <T> T c(T t, h.k2.u.l<? super T, t1> lVar) {
        lVar.invoke(t);
        return t;
    }

    @h.g2.f
    private static final <T> T d(T t, h.k2.u.l<? super T, t1> lVar) {
        lVar.invoke(t);
        return t;
    }

    @h.g2.f
    private static final <T, R> R e(T t, h.k2.u.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @h.g2.f
    private static final void f(int i2, h.k2.u.l<? super Integer, t1> lVar) {
        for (int i3 = 0; i3 < i2; i3++) {
            lVar.invoke(Integer.valueOf(i3));
        }
    }

    @h.g2.f
    private static final <T, R> R g(T t, h.k2.u.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @h.g2.f
    private static final <R> R h(h.k2.u.a<? extends R> aVar) {
        return aVar.invoke();
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final <T> T i(T t, h.k2.u.l<? super T, Boolean> lVar) {
        if (lVar.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final <T> T j(T t, h.k2.u.l<? super T, Boolean> lVar) {
        if (lVar.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @h.g2.f
    private static final <T, R> R k(T t, h.k2.u.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }
}
