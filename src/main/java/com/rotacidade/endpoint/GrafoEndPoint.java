package com.rotacidade.endpoint;

import com.rotacidade.domain.exception.RecursoNaoEncontradoException;
import com.rotacidade.domain.gerente.GerenteGrafo;
import com.rotacidade.domain.model.Aresta;

import com.rotacidade.domain.model.DTO.GrafoDTO;
import com.rotacidade.domain.model.Grafo;
import com.rotacidade.domain.model.Vertice;
import com.rotacidade.repositorio.ArestaRepositorio;
import com.rotacidade.repositorio.GrafoRepositorio;
import com.rotacidade.repositorio.VerticeRepositorio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/grafo")
public class GrafoEndPoint {

    @Resource
    private GrafoRepositorio grafoRepositorio;

    @Resource
    private GerenteGrafo gerenteGrafo;

    @Resource
    private VerticeRepositorio verticeRepositorio;

    @Resource
    private ArestaRepositorio arestaRepositorio;

    @ApiOperation(value = "Cadastrar novo grafo", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = ""),
            @ApiResponse(code = 400, message = "Dados Incorretos!"),
            @ApiResponse(code = 500, message = "Erro interno !")
    })
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody List<Aresta> aresta){

        Grafo grafo = gerenteGrafo.buildGrafo(aresta);
        grafoRepositorio.save(grafo);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @ApiOperation(value = "Buscar grafo por id", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 500, message = "Erro interno !"),
            @ApiResponse(code = 404, message = "Grafo não encontrado")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findGrafo(@PathVariable("id")Long id){
        Optional<Grafo> grafoOptional = grafoRepositorio.findById(id);
        if (!grafoOptional.isPresent()){
            throw new RecursoNaoEncontradoException("Grafo não encontrado");
        }
        Map<Long, List<GrafoDTO>> grafoDTO = gerenteGrafo.preencherGrafoDTO(grafoOptional.get());
        return new ResponseEntity<>(grafoDTO, HttpStatus.OK);

    }


    @GetMapping(value = "/rotas/de/{pontoA}/para/{pontoB}")
    public ResponseEntity<?> rotas(@PathVariable("pontoA") String town1, @PathVariable("pontoB") String town2,
                                   @RequestParam("maxStops") Long maxStops){
        String cidade1 = town1;
        String cidade2 = town2;
        /*Long paradas = maxStops;*/

        return null;
    }



}
