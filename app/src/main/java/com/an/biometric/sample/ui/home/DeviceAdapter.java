package com.an.biometric.sample.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.an.biometric.sample.R;
import com.an.biometric.sample.persistence.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceHolder> {
    private List<Device> devices = new ArrayList<>();

    @NonNull
    @Override
    public DeviceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.note_item,parent,false);
        return new DeviceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceHolder holder, int position) {
        Device currentDevice = devices.get(position);
        holder.textViewImei.setText(currentDevice.getImei());
        holder.textViewAlias.setText(currentDevice.getName());
        holder.textViewCose.setText(currentDevice.getIp());
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void setDevices(List<Device> devices){
        this.devices = devices;
        //non usare di solito
        notifyDataSetChanged();
    }

    class DeviceHolder extends RecyclerView.ViewHolder{
        private TextView textViewImei;
        private TextView textViewAlias;
        private TextView textViewCose;

        public DeviceHolder(@NonNull View itemView) {
            super(itemView);
            textViewImei = itemView.findViewById(R.id.text_view_imei);
            textViewAlias = itemView.findViewById(R.id.text_view_alias);
            textViewCose = itemView.findViewById(R.id.text_view_cose);

        }
    }
}
