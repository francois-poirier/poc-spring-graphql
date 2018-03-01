package poc.fpo.services.pocspringgraphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import poc.fpo.services.pocspringgraphql.exception.AlbumNotFoundException;
import poc.fpo.services.pocspringgraphql.model.Artist;
import poc.fpo.services.pocspringgraphql.model.Album;
import poc.fpo.services.pocspringgraphql.repository.ArtistRepository;
import poc.fpo.services.pocspringgraphql.repository.AlbumRepository;

public class Mutation implements GraphQLMutationResolver {
	
	private ArtistRepository artistRepository;
	private AlbumRepository albumRepository;
	
	@Autowired
	public Mutation(ArtistRepository artistRepository, AlbumRepository albumRepository) {
		this.artistRepository = artistRepository;
		this.albumRepository = albumRepository;
	}
	
	
	public Artist newArtist(String firstName, String lastName , String country) {
		Artist artist = new Artist(firstName, lastName , country);
		artistRepository.save(artist);

        return artist;
    }

    public Album newAlbum(String title, Integer duration, String genre, Integer pageCount, Long artistId) {
    	Album album = new Album(title, duration, genre, pageCount != null ? pageCount : 0, new Artist(artistId));
        albumRepository.save(album);

        return album;
    }

    public boolean deleteAlbum(Long id) {
    	albumRepository.delete(id);
        return true;
    }

    public Album updateAlbumPageCount(Integer pageCount, Long id) {
        Album album = albumRepository.findOne(id);
        if(album == null) {
            throw new AlbumNotFoundException("The album to be updated was not found ", id);
        }
        album.setPageCount(pageCount);

        albumRepository.save(album);

        return album;
    }
}
