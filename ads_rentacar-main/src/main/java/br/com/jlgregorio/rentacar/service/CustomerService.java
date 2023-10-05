package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.CustomerDTO;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.CustomerModel;
import br.com.jlgregorio.rentacar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerDTO create(CustomerDTO dto) {
        CustomerModel model = CustomModelMapper.parseObject(dto, CustomerModel.class);
        return CustomModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    public CustomerDTO findById(int id) {
        CustomerModel model = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with ID: " + id));
        return CustomModelMapper.parseObject(model, CustomerDTO.class);
    }

    public List<CustomerDTO> findAll() {
        List<CustomerModel> list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, CustomerDTO.class);
    }

    public CustomerDTO update(CustomerDTO dto) {
        CustomerModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with ID: " + dto.getId()));
        model = CustomModelMapper.parseObject(dto, CustomerModel.class);
        return CustomModelMapper.parseObject(repository.save(model), CustomerDTO.class);
    }

    public void delete(CustomerDTO dto) {
        CustomerModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found with ID: " + dto.getId()));
        repository.delete(model);
    }
}
