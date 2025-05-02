package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

	private final ModelMapper requestMapper;
	private final ModelMapper responseMapper;

	public ModelMapperManager() {
		this.requestMapper = new ModelMapper();
		this.requestMapper.getConfiguration()
			.setAmbiguityIgnored(true)
			.setMatchingStrategy(MatchingStrategies.STANDARD);

		this.responseMapper = new ModelMapper();
		this.responseMapper.getConfiguration()
			.setAmbiguityIgnored(true)
			.setMatchingStrategy(MatchingStrategies.LOOSE);
	}

	@Override
	public ModelMapper forResponse() {
		return this.responseMapper;
	}

	@Override
	public ModelMapper forRequest() {
		return this.requestMapper;
	}
}
