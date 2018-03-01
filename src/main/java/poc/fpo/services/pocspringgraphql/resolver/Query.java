package poc.fpo.services.pocspringgraphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import poc.fpo.services.pocspringgraphql.model.Artist;
import poc.fpo.services.pocspringgraphql.model.Album;
import poc.fpo.services.pocspringgraphql.repository.ArtistRepository;
import poc.fpo.services.pocspringgraphql.repository.AlbumRepository;

public class Query implements GraphQLQueryResolver {
	
	private ArtistRepository artistRepository;
	private AlbumRepository albumRepository;
	
	@Autowired
    public Query(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }
	
	
    public Iterable<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    public Iterable<Artist> findAllArtists() {
        return artistRepository.findAll();
    }

    public long countAlbums() {
        return albumRepository.count();
    }
    public long countArtists() {
        return artistRepository.count();
    }
}
