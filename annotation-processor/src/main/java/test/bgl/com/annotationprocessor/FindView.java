package test.bgl.com.annotationprocessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: TODO
 * Date: 2018/4/10-${hour}
 * Author: ${user}
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface FindView {
    int value();
}
