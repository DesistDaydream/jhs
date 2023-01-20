package e.j.f;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes2.dex */
public interface j {
    k a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    k c(b bVar) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
