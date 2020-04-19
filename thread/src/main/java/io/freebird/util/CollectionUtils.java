package io.freebird.util;

import java.util.Collection;

/**
 * @author freebird
 * @date 2020/4/19 17:41
 */
public final class CollectionUtils {

    public static boolean isEmpty(Collection col) {
        return col == null || col.isEmpty();
    }

    public static boolean isNotEmpty(Collection col) {
        return !isEmpty(col);
    }
}
