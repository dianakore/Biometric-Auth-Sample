package com.an.biometric.sample.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.an.biometric.sample.FirstPageActivity;
import com.an.biometric.sample.R;
import com.an.biometric.sample.persistence.Device;

import java.util.List;

public class HomeFragment extends Fragment {
    private DeviceViewModel deviceViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final DeviceAdapter adapter= new DeviceAdapter();
        recyclerView.setAdapter(adapter);


        deviceViewModel =
                ViewModelProviders.of(requireActivity()).get(DeviceViewModel.class);

                //Without ViewModelFactory
       // deviceViewModel = new ViewModelProvider(requireActivity()).get(DeviceViewModel.class);

        // With ViewModelFactory


        //al posto di this android suggerisce l'uso di getViewLifecycleOwner()
        deviceViewModel.getAllDevices().observe(getViewLifecycleOwner(), new Observer<List<Device>>() {
            @Override
            public void onChanged(List<Device> devices) {
                //update recyclerview later
               adapter.setDevices(devices);
            }
        });






        return root;
    }


}
