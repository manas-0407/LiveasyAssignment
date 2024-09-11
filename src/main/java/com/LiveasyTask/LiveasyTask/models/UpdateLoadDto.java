package com.LiveasyTask.LiveasyTask.models;

import lombok.Data;

@Data
public class UpdateLoadDto {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String comment;
    private String date;
}
