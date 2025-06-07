package eist.shippingmicroservice;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/shipping/")
public class ShippingController {
    List<String> shippingList = new ArrayList<>();

    //TODO: check correct mapping type and end point from ShippingClient to fill mapping information. Then add the given input parameter to the shippingList instance and return necessary messages.
    public String makeShipping(@RequestParam String shipping){
        return "";
    }

    //TODO: check correct mapping type and end point from ShippingClient to fill mapping information. Then return shippingList instance instead of wrongList.
    public List<String> shippingRecord(){List<String> wrongList = new ArrayList<>(); return wrongList;}

}
