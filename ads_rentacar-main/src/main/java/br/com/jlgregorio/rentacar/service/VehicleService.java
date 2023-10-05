package br.com.jlgregorio.rentacar.vehicleservice;

import br.com.jlgregorio.rentacar.vehicledto.VehicleDTO;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.vehiclemodel.VehicleModel;
import br.com.jlgregorio.rentacar.vehiclerepository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public VehicleDTO create(VehicleDTO dto) {
        VehicleModel model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public VehicleModel findById(int id) {
        VehicleModel model = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(null));
        return CustomModelMapper.parseObject(model, VehicleDTO.class);
    }

    public List<VehicleDTO> findAll();

    {

        List<VehicleModel> list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, VehicleDTO.class);
    }

    public VehicleDTO update(VehicleDTO dto) {
        VehicleModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public void delete(VehicleDTO dto) {
        VehicleModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException(null));
        repository.delete(model);
    }
}
