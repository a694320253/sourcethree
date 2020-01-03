package com.usho.opengl;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    private GLSurfaceView glsurface_view;
//    private FloatBuffer floatBuffer;
    private ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        glsurface_view=findViewById(R.id.glsurface_view);
//        //定义定点数据
//        float [] vertexDate=new float[16];
//        floatBuffer= ByteBuffer.allocateDirect(vertexDate.length* SyncSt)
        image_view=findViewById(R.id.image_view);
        ImageLoader imageLoader=new ImageLoader();
        imageLoader.displayImage("http://p2.so.qhimgs1.com/bdr/_240_/t01b20aa81f9cd5a5f2.jpg",image_view);
    }
}
