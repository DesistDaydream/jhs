package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import c.c.a.a.a.a;
import c.c.a.a.a.b;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class KeyParser {

    /* loaded from: classes.dex */
    public interface DataType {
        int get(int i2);
    }

    /* loaded from: classes.dex */
    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i2 = 0; i2 < size; i2++) {
                CLKey cLKey = (CLKey) parse.get(i2);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i3 = ids.get(content);
                if (i3 == -1) {
                    PrintStream printStream = System.err;
                    printStream.println("unknown type " + content);
                } else {
                    int i4 = dataType.get(i3);
                    if (i4 == 1) {
                        typedBundle.add(i3, parse.getBoolean(i2));
                    } else if (i4 == 2) {
                        typedBundle.add(i3, value.getInt());
                        PrintStream printStream2 = System.out;
                        printStream2.println("parse " + content + " INT_MASK > " + value.getInt());
                    } else if (i4 == 4) {
                        typedBundle.add(i3, value.getFloat());
                        PrintStream printStream3 = System.out;
                        printStream3.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                    } else if (i4 == 8) {
                        typedBundle.add(i3, value.content());
                        PrintStream printStream4 = System.out;
                        printStream4.println("parse " + content + " STRING_MASK > " + value.content());
                    }
                }
            }
        } catch (CLParsingException e2) {
            e2.printStackTrace();
        }
        return typedBundle;
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, b.a, a.a);
    }
}
