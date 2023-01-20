package e.b.a.p.m.d;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;

@Deprecated
/* loaded from: classes.dex */
public class f0 extends VideoDecoder<ParcelFileDescriptor> {
    public f0(Context context) {
        this(e.b.a.c.e(context).h());
    }

    public f0(e.b.a.p.k.x.e eVar) {
        super(eVar, new VideoDecoder.g());
    }
}
