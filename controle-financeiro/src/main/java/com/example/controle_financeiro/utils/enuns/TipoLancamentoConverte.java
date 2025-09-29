package com.example.controle_financeiro.utils.enuns;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoLancamentoConverte implements AttributeConverter<TipoLancamento, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoLancamento tipoLancamento) {
		return tipoLancamento != null ? tipoLancamento.getIndice() : null;
	}
	@Override
	public TipoLancamento convertToEntityAttribute(Integer dbData) {
		return dbData != null ? Stream.of(TipoLancamento.values())
		          .filter(c -> c.getIndice().equals(dbData))
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new):null;
	}	
}