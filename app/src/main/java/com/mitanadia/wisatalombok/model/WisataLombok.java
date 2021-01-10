package com.mitanadia.wisatalombok.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;


public class WisataLombok {
    public static final String PANTAI = "PANTAI";
    public static final String AIRTERJUN = "AIR TERJUN";
    public static final String PEMANDIAN = "PEMANDIAN";
    public static final String BUDAYA = "BUDAYA";
    public static final String SEJARAH = "AIR TERJUN";
    public static final String PEGUNUNGAN = "PEGUNUNGAN";
    public static final String DESA = "DESA WISATA";

    private String id;
    private String nama;
    private String daerah;
    private String kategori;
    private String deskripsi;

    public WisataLombok() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaDestinasi() {
        return nama;
    }

    public void setNamaDestinasi(String nama) {
        this.nama = nama;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public static WisataLombok fromJSONObject(JSONObject obj) {
        WisataLombok tr = new WisataLombok();
        try {
            tr.setId(obj.getString("id"));
            tr.setNamaDestinasi(obj.getString("nama"));
            tr.setDaerah(obj.getString("daerah"));
            tr.setKategori(obj.getString("kategori"));
            tr.setDeskripsi(obj.getString("deskripsi"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("nama", this.nama);
            jsonObj.put("daerah", this.daerah);
            jsonObj.put("kategori", this.kategori);
            jsonObj.put("deskripsi", this.deskripsi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
