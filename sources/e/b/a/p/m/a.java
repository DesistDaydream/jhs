package e.b.a.p.m;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import e.b.a.p.e;
import e.b.a.p.f;
import e.b.a.p.g;
import e.b.a.p.k.s;
import e.b.a.p.m.d.o;
import e.b.a.p.m.d.u;
import java.io.IOException;

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class a<T> implements g<ImageDecoder.Source, T> {
    private static final String b = "ImageDecoder";
    public final u a = u.d();

    /* renamed from: e.b.a.p.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0319a implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f9730c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DecodeFormat f9731d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownsampleStrategy f9732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PreferredColorSpace f9733f;

        /* renamed from: e.b.a.p.m.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0320a implements ImageDecoder.OnPartialImageListener {
            public C0320a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public C0319a(int i2, int i3, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.a = i2;
            this.b = i3;
            this.f9730c = z;
            this.f9731d = decodeFormat;
            this.f9732e = downsampleStrategy;
            this.f9733f = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (a.this.a.g(this.a, this.b, this.f9730c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f9731d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0320a());
            Size size = imageInfo.getSize();
            int i2 = this.a;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getWidth();
            }
            int i3 = this.b;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getHeight();
            }
            float b = this.f9732e.b(size.getWidth(), size.getHeight(), i2, i3);
            int round = Math.round(size.getWidth() * b);
            int round2 = Math.round(size.getHeight() * b);
            if (Log.isLoggable(a.b, 2)) {
                Log.v(a.b, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b);
            }
            imageDecoder.setTargetSize(round, round2);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 28) {
                if (i4 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                    return;
                }
                return;
            }
            if (this.f9733f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                z = true;
            }
            imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }

    public abstract s<T> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // e.b.a.p.g
    @Nullable
    /* renamed from: d */
    public final s<T> b(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull f fVar) throws IOException {
        DecodeFormat decodeFormat = (DecodeFormat) fVar.a(o.f9763g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.a(DownsampleStrategy.f1718h);
        e<Boolean> eVar = o.f9767k;
        return c(source, i2, i3, new C0319a(i2, i3, fVar.a(eVar) != null && ((Boolean) fVar.a(eVar)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) fVar.a(o.f9764h)));
    }

    @Override // e.b.a.p.g
    /* renamed from: e */
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull f fVar) {
        return true;
    }
}
