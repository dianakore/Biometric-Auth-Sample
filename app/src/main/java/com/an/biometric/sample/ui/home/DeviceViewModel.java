package com.an.biometric.sample.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.an.biometric.sample.persistence.Device;
import com.an.biometric.sample.persistence.DeviceRepository;

import java.util.List;

public class DeviceViewModel extends AndroidViewModel {
    private DeviceRepository repository;

    private LiveData<List<Device>> allDevices;

    public DeviceViewModel(@NonNull Application application) {
        super(application);
        repository= new DeviceRepository(application);
        allDevices= repository.getAllDevices();
    }

    public void insert(Device device)   {
        repository.insert(device);
    }

    public void update(Device device){
        repository.update(device);
    }

    public void delete(Device device){
        repository.delete(device);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Device>> getAllDevices(){
        return allDevices;
    }
}
