package e.j.f;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public interface n {
    e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException;

    e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException;
}
