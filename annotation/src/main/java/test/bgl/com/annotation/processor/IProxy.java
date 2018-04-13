package test.bgl.com.annotation.processor;

import android.view.View;

/**
 * @desc:
 *
 * @author: baoguolin
 * @date: 2018/4/11
 */

public interface IProxy<T>{
    void inject(final T target, View root);
}
