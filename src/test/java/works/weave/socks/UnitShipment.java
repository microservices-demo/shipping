package works.weave.socks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitShipment {

    @Test
    public void testPojo() throws Exception {
        Shipment shipment = new Shipment("id", "name");
        assertEquals("id", shipment.getId());
        assertEquals("name", shipment.getName());
    }
}
