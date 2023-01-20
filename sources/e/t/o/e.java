package e.t.o;

import com.vector.fitter.Mode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/fitter/FitStrategy;", "", "value", "Lcom/vector/fitter/Mode;", "()Lcom/vector/fitter/Mode;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@h.z1.c(AnnotationRetention.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@h.z1.d(allowedTargets = {AnnotationTarget.CLASS})
/* loaded from: classes3.dex */
public @interface e {
    Mode value();
}
