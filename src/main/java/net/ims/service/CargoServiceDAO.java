package net.ims.service;

import net.ims.entity.Cargo;

import java.util.List;

public interface CargoServiceDAO {
    public void saveCargo(Cargo s);
    public List<Cargo> getAllCargo();
    public Cargo getCargoById(int id);
    public void deleteById(int id);


}
