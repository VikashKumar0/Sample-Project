package com.example.linchpin.sampleapplication.Models;

/**
 * Created by linchpin on 7/7/16.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Timesheet {

    @SerializedName("Timesheet")
    @Expose
    private List<Phone> timesheet = new ArrayList<Phone>();

    /**
     *
     * @return
     * The Timesheet
     */
    public List<Phone> getTimesheet() {
        return timesheet;
    }

    /**
     *
     * @param timesheet
     * The Timesheet
     */
    public void setTimesheet(List<Phone> timesheet) {
        this.timesheet = timesheet;
    }

}