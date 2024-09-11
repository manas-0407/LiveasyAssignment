package com.LiveasyTask.LiveasyTask.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoadDto {
    @NonNull
    private String loadingPoint;
    @NonNull
    private String unloadingPoint;
    @NonNull
    private String productType;
    @NonNull
    private String truckType;
    @NonNull
    private String noOfTrucks;
    @NonNull
    private String weight;
    private String comment;
    @NonNull
    private String shipperId;
    @NonNull
    private String date;
}