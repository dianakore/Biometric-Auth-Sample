package com.an.biometric.sample.persistence;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "device")
public class Device {

    public Device(String imei) {
        this.imei = imei;
    }

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "alias_device")
    private String imei;

    @ColumnInfo(name = "data_device")
    private String lastAlive;

    @ColumnInfo(name = "sim_device")
    private String sim = "";

    @ColumnInfo(name = "fwversion_device")
    private String fwVersion;

    @ColumnInfo(name = "swversion_device")
    private String swVersion;

    @ColumnInfo(name = "iccid_device")
    private String iccid;

    @ColumnInfo(name = "ip_device")
    private String ip = "0.0.0.0";

    @ColumnInfo(name = "temperature_device")
    private String temperature = "0.00";

    @ColumnInfo(name = "is_device")
    private int inService;

    @ColumnInfo(name = "current_device")
    private String energy = "0.00";

    @ColumnInfo(name = "voltage_device")
    private String voltage = "0.00";

    @ColumnInfo(name = "updating_device")
    private int updating;

    @ColumnInfo(name = "name_device")
    private String name;

    @ColumnInfo(name = "field_device")
    private String field;

    @NonNull
    public Long getId() {
        return id;
    }


    public String getImei() {
        return imei;
    }

    public String getLastAlive() {
        return lastAlive;
    }

    public String getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public int getUpdating() {
        return updating;
    }

    public String getVoltage() {
        return voltage;
    }

    public String getEnergy() {
        return energy;
    }

    public int getInService() {
        return inService;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getIp() {
        return ip;
    }

    public String getIccid() {
        return iccid;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public String getFwVersion() {
        return fwVersion;
    }

    public String getSim() {
        return sim;
    }


    public void setLastAlive(String lastAlive) {
        this.lastAlive = lastAlive;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setInService(int inService) {
        this.inService = inService;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public void setUpdating(int updating) {
        this.updating = updating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

}
