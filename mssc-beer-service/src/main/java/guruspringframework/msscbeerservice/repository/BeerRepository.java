package guruspringframework.msscbeerservice.repository;

import guruspringframework.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

//@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
