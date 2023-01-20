package c.b.b.b2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;

/* compiled from: Config.java */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 {
    public static boolean a(@NonNull Config.OptionPriority optionPriority, @NonNull Config.OptionPriority optionPriority2) {
        Config.OptionPriority optionPriority3 = Config.OptionPriority.ALWAYS_OVERRIDE;
        if (optionPriority == optionPriority3 && optionPriority2 == optionPriority3) {
            return true;
        }
        Config.OptionPriority optionPriority4 = Config.OptionPriority.REQUIRED;
        return optionPriority == optionPriority4 && optionPriority2 == optionPriority4;
    }

    @NonNull
    public static Config b(@Nullable Config config, @Nullable Config config2) {
        MutableOptionsBundle create;
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        if (config2 != null) {
            create = MutableOptionsBundle.from(config2);
        } else {
            create = MutableOptionsBundle.create();
        }
        if (config != null) {
            for (Config.Option<?> option : config.listOptions()) {
                create.insertOption(option, config.getOptionPriority(option), config.retrieveOption(option));
            }
        }
        return OptionsBundle.from(create);
    }
}
