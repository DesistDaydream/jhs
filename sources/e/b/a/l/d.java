package e.b.a.l;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface d {

    /* renamed from: c  reason: collision with root package name */
    public static final int f9364c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9365d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9366e = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
