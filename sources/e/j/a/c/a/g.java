package e.j.a.c.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];
    private final float[] b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f10554c = new Matrix();

    @Override // android.animation.TypeEvaluator
    @NonNull
    /* renamed from: a */
    public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.b;
            float f3 = fArr[i2];
            float[] fArr2 = this.a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f10554c.setValues(this.b);
        return this.f10554c;
    }
}
