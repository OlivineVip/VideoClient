package com.olivine.module_opengl;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;

import androidx.appcompat.app.AppCompatActivity;

import com.olivine.videolib.capture.Camera1Capturer;
import com.olivine.videolib.capture.Camera1Enumerator;
import com.olivine.videolib.capture.CameraEnumerator;
import com.olivine.videolib.capture.CameraVideoCapturer;
import com.olivine.videolib.capture.CapturerObserver;
import com.olivine.videolib.capture.SurfaceTextureHelper;
import com.olivine.videolib.capture.VideoFrame;
import com.olivine.videolib.egl.EglBase;

import java.io.IOException;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SimpleOpenglActivity extends AppCompatActivity {
    private static final String TAG = "SimpleOpenglActivity";

    private GLSurfaceView glSurfaceView;
    private TextureView textureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_opengl);


        glSurfaceView = findViewById(R.id.gl_surface_view);


        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new MyRender());
        glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        openCamera();

    }


    private void openCamera() {
        CameraEnumerator cameraEnumerator = new Camera1Enumerator(false);
        for (String deviceName : cameraEnumerator.getDeviceNames()) {
            if (cameraEnumerator.isFrontFacing(deviceName)) {

                CameraVideoCapturer videoCapturer = cameraEnumerator.createCapturer(deviceName, null);


               EglBase eglBase= EglBase.create();

                videoCapturer.initialize( SurfaceTextureHelper.create("cameara", eglBase.getEglBaseContext()), getApplicationContext(), new CapturerObserver() {
                    @Override
                    public void onCapturerStarted(boolean success) {

                    }

                    @Override
                    public void onCapturerStopped() {

                    }

                    @Override
                    public void onFrameCaptured(VideoFrame frame) {

                    }
                });
                videoCapturer.startCapture(240,320,30);
                return;
            }

        }


    }


    private static class MyRender implements GLSurfaceView.Renderer {


        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES20.glClearColor(1, 0, 0, 0);

        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);

        }

        @Override
        public void onDrawFrame(GL10 gl) {

            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        }
    }


}