package com.an.biometric.sample.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DeviceDao {
    @Query("SELECT * FROM device")
    LiveData<List<Device>> getAll();

    @Query("DELETE FROM device")
    void deleteAll();

    @Query("SELECT * FROM device WHERE id IN (:deviceId)")
    LiveData<List<Device>> loadAllByIds(int[] deviceId);

    @Query("SELECT * FROM device WHERE alias_device IN (:deviceImei)")
    LiveData<List<Device>> loadAllByImei(int[] deviceImei);

    @Query("SELECT * FROM device WHERE iccid_device LIKE (:iccd) LIMIT 1")
    LiveData<List<Device>> findByIccid(int[] iccd);

    @Query("SELECT * FROM device WHERE name_device LIKE (:name) ")
    LiveData<List<Device>> findByName(String name);

/*    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Device... devices);*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Device device);

    @Delete
    void delete(Device device);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Device device);
}
