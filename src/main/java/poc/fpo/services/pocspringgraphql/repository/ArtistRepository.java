package poc.fpo.services.pocspringgraphql.repository;

import org.springframework.data.repository.CrudRepository;

import poc.fpo.services.pocspringgraphql.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
