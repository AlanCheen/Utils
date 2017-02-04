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

import android.graphics.DashPathEffect;
import android.graphics.Path;

/**
 * Created by 程序亦非猿 on 15/12/27.
 */
public final class PathEffectUtil {

    private PathEffectUtil() {
        //no instance
        throw new AssertionError("No instances.");
    }

    /**
     * 生成一个可用作Path动画的DashPathEffect
     * 效果 从头画到尾
     * @param pathLength path的长度 可以通过{@link me.yifeiyuan.utils.PathUtil#measurePath(Path)}来测量path的长度
     * @param phase 阶段
     * @return DashPathEffect
     */
    public DashPathEffect createAnimPathEffect(float pathLength, int phase) {
        return new DashPathEffect(new float[]{pathLength*(1-phase),pathLength},0);
    }
}
