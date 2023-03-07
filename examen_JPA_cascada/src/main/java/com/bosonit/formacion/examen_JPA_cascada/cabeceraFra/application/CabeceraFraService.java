package com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.application;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraInputDto;

import java.util.List;

public interface CabeceraFraService {

    CabeceraFraOutputDto addCabeceraFra (CabeceraFraInputDto cabeceraFraInputDto);
    CabeceraFraOutputDto getCabeceraFraById (Integer id);
    List<CabeceraFraOutputDto> getAllCabeceraFra ();
    CabeceraFraOutputDto updateCabeceraFra (Integer id, CabeceraFraInputDto cabeceraFraInputDto);
    String deleteCabeceraFraById (Integer id);

    CabeceraFraOutputDto addLineaFraToCabeceraFra (LineaFraInputDto lineaFraInputDto);

}
