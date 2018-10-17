package ua.kiev.prog.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.model.product.Category;
import ua.kiev.prog.model.product.Product;
import ua.kiev.prog.service.ProductService;

@RestController
@RequestMapping("/admin/product")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminProductController {
    private final ProductService productService;

    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Page<Product> productsByCategory (
            @RequestBody Category category,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return productService.findProductsByCategory(category,pageable);
    }

    @GetMapping("{id}")
    public Product product (@PathVariable("id") Product product){
        return product;
    }

    @PostMapping("add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Product product){
        productService.deleteProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct (
            @PathVariable("id") Product productDb,
            @RequestBody Product product){

        BeanUtils.copyProperties(product, productDb, "id");
        productService.updateProduct(productDb);
        return new ResponseEntity<>(productDb, HttpStatus.OK);
    }
}
