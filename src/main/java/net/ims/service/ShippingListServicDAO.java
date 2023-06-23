package net.ims.service;

import net.ims.entity.ShippingList;
import net.ims.entity.Users;
import net.ims.exceptionalhandler.RecordNotFoundException;

import java.util.List;

public interface ShippingListServicDAO  {


        ShippingList getCargo(int userId, int cargoId);
        ShippingList saveCargo(ShippingList shippingList)throws RecordNotFoundException;
        ShippingList updateCargo(String shippingList, int userId, int cargoId);
        void deleteCargo(int userId, int cargoId);
        List<ShippingList> getUsers(int userId);
        List<ShippingList> getCargo(int cargoId);
        List<ShippingList> getAllShippingList();
    }

