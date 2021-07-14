package com.verchetasheva.productinventory.inventory;

import com.verchetasheva.productinventory.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventories")
public class InventoryResource {

    private InventoryService inventoryService;

    public InventoryResource(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public InventoryDTO create(@RequestBody final InventoryRequest request){
        return inventoryService.create(request);
    }

    @GetMapping(path = "/find-by-name/{name}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public InventoryDTO findByName(@PathVariable("name") final String name){
        return inventoryService.findByNameNative(name);
    }
    @PutMapping(path = "/{inventoryId", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public InventoryDTO update(@PathVariable("inventoryId") final Integer inventoryId, @RequestBody final InventoryRequest request) {
        return inventoryService.update(inventoryId, request);
    }
    @DeleteMapping(path = "/{inventoryId}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> delete(@PathVariable("inventoryId") final Integer inventoryId){
        return inventoryServie.delete(inventoryId);
}





