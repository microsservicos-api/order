package store.order;

import lombok.Builder;

@Builder
public record OrderOut(
    String id,
    String name,
    String email
) {
    
}
