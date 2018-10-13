package ua.kiev.prog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.model.product.Category;
import ua.kiev.prog.model.product.Photo;
import ua.kiev.prog.model.product.Product;
import ua.kiev.prog.model.product.Specification;
import ua.kiev.prog.repos.PhotoRepo;
import ua.kiev.prog.repos.ProductRepo;
import ua.kiev.prog.repos.SpecificationRepo;
import ua.kiev.prog.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final PhotoRepo photoRepo;
    private final SpecificationRepo specificationRepo;

    public ProductServiceImpl(ProductRepo productRepo, PhotoRepo photoRepo, SpecificationRepo specificationRepo) {
        this.productRepo = productRepo;
        this.photoRepo = photoRepo;
        this.specificationRepo = specificationRepo;
    }
    @Transactional
    @Override
    public Product getProductById(Long id) {
        return productRepo.getOne(id);
    }
    @Transactional
    @Override
    public Page<Product> findProductsByPattern(String pattern, Pageable pageable) {
        return productRepo.findProductByNameContains(pattern,pageable);
    }
    @Transactional
    @Override
    public Page<Product> findProductsByCategory(Category category, Pageable pageable) {
        return productRepo.findProductByCategory(category,pageable);
    }
    @Transactional
    @Override
    public Page<Product> findProductsBySpecification(Specification specification, Pageable pageable) {
        return productRepo.findProductsBySpecification(specification, pageable);
    }
    @Transactional
    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }
    @Transactional
    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
    @Transactional
    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }
    @Transactional
    @Override
    public Specification getSpecificationById(Long id) {
        return specificationRepo.getOne(id);
    }
    @Transactional
    @Override
    public void updateSpecification(Specification specification) {
        specificationRepo.save(specification);
    }
    @Transactional
    @Override
    public void addPhoto(Photo photo) {
        photoRepo.save(photo);
    }
    @Transactional
    @Override
    public void updatePhoto(Photo photo) {
        photoRepo.save(photo);
    }
    @Transactional
    @Override
    public void deletePhoto(Photo photo) {
        photoRepo.delete(photo);
    }
    @Transactional
    @Override
    public Photo getPhotoById(Long id) {
        return photoRepo.getOne(id);
    }
}
