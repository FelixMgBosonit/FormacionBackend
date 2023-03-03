package com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.application;

import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraInputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.controller.dto.CabeceraFraOutputDto;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.domain.CabeceraFra;
import com.bosonit.formacion.examen_JPA_cascada.cabeceraFra.repository.CabeceraFraRepository;
import com.bosonit.formacion.examen_JPA_cascada.cliente.repository.ClienteRepository;
import com.bosonit.formacion.examen_JPA_cascada.exception.EntityNotFoundException;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.domain.LineaFra;
import com.bosonit.formacion.examen_JPA_cascada.lineasFra.repository.LineaFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabeceraFraServicImpl implements CabeceraFraService{

    @Autowired
    CabeceraFraRepository cabeceraFraRepository;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    private LineaFraRepository lineaFraRepository;

    @Override
    public CabeceraFraOutputDto addCabeceraFra(CabeceraFraInputDto cabeceraFraInputDto) {
        CabeceraFra cabeceraFra= new CabeceraFra();
        cabeceraFra.setImporteFra(cabeceraFraInputDto.getImporteFra());


        cabeceraFra.setCliente(clienteRepository.findById(cabeceraFraInputDto.getIdCliente()).orElseThrow());


        cabeceraFraRepository.save(cabeceraFra);
        return new CabeceraFraOutputDto(cabeceraFra);
    }

    @Override
    public CabeceraFraOutputDto getCabeceraFraById(Integer id) {
        CabeceraFra cabeceraFra=cabeceraFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CabeceraFra no encontrada."));
        return new CabeceraFraOutputDto(cabeceraFra);
    }

    @Override
    public List<CabeceraFraOutputDto> getAllCabeceraFra() {
//-------------------------------------Opción 1----------------------------------------
//        List<CabeceraFraOutputDto> cabeceraFraOutputDtoList = new ArrayList<>();
//        for (CabeceraFra c : cabeceraFraRepository.findAll()) {
//            cabeceraFraOutputDtoList.add(new CabeceraFraOutputDto(c));
//        }
//        return cabeceraFraOutputDtoList;
//    }
//-------------------------------------Opción 2----------------------------------------
        List <CabeceraFra> cabeceraFraList= cabeceraFraRepository.findAll();
        return cabeceraFraList.stream().map(CabeceraFraOutputDto::new).toList();
    }
//-------------------------------------------------------------------------------------



    @Override
    public CabeceraFraOutputDto updateCabeceraFra(Integer id, CabeceraFraInputDto cabeceraFraInputDto) {
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CabeceraFra no encontrada."));

        if (cabeceraFraInputDto.getIdCliente() != null)cabeceraFra.setCliente(clienteRepository.findById(cabeceraFraInputDto.getIdCliente()).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado.")));
        if(cabeceraFraInputDto.getImporteFra() != null)cabeceraFra.setImporteFra(cabeceraFraInputDto.getImporteFra());


        cabeceraFraRepository.save(cabeceraFra);
        return new CabeceraFraOutputDto(cabeceraFra);

    }

    @Override
    public String deleteCabeceraFraById(Integer id) {
        CabeceraFra cabeceraFra= cabeceraFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CabeceraFra no encontrada."));
        cabeceraFraRepository.delete(cabeceraFra);
        return "La cabeceraFra con id " + id + " ha sido borrada.";
    }

    @Override
    public CabeceraFraOutputDto addLineaFraToCabeceraFra(Integer idCabeceraFra, List<Integer> idLineaFraList) {
        //Creo cabeceraFra con el id obtenido.
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(idCabeceraFra).orElseThrow(() -> new EntityNotFoundException("CabeceraFra no encontrada."));

        //Bucle for each donde creo una lista de lineaFras con los ids obtenidos
        for (LineaFra l : lineaFraRepository.findAllById(idLineaFraList)) {
            if (!cabeceraFra.getLineaFraList().stream().anyMatch(lineaFra -> lineaFra.getIdLineaFra().equals(l.getIdLineaFra()))) {
                cabeceraFra.getLineaFraList().add(l);
            }
        }
        //Con el if filtro a traves de .stream()anyMatch si alguna lineaFra ya aparece en la lista de esa cabeceraFra no la vuelve a añadir.

        //Se guarda la cabeceraFra en repositorio con su lista actualizada
        cabeceraFraRepository.save(cabeceraFra);

        return new CabeceraFraOutputDto(cabeceraFra);
    }

    @Override
    public String removeLineaFraFromCabeceraFra(Integer id, List<Integer> idLineaFraList) {
        //Creo cabeceraFra con el id obtenido.
        CabeceraFra cabeceraFra = cabeceraFraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CabeceraFra no encontrada."));

        //Bucle for each donde creo una lista de lineaFras con los ids obtenidos
        for (LineaFra l : lineaFraRepository.findAllById(idLineaFraList)) {{
            cabeceraFra.getLineaFraList().remove(l);
        }
        }

        //Se guarda el student en repositorio con su lista actualizada
        cabeceraFraRepository.save(cabeceraFra);

        return "CabeceraFra Actualizada";
    }
}
