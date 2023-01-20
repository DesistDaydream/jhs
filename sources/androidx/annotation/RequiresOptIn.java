package androidx.annotation;

import com.baidu.mobads.sdk.internal.bp;
import h.z1.c;
import h.z1.d;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.ANNOTATION_TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/annotation/RequiresOptIn;", "", "Landroidx/annotation/RequiresOptIn$Level;", "level", "()Landroidx/annotation/RequiresOptIn$Level;", "<init>", "(Landroidx/annotation/RequiresOptIn$Level;)V", "Level", "annotation-experimental_release"}, k = 1, mv = {1, 4, 2})
@c(AnnotationRetention.BINARY)
@Retention(RetentionPolicy.CLASS)
@d(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
/* loaded from: classes.dex */
public @interface RequiresOptIn {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/annotation/RequiresOptIn$Level;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", bp.f1533l, "annotation-experimental_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes.dex */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
