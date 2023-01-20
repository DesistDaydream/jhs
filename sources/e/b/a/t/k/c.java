package e.b.a.t.k;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class c extends j<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    @Override // e.b.a.t.k.j
    /* renamed from: p */
    public void n(Bitmap bitmap) {
        ((ImageView) this.b).setImageBitmap(bitmap);
    }

    @Deprecated
    public c(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
