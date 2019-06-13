package bird.free.utils;

import java.util.Collection;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/13 17:24
 */
public class CollectionUtils {


    public static boolean isEmpty(Collection collection) {
        return collection.isEmpty() || collection == null;
    }
}
