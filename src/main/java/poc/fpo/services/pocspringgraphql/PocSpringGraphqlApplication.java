package poc.fpo.services.pocspringgraphql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import poc.fpo.services.pocspringgraphql.exception.GraphQLErrorAdapter;
import poc.fpo.services.pocspringgraphql.model.Artist;
import poc.fpo.services.pocspringgraphql.model.Album;
import poc.fpo.services.pocspringgraphql.repository.ArtistRepository;
import poc.fpo.services.pocspringgraphql.repository.AlbumRepository;
import poc.fpo.services.pocspringgraphql.resolver.Mutation;
import poc.fpo.services.pocspringgraphql.resolver.Query;
import poc.fpo.services.pocspringgraphql.resolver.AlbumResolver;

@SpringBootApplication
public class PocSpringGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringGraphqlApplication.class, args);
	}
	
	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

	@Bean
	public AlbumResolver authorResolver(ArtistRepository artistRepository) {
		return new AlbumResolver(artistRepository);
	}

	@Bean
	public Query query(ArtistRepository artistRepository, AlbumRepository albumRepository) {
		return new Query(artistRepository, albumRepository);
	}

	@Bean
	public Mutation mutation(ArtistRepository artistRepository, AlbumRepository albumRepository) {
		return new Mutation(artistRepository, albumRepository);
	}

	@Bean
	public CommandLineRunner demo(ArtistRepository artistRepository, AlbumRepository albumRepository) {
		return (args) -> {
			Artist artist = new Artist ("Serge","Gainsbourg","France");
			artistRepository.save(artist);
			Album album = new Album("Aux armes et cætera", 33, "Reggae", 1, artist);
			albumRepository.save(album);
			
		};
	}
}	
