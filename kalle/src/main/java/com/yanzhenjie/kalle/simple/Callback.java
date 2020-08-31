/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yanzhenjie.kalle.simple;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Zhenjie Yan on 2018/2/17.
 */
public abstract class Callback<Succeed, Failed> {

    public Callback() {
    }

    /**
     * Get the data type when the business was successful.
     */
    public Type getSucceed() {
        Type superClass = getClass().getGenericSuperclass();
        return ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    /**
     * Get the data type when the business failed.
     */
    public Type getFailed() {
        Type superClass = getClass().getGenericSuperclass();
        return ((ParameterizedType) superClass).getActualTypeArguments()[1];
    }

    /**
     * Time dimensions: The request started.
     */
    public abstract void onStart();

    /**
     * Result dimensions: The request has responded.
     */
    public abstract void onResponse(Result<Succeed, Failed> response);

    /**
     * Result dimensions: An abnormality has occurred.
     */
    public abstract void onException(Exception e);

    /**
     * Result dimensions: The request was cancelled.
     */
    public abstract void onCancel();

    /**
     * Time dimensions: The request ended.
     */
    public abstract void onEnd();
}