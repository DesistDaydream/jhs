package e.j.a.b.c;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.common.AccountPicker;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class a {
    private a() {
    }

    public static Intent a(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        Intent intent = new Intent();
        e.j.a.b.c.r.a0.b(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(AccountPicker.EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z);
        intent.putExtra(AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra(AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        intent.putExtra(AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        return intent;
    }
}
