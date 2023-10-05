package br.com.jlgregorio.rentacar.vehiclerepository;

import br.com.jlgregorio.rentacar.vehiclemodel.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {
}
