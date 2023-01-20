package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class SupportInfo {
    public String a;
    public Boolean b;

    public void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    public boolean a() {
        return this.b != null;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }

    public void b(String str) {
        this.a = str;
    }

    public boolean b() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
