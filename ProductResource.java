package com.verchetasheva.productinventory.product;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventories/{inventoryId}products")
public class ProductResource {
    private ProductService productService;
    public ProductResource(ProductService productService){
        this.productService = productService;
    }
    @PostMapping(consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
        public ProductDTO create(@PathVariable("inventoryId") final  Integer inventoryId,
                                 @RequestBody final ProductRequest request){
        return productService.create(inventoryId, request);
    }
    @PostMapping(path ="/{productId}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ProductDTO update(@PathVariable("inventoryId") final Integer inventoryId,
                             @PathVariable("productId")final Integer productId,
                             @RequestBody final ProductRequest request){
        return productService.create(inventoryId,productId, request);
    }
    @DeleteMapping(path ="/{productId}",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete (@PathVariable("inventoryId") final Integer inventoryId,
                                     @PathVariable("productId")final Integer productId){
        return productService.delete(productId,inventoryId);
    }

}
