package e.j.a.b.c.r;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;
import javax.annotation.Nullable;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class f0 {
    private final Resources a;
    private final String b;

    public f0(Context context) {
        a0.k(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.b = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @e.j.a.b.c.m.a
    @Nullable
    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
