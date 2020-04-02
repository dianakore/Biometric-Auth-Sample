package com.an.biometric.sample.persistence;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DeviceRepository {
    private DeviceDao deviceDao;
    private LiveData<List<Device>> allDevices;

    public DeviceRepository(Application application){
        AppDatabase database= AppDatabase.getInstance(application);
        //room genera in automatico il codive per il dao
        deviceDao= database.deviceDao();
        allDevices= deviceDao.getAll();
    }

    public LiveData<List<Device>> getAllDevices(){
        return allDevices;
    }

    public void delete(Device device){
        new DeleteDeviceAsyncTask(deviceDao).execute(device);
    }

    public void update(Device device){
        new UpdateDeviceAsyncTask(deviceDao).execute(device);
    }

    public void deleteAll(){
        new DeleteAllDeviceAsyncTask(deviceDao).execute();
    }

    public void insert(Device device){
        new InsertDeviceAsyncTask(deviceDao).execute(device);
    }

    private static class InsertDeviceAsyncTask extends AsyncTask<Device,Void,Void>{

        private DeviceDao deviceDao;

        private InsertDeviceAsyncTask(DeviceDao deviceDao){
            this.deviceDao =deviceDao;
        }

        @Override
        protected Void doInBackground(Device... devices) {
            deviceDao.insert(devices[0]);
            return null;
        }
    }

    private static class UpdateDeviceAsyncTask extends AsyncTask<Device,Void,Void>{

        private DeviceDao deviceDao;

        private UpdateDeviceAsyncTask(DeviceDao deviceDao){
            this.deviceDao =deviceDao;
        }

        @Override
        protected Void doInBackground(Device... devices) {
            deviceDao.update(devices[0]);
            return null;
        }
    }

    private static class DeleteDeviceAsyncTask extends AsyncTask<Device,Void,Void>{

        private DeviceDao deviceDao;

        private DeleteDeviceAsyncTask(DeviceDao deviceDao){
            this.deviceDao =deviceDao;
        }

        @Override
        protected Void doInBackground(Device... devices) {
            deviceDao.delete(devices[0]);
            return null;
        }
    }

    private static class DeleteAllDeviceAsyncTask extends AsyncTask<Void,Void,Void>{

        private DeviceDao deviceDao;

        private DeleteAllDeviceAsyncTask(DeviceDao deviceDao){
            this.deviceDao =deviceDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            deviceDao.deleteAll();
            return null;
        }
    }

}
