package br.com.hessel.controle_financeiro.model.enuns;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusMetaConverte implements AttributeConverter<StatusMeta, Integer> {

	@Override
	public Integer convertToDatabaseColumn(StatusMeta stStatus) {
		return stStatus != null ? stStatus.getIndice() : null;
	}
	@Override
	public StatusMeta convertToEntityAttribute(Integer dbData) {
		return dbData != null ? Stream.of(StatusMeta.values())
		          .filter(c -> c.getIndice().equals(dbData))
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new):null;
	}
}