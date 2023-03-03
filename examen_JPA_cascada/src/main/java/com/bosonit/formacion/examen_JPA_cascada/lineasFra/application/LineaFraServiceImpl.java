package com.bosonit.formacion.examen_JPA_cascada.lineasFra.application;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.repository.CabeceraFraRepository;
import com.bosonit.formacion.examen_JPA_cascada.exception.EntityNotFoundException;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.controller.dto.LineaFraOuputDto;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain.LineaFra;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineaFraServiceImpl implements LineaFraService {

    @Autowired
    LineaFraRepository lineaFraRepository;
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Override
    public LineaFraOuputDto addLineaFra(LineaFraInputDto lineaFraInputDto) {
        LineaFra lineaFra = new LineaFra();

        lineaFra.setProductoNombre(lineaFraInputDto.getProductoNombre());

        lineaFra.setCantidad(lineaFraInputDto.getCantidad());
        lineaFra.setPrecio(lineaFraInputDto.getPrecio());


        lineaFraRepository.save(lineaFra);

        return new LineaFraOuputDto(lineaFra);
    }

    @Override
    public LineaFraOuputDto getLineaFraById(Integer id) {
        LineaFra lineaFra = lineaFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("LineaFra no encontrada."));
        return new LineaFraOuputDto(lineaFra);
    }

    @Override
    public List<LineaFraOuputDto> getAllLineaFra() {
//-------------------------------------Opción 1----------------------------------------
//        List<LineaFraOuputDto> lineaFraOuputDtoList = new ArrayList<>();
//        for (LineaFra l : lineaFraRepository.findAll()) {
//            lineaFraOuputDtoList.add(new LineaFraOuputDto(l));
//        }
//        return lineaFraOuputDtoList;
//    }
//-------------------------------------Opción 2----------------------------------------
        List<LineaFra> lineaFraList = lineaFraRepository.findAll();
        return lineaFraList.stream().map(LineaFraOuputDto::new).toList();
    }
//-------------------------------------------------------------------------------------    }

    @Override
    public LineaFraOuputDto updateLineaFra(Integer id, LineaFraInputDto lineaFraInputDto) {
        LineaFra lineaFra = lineaFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("LineaFra no encontrada."));

        if (lineaFraInputDto.getProductoNombre() != null)
            lineaFra.setProductoNombre(lineaFraInputDto.getProductoNombre());
        if (lineaFraInputDto.getCantidad() != null) lineaFra.setCantidad(lineaFraInputDto.getCantidad());
        if (lineaFraInputDto.getPrecio() != null) lineaFra.setPrecio(lineaFraInputDto.getPrecio());


        lineaFraRepository.save(lineaFra);
        return new LineaFraOuputDto(lineaFra);
    }

    @Override
    public String deleteLineasFraById(Integer id) {
        LineaFra lineaFra = lineaFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("LineaFra no encontrada."));
        lineaFraRepository.delete(lineaFra);
        return "La lineaFra con id " + id + " ha sido borrada.";
    }
}
