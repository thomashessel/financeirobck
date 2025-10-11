package br.com.hessel.controle_financeiro.model.enuns;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoValorConverte implements AttributeConverter<TipoValor, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoValor stStatus) {
		return stStatus != null ? stStatus.getIndice() : null;
	}
	@Override
	public TipoValor convertToEntityAttribute(Integer dbData) {
		return dbData != null ? Stream.of(TipoValor.values())
		          .filter(c -> c.getIndice().equals(dbData))
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new):null;
	}
}