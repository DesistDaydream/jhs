package f.a.b;

import com.huawei.hms.push.constant.RemoteMessageConst;
import h.z1.c;
import h.z1.d;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Linject/annotation/route/Route;", "", "path", "", RemoteMessageConst.Notification.PRIORITY, "", "()Ljava/lang/String;", "()I", "annotation"}, k = 1, mv = {1, 5, 1}, xi = 48)
@c(AnnotationRetention.SOURCE)
@Retention(RetentionPolicy.SOURCE)
@d(allowedTargets = {AnnotationTarget.CLASS})
/* loaded from: classes3.dex */
public @interface a {
    String path();

    int priority() default 0;
}
