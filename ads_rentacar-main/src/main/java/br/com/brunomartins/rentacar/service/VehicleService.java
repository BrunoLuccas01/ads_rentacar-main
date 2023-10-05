package br.com.brunomartins.rentacar.service;

import br.com.brunomartins.rentacar.dto.VehicleDTO;
import br.com.brunomartins.rentacar.exception.ResourceNotFoundException;
import br.com.brunomartins.rentacar.mapper.CustomModelMapper;
import br.com.brunomartins.rentacar.model.VehicleModel;
import br.com.brunomartins.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public VehicleDTO create(VehicleDTO dto) {
        VehicleModel model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public VehicleDTO findById(int id) {
        VehicleModel model = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle not found with ID: " + id));
        return CustomModelMapper.parseObject(model, VehicleDTO.class);
    }

    public List<VehicleDTO> findAll() {
        List<VehicleModel> list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, VehicleDTO.class);
    }

    public VehicleDTO update(VehicleDTO dto) {
        VehicleModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle not found with ID: " + dto.getId()));
        model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public void delete(VehicleDTO dto) {
        VehicleModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Vehicle not found with ID: " + dto.getId()));
        repository.delete(model);
    }
}
