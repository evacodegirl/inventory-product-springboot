package com.verchetasheva.productinventory.inventory;

public class InventoryDTO {

    public final Integer id;
    public final  String location;
    public final String name;

    public InventoryDTO(Integer id, String location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
    }
}
