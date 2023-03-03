package com.bosonit.formacion.examen_JPA_cascada.lineasFra.application;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraOuputDto;

import java.util.List;

public interface LineaFraService {
    LineaFraOuputDto addLineaFra (LineaFraInputDto lineaFraInputDto);
    LineaFraOuputDto getLineaFraById (Integer id);
    List<LineaFraOuputDto> getAllLineaFra ();
    LineaFraOuputDto updateLineaFra (Integer id,LineaFraInputDto lineaFraInputDto);
    String deleteLineasFraById (Integer id);
}
