package poc.fpo.services.pocspringgraphql.repository;

import org.springframework.data.repository.CrudRepository;

import poc.fpo.services.pocspringgraphql.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
