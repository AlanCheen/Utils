/*
 * Copyright (C) 2017, 程序亦非猿
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

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by 程序亦非猿 on 17/2/22.
 */
public class ClipUtil {


    public static void clipText(Context cxt,CharSequence label,CharSequence text) {
        ClipboardManager cm = (ClipboardManager) cxt.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data = ClipData.newPlainText(label,text);
        cm.setPrimaryClip(data);
    }
}
