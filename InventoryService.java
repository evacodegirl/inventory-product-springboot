package com.verchetasheva.productinventory;

import com.verchetasheva.productinventory.inventory.Inventory;
import com.verchetasheva.productinventory.inventory.InventoryDTO;
import com.verchetasheva.productinventory.inventory.InventoryRepository;
import com.verchetasheva.productinventory.inventory.InventoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Service
public class InventoryService {

    private InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public InventoryDTO create(final InventoryRequest request) {
        var inventory = new Inventory(request.name, request.location);
        var createdInventory = repository.save(inventory);
        return new InventoryDTO(createdInventory.id, createdInventory.name, createdInventory.location);
    }

    public InventoryDTO findByNameNative(final String name) {
        var foundInventory = repository.findFirstByNameNative(name)
                .orElseThrow(() -> new RuntimeException("Inventory with name " + name + " is not found."));
        return new InventoryDTO(foundInventory.id, foundInventory.name, foundInventory.location);
    }

   @Transactional

    public InventoryDTO update(final Integer inventoryId,final InventoryRequest requst){
       var inventory = repository.findById(inventoryId)
               .orElseThrow(() -> new RuntimeException("Inventory with ID " + inventoryId + " is not found."));
       inventory.name = request.name;
       inventory.location = request.location;
       return repository.save(inventory).toDTO();
    }
    public ResponseEntity<HttpStatus> delete(final Integer inventoryId){
        var inventory = repository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory with ID " + inventoryId + " is not found."));
        repository.delete(inventory);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}