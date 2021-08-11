package com.example.finaltest.model;

public class SinhVien {
    private String MaMon;
    private String MaSV;
    private String Diem;

    public SinhVien() {
    }

    public SinhVien(String maMon, String maSV, String diem) {
        MaMon = maMon;
        MaSV = maSV;
        Diem = diem;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String maMon) {
        MaMon = maMon;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getDiem() {
        return Diem;
    }

    public void setDiem(String diem) {
        Diem = diem;
    }
}
