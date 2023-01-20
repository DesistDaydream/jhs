package k.d.a.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface a {
    @k.e.a.c
    public static final String h0 = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
    @k.e.a.c
    public static final String i0 = "this";
    @k.e.a.c
    public static final String j0 = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
    @k.e.a.c
    public static final String k0 = "The return value of this method";
    @k.e.a.c
    public static final String l0 = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
