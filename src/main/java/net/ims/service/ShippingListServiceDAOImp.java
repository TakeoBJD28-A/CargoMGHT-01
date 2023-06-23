package net.ims.service;

import net.ims.entity.Cargo;
import net.ims.entity.ShippingList;


import net.ims.entity.Users;
import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.repo.CargoRepo;
import net.ims.repo.ShippingListRepo;
import net.ims.repo.TrackingInfoRepo;
import net.ims.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ShippingListServiceDAOImp implements ShippingListServicDAO {
    @Autowired
   private CargoRepo cargoRepo;
    @Autowired
    private ShippingListRepo shippingListRepo;
    @Autowired
    private TrackingInfoRepo trackingInfoRepo;
    @Autowired
    private  UserRepo userRepo;
    public String generateUniqueCode() {
        Random random = new Random();
        int min = 10000; // Minimum 5-digit number
        int max = 99999; // Maximum 5-digit number
        int randomNumber = random.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

    @Override
    public ShippingList getCargo(int userId, int cargoId) {
        return null;
    }

    @Override
    public ShippingList saveCargo(ShippingList shippingList)throws RecordNotFoundException {



        ShippingList sh =shippingListRepo.save(shippingList);

        if (sh!=null)
            return sh;
        else
            throw new RecordNotFoundException("Record Not Found");

    }

    @Override
    public ShippingList updateCargo(String shippingList, int userId, int cargoId) {
        return null;
    }

    @Override
    public void deleteCargo(int userId, int cargoId) {

    }

    @Override
    public List<ShippingList> getUsers(int userId) {
        return null;
    }

    @Override
    public List<ShippingList> getCargo(int cargoId) {
        return null;
    }

    @Override
    public List<ShippingList> getAllShippingList() {
        List<ShippingList>shALL=shippingListRepo.findAll();
        return shALL;
    }
    /*@Autowired
    private ShippingListRepo ssRepo;
    public List<ShippingList> getAllshippingList(){
        return ssRepo.findAll();
    }

    public ShippingList save(ShippingList ship){
        ShippingList list=ssRepo.save(ship);
        if(list!=null){list=ssRepo.save(ship);
        return list;}
        return null;


    }
    public ShippingList saveOrUpdateShipping(ShippingList ship){
        Optional<ShippingList> userOptional = ssRepo.findById(ship.getSlid());
        ShippingList b= userOptional.get();
        if (b!=null)
            b=ssRepo.save(b);

        return b;}

    public void deleteShippingByID(Integer id)
    {
        ssRepo.deleteById(id);
    }




    public ShippingList getShippingById(Integer id ) {
        return ssRepo.findById(id).get();
    }


    public int saveShipping(ShippingList ss){

    	ShippingList saveSL=ssRepo.save(ss);

	     if(saveSL!=null)
            return 1;
	       else
            return 0;
}*/
}
