
package com.example.NewUser;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.data.mongodb.repository.MongoRepository;
        import java.util.List;
@SpringBootApplication
public class NewUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewUserApplication.class, args);
	}

}

interface ProductRepository extends MongoRepository<Product, String> {

	Product findByName(String name);

}

class ProductController {

	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product findOne(String id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

}



