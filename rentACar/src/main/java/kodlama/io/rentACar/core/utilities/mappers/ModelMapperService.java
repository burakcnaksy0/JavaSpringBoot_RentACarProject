package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

// ModelMapper, Java'da benzer alanlara sahip nesneleri otomatik olarak birbirine dönüştüren bir kütüphanedir.
public interface ModelMapperService {
	// Cevap dönerken → Entity'den DTO'ya çevirirsin (forResponse())
	ModelMapper forResponse();
	
	//Request geldiğinde → DTO'dan Entity'ye çevirmen gerekir (forRequest())
	ModelMapper forRequest();
	
}
