package com.example.csv;

public class OuraRingData {
    private double HR;
    private int readiness;
    private int sleep;
    private int HRV;
    private double tempDev;

    public int getHRV() {
        return HRV;
    }

    public void setHRV(int HRV) {
        this.HRV = HRV;
    }

    public double getHR() {
        return HR;
    }

    public void setHR(double HR) {
        this.HR = HR;
    }

    public int getReadiness() {
        return readiness;
    }

    public void setReadiness(int readiness) {
        this.readiness = readiness;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public double getTempDev() {
        return tempDev;
    }

    public void setTempDev(double tempDev) {
        this.tempDev = tempDev;
    }

    @Override
    public String toString() {
        return "OuraRingData{" +
                "HR=" + HR +
                ", readiness=" + readiness +
                ", sleep=" + sleep +
                ", HRV=" + HRV +
                ", tempDev=" + tempDev +
                '}';
    }
}
