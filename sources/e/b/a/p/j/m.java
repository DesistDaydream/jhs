package e.b.a.p.j;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // e.b.a.p.j.b
    /* renamed from: e */
    public void b(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // e.b.a.p.j.b
    /* renamed from: f */
    public InputStream d(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    @Override // e.b.a.p.j.d
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
