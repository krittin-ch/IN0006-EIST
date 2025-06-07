package eist;


import java.util.List;

public class FactoryFacade {

    private AccessControlList ACL;
    private InventoryClient inventoryClient;
    private ShippingClient shippingClient;

    //TODO: initialize variables in the constructor. AccessControlList instance should be filled according to Role/Permission table.
    public FactoryFacade(){

    }

    //TODO: implement addProduct method with calling necessary methods from InventoryClient and/or ShippingClient. Do permission checks and follow return message if permission fails.
    public String addProduct(String role, int product){
        return "";
    }

    //TODO: implement sellProduct method with calling necessary methods from InventoryClient and/or ShippingClient. Do permission checks and follow return message if permission fails.
    public String sellProduct(String role, String shippingAddress, int product){return "";}

    //TODO: implement checkProduct method with calling necessary methods from InventoryClient and/or ShippingClient. Do permission checks and follow return message if permission fails.
    public String checkProduct(String role){
        return "";
    }

    //TODO: implement shippingRecord method with calling necessary methods from InventoryClient and/or ShippingClient. Do permission checks and follow return message if permission fails.
    //TODO: be aware that only people who have "Sell" permission can access to the shippingRecords.
    public String shippingRecord(String role){
        return "";
    }

    public AccessControlList getACL() {
        return ACL;
    }

    public void setACL(AccessControlList ACL) {
        this.ACL = ACL;
    }

    public InventoryClient getInventoryClient() {
        return inventoryClient;
    }

    public void setInventoryClient(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public ShippingClient getShippingClient() {
        return shippingClient;
    }

    public void setShippingClient(ShippingClient shippingClient) {
        this.shippingClient = shippingClient;
    }

}