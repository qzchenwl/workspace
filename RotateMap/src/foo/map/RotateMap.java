package foo.map;

import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class RotateMap extends MapActivity {
    // private static final String TAG = "MapViewCompassDemo";
    private SensorManager mSensorManager;
    private RotateView mRotateView;
    private MapView mMapView;
    private MyLocationOverlay mMyLocationOverlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mRotateView = new RotateView(this);
        mMapView = new MapView(this, "0rfQ8EiZO3AZB7X0QDcYuN6aGWK7b0xkTxtnfdw");
        mRotateView.addView(mMapView);
        setContentView(mRotateView);

        mMyLocationOverlay = new MyLocationOverlay(this, mMapView);
        mMyLocationOverlay.runOnFirstFix(new Runnable() { public void run() {
            mMapView.getController().animateTo(mMyLocationOverlay.getMyLocation());
        }});
        mMapView.getOverlays().add(mMyLocationOverlay);
        mMapView.getController().setZoom(18);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mRotateView,
                SensorManager.SENSOR_ORIENTATION,
                SensorManager.SENSOR_DELAY_UI);
        mMyLocationOverlay.enableMyLocation();
    }

    @Override
    protected void onStop() {
        mSensorManager.unregisterListener(mRotateView);
        mMyLocationOverlay.disableMyLocation();
        super.onStop();
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
