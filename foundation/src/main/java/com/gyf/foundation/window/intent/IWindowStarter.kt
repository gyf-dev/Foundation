/*
 *
 *  * Copyright @ 2021 - 2022 Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *  * All Rights Reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are NOT permitted except as agreed by
 *  * Human Horizons (Shanghai) Cloud Computing Technology Co., Ltd.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */
package com.gyf.foundation.window.intent

import com.gyf.foundation.window.Window

/**
 * The interface Window starter.
 *
 * @author: Ifan Ge
 * @date: 2022 -10-13  13:46
 * @Version: design3.0
 */
interface IWindowStarter {
    /**
     * Start window.
     *
     * @param intent the intent
     */
    fun <T : Window> startWindow(intent: WindowIntent)

    /**
     * Start window get t.
     *
     * @param <T>    the type parameter
     * @param intent the intent
     * @return the t
    </T> */
    fun <T : Window> startWindowGet(intent: WindowIntent): T
}
