package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;
import c.b.b.b2.c0;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    @NonNull
    private static final Config.OptionPriority DEFAULT_PRIORITY = Config.OptionPriority.OPTIONAL;

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        super(treeMap);
    }

    @NonNull
    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(OptionsBundle.ID_COMPARE));
    }

    @NonNull
    public static MutableOptionsBundle from(@NonNull Config config) {
        TreeMap treeMap = new TreeMap(OptionsBundle.ID_COMPARE);
        for (Config.Option<?> option : config.listOptions()) {
            Set<Config.OptionPriority> priorities = config.getPriorities(option);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : priorities) {
                arrayMap.put(optionPriority, config.retrieveOptionWithPriority(option, optionPriority));
            }
            treeMap.put(option, arrayMap);
        }
        return new MutableOptionsBundle(treeMap);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        insertOption(option, DEFAULT_PRIORITY, valuet);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    @Nullable
    public <ValueT> ValueT removeOption(@NonNull Config.Option<ValueT> option) {
        return (ValueT) this.mOptions.remove(option);
    }

    @Override // androidx.camera.core.impl.MutableConfig
    public <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority, @Nullable ValueT valuet) {
        Map<Config.OptionPriority, Object> map = this.mOptions.get(option);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.mOptions.put(option, arrayMap);
            arrayMap.put(optionPriority, valuet);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
        if (!Objects.equals(map.get(optionPriority2), valuet) && c0.a(optionPriority2, optionPriority)) {
            throw new IllegalArgumentException("Option values conflicts: " + option.getId() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + valuet);
        }
        map.put(optionPriority, valuet);
    }
}
