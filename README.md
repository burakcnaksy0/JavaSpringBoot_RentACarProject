# 🚀 Spring Boot Projesi Nasıl Oluşturulur?

## 1. Proje Başlatma
İlk olarak [Spring Initializr](https://start.spring.io/) sitesine gidiyoruz.  
Burada proje yapılandırması için seçimler yapıyoruz:

- **Project:** Maven
- **Language:** Java
- **Spring Boot:** (Önerilen en güncel versiyon)

![Spring Initializr](https://miro.medium.com/v2/format:webp/1*HoHcZhegEmh_mi3VbNO7CQ.png)

---

## 2. Bağımlılıkları (Dependencies) Eklemek
"Add Dependencies" butonuna basarak aşağıdaki bağımlılıkları ekliyoruz:

- Spring Boot DevTools
- Lombok
- Spring Web
- Spring Data JPA
- Validation
- PostgreSQL Driver

### 📚 Bu Bağımlılıklar Ne İşe Yarar?

- **Spring Boot DevTools (Developer Tools):**  
  Hızlı geliştirme için otomatik uygulama restart ve LiveReload sağlar.

- **Lombok (Developer Tools):**  
  `@Getter`, `@Setter` gibi anotasyonlarla Java’da tekrarlayan kod yazımını azaltır.

- **Spring Web (Web):**  
  Web uygulamaları ve REST API geliştirmek için kullanılır. İçinde Spring MVC ve gömülü Tomcat sunucusu bulunur.

- **Spring Data JPA (SQL):**  
  SQL yazmadan Java sınıfları ile veritabanı işlemleri yapmamızı sağlar. Arkada Hibernate çalışır.

- **Validation (I/O):**  
  Giriş verilerini doğrulamak için kullanılır (`@NotNull`, `@Size`, vs.).

- **PostgreSQL Driver (SQL):**  
  PostgreSQL veritabanına Java ile bağlantı kurmak için gerekli JDBC sürücüsüdür.

> **Not:** Bu bağımlılıklar `pom.xml` dosyası içinde bulunur.

---

## 3. Katmanlı Mimari (Layered Architecture)

Projeyi düzenli ve anlaşılır hale getirmek için katmanlı mimari kullanıyoruz.  
Bu mimaride her katman **tek bir işten sorumludur**.

### Kullanılan Katmanlar:

- Entities Layer
- Data Access Layer
- Business Layer
- Web API Layer

---

### 📦 Katmanlar ve Görevleri

#### 1. Entities Layer (Entity Katmanı)
- Veritabanındaki tabloların Java karşılıkları burada olur (`@Entity` anotasyonu).
- Sadece veri yapısını tutar.  
Örneğin:
```java
@Entity
public class User { ... }

#### 2. Data Access Layer (DAL)
  -Veritabanı işlemleri burada yapılır.
  -Repository (DAO) sınıfları bulunur.

### 3. Business Layer (Service Katmanı)
    -İş kuralları (business logic) burada yer alır.
    -Genellikle @Service anotasyonu kullanılır.

### 4. Web API Layer (Controller Katmanı)
    -HTTP isteklerini karşılar ve cevaplar (@RestController anotasyonu).

4. Abstract ve Concrete Paket Yapısı
Her katmanda iki alt package bulunur:


Package	Açıklama
abstract	Interface veya abstract class'lar bulunur. Sadece sözleşme/şablon içerir.
concrete	Interface veya abstract class'ların gerçek implementasyonları bulunur.

🎯 Neden Abstract ve Concrete Ayrımı Yapılır?
İleride farklı bir implementasyon gerektiğinde sadece concrete kısmı değiştirmek yeterlidir.

Test yazarken kolayca mock sınıflar oluşturabiliriz.

Bağımlılıklar azalır, proje daha esnek hale gelir.

Dependency Injection prensibine uygun çalışır.
