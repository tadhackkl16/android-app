package org.restcomm.android.sdk.util;

import android.util.Log;

import org.motion.detection.BasicDetector;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.webrtc.VideoCapturer.CapturerObserver;
/**
 * Created by abd on 10/15/16.
 */

public class MotionDetecation implements CapturerObserver{
    @Override
    public void onCapturerStarted(boolean b) {

    }

    @Override
    public void onCapturerStopped() {

    }

    @Override
    public void onByteBufferFrameCaptured(byte[] bytes, int i, int i1, int i2, long l) {
        Log.e("data", new String(bytes));
        BasicDetector detector = new BasicDetector(100);
        Mat mat = Imgcodecs.imdecode(new MatOfByte(bytes), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        detector.detect(mat);
        if(detector.isDetected()){
            Log.e("IIIIII","HELLLLLLLLLLLIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIILLLLLO");
        }
        Log.e("@","@@");
    }

    @Override
    public void onTextureFrameCaptured(int i, int i1, int i2, float[] floats, int i3, long l) {

    }

    @Override
    public void onOutputFormatRequest(int i, int i1, int i2) {

    }

    // Calculate white pixels
//    private int CalculateWhitePixels( Bitmap image )
//    {
//        int count = 0;
//        // lock difference image
//        BitmapData data = image.LockBits( new Rectangle( 0, 0, width, height ),
//                ImageLockMode.ReadOnly, PixelFormat.Format8bppIndexed );
//        int offset = data.Stride - width;
//        unsafe
//        {
//            byte * ptr = (byte *) data.Scan0.ToPointer( );
//            for ( int y = 0; y < height; y++ )
//            {
//                for ( int x = 0; x < width; x++, ptr++ )
//                {
//                    count += ( (*ptr) >> 7 );
//                }
//                ptr += offset;
//            }
//        }
//        // unlock image
//        image.UnlockBits( data );
//        return count;
//    }
}
