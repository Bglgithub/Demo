package test.bgl.com.annotation.declaration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc:
 *
 * @author: baoguolin
 * @date: 2018/4/9
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface DBTable {
    public String tableName();
}
