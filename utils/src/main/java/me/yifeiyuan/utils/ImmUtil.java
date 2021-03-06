/*
 * Copyright (C) 2015, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by 程序亦非猿 on 16/1/5.
 *
 *  隐藏/显示输入法
 */
public final class ImmUtil {

    private ImmUtil() {
        //no instance
        throw new AssertionError("No instances.");
    }

    /**
     * 隐藏输入法
     * @param act activity
     */
    public static void hide(@NonNull Activity act) {

        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = act.getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 显示输入法
     * @param act activity
     */
    public static void show(@NonNull Activity act){
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = act.getCurrentFocus();
        if (view != null) {
            imm.showSoftInputFromInputMethod(view.getWindowToken(),InputMethodManager.SHOW_IMPLICIT);
        }
    }

}
