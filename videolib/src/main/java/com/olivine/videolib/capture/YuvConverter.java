/*
 *  Copyright 2015 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package com.olivine.videolib.capture;



/**
 * Class for converting OES textures to a YUV ByteBuffer. It can be constructed on any thread, but
 * should only be operated from a single thread with an active EGL context.
 */
public class YuvConverter {

    public YuvConverter() {

    }


    /**
     * Converts the texture buffer to I420.
     */
    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer inputTextureBuffer) {
        return null;
    }

    public void release() {

    }
}
