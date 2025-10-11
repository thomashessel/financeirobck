package br.com.hessel.controle_financeiro.model.enuns;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoRecorrenciaConverte implements AttributeConverter<TipoRecorrencia, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoRecorrencia stStatus) {
		return stStatus != null ? stStatus.getIndice() : null;
	}
	@Override
	public TipoRecorrencia convertToEntityAttribute(Integer dbData) {
		return dbData != null ? Stream.of(TipoRecorrencia.values())
		          .filter(c -> c.getIndice().equals(dbData))
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new):null;
	}
}