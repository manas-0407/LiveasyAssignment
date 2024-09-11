package com.LiveasyTask.LiveasyTask.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

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
