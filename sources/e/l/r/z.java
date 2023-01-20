package e.l.r;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContract;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.page.photo.ChoosePhotoActivityCreator;
import com.jihuanshe.ui.widget.GameBar;

/* loaded from: classes2.dex */
public final class z extends ActivityResultContract<Integer, Uri> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.d
    /* renamed from: a */
    public Intent createIntent(@k.e.a.d Context context, @k.e.a.e Integer num) {
        Game value = GameBar.b.a().getValue();
        return ChoosePhotoActivityCreator.newIntent(context, value == null ? null : value.getGameKey(), num, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.activity.result.contract.ActivityResultContract
    @k.e.a.e
    public Uri parseResult(int i2, @k.e.a.e Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Uri) intent.getParcelableExtra("result");
    }
}
