package com.olivine.videolib.camera;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.util.Log;

public class CameraManager implements ICamera {
    private static final String TAG = "CameraManager";
    private static final int DEFAULT_16_9_WIDTH = 1280;
    private static final int DEFAULT_16_9_HEIGHT = 720;

    // 预览宽度
    private int mPreviewWidth = DEFAULT_16_9_WIDTH;
    // 预览高度
    private int mPreviewHeight = DEFAULT_16_9_HEIGHT;


    // 相机对象
    private Camera mCamera;
    // 摄像头id
    private int mCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;


    @Override
    public void open() {
        mCamera = Camera.open(mCameraId);

        Camera.Parameters parameters = mCamera.getParameters();


        parameters.setPreviewFormat(ImageFormat.NV21);
        parameters.setPreviewSize(mPreviewWidth, mPreviewHeight);
        parameters.setPictureSize(mPreviewWidth, mPreviewHeight);

        mCamera.setDisplayOrientation(0);


        mCamera.setPreviewCallback(new Camera.PreviewCallback() {
            @Override
            public void onPreviewFrame(byte[] data, Camera camera) {
                Log.d(TAG, "onPreviewFrame: ");

            }
        });

        mCamera.startPreview();

    }

    @Override
    public void stop() {

    }
}
