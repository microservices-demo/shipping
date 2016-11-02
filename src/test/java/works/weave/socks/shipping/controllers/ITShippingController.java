package works.weave.socks.shipping.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import works.weave.socks.shipping.entities.Shipment;
import works.weave.socks.shipping.entities.HealthCheck;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ITShippingController {
    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ShippingController shippingController;

    @Test
    public void getShipment() throws Exception {
        String shipping = shippingController.getShipping();
        assertThat(shipping, is(notNullValue()));
    }

    @Test
    public void getShipmentById() throws Exception {
        String shipping = shippingController.getShippingById("id");
        assertThat(shipping, is(notNullValue()));
    }

    @Test
    public void newShipment() throws Exception {
        Shipment original = new Shipment("someName");
        Shipment saved = shippingController.postShipping(original);
        verify(rabbitTemplate, times(1)).convertAndSend(anyString(), any(Shipment.class));
        assertThat(original, is(equalTo(saved)));
    }

    @Test
    public void getHealthCheck() throws Exception {
        Map<String, List<HealthCheck>> healthChecks = shippingController.getHealth();
        assertThat(healthChecks.get("health").size(), is(equalTo(2)));
    }

    @Test
    public void doNotCrashWhenNoQueue() throws Exception {
        doThrow(new AmqpException("test error")).when(rabbitTemplate).convertAndSend(anyString(), any(Shipment.class));
        Shipment original = new Shipment("someName");
        Shipment saved = shippingController.postShipping(original);
        verify(rabbitTemplate, times(1)).convertAndSend(anyString(), any(Shipment.class));
        assertThat(original, is(equalTo(saved)));
    }
}
