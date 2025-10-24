package store.order;

import lombok.Builder;

@Builder
public record OrderIn(
    String name,
    String email,
    String password
) {
    
}
