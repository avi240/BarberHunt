package com.example.patientdemo;

public class MyAppointmentsBarberModel {

    String patient, remarks, slot;

    public MyAppointmentsBarberModel() {
    }

    public MyAppointmentsBarberModel(String patient, String remarks, String slot) {
        this.patient = patient;
        this.remarks = remarks;
        this.slot = slot;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
