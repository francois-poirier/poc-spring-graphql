package poc.fpo.services.pocspringgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;

import poc.fpo.services.pocspringgraphql.model.Artist;
import poc.fpo.services.pocspringgraphql.model.Album;
import poc.fpo.services.pocspringgraphql.repository.ArtistRepository;

public class AlbumResolver implements GraphQLResolver<Album> {
	
	private ArtistRepository artistRepository;
	
    public AlbumResolver(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist getAuthor(Album album) {
        return artistRepository.findOne(album.getArtist().getId());
    }
}
