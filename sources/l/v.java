package l;

import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import java.lang.annotation.Annotation;

/* loaded from: classes4.dex */
public final class v implements u {
    private static final u m0 = new v();

    public static Annotation[] a(Annotation[] annotationArr) {
        if (w.l(annotationArr, u.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = m0;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return u.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return TIMMentionEditText.TIM_MENTION_TAG + u.class.getName() + "()";
    }
}
