package com.verchetasheva.productinventory.product;

import com.verchetasheva.productinventory.inventory.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
     private InventoryRepository inventoryRepository;
     private ProductRepository productRepository;

    public ProductService(InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }
@Transactional
public ProductDTO create(final Integer inventoryId,final ProductRequest request){
        var inventory inventory = inventoryRepository.findById(inventoryId);
            .orElseThrow(() -> new ResourseNotFoundException("Inventory with ID" +inventoryId+ "is not found"));
        var product = new Product(request.name, request.type, request.price, request.description);
        product.inventory = inventory;
  return productRepository.save(product).toDto();
}

@Transactional
    public ProductDTO update(final Integer inventoryId, final Integer productId,final ProductRequest request){
    var inventory Inventory = inventoryRepository.findById(inventoryId);
            .orElseThrow(() -> new ResourseNotFoundException("Inventory with ID" +inventoryId+ "is not found"));
    var product Product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourseNotFoundException("Product with ID" +productId+ "is not found"));

    product.name = request.name;
    product.type = request.type;
    product.price = request.price;
    product.description = request.description;
    product.inventory = inventory;

    return productRepository.save(product).toDto();
}

@Transactional
    public ResponseEntity<?> delete(final Integer productId, final Integer inventoryId){
    var product Product = productRepository.findsByIdAndInventoryId(productId, inventoryId)
            .orElseThrow(() -> new ResourseNotFoundException("Product with ID" +productId+ " and inventory ID" +inventoryId+ "is not found"));
    productRepository.delete(product);
return ResponseEntity.status(HttpStatus.OK).body("Product was successfully deleted");
    }
}
