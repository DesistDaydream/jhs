package e.l.n;

import com.jihuanshe.net.config.NetService;
import h.z1.c;
import h.z1.d;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@c(AnnotationRetention.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@d(allowedTargets = {AnnotationTarget.CLASS})
/* loaded from: classes2.dex */
public @interface b {
    NetService service();
}
