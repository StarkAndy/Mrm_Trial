package com.example.ishu.repairproject;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.location.LocationManager.GPS_PROVIDER;

public class LocationDisplayer extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    String mPermission = android.Manifest.permission.ACCESS_FINE_LOCATION;

    private int LOCATION_REQUEST_CODE = 1;

    private LocationManager locationManager;

    private LocationListener  locationListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_location_displayer, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        // ObtainupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        //for getting lacation
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        return rootView;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

   //function will check the permission
    public void checkPermission() {

        if (Build.VERSION.SDK_INT > 23) {

            try {
                if (ActivityCompat.checkSelfPermission(getActivity(), mPermission)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(), new String[]{mPermission},
                            LOCATION_REQUEST_CODE);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else{

            getLocation();

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(permissions.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            checkPermission();
            locationManager.requestLocationUpdates(GPS_PROVIDER,0,0,locationListener);



        }


    }

    public void getLocation(){
        checkPermission();
        Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location!=null){


            double latitude =location.getLatitude();
            double longitude=location.getLongitude();

            Toast.makeText(getActivity(),"Location"+latitude+longitude,Toast.LENGTH_LONG).show();
        }

    }
}
