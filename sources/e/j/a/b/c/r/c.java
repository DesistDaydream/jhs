package e.j.a.b.c.r;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class c {
    @NonNull
    @e.j.a.b.c.m.a
    public static ApiException a(@NonNull Status status) {
        if (status.hasResolution()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
