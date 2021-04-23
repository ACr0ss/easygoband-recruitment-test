package com.cross.easygoband_test.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticket implements Serializable {
    @Expose
    @SerializedName("access_group_name")
    public String access_group_name;

    @Expose
    @SerializedName("access_group_id")
    public int access_group_id;

    @Expose
    @SerializedName("total_uses")
    public int total_uses;

    @Expose
    @SerializedName("sessions")
    public List<Session> sessions;

    @Expose
    @SerializedName("event_id")
    public int event_id;

    @Expose
    @SerializedName("structure_decode")
    public boolean structure_decode;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("modified")
    public String modified;

    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("basic_product_id")
    public int basic_product_id;

    public Ticket(String access_group_name, int access_group_id, int total_uses, List<Session> sessions, int event_id, boolean structure_decode, String name, String modified, int id, int basic_product_id) {
        this.access_group_name = access_group_name;
        this.access_group_id = access_group_id;
        this.total_uses = total_uses;
        this.sessions = sessions;
        this.event_id = event_id;
        this.structure_decode = structure_decode;
        this.name = name;
        this.modified = modified;
        this.id = id;
        this.basic_product_id = basic_product_id;
    }

    public String getAccess_group_name() {
        return access_group_name;
    }

    public void setAccess_group_name(String access_group_name) {
        this.access_group_name = access_group_name;
    }

    public int getAccess_group_id() {
        return access_group_id;
    }

    public void setAccess_group_id(int access_group_id) {
        this.access_group_id = access_group_id;
    }

    public int getTotal_uses() {
        return total_uses;
    }

    public void setTotal_uses(int total_uses) {
        this.total_uses = total_uses;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public boolean isStructure_decode() {
        return structure_decode;
    }

    public void setStructure_decode(boolean structure_decode) {
        this.structure_decode = structure_decode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasic_product_id() {
        return basic_product_id;
    }

    public void setBasic_product_id(int basic_product_id) {
        this.basic_product_id = basic_product_id;
    }
}

