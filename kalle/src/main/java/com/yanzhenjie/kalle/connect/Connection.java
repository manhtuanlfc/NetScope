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
package com.yanzhenjie.kalle.connect;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhenjie Yan on 2018/2/20.
 */
public interface Connection extends Closeable {

    /**
     * Gets output stream for socket.
     */
    OutputStream getOutputStream() throws IOException;

    /**
     * Gets response code for server.
     */
    int getCode() throws IOException;

    /**
     * Gets response headers for server.
     */
    Map<String, List<String>> getHeaders() throws IOException;

    /**
     * Gets input stream for socket.
     */
    InputStream getInputStream() throws IOException;

    /**
     * Cancel connect.
     */
    void disconnect();

}