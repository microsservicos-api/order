package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order", url = "http://order:8080")
public interface OrderController {

    @PostMapping("/order")
    ResponseEntity<OrderOut> create(@RequestBody OrderIn in);

    @GetMapping("/order")
    ResponseEntity<List<OrderOut>> findAll();

    @GetMapping("/order/{id}")
    ResponseEntity<OrderOut> findById(@PathVariable("id") String id);
}
