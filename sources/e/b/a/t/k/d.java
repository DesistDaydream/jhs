package e.b.a.t.k;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // e.b.a.t.k.q
    /* renamed from: q */
    public Drawable p(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.b).getResources(), bitmap);
    }

    @Deprecated
    public d(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
