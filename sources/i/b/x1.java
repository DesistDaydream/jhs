package i.b;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Li/b/x1;", "", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "This is an internal kotlinx.coroutines API that should not be used from outside of kotlinx.coroutines. No compatibility guarantees are provided.It is recommended to report your use-case of internal API to kotlinx.coroutines issue tracker, so stable API could be provided instead")
@h.z1.c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@h.z1.d(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPEALIAS, AnnotationTarget.PROPERTY})
/* loaded from: classes4.dex */
public @interface x1 {
}
