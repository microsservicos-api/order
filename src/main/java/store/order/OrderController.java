package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "order", url = "http://order:8080")
public interface OrderController {

    @PostMapping("/order")
    public ResponseEntity<OrderOut> create(
        @RequestBody OrderIn in
    );

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderOut> findById(
        @PathVariable("id") String id
    );

    @PostMapping("/order/login")
    public ResponseEntity<OrderOut> findByEmailAndPassword(
        @RequestBody OrderIn in
    );

    @GetMapping("/order")
    public ResponseEntity<List<OrderOut>> findAll();

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable("id") String id
    );

    @GetMapping("/order/whoami")
    public ResponseEntity<OrderOut> whoAmI(
        @RequestHeader(value = "id-order", required = true) String idOrder
    );

}
