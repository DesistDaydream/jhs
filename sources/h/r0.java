package h;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a.\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\t\u001a\u0087\u0001\u0010\n\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\r2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u0012\u001a3\u0010\u0013\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052\u0006\u0010\u0014\u001a\u0002H\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a^\u0010\u0016\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0018\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a`\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aS\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0017\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001e0\rH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aZ\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u001e0\rH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001ad\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\r¢\u0006\u0002\b!H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0017\u001a\u0018\u0010\"\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0005H\u0001ø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", ExifInterface.GPS_DIRECTION_TRUE, "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class r0 {
    @p0
    @s0(version = "1.3")
    @k.e.a.d
    public static final Object a(@k.e.a.d Throwable th) {
        return new Result.Failure(th);
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T> R b(Object obj, h.k2.u.l<? super T, ? extends R> lVar, h.k2.u.l<? super Throwable, ? extends R> lVar2) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl == null) {
            return lVar.invoke(obj);
        }
        return lVar2.invoke(m109exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T extends R> R c(Object obj, R r) {
        return Result.m112isFailureimpl(obj) ? r : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T extends R> R d(Object obj, h.k2.u.l<? super Throwable, ? extends R> lVar) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        return m109exceptionOrNullimpl == null ? obj : lVar.invoke(m109exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @s0(version = "1.3")
    private static final <T> T e(Object obj) {
        n(obj);
        return obj;
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T> Object f(Object obj, h.k2.u.l<? super T, ? extends R> lVar) {
        if (Result.m113isSuccessimpl(obj)) {
            Result.a aVar = Result.Companion;
            return Result.m106constructorimpl(lVar.invoke(obj));
        }
        return Result.m106constructorimpl(obj);
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T> Object g(Object obj, h.k2.u.l<? super T, ? extends R> lVar) {
        if (Result.m113isSuccessimpl(obj)) {
            try {
                Result.a aVar = Result.Companion;
                return Result.m106constructorimpl(lVar.invoke(obj));
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                return Result.m106constructorimpl(a(th));
            }
        }
        return Result.m106constructorimpl(obj);
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> Object h(Object obj, h.k2.u.l<? super Throwable, t1> lVar) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl != null) {
            lVar.invoke(m109exceptionOrNullimpl);
        }
        return obj;
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T> Object i(Object obj, h.k2.u.l<? super T, t1> lVar) {
        if (Result.m113isSuccessimpl(obj)) {
            lVar.invoke(obj);
        }
        return obj;
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T extends R> Object j(Object obj, h.k2.u.l<? super Throwable, ? extends R> lVar) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl == null) {
            return obj;
        }
        Result.a aVar = Result.Companion;
        return Result.m106constructorimpl(lVar.invoke(m109exceptionOrNullimpl));
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R, T extends R> Object k(Object obj, h.k2.u.l<? super Throwable, ? extends R> lVar) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.a aVar = Result.Companion;
            return Result.m106constructorimpl(lVar.invoke(m109exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m106constructorimpl(a(th));
        }
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <T, R> Object l(T t, h.k2.u.l<? super T, ? extends R> lVar) {
        try {
            Result.a aVar = Result.Companion;
            return Result.m106constructorimpl(lVar.invoke(t));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            return Result.m106constructorimpl(a(th));
        }
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final <R> Object m(h.k2.u.a<? extends R> aVar) {
        try {
            Result.a aVar2 = Result.Companion;
            return Result.m106constructorimpl(aVar.invoke());
        } catch (Throwable th) {
            Result.a aVar3 = Result.Companion;
            return Result.m106constructorimpl(a(th));
        }
    }

    @p0
    @s0(version = "1.3")
    public static final void n(@k.e.a.d Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
