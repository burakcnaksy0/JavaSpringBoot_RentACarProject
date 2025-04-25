package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

// JpaRepository<Brand, Integer> extend edildiği için CRUD işlemleri hazır.
// Java'da bir interface, başka bir interface’i extends edince onun tüm metodlarını devralmış olur.

/*
JpaRepository<T, ID> → Spring Data JPA tarafından sağlanan bir interface'tir.
Senin durumunda:
	T = Brand → Yani bu repository Brand entity’si için çalışacak.
	ID = Integer → Yani Brand tablosunun id alanı Integer türünde primary key
 */
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
