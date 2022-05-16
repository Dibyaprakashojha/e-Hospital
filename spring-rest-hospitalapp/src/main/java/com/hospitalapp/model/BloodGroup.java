package com.hospitalapp.model;

/**
 * @author Dibya Prakash Ojha
 * @date : 14-May-22
 * @project : e-Hospital
 */
public enum BloodGroup {
    OPOSITIVE("O+ve"),
    ONEGATIVE("O-ve"),
    APOSITIVE("A+ve"),
    ANEGATIVE("A-ve"),
    BPOSITIVE("B+ve"),
    BNEGATIVE("B-ve"),
    ABPOSITIVE("AB+ve"),
    ABNEGATIVE("AB-ve");

    private String groupType;

    BloodGroup(String bGroup) {
        this.groupType = bGroup;
    }
}
