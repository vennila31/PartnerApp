package com.codetez.partnerapp.ui.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.codetez.partnerapp.R
import com.codetez.partnerapp.databinding.ActivityMapsBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback , TaskLoadedCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var place1 : MarkerOptions
    lateinit var place2 : MarkerOptions
    lateinit var polyline : Polyline

    lateinit var getDirection : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        getDirection = findViewById(R.id.direction)

        place1 = MarkerOptions().position(LatLng(27.658143,
            85.3166503)).title("Location1")
        place2 = MarkerOptions().position(LatLng(27.667491,85.3208583)).title("Location2")

        getDirection.setOnClickListener {
            FetchURL(this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
        }


    }

    private fun getUrl(origin: LatLng, destination : LatLng, directionMode: String): String {

        var str_origin = "origin=" + origin.latitude + "," + origin.longitude
        var str_dest = "destination=" + destination.latitude + "," + destination.longitude
        var mode = "mode=" + directionMode
        var parameters = str_origin + "&" + str_dest + "&" + mode
        var output = "json"
        var url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key)

    return url

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.addMarker(place1);
        mMap.addMarker(place2);
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onTaskDone(vararg values: PolylineOptions) {
        if (polyline != null)
            polyline.remove();
        polyline = mMap.addPolyline(values[0]);
    }
}