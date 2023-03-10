package kotlin;

import com.tencent.android.tpush.common.Constants;
import h.k2.g;
import h.s0;
import h.z1.c;
import h.z1.d;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003R\u0012\u0010\u0006\u001a\u00020\u0005X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\r\u001a\u00020\u0003X\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0012\u0010\f\u001a\u00020\tX\u0087\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", Constants.FLAG_PACKAGE_NAME, "extraInt", "bv", "()[I", "d1", "()[Ljava/lang/String;", "d2", "xi", "()I", "xs", "()Ljava/lang/String;", "k", "mv", "pn", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
@c(AnnotationRetention.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@d(allowedTargets = {AnnotationTarget.CLASS})
/* loaded from: classes3.dex */
public @interface Metadata {
    @g(name = "bv")
    int[] bv() default {1, 0, 3};

    @g(name = "d1")
    String[] d1() default {};

    @g(name = "d2")
    String[] d2() default {};

    @g(name = "k")
    int k() default 1;

    @g(name = "mv")
    int[] mv() default {};

    @g(name = "pn")
    String pn() default "";

    @g(name = "xi")
    int xi() default 0;

    @g(name = "xs")
    String xs() default "";
}
