package net.ims.controller;


import net.ims.entity.Cargo;
import net.ims.entity.ShippingList;

import net.ims.entity.Users;
import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.service.CargoServiceDaoImpl;
import net.ims.service.ShippingListServiceDAOImp;

import net.ims.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ShippingListController {
    @Autowired
    private ShippingListServiceDAOImp serviceShippingList;
    @Autowired
    private UserService serviceUser;
    @Autowired
    private CargoServiceDaoImpl serviceCargo;

    @GetMapping("/getAllShipping")
    public String allShippingList(@NotNull Model model) {
        List<ShippingList>list=serviceShippingList.getAllShippingList();
        model.addAttribute("dsl", list);
        return ("ShippingListDisplay");

    }

    @RequestMapping("/shippingForm")
    public String findBook() {

        return "shippingList";
    }

    @PostMapping("/createShippingLists")
    public String createShippingList(@RequestParam("receiverName") String receiverName,
                                     @RequestParam("receiverEmail") String receiverEmail,
                                     @RequestParam("receiverPhone") long receiverPhone,
                                     @RequestParam("receiverAddress") String receiverAddress,
                                     @RequestParam("UserID") int UserID,

                                     @RequestParam("CargoID") int CargoID,
                                     @RequestParam("weight") double weight,Model model) {
        try {
            ShippingList shippingList = new ShippingList();
            shippingList.setReceiverName(receiverName);
            shippingList.setReceiverAddress(receiverAddress);
            shippingList.setReceiverPhone(receiverPhone);
            shippingList.setReceiverEmail(receiverEmail);
            shippingList.setTrackingNum(serviceShippingList.generateUniqueCode());

            Users users = serviceUser.getUserById(UserID);
            if (users == null) {
                model.addAttribute("msg", "User not found");
                return "DashBoard";
            }

            shippingList.setSenderName(users.getUname());

            Cargo cargo = serviceCargo.getCargoById(CargoID);
            if (cargo == null) {
                model.addAttribute("msg", "Cargo not found");
                return "DashBoard";
            }
            shippingList.setCargo_ID(cargo.getSbid());
              double dd=cargo.getCost();
              shippingList.setWeight(weight*dd);

            ShippingList savedShippingList = serviceShippingList.saveCargo(shippingList);
            if (savedShippingList != null) {
                model.addAttribute("msg", "Cargo Created");
            } else {
                model.addAttribute("msg", "Failed to create cargo");
            }
        } catch (RecordNotFoundException e) {
            model.addAttribute("msg", "Record not found");
        }
        return "DashBoard";
    }

}





