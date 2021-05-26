package com.chunchiehliang.apechealthkey.map

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.chunchiehliang.apechealthkey.R
import com.chunchiehliang.apechealthkey.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private val mapViewModel: MapViewModel by viewModels()
    private lateinit var mMap: GoogleMap

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mapViewModel
            recyclerAttractions.hasFixedSize()
            recyclerAttractions.adapter = AttractionListAdapter(AttractionListener {
            })
        }
        // Instantiate the map
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val taipei101 = LatLng(25.03386008609641, 121.56453891088545)
        mMap = googleMap

        mMap.addMarker(
            MarkerOptions()
                .position(taipei101)
                .title("Taipei 101")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taipei101, 16f))

    }
}