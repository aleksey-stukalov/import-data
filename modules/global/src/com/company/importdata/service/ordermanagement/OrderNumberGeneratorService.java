package com.company.importdata.service.ordermanagement;


import java.util.Date;

/**
 * Generates number for a new order
 */

public interface OrderNumberGeneratorService {
    String NAME = "importdata_OrderNumberGeneratorService";

    String getOrderNumber();

    String getOrderNumber(Date datedFrom);
}