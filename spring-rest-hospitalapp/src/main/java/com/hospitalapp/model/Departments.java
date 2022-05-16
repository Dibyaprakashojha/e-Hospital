package com.hospitalapp.model;

/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
public enum Departments {
    GMED("GENERAL MEDICINE"),
    SURGERY("SURGERY"),
    GYNAEC("GYNAECOLOGY"),
    PAEDIA("PAEDIATRICS"),
    EYE("OPTHALMOLOGY"),
    DENTAL("DENTAL"),
    CARDIO("CARDDIOLOGY"),
    ORTHO("ORTHOLOGY"),
    NEURO("NEUROLOGY"),
    SKIN("DERMATOLOGY"),
    ONCO("ONCOLOGY"),
    ENT("ENT"),
    PSYCH("PSYCHIATRY"),
    PLASTIC("PLASTIC SURGERY"),
    OBS("OBSTETRICS"),
    NMED("NUCLEAR MEDICINE");

    private String deptType;

    Departments(String deptName) {
        this.deptType = deptName;
    }
}
