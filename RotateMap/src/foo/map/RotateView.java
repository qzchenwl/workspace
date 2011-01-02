package foo.map;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.SensorListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

@SuppressWarnings("deprecation")
public class RotateView  extends ViewGroup implements SensorListener {
    private static final float SQ2 = 1.414213562373095f; // sqrt(2)
    private final SmoothCanvas mCanvas = new SmoothCanvas();
    private float mHeading = 0;

    public RotateView(Context context) {
        super(context);
    }

    public void onSensorChanged(int sensor, float[] values) {
        synchronized (this) {
            mHeading = values[0]; // 指定角度给mHeading变量
            invalidate(); // 变动已处理
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save(Canvas.MATRIX_SAVE_FLAG); 
        canvas.rotate(-mHeading, getWidth() * 0.5f, getHeight() * 0.5f); // 以中心为支点旋转-mHeading角度
        mCanvas.delegate = canvas; // 指定当前canvas给自定canvas
        super.dispatchDraw(mCanvas);
        canvas.restore(); 
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int width = getWidth();
        final int height = getHeight();
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = getChildAt(i);
            final int childWidth = view.getMeasuredWidth(); 
            final int childHeight = view.getMeasuredHeight();
            final int childLeft = (width - childWidth) / 2;
            final int childTop = (height - childHeight) / 2;
            view.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int h = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        int sizeSpec;
        if (w > h) {
            sizeSpec = MeasureSpec.makeMeasureSpec((int) (w * SQ2), MeasureSpec.EXACTLY);
        } else {
            sizeSpec = MeasureSpec.makeMeasureSpec((int) (h * SQ2), MeasureSpec.EXACTLY);
        }
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            getChildAt(i).measure(sizeSpec, sizeSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO: rotate events too
        return super.dispatchTouchEvent(ev);
    }

    public void onAccuracyChanged(int sensor, int accuracy) {
        // TODO Auto-generated method stub
        
    }
}
